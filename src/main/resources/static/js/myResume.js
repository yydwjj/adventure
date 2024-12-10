document.addEventListener('DOMContentLoaded', async function () {
    const authToken = localStorage.getItem('authToken'); // 从本地存储获取token，你可根据实际获取方式调整
    if (!authToken) {
        console.error('未获取到有效的token，请先登录');
        return;
    }

    try {
        const response = await fetch('/resume/myResume', {
            method: 'GET',
            headers: {
                'token': authToken
            }
        });

        if (response.ok) {
            const resumes = await response.json();
            const MyResumeList = document.getElementById('my-resume');
            // 创建按钮数组，用于后续获取第一个按钮的id
            const resumeButtons = [];
            if (resumes.data != null ) {
                resumes.data.forEach(resume => {
                    const resumeButton = document.createElement('button');
                    resumeButton.textContent = resume.resumeName; // 展示简历名称
                    resumeButton.id = resume.resumeId; // 将简历Id藏入按钮Id中
                    // 为每个简历按钮添加点击事件监听器
                    resumeButton.addEventListener('click', async function () {
                        const resumeId = this.id;
                        try {
                            const InfoResponse = await fetch(`/resume/info/${resumeId}`, {
                                method: 'GET',
                                headers: {
                                    'token': authToken
                                }
                            });
                            if (InfoResponse.ok) {
                                const Info = await InfoResponse.json();
                                const resumeData = Info.data;
                                // 调用通用函数展示各个字段信息
                                updateResumeInfo(resumeData, resumeId);
                            } else {
                                console.error('获取基本信息失败:', InfoResponse.statusText);
                            }
                        } catch (error) {
                            console.error('网络错误（获取基本信息）:', error);
                        }
                    });
                    resumeButtons.push(resumeButton);
                    MyResumeList.appendChild(resumeButton);
                });
            }

            // 获取第一个简历按钮对应的id，如果有按钮的话
            const firstResumeId = resumeButtons.length > 0? resumeButtons[0].id : null;
            if (firstResumeId) {
                try {
                    const InfoResponse = await fetch(`/resume/info/${firstResumeId}`, {
                        // 使用模板字符串将获取到的resumeId拼接到接口路径中，请求对应简历详细信息
                        method: 'GET',
                        headers: {
                            'token': authToken
                        }
                    });

                    if (InfoResponse.ok) {
                        const Info = await InfoResponse.json();
                        const resumeData = Info.data;

                        // 调用通用函数展示各个字段信息
                        updateResumeInfo(resumeData, firstResumeId);
                    } else {
                        console.error('获取基本信息失败:', InfoResponse.statusText);
                    }
                } catch (error) {
                    console.error('网络错误（获取基本信息）:', error);
                }
            }

            // 获取保存按钮元素并添加点击事件监听器
            const saveBtn = document.getElementById('save-btn');
            saveBtn.addEventListener('click', async function () {
                const resumeId = document.getElementById('resume-id').textContent;
                if (resumeId) {
                    const updatedResume = {
                        resumeId: parseInt(resumeId), // 将获取到的id转换为数字类型，根据实际后端需求调整
                        resumeName: document.getElementById('resume-name').value,
                        name: document.getElementById('name').value,
                        school: document.getElementById('school').value,
                        major: document.getElementById('major').value,
                        phoneNumber: document.getElementById('phone').value,
                        email: document.getElementById('email').value,
                        desiredPosition: document.getElementById('desired-position').value,
                        personalStrengths: document.getElementById('personal-strengths').value,
                        previousExperience: document.getElementById('personal-experience').value
                    };

                    try {
                        const updateResponse = await fetch(`/resume/editResume/${resumeId}`, {
                            method: 'PUT', // 假设后端接口使用PUT方法更新数据，这里需要明确指定请求方法
                            headers: {
                                'token': authToken, // 用于身份验证的token，从本地存储获取的那个token，
                                'Content-Type': 'application/json' // 表明发送的数据格式为JSON格式，后端才能正确解析
                            },
                            body: JSON.stringify(updatedResume)
                        });
                        if (updateResponse.ok) {
                            const result = await updateResponse.json();
                            console.log('简历更新成功:', result);
                            alert('简历更新成功！');
                            location.reload();
                        } else {
                            const error = await updateResponse.json();
                            console.error('简历更新失败:', error);
                            alert('简历更新失败，请检查输入信息后重试！');
                        }
                    } catch (error) {
                        console.error('网络错误（更新简历时）:', error);
                        alert('网络出现问题，请稍后重试！');
                    }
                } else {
                    console.error('未获取到有效的简历id，请先选择要编辑的简历');
                    alert('未获取到有效的简历id，请先选择要编辑的简历');
                }
            });

            // 右侧栏创建按钮
            const createBtn = document.getElementById('create-btn');
            if (createBtn) {
                createBtn.addEventListener('click', async function () {
                    const authToken = localStorage.getItem('authToken'); // 从本地存储获取token，你可根据实际获取方式调整
                    if (!authToken) {
                        console.error('未获取到有效的token，请先登录');
                        return;
                    }
                    const newResume = {
                        resumeName: "resume",
                        name: "",
                        school: "",
                        major: "",
                        phoneNumber: "",
                        email: "",
                        desiredPosition: "",
                        personalStrengths: "",
                        previousExperience: "",
                    };

                    try {
                        const response = await fetch('/resume/create', {
                            method: 'POST',
                            headers: {
                                'token': authToken,
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(newResume)
                        });
                        if (response.ok) {
                            const result = await response.json();
                            console.log('简历创建成功:', result);
                            alert('简历创建成功！');
                            // 添加页面重新加载逻辑，重新加载当前页面
                            location.reload();
                        } else {
                            const error = await response.json();
                            console.error('简历创建失败:', error);
                            alert('简历创建失败，请检查输入信息后重试！');
                        }
                    } catch (error) {
                        console.error('网络错误（创建简历时）:', error);
                        alert('网络出现问题，请稍后重试！');
                    }
                });
            }

            // 获取删除按钮元素并添加点击事件监听器
            const deleteBtn = document.getElementById('delete-btn');
            if (deleteBtn) {
                deleteBtn.addEventListener('click', async function () {
                    const resumeId = document.getElementById('resume-id').textContent;
                    if (resumeId) {
                        try {
                            const deleteResponse = await fetch(`/resume/deleteResume/${resumeId}`, {
                                method: 'PUT',
                                headers: {
                                    'token': authToken
                                }
                            });
                            if (deleteResponse.ok) {
                                const result = await deleteResponse.json();
                                console.log('简历删除成功（假删除）:', result);
                                alert('简历已成功删除！');
                                // 假删除成功后重新加载页面，显示更新后的简历列表
                                location.reload();
                            } else {
                                const error = await deleteResponse.json();
                                console.error('简历删除失败:', error);
                                alert('简历删除失败，请稍后重试！');
                            }
                        } catch (error) {
                            console.error('网络错误（删除简历时）:', error);
                            alert('网络出现问题，请稍后重试！');
                        }
                    } else {
                        console.error('未获取到有效的简历id，请先选择要删除的简历');
                        alert('未获取到有效的简历id，请先选择要删除的简历');
                    }
                });
            }
        } else {
            console.error('获取简历列表失败:', response.statusText);
        }
    } catch (error) {
        console.error('网络错误（获取简历列表时）:', error);
    }
});



// 通用函数用于更新简历各个字段的展示信息，新增参数resumeId用于接收当前简历的id
const updateResumeInfo = function (resumeData, resumeId) {
    const fields = [
        { id: 'resume-name', value: resumeData.resumeName || '我的在线简历' },
        { id: 'name', value: resumeData.name || '暂无姓名信息' },
        { id: 'school', value: resumeData.school || '暂无学校信息' },
        { id: 'major', value: resumeData.major || '暂无专业信息' },
        { id: 'phone', value: resumeData.phoneNumber || '暂无电话号码' },
        { id: 'email', value: resumeData.email || '暂无邮箱信息' },
        { id: 'desired-position', value: resumeData.desiredPosition || '暂无期望职位信息' },
        { id: 'personal-strengths', value: resumeData.personalStrengths || '暂无个人优势信息' },
        { id: 'personal-experience', value: resumeData.previousExperience || '暂无个人经历信息' }
    ];

    fields.forEach(field => {
        const element = document.getElementById(field.id);
        if (element) {
            element.textContent = field.value;
        }
    });

    // 获取resume-id元素，并将当前简历的id设置到其textContent中
    const resumeIdElement = document.getElementById('resume-id');
    if (resumeIdElement) {
        resumeIdElement.textContent = resumeId;
    }
};