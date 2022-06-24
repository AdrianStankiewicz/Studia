'use strict';

function sprawdzDane(f)
{
  let regExName = /[A-Z]{1}[a-z]+)\w+/;
  let regExIndex = /([0-9]{4})\w+/;
  let regExYear = /([1-2]{1}[0-9]{2})\w+/;

  let ifName = regExName.test(document.getElementById("imnaz").value);
  let ifIndex = regExIndex.test(document.getElementsByName("indeks").value)
  let ifYear = regExYear.test(document.getElementsByName("rok").value)

  if(ifName && ifIndex && ifYear) {
    return true;
  }
  return false;   //true oznacza, że formularz jest poprawny i mozna go wysłać
}

// ZROBIĆ TO DO KOŃCA MAJÓWKI 2, 3, 4