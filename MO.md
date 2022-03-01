https://www.canva.com/design/DAE5ZuZINAw/dkrcFCOm6s-czRF5caY73w/view?utm_content=DAE5ZuZINAw&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink

# WYKRES
___
# Podział optymalizacji
## Jednokryterialna - Oznacza to, że jest jedna funkcja celu dla której wyznaczamy maksimum lub minimum.
### Na zdjęciu widać strukturę modeli jednokryterialnych
- ### Funkcje C1 - CM to funkcje wielu zmiennych, i definiują one funkcje celu i ograniczenia.
- ### np. zysk - mamy różne źródła dochodu ale tylko jeden łączny zysk
## Wielokryterialne - Czyli mamy kilka funkcji celu i wśród nich musimy znaleźć kompromis, poniewa z funkcje celu zazwyczaj wykluczaja sie wzajemnie
- ### Funkcje C1 - CK definiują ilość funkcji celu podlegających optymalizacji
- ### Funkcje CK+1 - CM to funkcje ograniczeń
- ### np. inwestycje - chcemy zyskać maksymalny zysk (1 kryterium) przy minimalnym ryzyku (2 kryterium)
___
# Optymalizacja jednokryterialna
## Można powiedzieć, że tutaj rolę w rozróznieniu odgrywa czas -
### *definicja statycznego z prezentacji* - znalezienie optymalnego doboru rury w instalacji gazowej.
### *definicja dynamicznego z prezentacji* - optymalizacja sterowania maszyny elektrycznej
___
# WYKRES
### Jako, że heurystyczne są krótsze, zacznijmy od nich
___
# Metody heurystyczne
## Metody heurystyczne to iteracyjne metody polegające na wyznaczaniu kolejnych przybliżeń rozwiązania poprzez heurystyczne przekształcenia poprzednich rozwiązań. (coś jak liczenie PI w monte carlo)
---
## Heurystyka (gr. _heurisko - znajdowanie_) - Wykrywanie nowych faktów i związków między faktami. Jest to kojarzenie faktów, dedukowanie, i wyciąganie wniosków.
## W takim sensie informatycznym, heurystyka to algorytm znajdywania rozwiazan "niedokladnych". Algorytmy dokładne po długim czasie działania podadzą nam wynik dokładny, podczas gdy algorytmy heurystyczne często juz po chwili potrafia podac wynik przyblizony
### Monte Carlo - pi = obwód koła / średnice, wiele wyników z błędem pomiarowym, wyciągamy średnią i jest super
### Rój cząstek - Mamy grupę osobników tego samego gatunku które żyją na określonym terytorium. Możemy poprzez obserwację ich zachowań wyciągnąć przydatne dla nas wznioski - Przykładowo samoloty są optymalizowane na podstawie ptaków
___
# Metody deterministyczne
## Metody deterministyczne dzielimy na te bez ograniczeń i te zograniczeniami. Oba te podziału dzielimy również na metody gradientowe i brzgradientowe.
___
## Gradientowe korzystają ze znajomości wartości funkcji oraz jej gradientu
- ### gradient funkcji - pole wektorowe wskazujące kierunki najszybszych wzrostów wartości funkcji. Jego znajomość jest przydatna w zadaniach optymalizacyjnych.
    - ### np wyznaczanie ekstremum funkcji (znalezienie najbardziej optymalnego punktu funkcji), liczyliśmy tam dwie pochodne funkji aby poznać jej gradient, czyli to kiedy rośnie a kiedy maleje, i w ten sposób wyznaczaliśmy ekstrema funkcji. 

## Metody bezgradientowe to np. 
- ### enumeratywne - mają skończoną ilość rozwiązań, dla każdej alternatywy szukamy wartości a następnie wybieramy tą maksymalną. 
    - ### np. szukamy najwyższego auta w salonie, a potem patrzymy mierząc który jest max.
- ### losowe - (zaczynamy od punktu wyjścia i szukamy czegoś lepszego, kolejne elementy wybierając na hybił trafił w sąsiedztwie rozwiązania poprzedniego.
    - ### np. wybór zegarka (przychodzimy, bierzemy jakiś w rękę a potem porównujemy z innymi aż znajdziemy najładniejszy)
---
## Podstawowe
### bezpośrednie opierają się na wyznaczaniu zredukowanego gradientu funkcjonału względem streowania
___
### pośrednie opierają się na warunku koniecznym optymalności i stanowią rózne sposoby rozwiazywania rownan rozniczkowych ekstremal, dla ktorych dane są zarówno warunki początkowe, jak i pewne warunki końcowe.
___
### specjalne - uwzględniają specyficzną dla danego procesu sterowania postać ograniczeń stanu i sterowania
# Metody wielokryterialne
## Celem optymalizacji wielokryterialnej jest wyznaczenie zbioru najlepszych rozwiązań spełniających jednocześnie zestaw wielu, często sprzecznych ze sobą kryteriów optymalizacyjnych np. minimalizacji ryzyka i maksymalizacji zysku.
---
## Statyczna
- ### Dotyczy zagadnień o charakterze stałym w czasie, czyli takich problemów, gdzie funkcja celu jest stała w czasie obliczeń. 
- ### Wartość funkcji celu jest zależna jedynie od argumentu. 
## Dynamiczna
- ### zagadnienia o charakterze zmiennym w czasie, czyli funkcja celu jest zmienna w czasie obliczeń.
- ### Wartość funkcji celu jest zależna zarówno od argumentu, jak i od chwili, w której jest obliczana. 
Trzeba uważać - Proces, statek płynie, dron leci itd
## Rozgrywająca
### dotyczy rozgrywajacych procesow transportowych lub logistycznych, ktorych synteze prowadzi sie metodami kierunków gier, oraz opiera sie na zasadzie min-max.
### Teoria gier jest działem współczesnej matematyki, obejmujących teorię sytuacji konfliktowych oraz budowę i analizę ich modeli.
### Gracze to strony uczestniczące ze swoimi strategiami w sytuacji konflikowej
### Strategia natomiast to zbiór reguł sterowania gracza, których nie mogą zmienić działania przeciwnika lub natury.
### układ min-max - minimum wysiłku, maksimum zadowolenia ze studiów