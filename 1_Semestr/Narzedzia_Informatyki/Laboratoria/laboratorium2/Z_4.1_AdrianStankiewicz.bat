@echo off
@chcp 1250
echo Podaj imie
set /p imie=">> "
echo Podaj nazwisko
set /p nazwisko=">> "
echo Podaj wzrost
set /p wzrost=">> "
echo Podaj wage
set /p waga=">> "

set /a BMI=%waga%/(%wzrost%*%wzrost%)
echo %BMI%

echo Imie: %imie% >> wynikStankiewicz4.1.txt
echo Nazwisko: %nazwisko% >> wynikStankiewicz4.1.txt
echo Wzrost: %wzrost% >> wynikStankiewicz4.1.txt
echo Waga: %waga% >> wynikStankiewicz4.1.txt
echo BMI: %BMI% >> wynikStankiewicz4.1.txt

pause

echo Podziekowania
timeout /t 3
exit