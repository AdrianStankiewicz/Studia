@echo off
echo podaj slowo
set /p slowo=">> "
:tutaj
echo %slowo%
set /a liczba+=1
echo %liczba% > wynik_4.5_AdrianStankiewicz.txt
goto tutaj
pause