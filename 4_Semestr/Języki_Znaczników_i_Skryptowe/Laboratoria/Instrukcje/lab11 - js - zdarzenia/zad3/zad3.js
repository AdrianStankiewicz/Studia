"use strict"

let deg = document.getElementById('deg');
let rad = document.getElementById('rad');
let out = document.getElementById('out');

deg.addEventListener('click', () => {
    out.innerHTML = parseFloat(document.getElementById('wartosc').value) * (Math.PI/180); 
});

rad.addEventListener('click', () => {
    out.innerHTML = parseFloat(document.getElementById('wartosc').value) * (180/Math.PI); 
});