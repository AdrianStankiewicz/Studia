# 1. Wymień 4 podstawowe paradygmaty w oparciu o które powstały języki programowania
- ### Imperatywny (Algol, Fortran, Pascal, C)
- ### Obiektowy (Smalltalk, Java, C++, C#,, Ada)
- ### Funkcyjny (Scheme, Haskell, ML, Scala)
- ### Logiczny (Prolog)
___
# 2. Podaj charakterystyczne cechy programowania imperatywnego
- ### Wykonanie każdej instrukcji zmienia stan programu (pamięci, rejestrów, znaczników procesora)
- ### Abstrakcja, dziedziczenie, hermetyzacja
- ### Zmienne mogą być różnych typów (jawnie bądź niejawnie deklarowanych)
- ### Instrukcje mogą być zagnieżdżane (strukturalność) 
___
# 3. Podaj nazwy kilku języków imperatywnych/obiektowych/funkcyjnych
- ## Imperatywne:
    - ### Fortran
    - ### Pascal
    - ### C
- ## Obiektowe:
    - ### Java
    - ### C++
    - ### C#
- ## Funkcyjne:
    - ### Scheme
    - ### Haskell
    - ### Scala
___
# 4. Wyjaśnij znaczenie pojęcia zmiennej w:
- ## języki imperatywne
    - ### zmienna to abstrakcja komórek pamięci (miejsce w pamięci komputera)
- ## języki funkcyjne
    - ### wartość, którą podajemy przy wywołaniu funkcji która potem z niej korzysta
- ## prolog
    - ### wartość, pod którą program podczas działania dopasuje pasujące odpowiedzi
- ## matematyka
    - ### Symbol pod który można podstawić dowolną liczbę spełniającą założenia
___
# 5. Jakie struktury danych występują w językach imperatywnych?
- ### kolejka
- ### drzewo
- ### graf
- ### stos
- ### lista
- ### tablica
___
# 6. Jakie struktury danych występują w językach funkcyjnych i prologu?
- ## Funkcyjne
    - ### lista
    - ### graf
- ## Prolog
    - ### lista
    - ### atom
___
# 7. Jak rozumieć termin „architektura von Neumanna”, w jakim kontekście on występuje?
- ### Występuje tylko w kontekście języków imperatywnych
- ### Poszczególne instrukcje kodu maszynowego zmieniają stan komputera
- ### Pamięć przechowuje instrukcje i dane, które możemy pobierać
___
# 8. Czy zmienne w językach funkcyjnych mają określony typ, czy obowiązkowe jest jego deklarowanie?
- ### Posiadają określony typ, jednak jest on określony przez program
- ### Deklarowanie typu zmiennej NIE JEST obowiązkowe
___
# 9. Czy pojęcie typu danych występuje tylko w językach imperatywnych i obiektowych?
## Tak, ponieważ:
- ### Języki funkcyjne wszystko traktują jako listę, 
- ### Języki logiczne nie są typowane
___
# 10. Czym różni się rekurencja od iteracji?
## Zarówno rekurencja jak i iteracja polegają na wielokrotnym wykonaniu funkcji lub podprogramu, jednak:
- ### Rekurencja wowołuje samą siebie aż do spełnienia jakiegoś warunku
- ### Iteracja wykonuje się wielokrotnie w pętli, aż do czasu jej przerwania
___
# 11. Czym różnią się pojęcia język deklaratywny i proceduralny?
- ## Język Deklaratywny
    - ### Określa sposób w jaki cel ma być osiągnięty, jednak pozostawia programowi dowolność w określeniu sposoby jego osiągnięcia
- ## Język Proceduralny
    - ### Określa konkretną listę kroków (sposób) do wykonania aby osiągnąć cel
___
# 12. Podaj przykłady języków proceduralnych i deklaratywnych
- ## Prodeduralne:
    - ### Fortran
    - ### Ada
    - ### C
- ## Deklaratywne:
    - ### MySQL
    - ### Prolog
___
# 13. Jak rozumiesz, w kontekście programowania pojęcia: 
- ## abstrakcja
    - ### Reprezentacja pewnego bytu, w której pomijamy szczegóły nieistotne w danym kontekście.
    - ### Np. używamy w programach liczb rzeczywistych, mnożymy je i dzielimy i nie wnikamy w ich fizyczną reprezentację w pamięci komputera.
- ## abstrakcja danych
    - ### Standardowe typy danych to abstrakcje danych w postaci zbioru, np. liczbowego oraz operacji działających na elementach tego zbioru
    - ### Np. typ integer z dodawaniem, odejmowaniem i mnożeniem.
- ## abstrakcja procesu
    - ### Zestaw złożonych operacji możliwych do wielokrotnego wykorzystania i komunikujący się ze swoim otoczeniem w określony sposób.
    - ### Np. podprogramy (procedury i funkcje)
