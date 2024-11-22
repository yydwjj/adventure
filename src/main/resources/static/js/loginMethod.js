// 登录的方法
document.getElementById('login-form').addEventListener('click', async function(event) {
    event.preventDefault();

    const phoneNumber = document.getElementById('phone').value;
    const userPwd = document.getElementById('userPwd').value;

    try {
        const response = await fetch('/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ phoneNumber, userPwd })
        });

        if (response.ok) {
            const data = await response.json();
            const token = data.data.token;

            if (token) {
                // 存储 token
                storeToken(token);

                // 重定向到用户首页或其他页面
                window.location.href = 'index';
            } else {
                throw new Error('Token not found in response data');
            }
        } else {
            const errorData = await response.json();
            alert(errorData.message || 'Login failed. Please try again.');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Login failed. Please try again.');
    }
});

function storeToken(token) {
    // 选择存储方式：LocalStorage、SessionStorage、Cookie等
    localStorage.setItem('authToken', token);
}