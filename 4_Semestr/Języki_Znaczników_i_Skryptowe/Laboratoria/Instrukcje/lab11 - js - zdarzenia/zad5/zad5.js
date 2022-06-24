"use strict"

setInterval(() => {
    document.getElementById('screenSize').innerHTML = screen.width + 'x' + screen.height;
    document.getElementById('windowSize').innerHTML = window.innerWidth + 'x' + window.innerHeight;
}, 50);

document.getElementById('browserVersion').innerHTML = navigator.userAgent;