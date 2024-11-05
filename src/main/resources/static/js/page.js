// 获取所有必要的 DOM 元素
const prevButton = document.getElementById('prev-page');
const nextButton = document.getElementById('next-page');
const currentPageElem = document.getElementById('current-page');
const pageNumbers = document.querySelectorAll('.page-number');

// 初始化当前页码
let currentPage = 1;
const totalPages = pageNumbers.length;

// 更新页码显示和按钮状态
function updatePagination() {
    // 更新当前页码文本
    currentPageElem.textContent = currentPage;

    // 更新每个页码按钮的样式
    pageNumbers.forEach(button => {
        const pageNumber = parseInt(button.dataset.page);
        if (pageNumber === currentPage) {
            button.classList.add('active');  // 给当前页添加 active 样式
        } else {
            button.classList.remove('active'); // 移除其他页的 active 样式
        }
    });

    // 上一页和下一页按钮的禁用状态
    prevButton.disabled = currentPage === 1;
    nextButton.disabled = currentPage === totalPages;
}

// 处理上一页按钮点击
prevButton.addEventListener('click', () => {
    if (currentPage > 1) {
        currentPage--;
        updatePagination();
    }
});

// 处理下一页按钮点击
nextButton.addEventListener('click', () => {
    if (currentPage < totalPages) {
        currentPage++;
        updatePagination();
    }
});

// 处理页码按钮点击
pageNumbers.forEach(button => {
    button.addEventListener('click', () => {
        currentPage = parseInt(button.dataset.page);
        updatePagination();
    });
});

// 初始化分页显示
updatePagination();
