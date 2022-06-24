"use strict"

let imgs = ["../foto/o1.jpg", "../foto/o2.jpg", "../foto/o3.jpg", "../foto/o4.jpg", "../foto/o5.jpg", "../foto/o6.jpg"];
let baner = document.getElementById('baner');

setInterval(() => {
    baner.src = imgs[Math.floor(Math.random() * imgs.length)];
}, 5000);
