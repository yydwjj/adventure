// 获取当前页面元素
const currentPageElement = document.getElementById("current-page");
let currentPage = 1; // 默认初始页面

// 获取所有页码按钮
const pageButtons = document.querySelectorAll(".page-number");
const prevButton = document.getElementById("prev-page");
const nextButton = document.getElementById("next-page");

// 更新页码显示
function updatePageNumber(page) {
    currentPage = page;
    currentPageElement.textContent = currentPage;
    updateButtonState();
}

// 更新上一页和下一页按钮的状态
function updateButtonState() {
    // 设置上一页和下一页按钮的禁用状态
    prevButton.disabled = currentPage === 1;
    nextButton.disabled = currentPage === pageButtons.length;

    // 更新页码按钮的选中样式
    pageButtons.forEach(button => {
        const page = parseInt(button.getAttribute("data-page"));
        if (page === currentPage) {
            button.classList.add("active"); // 高亮当前页
        } else {
            button.classList.remove("active");
        }
    });
}

// 为每个页码按钮绑定点击事件
pageButtons.forEach(button => {
    button.addEventListener("click", (e) => {
        const page = parseInt(e.target.getAttribute("data-page"));
        if (page !== currentPage) {
            updatePageNumber(page);
        }
    });
});

// 上一页按钮点击事件
prevButton.addEventListener("click", () => {
    if (currentPage > 1) {
        updatePageNumber(currentPage - 1);
    }
});

// 下一页按钮点击事件
nextButton.addEventListener("click", () => {
    if (currentPage < pageButtons.length) {
        updatePageNumber(currentPage + 1);
    }
});

// 初始化页面状态
updatePageNumber(currentPage);
