@echo off
@chcp 1250
echo Podaj pierwsza liczbe
set /p liczba1=">> "
echo Podaj druga liczbe
set /p liczba2=">> "

set /a wynik=%liczba1%+%liczba2%

echo Oto wynik: %wynik%
echo liczba1 to: %liczba1% >> wynik_4.4_AdrianStankiewicz.txt
echo liczba2 to: %liczba2% >> wynik_4.4_AdrianStankiewicz.txt
echo wynik to: %wynik% >> wynik_4.4_AdrianStankiewicz.txt
pause