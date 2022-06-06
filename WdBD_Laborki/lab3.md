# 1 Nazwa, cena stan najtańszego produktu
```SQL
SELECT nazwa, cena, stan
FROM produkty
ORDER BY cena
LIMIT 1
```
# 2. Identyfikatory klientów, którzy kupowali po ostatniej wizycie klienta K07
```SQL
SELECT DISTINCT idklienta
FROM nagsprzedaz
WHERE datasp > (
	SELECT datasp
	FROM nagsprzedaz
	WHERE idklienta = 'K07'
	ORDER BY datasp
	LIMIT 1
	)
	ORDER BY idklienta
```
# 3. Nazwy, ceny produktów liczone w tych samych jednostkach co Wełna min
```SQL
SELECT nazwa, cena
FROM produkty
WHERE miara LIKE (
	SELECT DISTINCT miara
	FROM produkty
	WHERE nazwa = 'Wełna min'
	)
```
# 4. Dni (data) z utargiem (brutto) większym niż 2000
```SQL
SELECT *
FROM (
	SELECT datasp, SUM((cena + (cena*vat)) * ilosc) AS utarg
	FROM nagsprzedaz NATURAL JOIN pozsprzedaz NATURAL JOIN produkty
	GROUP BY datasp
	ORDER BY datasp
	) AS Foo
WHERE Foo.utarg > 2000
```
# 5. Średnia wartość wystawionej faktury
```SQL
SELECT AVG(Foo.utarg)
FROM (
	SELECT nrfaktury, SUM((cena + (cena*vat)) * ilosc) AS utarg
	FROM pozsprzedaz NATURAL JOIN produkty
	GROUP BY nrfaktury
	ORDER BY nrfaktury
	) AS Foo
```
# 6. Nazwy klientów i numery faktur o wartości wyższej niż średnia wartość faktury
```SQL
SELECT Foo.nazwa, Foo.nrfaktury
FROM (
	SELECT k.nazwa, nrfaktury, SUM((cena + (cena*vat)) * ilosc) AS wartosc
	FROM klienci k JOIN (nagsprzedaz NATURAL JOIN pozsprzedaz NATURAL JOIN produkty) USING (idklienta)
	GROUP BY k.nazwa, nrfaktury
	) AS Foo
WHERE Foo.wartosc > (
	SELECT AVG(Fooo.utarg)
	FROM (
		SELECT nrfaktury, SUM((cena + (cena*vat)) * ilosc) AS utarg
		FROM pozsprzedaz NATURAL JOIN produkty
		GROUP BY nrfaktury
		ORDER BY nrfaktury
	) AS Fooo
)
```
# 7. Podaj wszystkie nazwy występujące w bazie i określ czego dotyczą: wynikowa tabela powinna zawierać wpisy postaci:
|nazwa | Co_nazywa|
|-------|--------|
|WodKanRem | Klient|
|Hydrobud | Klient|
|lakierobejca | produkt|
```SQL
SELECT nazwa, 'Klient'
FROM klienci
UNION (
	SELECT nazwa, 'Produkt'
	FROM produkty
)
```
# 8 Dodaj do bazy informację o nowym kliencie kod: K05, nazwa: Tralaliński, miasto: Kraków, ulica: Cyfrowa 8, kod: 22-333, rabat: 1%
```SQL
INSERT INTO klienci(idklienta, nazwa, miasto, adres, kod, rabat)
VALUES ('K05', 'Tralaliński', 'Kraków', 'Cyfrowa 8', '22-333', 0.01)
```
# 9. Dopisz do bazy informację o nowym dokumencie sprzedaży wystawionym dzisiaj, dla klienta K10 z odroczoną płatnością, sprzedano 10 jednostek produktu P10, 3 jesdnostki P26 i 5 jednostek P38.
```SQL
INSERT INTO pozsprzedaz(nrfaktury, idproduktu, ilosc)
VALUES (50, 'P10', 10), (50, 'P38', 5);
```
# 10. Adres klienta WodKanRem zmienił się na Storczykowa 23 a kod pocztowy na 83-233
```SQL
UPDATE klienci
SET adres = 'Stroczykowa 23', kod = '83-233'
WHERE nazwa = 'WodKanRem'
```
# 11. Zdefiniuj dla swojej bazy rembud:
- ## a. Klucze główne dla wszystkich tabel
- ## b. Klucze obce dla wszystkich tabel
## Podczas definiowania włącz opcję VALIDATED. Jeśli wystąpią jakiekolwiek problemy, zdiagnozuj je i usuń używając właściwych zapytań
```SQL
ALTER TABLE klienci ADD PRIMARY KEY (idklienta);
ALTER TABLE nagsprzedaz ADD PRIMARY KEY (nrfaktury);
ALTER TABLE pozsprzedaz ADD PRIMARY KEY (idpoz);
ALTER TABLE produkty ADD PRIMARY KEY (idproduktu);

ALTER TABLE nagsprzedaz ADD FOREIGN KEY (idklienta) REFERENCES klienci(idklienta)
ALTER TABLE pozsprzedaz ADD FOREIGN KEY (nrfaktury) REFERENCES nagsprzedaz(nrfaktury)
ALTER TABLE pozsprzedaz ADD FOREIGN KEY (idproduktu) REFERENCES produkty(idproduktu)
```
# 12. Wypróbuj odporność swojej bazy formułując zapytania
a. Identyfikator klienta Hydrobud zmień na K14.
b. Usuń dokumenty sprzedaży wystawione klientowi Gładzkiemu
```SQL
UPDATE klienci
SET idklienta = 'K14'
WHERE nazwa = 'Hydrobud'

DELETE FROM nagsprzedaz
WHERE idklienta = (
	SELECT idklienta
	FROM klienci
	WHERE nazwa = 'Gładzki Sp z o.o.'
)
```
# 13. 
# 14. Klientom, których łączna wartość zakupów przekroczyła 5000 ustaw rabat na 5%.
```SQL

```