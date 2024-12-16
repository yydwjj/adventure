// 从url中获取位于最末尾的id
function getIdFromUrl() {
    const path = window.location.pathname;
    const parts = path.split('/');
    return parts[parts.length - 1];
}

// ai小组件的构建
function createResponseContainer() {
    let container = document.getElementById('response-container');
    if (!container) {
        container = document.createElement('div');
        container.id = 'response-container';

        // 标题
        const title = document.createElement('h2');
        title.textContent = '智能助手';
        title.style.textAlign = 'left'; // 左对齐
        title.style.fontSize = 'x-large'; // 字体大小
        title.style.borderBottom = '1px #777373 dotted'; // 底部虚线边框
        title.style.width = '98px'; // 宽度
        title.style.marginBottom = '20px'; // 下边距
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

        // 展开按钮
        const toggleBtn = document.createElement('span');
        toggleBtn.className = 'toggle-btn';
        toggleBtn.textContent = '《隐藏';
        toggleBtn.style.position = 'fixed';
        // toggleBtn.style.right = '50px';
        toggleBtn.style.bottom = '100px';
        let flag = false;
        toggleBtn.onclick = () => {
            if(flag){
                flag = false;
                toggleBtn.textContent = '《隐藏';
            }else{
                flag = true;
                toggleBtn.textContent = '展开》';
            }
            container.classList.toggle('visible');
        };
        document.body.appendChild(toggleBtn);
    }
    return container;
}

// 向 API 发送请求并展示数据
async function fetchAndDisplayJobs(myUrl) {
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
        const response = await fetch(myUrl);
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
        content.style.border = "1px #b5b4b4 solid";
        content.style.borderRadius = "8px";
        content.style.padding="5px";
        content.style.paddingLeft="10px"
        // content.style.boxShadow="2px 2px 0px #ebebeb"
        content.style.listStyleType="none";
        // 添加hover效果
        content.style.transition = 'box-shadow 0.3s'; // 平滑过渡效果
        content.addEventListener('mouseover', () => {
            content.style.boxShadow = '2px 2px 0px #ebebeb'; // 右下角小阴影
        });
        content.addEventListener('mouseout', () => {
            content.style.boxShadow = ''; // 恢复默认阴影
        });
        container.appendChild(content);
        addFeedbackStyle();

        const feedbackContainer = document.createElement('div');
        feedbackContainer.className = 'feedback-container';
        feedbackContainer.innerHTML = `
        <p>对此回答是否满意？</p>
        <button id="satisfied-btn" class="feedback-btn">满意</button>
        <button id="unsatisfied-btn" class="feedback-btn">不满意</button>
    `;
        container.appendChild(feedbackContainer);

        // 处理用户反馈
        document.getElementById('satisfied-btn').addEventListener('click', () => {
            thankYouFeedback(feedbackContainer, true);
        });

        document.getElementById('unsatisfied-btn').addEventListener('click', () => {
            thankYouFeedback(feedbackContainer, false);
        });

    } catch (error) {
        console.error('获取数据失败:', error.message);
        clearInterval(messageInterval); // 停止加载提示
        loadingMessage.textContent = '加载失败，请稍后重试。';
    }
}

function addFeedbackStyle(){
    // 动态添加 CSS 样式
    const style = document.createElement('style');
    style.innerHTML = `
        .feedback-btn {
            margin-right: 10px;
            padding: 10px 20px;
            border: none;
            background-color: #22bfa7;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .feedback-btn:hover {
            background-color: #a0d5b7;
        }
        .feedback-container {
            margin-top: 20px;
            text-align: center;
        }
        .thank-you-message {
            opacity: 0;
            transform: translateY(20px);
            transition: opacity 0.5s, transform 0.5s;
        }
        .fade-in {
            opacity: 1;
            transform: translateY(0);
        }
    `;
    document.head.appendChild(style);
}

// 感谢反馈函数
function thankYouFeedback(container, isSatisfied) {
    // 创建感谢反馈的消息
    const thankYouMessage = document.createElement('p');
    thankYouMessage.className = 'thank-you-message';
    thankYouMessage.textContent = '感谢您的反馈！';

    // 清空反馈容器
    container.innerHTML = '';

    // 添加感谢消息到反馈容器
    container.appendChild(thankYouMessage);

    // 添加动画类
    setTimeout(() => {
        thankYouMessage.classList.add('fade-in');
    }, 0);

    // 如果需要，可以在这里发送满意度数据到服务器
    if (isSatisfied) {
        // 发送满意的反馈
    } else {
        // 发送不满意的反馈
    }
}

// 主函数
function main() {
    const teamId = getIdFromUrl();
    if (!teamId) {
        console.error('未找到 teamId 参数');
        return;
    }
    // 创建容器并添加展开按钮
    const container = createResponseContainer();
    const myUrl = `http://localhost:8080/model/teams?taskId=`+teamId;
    // 开始获取数据
    fetchAndDisplayJobs(myUrl);
}

// 页面加载完成后执行
document.addEventListener('DOMContentLoaded', main);
