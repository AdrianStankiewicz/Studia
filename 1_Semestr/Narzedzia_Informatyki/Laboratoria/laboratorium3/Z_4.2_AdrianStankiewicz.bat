echo Ile liczb chcesz podac?
set /p ile=">> "
FOR /L %%x IN (1,1,%ile%) DO ( echo Podaj liczbe & set /p liczba=">> " & set /a suma += liczba ) 

echo Suma liczb to: %suma%

pause