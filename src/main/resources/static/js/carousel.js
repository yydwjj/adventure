document.addEventListener('DOMContentLoaded', function() {
    let slideIndex = 0;
    const slides = document.querySelectorAll('.carousel-slide');
    const prevButton = document.querySelector('.carousel-prev');
    const nextButton = document.querySelector('.carousel-next');
    const carouselContainer = document.querySelector('.carousel-container');

    // 设置图片样式
    slides.forEach(slide => {
        const img = slide.querySelector('img');
        img.style.width = '100%';
        img.style.height = '100%';
        img.style.objectFit = 'cover'; // 保持图片的宽高比，覆盖整个容器
    });

    // 设置 carousel-container 的样式
    carouselContainer.style.height = '200px'; // 调整高度
    carouselContainer.style.marginBottom = '80px'; // 添加底部外边距

    function showSlides(n) {
        if (n >= slides.length) slideIndex = 0;
        if (n < 0) slideIndex = slides.length - 1;

        slides.forEach(slide => slide.classList.remove('active'));
        slides[slideIndex].classList.add('active');
    }

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    prevButton.addEventListener('click', function() { plusSlides(-1); });
    nextButton.addEventListener('click', function() { plusSlides(1); });

    // 自动播放
    setInterval(function() { plusSlides(1); }, 5000);

    // 初始化
    showSlides(slideIndex);
});