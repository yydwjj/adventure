// 获取 URL 中的 teamId 参数
function getTeamIdFromUrl() {
    const path = window.location.pathname;
    const parts = path.split('/');
    return parts[parts.length - 1];
}

// 创建一个容器用于展示返回的数据
function createResponseContainer() {
    let container = document.getElementById('response-container');
    if (!container) {
        container = document.createElement('div');
        container.id = 'response-container';

        // 标题
        const title = document.createElement('h2');
        title.textContent = '推荐内容';
        title.style.textAlign = 'center';
        container.appendChild(title);

        // 进度条
        const progressBar = document.createElement('div');
        progressBar.id = 'progress-bar';
        progressBar.innerHTML = '<span></span>';
        container.appendChild(progressBar);

        // 加载提示文字
        const loadingMessage = document.createElement('div');
        loadingMessage.id = 'loading-message';
        loadingMessage.textContent = '正在加载数据，请稍候...';
        container.appendChild(loadingMessage);

        // 关闭按钮
        const closeBtn = document.createElement('span');
        closeBtn.className = 'close-btn';
        closeBtn.textContent = '×';
        closeBtn.onclick = () => {
            container.classList.remove('visible');
        };
        container.appendChild(closeBtn);

        document.body.appendChild(container);
    }
    return container;
}

// 向 API 发送请求并展示数据
async function fetchAndDisplayJobs(teamId) {
    const container = createResponseContainer();
    container.classList.add('visible'); // 显示容器

    const loadingMessage = document.getElementById('loading-message');
    const messages = ['正在加载数据，请稍候...', '即将获取推荐信息...', '数据加载中，请稍等片刻'];
    let messageIndex = 0;

    // 轮流显示加载提示文字
    const messageInterval = setInterval(() => {
        loadingMessage.textContent = messages[messageIndex];
        messageIndex = (messageIndex + 1) % messages.length;
    }, 1000);

    try {
        const response = await fetch(`http://localhost:8080/model/teams?taskId=${teamId}`);
        if (!response.ok) {
            throw new Error(`API 请求失败: ${response.status}`);
        }

        const responseData = await response.text(); // 读取纯文本内容
        clearInterval(messageInterval); // 停止加载提示
        loadingMessage.remove(); // 移除加载文字

        const progressBar = document.getElementById('progress-bar');
        progressBar.remove(); // 移除进度条

        // 添加返回的 Markdown 数据内容
        const content = document.createElement('div');
        content.innerHTML = marked.parse(responseData); // 渲染 Markdown 为 HTML
        container.appendChild(content);
    } catch (error) {
        console.error('获取数据失败:', error.message);
        clearInterval(messageInterval); // 停止加载提示
        loadingMessage.textContent = '加载失败，请稍后重试。';
    }
}


// 主函数
function main() {
    const teamId = getTeamIdFromUrl();
    if (!teamId) {
        console.error('未找到 teamId 参数');
        return;
    }

    // 创建容器并添加展开按钮
    const container = createResponseContainer();

    // 展开按钮
    const toggleBtn = document.createElement('span');
    toggleBtn.className = 'toggle-btn';
    toggleBtn.textContent = '推荐介绍》';
    toggleBtn.style.position = 'fixed';
    // toggleBtn.style.right = '50px';
    toggleBtn.style.bottom = '160px';
    toggleBtn.onclick = () => {
        container.classList.toggle('visible');
    };
    document.body.appendChild(toggleBtn);

    // 开始获取数据
    fetchAndDisplayJobs(teamId);
}

// 页面加载完成后执行
document.addEventListener('DOMContentLoaded', main);
