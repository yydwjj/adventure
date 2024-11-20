document.getElementById('resume_form').addEventListener('submit', async (event) => {

      // 统一处理表单提交和保存按钮点击的事件处理函数
      const handleSubmit = async function (event) {

        const resumeForm = document.getElementById('resume_form');
        const nameInput = document.getElementById('name');
        const phoneInput = document.getElementById('phone');
        const emailInput = document.getElementById('email');
        event.preventDefault(); // 阻止默认的表单提交行为，避免页面刷新等
        let isValid = true;

        // 验证姓名不能为空
        if (nameInput.value.trim() === '') {
          alert('姓名不能为空');
          isValid = false;
          return;
        }

        // 验证电话号码是否符合格式（简单示例，可进一步完善正则）
        const phoneRegex = /^[0-9]{11}$/;
        if (!phoneRegex.test(phoneInput.value)) {
          alert('请输入正确的11位电话号码');
          isValid = false;
          return;
        }

        // 验证邮箱格式
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(emailInput.value)) {
          alert('请输入正确的邮箱地址');
          isValid = false;
          return;
        }

        if (isValid) {
          console.log('表单验证通过，可以提交数据');
          const formData = new FormData(event.target);
          const data = Object.fromEntries(formData.entries());
          const authToken = localStorage.getItem('authToken');

          // 使用fetch发送POST请求
          try {
            const response = await fetch('/resumes/save', {
              method: 'PUT',
              headers: {
                'Content-Type': 'application/json',
                'token': authToken
              },
              body: JSON.stringify(data)
            });

            if (response.ok) {
              const result = await response.json();
              console.log('Resume saved successfully:', result);
              alert("简历保存成功！");
              window.location.href = 'resume.html';
              // 处理成功响应
            } else {
              const error = await response.json();
              console.error('Error saving resume:', error);
              // 处理错误响应
            }
          } catch (error) {
            console.error('Network error:', error);
            // 处理网络错误
          }
        }
      };
    });