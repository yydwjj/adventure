function getToken() {
    return localStorage.getItem('authToken');
}
// 获取用户信息
function getUserInfo() {
    const jwtToken = getToken();

    fetch('/user/getUserInfo', {
        method: 'GET',
        headers: {
            // 'Authorization': `Bearer ${jwtToken}`,
            'Content-Type': 'application/json',
            'token':`${jwtToken}`
        }
    })
        .then(response => response.json())
        .then(data => {
            // document.getElementById('response').innerText = JSON.stringify(data, null, 2);
           return data;
        })
        .catch(error => {
            console.error('Error:', error);
            return null;
        });
}

