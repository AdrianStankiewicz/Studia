netsh -c interface dump > c:\konfiguracja.

echo Podaj nazwe interfejsu
set /p nazwa_interfejsu=">> "
echo Podaj adres ip
set /p adres_ip=">> "
echo Podaj maske sieci
set /p maska_sieciowa=">> "
echo Podaj brame domyslna
set /p brama_domyślna=">> "

netsh interface ip set address name=%nazwa_interfejsu% %adres_ip% %maska_sieciowa% %brama_domyślna%

netsh -f c:\konfiguracja.txt

pause