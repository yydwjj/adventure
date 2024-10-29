document.addEventListener('DOMContentLoaded', function() {
    let slideIndex = 0;
    const slides = document.querySelectorAll('.carousel-slide');
    const prevButton = document.querySelector('.carousel-prev');
    const nextButton = document.querySelector('.carousel-next');

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