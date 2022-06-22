1.      Złożonść obliczeniowa - Jest to rzecz która pozwala okreslić ile zasobów komputerowych potrzeba aby obliczyć dany problem algorytmiczny
2.      Jeżeli znamy zasady złożonści algorytmicznej jesteśmy w stanie pisać bardziej optymalne programy, które nie będą zużywały niepotrzebnych zasobówpoprzez  używanie nieoptymalnych rozwiązań
3.      Notacja Wielkiego O ('big O notation') - Określa złożoność obliczeniową algorytmów dążących do nieskończoności
4.    Złożoność O(n<sup>2</sup>) = time(statement 1) + time(statement 2) + ... + time(statement k)
- patrzymy jedynie na najważniejszy wpływ. np. n<sup>3</sup> > n<sup>2</sup>
- ignorujemy stałe
5.      DRY (Don't Repeat Yourself) - Polega na seperacji powtarzającego się kodu i jedynie odwoływaniu się do niego w razie potrzeby (goto lub function)
6.      Dzięki stosowaniu DRY kod jest o wiele bardziej czytelny oraz zajmuje dużo mniej miejsca
7.  - unikanie powtórzeń kodu
    - zamykanie kodu w funkcji i jedynie odwoływanie się do niej
8.      (modyfikator) (typ-zwrotu) (nazwa) (podawane-paramery)
    - modyfikator: private / public
    - typ-zwrotu: typ wartosci jaka funkcja zwroci po wykonaniu
    - nazwa: np. funkcja_Stankiewicz
    - podawane parametry (np. int x, string slowo);
9.      void jest typem zwrotu który nie zwraca nic - Funkcja liczy w sobie ale nie zawiera słowa return
10.     Public | Private
    - Public: Masz dostep do funkcji z Main
    - Private: Masz dostep do danej funkcji jedynie przez wbudowane w nią rzeczy
11. - Dla funkcji mających wartosc zwracaną: return wartość
    - Dla funkcji bez wartosci: mozna pominac lub return;
12.     Argument domyślny to argument, który można ale nie trzeba podawać. Jeżeli go podamy, to domyślna wartość argumentu w wywołaniu zostanie przez nas nadpisana. Jeśli jednak go nie podamy, to argument przyjmie swoją wartość domyślną.
        
        np. public static int funkcja(int a=5) { return Math.Sin(a); }
13.     Argument nazwany jest identyfikowany po swojej nazwie a nie po kolejności wywołania.
``` C#
public static void funkcjaZeZwyklymArgumentem(int a, int b) 
{
    Console.Write("a ma wartość" + a + ", b ma wartość " + b);
}
funkcjaZeZwyklymArgumentem(5, 10);
// output: a ma wartość 5, b ma wartosc 10
```

``` C#
public static void funkcjaZNazwanymArgumentem(int a, int b) 
{
    Console.Write("a ma wartość" + a + ", b ma wartość " + b);
}
funkcjaZNazwanymArgumentem(b: 5, a: 10);
// output: a ma wartosc 10, b ma wartosc 5
```
14.     Oznacza to, że istnieje kilka funkcji o tej samej nazwie ale da się jej rozróżnić przez rózne typy lub ilości wymaganych przez nie argumentow
15.     Słowo kluczowe ref pozwala na zmianę wartości zmiennej (w głownym ciele programu) w funkcji (Main) programu nawet, jeżeli pod koniec programu nie zwracamy (return) nowej wartosci funkcji
``` C#
void Metoda(ref int argumentRef)
{
    argumentRef += 44;
}

argumentRef = 1;
Console.Write(Metoda(ref argumentRef));
// output: 45
```
16.     robi to samo co ref, ale służy do zwrotu funkcji (poprzez adres) oraz nie musi byc zadeklarowana przed wywołaniem funkcji
17.     Funkcja rekurencyjna to taka, która w swoim bloku kodu odwołuje się do siebie samej ze zmienionym argumentem
18. - silnia nierekurencyjna:
    ```` C#
    Silnia z n = for(int i=0;i<n;i++){
        wynikSilni*=n
    }
    ````
    - silnia rekurencyjna:
    ````C#
    public static int Ciag_Rekurencyjne(n){
    if (n==1) return 1;
            else return (Ciag_Rekurencyjny(n-1)*Ciag_Rekurencyjny(n-1))-3;
    }
    ````
19.     kod ASCII to odwzorowanie znakow alfanumerycznych (głownie dla języka Angielskiego) na liczby (w systemie 7bitowym), zatem jedynie 128 znakow.
20.     jest to rozszerzone ASCII o znaki, ktore nie zmiescily sie w oryginalnym 128 znakowym zapisie (jest bardzo wiele roznych typow eASCII)
21.     Strona kodowa to lista zawierająca odpowiadające sobie numey w danym kodowaniu a ich odpowiednik numeryczny
        np. ASCII: litery do liczb
22.     Różne strony kodowe mają różny zakres znaków - Przy użyciu złego kodowania można mieć nieodczytywalne znaki
23.     Unicode - Jest to uniwersalne kodowanie wszystkich znaków na świecie
24.     W teorii pozwala na używanie wszystkich możliwych znaków na świecie (teoretycznie) bez problemów
25. - utf-8 jest kodowany na 1 bajcie
    - utf-16 jest kodowany na 2 bajcie
    - utf-32 jest kodowany na 4 bajtach
26.     UTF-16, Encoding.Convert
27.     Unicode UTF-8, Encoding.Convert
28.     Znak ucieczki ( \ )  pozwala na ucieczkę z reguł konkretnego wyrażenia
        np. """" da nam dwa puste stringi
        "\"\"" da nam stringa o treści ""
29. - \+ konkatenacja
    - += konkatenacja rozszerzona
    - = przypisanie
    - == porownanie
    - [n] dostep do konkretnego znaku (tylko odczyt)
30.     Sposób przechowywania i zarządzania plikami w taki sposób, aby dostep do nich był dla użytkownika łatwy
31.     Katalog w Unix/Linux jest reprezentowany przez /  
        natomiast w Windows \

        - NTFS jest bardzo rozbudowany i ma w sobie wiele informacji, wielkosc od 512B do 4 kB
        - etx zawieta bardzo mało informacji i jest napisany w prosty sposób, rozmiar od 1 do 4kB
32.     Kwalifikowana nazwa pliku jednoznacznie determinuje o jaki plik w komputerze.
        
        np. na komputerze może być milion plików text.txt, ale tylko jeden taki plik dokładnie w C:\text.txt
33.     Plik - zbiór danych zapisanych w określonym porządku, określoną nazwą i w określonym miejscu
        
        Plik zmienia się w strumień kiedy staramy się go odczytać przy pomocy programu (np. dokładniej funkcji StreamReader lub StreamWriter). Strumień to najprościej mówiąc sekwencja bajtów.
34.     Przetwarzanie potokowe to sekwencyjny sposób przetwarzania danych. Każda sekwencja kolejno trafia do określonych bloków tak długo, aż nie dotrze do ostatniego bloku (każdy blok połączony jest z następnym, aż do ostatniego, który kończy schemat)
35.     Plik tekstowy - Zawiera w sobie dane zapisane w sposób alfanumeryczny

        Plik binarny - Zawiera sobie dane zapisane w postaci kodu np. binarnego lub hexadecymalnego (raczej o rozszerzeniu .bin)
36. - TextWriter
        - Stream Writer - (zapisuje znaki do strumienia w określonym kodowaniu)
        - String Writer - (zapisu informacje w ciągu / wpisuje pobrany ciąg danych do stringa)
    - TextReader
        - Stream Reader - (odczytuje znaki ze strumienia bajtów w określonym kodowaniu)
        - String Reader - (odczytuje z ciągu / czyta po prostu cały string)
37. 
38.     Tryby otwarcia FileStream.Open:
            * CreateNew     - Tworzy nowy plik. Jeżeli dany plik już istnieje to IOException
            * Create        - Tworzy nowy plik. Jeżeli dany plik już istnieje to zostanie zastapiony. Jeżeli ukryty to IOException
            * Open          - Otwiera istniejący plik. Jeżeli dany plik nie istnieje to IOException
            * OpenOrCreate  - Otwiera plik. Jeżeli dany plik nie istnieje to tworzy nowy plik
            * Truncate      - Otwiera plik. Jeżeli plik istnieje to w nim pisze. Jeżeli jest coś w nim zapisane to nadpisuje (TEN SAM PLIK). Jeżeli nie istnieje to tworzy nowy plik.
            * Append        - Otwiera plik. Jeżeli plik istnieje to po prostu w nim pisze. Jeżeli plik istnieje i jest już coś w nim zapisane to dopisuje. Jeżeli plik nie istnieje to tworzy nowy
39. 