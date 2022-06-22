# Przydatne funkcje:
## Sprawdzenie czy element jest na liście:
```Prolog
jest_na_liscie(X,[X|_]).
jest_na_liscie(X,[_|Y]) :- jest_na_liscie(X,Y).
```
___
## Łączy w pary chłopaków i dziewczyny pod względem umiejętności
```Prolog
umiejetnosci(X,Y,Z) :- dziewczyna(X), chlopak(Y),umie_tanczyc(X,Z), umie_tanczyc(Y,Z).
```
___
## Kto dobył z kim najwięcej puntków
```Prolog
punkty(X,C) :-  konkurs(X,C,_,A), konkurs(_,C,_,B), A>B.
```
___
## Sprawdzeie na co może chorować pacjent na podstawie objawów
```Scheme
objawki(D,C) :- pacjent(D,X), choroba(C,F), jest_na_liscie(X,F).
```
___
## Wyszukanie wspólnych części:
```Scheme
wspolne(X,Y,C) :- pojazd(X,_,F), pojazd(Y,_,E), jest_na_liscie(C,E), jest_na_liscie(C,F).
```