echo off
mkdir ProgramStankiewiczZadanie4
echo >> ProgramStankiewiczZadanie4\plikEgzekucyjny.exe

::if exist start vcpp-redist.exe :: - program uruchomi plik vcpp-redist.exe jeżeli takowy istnieje

echo Czy chcesz utworzyc skroty na pulpicie (1 oznacza tak, 0 oznacza nie)?
set /p czy=">> "
if %c% == 1 ( mklink C:\Users\adi02\Desktop C:\Users\adi02\Dekstop\ProgramStankiewiczZadanie4\plikEgzekucyjny.exe & echo Skrot zostal utworzony)
if %c% == 0 echo Skrot nie zostal utworzony
pause