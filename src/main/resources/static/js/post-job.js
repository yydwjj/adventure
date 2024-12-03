// 动态添加新的岗位表单
function addNewJobForm() {
    const container = document.getElementById('jobFormsContainer');
    const newJobForm = document.createElement('div');
    newJobForm.className = 'job-form';
    newJobForm.innerHTML = `
        <h2 class="form-section-title">岗位信息</h2>
        <div class="form-group">
            <label>岗位名称</label>
            <input type="text" name="jobTitle" placeholder="请输入岗位名称" required>
        </div>
        <div class="form-group">
            <label>岗位介绍</label>
            <textarea name="jobDescription" placeholder="请详细描述该岗位的主要职责和工作内容" required></textarea>
        </div>
        <div class="form-group">
            <label>招聘要求</label>
            <textarea name="jobRequirements" placeholder="请描述对应聘者的要求（如学历、工作经验、技能等）" required></textarea>
        </div>
        <div class="form-group">
            <label>联系方式</label>
            <input type="text" name="contactInfo" placeholder="请输入联系方式" required>
        </div>
    `;
    container.appendChild(newJobForm);
}

// 显示成功弹窗
function showModal() {
    document.getElementById('successModal').style.display = 'block';
}

// 隐藏成功弹窗
function hideModal() {
    document.getElementById('successModal').style.display = 'none';
}

// 提交所有岗位
async function submitJobs() {
    const forms = document.querySelectorAll('.job-form');
    const teamId = getTeamIdFromURL(); // 从 URL 获取 teamId
    if (!teamId) {
        alert('未能获取团队 ID，请检查 URL 格式！');
        return;
    }

    const jobs = [];

    // 收集表单数据
    forms.forEach(form => {
        const jobTitle = form.querySelector('input[name="jobTitle"]').value.trim();
        const jobDescription = form.querySelector('textarea[name="jobDescription"]').value.trim();
        const jobRequirement = form.querySelector('textarea[name="jobRequirements"]').value.trim();
        const jobRequirements = jobDescription+"\n"+jobRequirement;
        const contactInfo = form.querySelector('input[name="contactInfo"]').value.trim();

        if (jobTitle && jobDescription && jobRequirements && contactInfo) {
            jobs.push({
                teamId: parseInt(teamId), // 将 teamId 加入每个岗位
                jobTitle,
                jobDescription,
                jobRequirements,
                contactInfo
            });
        }
    });

    if (jobs.length === 0) {
        alert('请填写至少一个完整的岗位信息！');
        return;
    }

    try {
        // 向服务器发送请求
        const response = await fetch('/job/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jobs)
        });

        const result = await response.json();

        if (result.code === 200) {
            alert('所有岗位发布成功！');
            showModal();
        } else {
            alert('发布失败：' + result.message);
        }
    } catch (error) {
        console.error('发布过程中发生错误:', error);
        alert('发布失败，请稍后重试。');
    }
}

// 从 URL 中获取 teamId
function getTeamIdFromURL() {
    const pathSegments = window.location.pathname.split('/');
    return pathSegments[pathSegments.length - 1]; // 获取最后一个路径段，即 teamId
}

// 点击弹窗外部关闭弹窗
window.onclick = function(event) {
    const modal = document.getElementById('successModal');
    if (event.target == modal) {
        hideModal();
    }
}
