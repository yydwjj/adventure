// 用户注册的js
// 希望注册成功后 可以触发动画效果，注册失败可以提示
// 登录的方法
document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('.sign-up-form');

    form.addEventListener('submit', (event) => {
        event.preventDefault(); // 阻止表单默认提交行为

        // 获取表单字段的值
        const username = form.querySelector('input[placeholder="用户名"]').value;
        const phoneNumber = form.querySelector('input[placeholder="手机号码"]').value;
        const userPwd = form.querySelector('input[placeholder="密码"]').value;

        // 打印表单字段的值
        console.log('用户名:', username);
        console.log('手机号码:', phoneNumber);
        console.log('密码:', userPwd);

        fetch('/user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, phoneNumber, userPwd})
        })
        .then(response => response.json())
        .then(data => {
            console.log('注册成功:', data);
            alert('注册成功');
            const signInBtn = document.getElementById('sign-in-btn');
            signInBtn.click();
        })
        .catch(error => {
            console.error('注册失败:', error);
        });
    });
});
