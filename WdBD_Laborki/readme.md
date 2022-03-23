# Bazowa teoria:
## Klucz Główny
- ### Jest to constraint, dzięki któremu jesteśmy w stanie jednoznacznie zdefiniować rekord w tabeli
## Klucz obcy
- ### Dodajesz go w tabeli, której kolumna jest ograniczana przez PK innej tabeli
## __PODCZAS DEFINIOWANIA KLUCZY WYŁĄCZ OPCJĘ 'DON'T VALIDATE?'__
___
# Przydatne komendy:
## ALTER TABLE
### Dodanie Primary Key:
```SQL
ALTER TABLE nazwaTabeli ADD PRIMARY KEY (nazwaKolumny);
```
### Dodanie Foreign Key:
```SQL
ALTER TABLE tabelaMaster ADD FOREIGN KEY (kolumnaMaster) REFERENCES tabelaSlave(kolumnaSlave)
```
## CURRENT_DATE
- ### Podaje nam obecną datę w formacie YYYY-MM-DD
## date_part 
- ### wycina nam konkretną część daty, np:
    - ### ('year', CURRENT_DATE)
    - ### ('month', CURRENT_DATE)
    - ### ('day', CURRENT_DATE)
## IN
### Pozwala na znalezienie wartości w danym zakresie, np.
```SQL
WHERE nazwaTabeli IN (subQuery_które_zwraca_kilka_intów)
```
## UNION
- ### Pozwala na 'sklejenie' dwóch zapytań
## LIKE 'Tekst%'
- ### Wyszuka tekst, który zaczyna się na Tekst i potem ma cokolwiek
## LIKE '_'
- ### Dowolny jeden znak