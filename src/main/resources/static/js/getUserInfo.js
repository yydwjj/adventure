function getToken() {
    return localStorage.getItem('authToken');
}
// 获取用户信息
// 获取用户信息
function getUserInfo() {
    const jwtToken = getToken();

    // 返回 fetch 的 Promise
    return fetch('/user/getUserInfo', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'token': `${jwtToken}`
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json(); // 返回解析后的 JSON 数据
        })
        .catch(error => {
            console.error('Error:', error);
            return null; // 返回一个空值作为错误处理
        });
}


