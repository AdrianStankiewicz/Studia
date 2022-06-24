"use strict"

let head1 = document.getElementById('header1');
let colors = ["red", "blue", "green", "cyan", "magenta", "black", "yellow", "brown", "gray", "orange"];

head1.addEventListener("mouseenter", () => {
    head1.style.color = colors[Math.floor(Math.random() * colors.length)];
});

