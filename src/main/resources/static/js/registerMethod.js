document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('.sign-up-form');

    form.addEventListener('submit', (event) => {
        event.preventDefault(); // 阻止表单默认提交行为

        // 获取表单字段的值
        const username = form.querySelector('input[placeholder="用户名"]').value.trim();
        const phoneNumber = form.querySelector('input[placeholder="手机号码"]').value.trim();
        const userPwd = form.querySelector('input[placeholder="密码"]').value.trim();

        // 校验用户名是否为空
        if (!username) {
            alert('用户名不能为空！');
            return;
        }

        // 校验手机号码是否合法
        const phoneRegex = /^1[3456789]\d{9}$/;
        if (!phoneRegex.test(phoneNumber)) {
            alert('请输入有效的手机号码！');
            return;
        }

        // 打印表单字段的值
        console.log('用户名:', username);
        console.log('手机号码:', phoneNumber);
        console.log('密码:', userPwd);

        // 发送注册请求
        fetch('/user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, phoneNumber, userPwd })
        })
            .then(response => response.json())
            .then(data => {
                console.log('注册成功:', data);
                alert('注册成功');

                // 触发动画效果（示例：点击登录按钮触发动画）
                const signInBtn = document.getElementById('sign-in-btn');
                if (signInBtn) {
                    signInBtn.click();
                }
            })
            .catch(error => {
                console.error('注册失败:', error);
                alert('注册失败，请稍后重试！');
            });
    });
});
