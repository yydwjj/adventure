// 动态的修改顶部以及"我的"相关连接
//修改用户名显示
getUserInfo().then(data => {
    if (data) {
        console.log('User Info:', data);
        // 保存用户信息
        const userInfoString = JSON.stringify(data.data.loginUser);
        sessionStorage.setItem('myInfo', userInfoString);

        let name = document.getElementsByClassName('login-register').item(0);
        // 将登录注册按钮替换成用户名称 并设置用户主页超链接
        name.innerHTML=`<a href="show/userindex/${data.data.loginUser.userId}">${data.data.loginUser.username}</a>`;
        // 侧边栏中超链接的设置
        const menuItems = document.getElementById('sidebar').querySelectorAll('.menu-item span');
        // 定义每个菜单项对应的 URL
        const menuUrls = {
            '个人信息': `/profile`,
            '我的简历': `/resume`,
            '我的队伍': `/team`,
            '历史任务': `/history`
        };
        // 为每个 span 元素添加点击事件监听器
        menuItems.forEach((span) => {
            span.addEventListener('click', (event) => {
                const text = span.textContent.trim();
                const url = menuUrls[text];
                if (url) {
                    window.location.href = url;
                }
            });
        });
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
    } else {
        let name = document.getElementsByClassName('login-register').item(0);
// 将登录注册按钮替换成用户名称 并设置用户主页超链接
        name.innerHTML=`<a href="show/login">登录/注册</a>`
        console.log('Failed to fetch user info.');
    }
});