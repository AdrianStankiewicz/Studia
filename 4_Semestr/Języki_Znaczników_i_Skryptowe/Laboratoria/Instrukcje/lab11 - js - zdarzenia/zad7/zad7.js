"use strict"

let jezyk = document.getElementById('jezyk');
let checkboxy = document.getElementById('checkboxy');

let pon = document.getElementById('pon');
let wto = document.getElementById('wto');
let sro = document.getElementById('sro');
let czw = document.getElementById('czw');
let pia = document.getElementById('pia');
let sob = document.getElementById('sob');
let nie = document.getElementById('nie');

pon.addEventListener('click', () => {
    jezyk.value = 'poniedziałek';
});
wto.addEventListener('click', () => {
    jezyk.value = 'wtorek';
});
sro.addEventListener('click', () => {
    jezyk.value = 'środa';
});
czw.addEventListener('click', () => {
    jezyk.value = 'czwartek';
});
pia.addEventListener('click', () => {
    jezyk.value = 'piątek';
});
sob.addEventListener('click', () => {
    jezyk.value = 'sobota';
});
nie.addEventListener('click', () => {
    jezyk.value = 'niedziela';
});

jezyk.addEventListener('focusin', () => {
    checkboxy.classList.toggle('displayNone');
});
jezyk.addEventListener('focusout', () => {
    setTimeout(() => {
        checkboxy.classList.toggle('displayNone')
    }, 100);
});
jezyk.addEventListener('click', () => {
    document.getElementsByName('dzien').forEach((e) => {
        e.checked = false;
    });
    jezyk.value = '';
});