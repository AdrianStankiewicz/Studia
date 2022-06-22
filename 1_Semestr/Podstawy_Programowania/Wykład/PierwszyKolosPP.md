## 1. 
.NET jest darmową, cross-platformową, open-sourcową platformą developerską służącą do budowania apliakcji.
Można na niej pisać w wielu językach (chociażby C#, F# lub Visual Basic)

## 2.
Środowisko uruchomieniowe CLR (CommonLanguageRuntime) oraz Bibliotek

## 3.
- Windows.Forms - biblioteka wizualna umożliwiająca zaprojektowanie GUI

- WebServices - biblioteka umożliwiająca prace w architekturze rozproszonej

- ADO.NET - biblioteka dająca dostęp do danych i serwisów danych

- ASP.NET - biblioteka umożliwiająca budowę aplikacji internetowych

- XML, SQL - biblioteki umożliwiają prace nad standardami opisu danych (XML i SQL) 

- BCL (BaseClassLibrary) - biblioteka zapewniająca najpopularniejsze typy i funkcje narzędziowe oraz są podstawą wszystkich innych bibliotek klas platformy .NET

## 4.
odpowiednik Asemblera dla .NET. Najniższy język rozumialny dla człowieka, "pośrednik" między językami wysokimi i nieskimi

## 5.
Cross-Platformowość C# jest bardzo skomplikowana:

- Aplikacja Konsolowa będzie działała wszędzie (TRZEBA UŻYWAĆ Mono  LUB .NET Standard LUB .NET Core)
(.NET Core umie zbudować sobie samo w sobie środowisko które nie wymaga instaliwania środowiska C#)
- C# aplikacje webowe działają jak .NET Core
- GUI do C# się bardzo kłócą - najlepsze działają tylko na Windows

## 6. 
Boolean – wartości logiczne (true i false)
Int32, Int16, Int64 – liczby całkowite ze znakiem (+- różny zakres wartości)
UInt32, UInt16, UInt64 – liczby całkowite bez znaku
Double, Single – liczby rzeczywiste zmiennoprzecinkowe (single np. 1.1, double np. 1.23948923645)
String - łańcuch znaków

## 7.
Parse pozwala na konwersję z jednego typu prostego na drugi (np. Int32.Parse(Console.ReadLine()) przekonwersuje nam ze stringa na Int32)

## 8.
Ponieważ wartosć Int32 może być za duża dla Int16. Konwersja w drugą stronę będzie działać
Int 32: -2,147,483,648 to 2 147 483 647
Int 16: −32 768 to 32 767

## 9.
Deklaracja klasy w C# ma formę Form f2 = new Form2();
(np. tabela int: int[] tabela = new int32[])

## 10.
Utworzony zostanie tylko jeden obiekt. Inne będą skierowaniem do komórek w których zapisany jest obiekt oryginalny

## 11.
dodawanie: +  
odejmowanie: -  
mnożenie: *  
dzielenie: /  
modulo: %  

## 12.
większość: >  
większość/równość: >=  
mniejszość: <  
mniejszość/równość: <=  
równe: ==  
przypisanie wartości: =  
różne: !=

## 13.
mnożenie: *=  
dzielenie: /=  
dodawanie: +=  
odejmowanie: -=

## 14.
Operator oznacza "nie równe"
````C#
int a=7, b=6
if(a!=b) Console.Write("Lol różne")  
else Console.Write("o lol nie różne")
````

## 15.
Ponieważ cyfry wprowadzane bez zmiennych są traktowane jako int nie jako double wynik jest przypisywany jako wynik dzielenia intów a potem wbijany w double
````C# 
//działa dobrze
double x=3, y=4;
x /= y;
Console.WriteLine(x);
Console.ReadKey(true);
````
````C#
//działa źle
double x;
x = 3/4;
Console.WriteLine(x);
Console.ReadKey(true);
````

## 16.
Hierarchia operatrów to na ludzkie kolejność wykonywania działań  
np. 2+2*2 = 6 ALE (2+2)*2 = 8

## 17.
wyżej: / * %  
niżej: + -

## 18.
Działanie wykonujemy od lewej do prawej  
(wyjątkiem jest =, gdzie pierw liczymy prawą stronę a potem przypisujemy do lewej)

## 19.
Wykonujemy przypisanie ktok po kroku:
- Do b wpisujemy 3+2
- Do a wpisujemy wartość b
- Do y wpisujemy 4*5(a)

## 20.
![wzory matematyczne](zrzut.png)

## 21.
````C#
y = (3*a) / (Math.Sqrt(a)+b);
````
## 22.
;

## 23.
blok instrukcji to kawałek kody zamknięty w nawias klamrowy {}. Pozwala on na wydzielenie pewnej części kodu w jakimś celu  
np.
````C#
if() {

}

for() {

}
````

## 24.
````C#
if(WARUNEK) {
    BLOK KODU
}
````
## 25.
````C#
if(WARUNEK){ //wykona się
    "BLOK KODU";
}
else if(WARUNEK) { //wykona się tylko jeżeli poprzedni jest zły
    "BLOK KODU";
}
else { //wykona się jak oba poprzednie są złe
    "BLOK KODU";
}
````
## 26.
````C#
for(INICJACJA; WARUNEK; KROK) {
    "BLOK KODU";
}
````
kolejność:
1. deklaruję int
2. wykonuję blok kodu
3. wykonuję krok
4. sprawdzam warunek
5. wróć do 2
## 27.
````C#
while(WARUNEK) {
    "BLOK KODU";
}
````

## 28.
Drukowanie liczb od 1 do 2137:
````C#
for(int i = 1; i <= 2137; i++>) {
    Console.WriteLine(i);
}
````
 ## 29.
Wolimy używać for gdy wiemy ile razy się wykona, while jest do rzeczy o których nie wiemy ile razy musi się wykonać
- drukowanie tablicy
- obliczanie silni

## 30.
While używamy, gdy coś się musi wykonać nie wiemy ile razy
- pliki txt (eof)
- rekurencja

## 31.
````C#
try {
    //tutaj się wykonuje kod który jeżeli zrobiłby błąd
}
catch {
    //To tu ten błąd się obsłuży i zamiast wywalić nas na głupi ryj to napisze nam ładny błąd
}
````

## 32.
````C#
Int32 przyjmowanaLiczba, znanaLiczba=5,wynik;
try {
    przyjmowanaLiczba = Console.ReadLine();
    wynik = przyjmowanaliczba + znanaLiczba;
}
catch {
    Console.WriteLine("Złe dane wprowadzone przez użytkownika");
}
````

## 33.
Math. udostępnia mam funkcje matematyczne w C# które sprawiają, że C# umie w matematyke.

Nie trzeba i nie mozna tworzyć nowych obiektów Math.
````C#
int pi = Math.PI();
````
## 34.
Console daje nam dostęp do bazowego wejścia i wyjścia komputera (klawiatury i ekranu) oraz edycję konsoli.
````C#
Console.Write("Wpisz Pan 5");
int a = int.Parse(Console.ReadLine());
Console.WriteLine("Wpisał Pan " + a);
````