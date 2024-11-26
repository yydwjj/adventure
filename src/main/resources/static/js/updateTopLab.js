// 动态的修改顶部以及"我的"相关连接
//修改用户名显示
getUserInfo().then(data => {
    if (data) {
        console.log('User Info:', data);
        // 将对象转换为 JSON 字符串
        const userInfoString = JSON.stringify(data.data.loginUser);
        // 保存用户信息
        sessionStorage.setItem('myInfo', userInfoString);

        let name = document.getElementsByClassName('login-register').item(0);
        // 将登录注册按钮替换成用户名称 并设置用户主页超链接
        name.innerHTML = `<a href="/userindex/${data.data.loginUser.userId}">${data.data.loginUser.username}</a>`;
        // 侧边栏中超链接的设置
        const menuItems = document.getElementById('sidebar').querySelectorAll('.menu-item span');
        // 定义每个菜单项对应的 URL
        const menuUrls = {
            '个人信息': `/profile`,
            '我的简历': `/resume`,
            '我的队伍': `/myteam`,
            '历史任务': `/history`
        };
        // 为“发布”按钮添加点击事件监听器
        const publishButton = document.querySelector('.publish-btn');
        if (publishButton) {
            publishButton.addEventListener('click', () => {
                window.location.href = '/post-task';
            });
        }
        // 为每个 span 元素添加点击事件监听器
        menuItems.forEach((span) => {
            span.addEventListener('click', () => {
                const text = span.textContent.trim();
                const url = menuUrls[text];
                if (url) {
                    window.location.href = url;
                }
            });
        });
    } else {
        let name = document.getElementsByClassName('login-register').item(0);
        // 将登录注册按钮替换成用户名称 并设置用户主页超链接
        name.innerHTML = `<a href="/login">登录 / 注册</a>`;
        console.log('Failed to fetch user info.');
    }
    // 顶部超链接
    const navigationLinks = document.querySelectorAll('.navigation a');
    // 定义每个链接的新目标 URL
    const newUrls = {
        '首页': '/index',
        '组队': '/team',
        '人才': '/talent',
        '任务': '/tasks'
    };
    // 修改每个超链接的 href 属性
    navigationLinks.forEach((link) => {
        const text = link.textContent.trim();
        const newUrl = newUrls[text];
        if (newUrl) {
            link.href = newUrl;
        }
    });
});
//在右边添加我的消息列表
document.addEventListener('DOMContentLoaded', function() {
    // 获取侧边栏菜单的ul元素
    const sidebarMenu = document.querySelector('.sidebar-menu');

    // 创建新的li元素
    const newMenuItem = document.createElement('li');
    newMenuItem.className = 'menu-item';

    // 创建a元素，设置跳转链接
    const link = document.createElement('a');
    link.href = '/talk2.html';

    // 创建img元素
    const img = document.createElement('img');
    img.src = '/icon/messageIcon.svg'; // 请替换为你自己的图标路径
    img.alt = '我的消息图标';

    // 创建span元素
    const span = document.createElement('span');
    span.textContent = '我的消息';

    // 将img和span添加到a元素中
    link.appendChild(img);
    link.appendChild(span);

    // 将a元素添加到新的li元素中
    newMenuItem.appendChild(link);

    // 将新的li元素添加到ul中
    sidebarMenu.appendChild(newMenuItem);
});