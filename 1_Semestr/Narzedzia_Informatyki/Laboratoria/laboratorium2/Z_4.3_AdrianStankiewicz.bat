@echo off
@chcp 1250
echo Podaj link do strony (bez www)
set /p link=">> "
echo Ile razy mam pingowac?
set /p ile=">> "
echo Wielkosc bufora?
set /p bufor=">> "
ping %link% -n %ile% -l %bufor% >> wynik_4.3_AdrianStankiewicz.txt
pause 