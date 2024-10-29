// script.js
document.addEventListener('DOMContentLoaded', function() {
    const sidebar = document.getElementById('sidebar');
    const toggleButton = document.getElementById('sidebarToggle');

    toggleButton.addEventListener('click', function() {
        if (sidebar.style.right === '0px' || sidebar.style.right === '') {
            sidebar.style.right = '-200px';
        } else {
            sidebar.style.right = '0px';
        }
    });
});