___
# 14. Naszkicuj program do sumowania n kolejnych liczb naturalnych w języku: 
- ## imperatywnym
    - ### podajemy do programu tablicę/listę o dłu
    - ```C#
        Console.WriteLine("Podaj ile kolejnych liczb chcesz zsumować?");
        int n = Int.Parse(Console.ReadLine());
        int suma = 0;
        for(int i=0, i<=n, i++)
            suma+=i;
        Console.WriteLine("Suma podanych liczb to:" + n);
- ## funkcyjnym
    - 
    - ```Scheme
        (define (suma lista)
            (cond
                ( (null? lista) 0)
                ( else (+ (car lista) (suma (cdr lista))))
            )
        )
      ```
___
# 15. Czym różni się kompilacja od interpretacji. Jakie są ich zalety i wady
## Kompilacja polega na przetworzeniu kodu programu na kod maszynowy przez kompilator. Taki kod jest następnie wykonywany bezpośrednio przez procesor.
## Interpretacja natomiast jest wykonywana przez interpreter, który na bieżąco  przekazuje przełożony kod programu do procesora. 
- ## Kompilowane
    - ### Wykorzystuje kompilator
    - ### Programy działają szybciej
    - ### Błędy pojawiają się podczas kompilacji
    - ### Program po przekompilowaniu wykonywany jest bezpośrednio przez procesor
    - ### Skompilowany program nie może być już modyfikowany
- ## Interpretowane
    - ### Wykorzystuje interpreter
    - ### Programy działają zazwyczaj wolniej
    - ### Błędy pojawiają się na żywo podczas działania programu
    - ### Program jest na bieżąco interpretowany, i dopiero kompilator wysyła polecenia do procesora
    - ### Programy mogą być modyfikowane podczas działania
___
# 16. Wymień cechy (6 cech) zmiennej w językach imperatywnych i obiektowych
- ## nazwa
- ## typ
- ## wartość
- ## adres
- ## zakres
    - ### czy zmienna występująca w danym podprogramie jest widoczna/nie widoczna w innych podprogramach
- ## czas życia
    - ### czas od alokacji do usunięcia z pamięci
___
# 17. Co to są wiązania zmienej, kiedy w czasie życia zmiennej mogą nastąpić.
- ## Wiązanie to przypisanie zmiennej adresu w pamięci.
- ## Może wystąpić podczas:
    - ### kompilacji
    - ### konsolidacji
    - ### ładowania
    - ### działania
___
# 18. Statyczne i dynamiczne wiązanie pamięci dla zmiennej – czym się różnią
- ## Wiązania statyczne
    - ### Realizowane jeszcze przed wykonaniem programu
    - ### Są niezmienne przez cały czas działania programu
- ## Wiązania dynamiczne
    - ### Realizowane w czasie wykonywania programu
___
# 19. Statyczne i dynamiczne wiązanie zakresu zmiennej – czym się różnią
- ## Wiązania statyczne
    - ### Realizowane jeszcze 
- ## Wiązania dynamiczne
    - ### Są zmienne (w trakcje działania programu adres przypisany do zmiennej może się zmieniać)
    - ### Są wykonywane podczas wykonywania programu
___
# 20. Jakiego rodzaju zmienne mogą mieć przydział pamięci mimo, że niekoniecznie są w danym momencie widoczne.
### nie wiem
___
# 21. Co rozumiemy przez zgodność typów danych/zmiennych, czy we wszystkich językach imperatywnych obowiązują takie same zasady.
- ### Polega to na sprawdzeniu czy typy wszystkich zmiennych w danej operacji są prawidłowe.
- ### Nie wzystkie języki imperatywne posiadają identyczne zasady w tej kwestii
___
# 22. Na czym polega zagnieżdżanie podprogramów. Podaj przykład języka, który dopuszcza zagnieżdżanie i takiego, który go nie dopuszcza. Jakie mogą z tego wynikać konsekwencje dotyczące używania zmiennych.
???????
- ### Językiem który __dopuszcza__ zagnieżdżanie jest Ada
- ### Językiem który __NIE dopuszcza__ zagnieżdżania jest C
___
# 23. Czym różni się procedura od funkcji w językach imperatywnych.
- ## Funkcja jest procedurą, która wylicza i zwraca pojedynczą wartość
    - ### Wykonuje polecenia i zwraca wartość
    -   ```C
            int square( int n ) { return n * n; }
        ```
- ## Procedurę można traktować jako funkcję nie zwracającą wartości (void)
    - ### Po prostu wykonuje polecenia
    -   ```C
            void square( int n ) { printf("%d", n*n); }
        ```
# 24. Opisz metody przekazywania parametrów aktualnych do podprogramów.
- ## Wartość
    - ### podaje się dokładną wartość
- ## Wynik
    - ### podaje się zmienną, która zostanie “skopiowana” do działania w podprogramie
- ## Wartość i wynik
    - ### podaje się zmienną, która od razu staje się dokładną wartością
- ## Nazwę
    - ### działa na parametrze aktualnym o danej nazwie
- ## Referencję
    - ### działa na dokładnie tym samym wskaźniku, strukturze, obiekcie (p-nie obiektowe)
___
# 25. Z jakimi strukturami bywają kłopoty przy przekazywaniu ich do podprogramów.
- ### tablica
- ### callback
___
# 26. Czym jest podstawowa struktura języka Scheme. Jak jest przez Scheme interpretowany napis: (a b c d), jak napis ‘(‘a’ ‘b’ ‘c’ ‘d’).
- ## (a b c d)
    - ### Jest to wywołanie programu o nazwie 'a' z parametrami 'b', 'c', 'd'
- ## '('a' 'b' 'c' 'd')
    - ### Jest to lista napisów, składająca się z liter "a", "b", "c", "d"
___
# 27. Po co w listach używanych w językach funkcyjnych i logicznych wyróżnia się tzw głowę (head) i ogon (tail)
### Umożliwiają rekurencyjne przeglądanie list - Funkcja działa na pierwszym elemencie (head), natomiast pozostała część (tail) jest przekazywana ponownie do funkcji rekurencyjnej.
___
# 28. Podaj charakterystyczne cechy języków funkcyjnych
- ### rekurencja zamiast iteracji
- ### brak stanu maszyny
- ### brak zmiennych (w sensie imperatywnym)
- ### brak skutków ubocznych
# 29. Podaj charakterystyczne cechy języka prolog
- ### reguły i fakty
- ### brak stanu maszyny
- ### brak typowania
- ### brak instrukcji
# 30. Czym różni się funkcja z języka funkcyjnego od funkcji w języku imperatywnym.
- ### nie posiada instrukcji ani pętli
- ### zazwyczaj wykorzystuje rekurencję
- ### zawsze zwraca jakąś wartość (brak funkcji void)
# 31. Czym różni się lista w językach funkcyjnych i prologu od listy w programowaniu obiektowym.
- ### 
# 32. Czy w językach funkcyjnych istnieje pojęcie tablicy w sensie znanym z języków imperatywnych.
### Nie. Języki funkcyjne używają list, króre mają dynamicznie alokowany rozmiar oraz nie posiadają możliwości dostępu do konkretnego elementu listy od ręki.
# 33. W językach funkcyjnych występują specjalne funkcje map i filter – do czego one służą
# 34. Czym różni się pojęcie obiektu w językach obiektowych od obiektu w języku prolog
- ## Języki obiektowe
    - ### instancja pewnej klasy, zawierająca atrybuty o pewnych wartościach i metody, będące abstrakcją danych i procesu
- ## Prolog
    - ### wyrażenie, które jest częścią relacji w termie, np. stolica(warszawa, polska) - warszawa, polska to obiekty
___
# 35. Opisz pokrótce na czym polega wykonywanie programu w prologu
- ### Szukanie, czy podane stwierdzenie jest prawdą, poprzez sprawdzanie termów za pomocą reguł.
- ### Odbywa się to poprzez wybieranie podcelów, a następnie przeszukiwanie w głąb od lewej do prawej.
- ### Jeżeli nie znajdzie do rozwiązania, nawraca do innego podcelu.
- ### Jeżeli wyczerpie wszystkie możliwości zwraca wynik negatywny.
___
# 36. Na czym polega tzw leniwe obliczanie (lazy evaluation) stosowane w językach funkcyjnych
- ### Obliczenia są wykonywane dopiero w momencie, kiedy ich wynik jest potrzebny
- ### Optymalizuje czas potrzebny na wykonanie funkcji
___
# 37. Podaj interpretację reguły prologowej: ptak(X) :- zwierze(X), ma(X, piora). w postaci zdania logicznego
### X jest ptakiem jeżeli jest zwierzęciem i ma pióra.
___
# 38. Na czym polega ukonkretnienie zmiennej w prologu
## Gdy w prologu wpiszemy term np. syn(Adam, X), to Prolog ukonkretni zmienną X listą wszystkich obiektów pasujących w jej miejsce.
___
# 39. Podstawową zasadą występującą w operacjach listowych w prologu jest:
## Stosowanie podziału na [H|T], czyli rozdzielenie listy na głowę i ogon.
___
# 40. Do czego służy specjalny predykat prologowy !
- ### Predykat _!_ oznacza odcięcie
- ### Wyłącza uwzględnianie alternatywnych możliwości wyboru podczas nawracania.
- ### Optymalizuje działanie programu (mniej pamięci, nie spełnia oczywistych celów)
___