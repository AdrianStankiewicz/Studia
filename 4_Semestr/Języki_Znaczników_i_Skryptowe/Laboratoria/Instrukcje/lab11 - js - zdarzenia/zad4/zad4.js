"use strict"

let header = document.getElementById('header4');

setInterval(() => {
    header.style.color = '#' + Math.floor(Math.random()*16777215).toString(16);
}, 5000);