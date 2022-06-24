"use strict"

let gallery = document.getElementsByClassName('fotka');

gallery[0].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o1.jpg';
});
gallery[1].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o2.jpg';
});
gallery[2].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o3.jpg';
});
gallery[3].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o4.jpg';
});
gallery[4].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o5.jpg';
});
gallery[5].addEventListener('click', () => {
    document.getElementById('chosen').src = '../foto/o6.jpg';
});