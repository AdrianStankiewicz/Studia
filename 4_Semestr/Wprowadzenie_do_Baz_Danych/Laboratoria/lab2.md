# 1. Wszystkie dane dokumentów sprzedaży wraz z pełną nazwą i adresem klienta uporządkowane alfabetycznie według nazw klientów; tylko pierwszych 7 dokumentów sprzedaży
```SQL
|SELECT n.*, k.nazwa, k.adres
FROM nagsprzedaz n JOIN klienci k USING (idklienta)
ORDER BY k.nazwa
LIMIT 7
```
# 2. Nazwy i adresy klientów, którzy kupowali w pierwszych pięciu dniach dowolnego miesiąca
```SQL
SELECT k.nazwa, k.adres
FROM nagsprzedaz n JOIN klienci k USING (idklienta)
WHERE date_part('day', n.datasp) BETWEEN 1 and 5
```
# 3. Identyfikatory produktów kupowanych między 25 a 30 dniem każdego miesiąca przez klienta K03
```SQL
SELECT DISTINCT p.idproduktu
FROM pozsprzedaz p JOIN (nagsprzedaz n JOIN klienci k USING (idklienta)) USING (nrfaktury)
WHERE
	date_part('day', n.datasp) BETWEEN 25 and 30
		AND
	k.idklienta = 'K03'
```
# 4. Nazwy i adresy klientów, którzy kupili produkty Malfarba
```SQL
SELECT DISTINCT k.nazwa, k.adres
FROM produkty pr JOIN (pozsprzedaz p JOIN (nagsprzedaz n JOIN klienci k USING (idklienta)) USING (nrfaktury)) USING (idproduktu)
WHERE pr.producent = 'Malfarb'
```
# 5. Nazwy i adresy klientów z Sopotu lub Gdańska, którzy kupowali liczone na metry lub kilogramy produkty w cenie
wyższej niż 40
```SQL
SELECT DISTINCT k.nazwa, k.adres
FROM produkty pr JOIN (pozsprzedaz p JOIN (nagsprzedaz n JOIN klienci k USING (idklienta)) USING (nrfaktury)) USING (idproduktu)
WHERE
	(k.miasto = 'Sopot' OR k.miasto = 'Gdańsk')
	AND
	(pr.miara = 'metr' OR pr.miara = 'kg')
	AND
	pr.cena > 40
```
# 6. Nazwy i producenci produktów, które nie były sprzedawane
```SQL
SELECT pr.nazwa, pr.producent
FROM produkty pr LEFT JOIN pozsprzedaz p ON pr.idproduktu = p.idproduktu
WHERE p.idpoz IS NULL
```
# 7. Identyfikatory sprzedanych produktów nie zapisanych w tabeli produkty
```SQL
SELECT DISTINCT p.idproduktu
FROM produkty pr RIGHT JOIN pozsprzedaz p ON pr.idproduktu = p.idproduktu
WHERE pr.idproduktu IS NULL
```
# 8. Numery faktur i identyfikatory klientów, którym je wystawiono, ale o których to klientach nic poza identyfikatorem nie wiadomo
```SQL
SELECT n.nrfaktury, n.idklienta
FROM nagsprzedaz n LEFT JOIN klienci k ON n.idklienta = k.idklienta
WHERE k.idklienta IS NULL
```
# 9. Łączne sprzedane ilości poszczególnych produktów w postaci:a. (idproduktu, laczna_ilosc); b. nazwa produktu, laczna_ilosc) – są różnice?
```SQL
SELECT idproduktu, SUM(ilosc)
FROM pozsprzedaz
GROUP BY idproduktu
ORDER BY idproduktu
```
# 10. Numery, daty wystawienia i wartości brutto i poszczególnych dokumentów sprzedaży (faktur)
```SQL
SELECT nrfaktury, datasp, SUM(wartosc) as wartość
FROM (
	SELECT n.nrfaktury, n.datasp, ((pr.cena+(pr.cena*pr.vat))*p.ilosc) AS wartosc
	FROM nagsprzedaz n JOIN (pozsprzedaz p JOIN produkty pr USING (idproduktu)) USING (nrfaktury)
) AS test
GROUP BY nrfaktury, datasp
ORDER BY nrfaktury
```
# 11. Dla każdego klienta (identyfikator) podaj wartość netto jego zakupów z okresu 15 lutego – 15 marca
```SQL
SELECT k.idklienta, SUM(pr.cena * p.ilosc) 
FROM produkty pr JOIN (klienci k NATURAL JOIN (pozsprzedaz p NATURAL JOIN nagsprzedaz n)) USING (idproduktu)
WHERE 
	((date_part('day', n.datasp) BETWEEN 15 AND 31) AND (date_part('month', n.datasp) = '2'))
		OR
	((date_part('day', n.datasp) BETWEEN 1 AND 15) AND (date_part('month', n.datasp) = '3'))
GROUP BY k.idklienta
```
# 12. Dla każdego klienta (identyfikator) podaj datę ostatniej sprzedaży i liczbę wystawionych mu faktur
```SQL
SELECT idklienta, MAX(datasp), COUNT(nrfaktury) 
FROM nagsprzedaz
GROUP BY idklienta
```
# 13. Dla każdego klienta podaj wartość brutto jego zakupów z podziałem na zapłacone i niezapłacone
```SQL
SELECT n.idklienta, n.zaplacono, SUM(pr.cena+(pr.cena*pr.vat)*p.ilosc)
FROM produkty pr JOIN (nagsprzedaz n NATURAL JOIN pozsprzedaz p) USING (idproduktu)
GROUP BY n.idklienta, n.zaplacono
ORDER BY n.idklienta, n.zaplacono
```
# 14. Dni (data) z utargiem (brutto) większym niż 2000
```SQL
SELECT *
FROM(
	SELECT n.datasp, SUM((pr.cena+(pr.cena*pr.vat))*p.ilosc) AS utarg
	FROM produkty pr JOIN (nagsprzedaz n NATURAL JOIN pozsprzedaz p) USING (idproduktu)
	GROUP BY n.datasp
) as Foo
WHERE utarg > 2000
```
# 15. Liczone na sztuki produkty, które były sprzedawane co najmniej 5 razy; których łączna wartość sprzedaży wyniosła więcej niż 2000
```SQL
SELECT *
FROM (
	SELECT pr.nazwa, COUNT(p.idproduktu) AS ilosc, SUM((pr.cena+(pr.cena*pr.vat))*p.ilosc) AS wartosc
	FROM produkty pr JOIN (nagsprzedaz n NATURAL JOIN pozsprzedaz p) USING (idproduktu)
	WHERE miara = 'szt'
	GROUP BY pr.nazwa
	) AS Foo
WHERE ilosc > 4 AND wartosc >= 2000
```
# 16. Identyfikatory klientów, których ostatnia wizyta w sklepie odbyła się po 10 marca
```SQL
SELECT idklienta, MAX(datasp)
FROM nagsprzedaz
WHERE
	(date_part('day', datasp) > 10 AND date_part('month', datasp) = 3)
	OR
	date_part('month', datasp) > 3
GROUP BY idklienta
```
# 17. Producent, którego produkty dały największe wpływy
```SQL
SELECT producent
FROM (
	SELECT pr.producent, SUM(p.ilosc*(pr.cena+(pr.cena*pr.vat))) as Wpływy
	FROM pozsprzedaz p NATURAL JOIN produkty pr
	GROUP BY pr.producent
	) AS Foo
ORDER BY Wpływy DESC
LIMIT 1
```
# 18. Nazwy klientów z siedzibami w tym samym mieście, co WodKanRem
```SQL
SELECT nazwa
FROM klienci
WHERE miasto = (
	SELECT miasto
	FROM klienci
	WHERE nazwa = ('WodKanRem')
	)
```
# 19. Nazwy, adresy klientów, którzy nic nie kupowali w lutym
```SQL
SELECT k.idklienta
FROM klienci k LEFT JOIN (
	SELECT DISTINCT idklienta
	FROM nagsprzedaz
	WHERE date_part('month', datasp) = 2
	) AS Foo ON k.idklienta = Foo.idklienta
WHERE Foo.idklienta IS NULL
```
# 20. Identyfikator produktu, który był najczęściej kupowany
```SQL
SELECT idproduktu, SUM(ilosc) AS Ilość_sprzedanych_sztuk
FROM pozsprzedaz
GROUP BY idproduktu
```
# 21. Dla każdego produktu podaj, ilu różnych klientów go kupowało
```SQL
SELECT DISTINCT idproduktu, COUNT(idklienta)
FROM pozsprzedaz NATURAL JOIN nagsprzedaz
GROUP BY idproduktu
ORDER BY idproduktu
```
# 22. Średnia wartość wystawionej faktury
```SQL
SELECT AVG(Foo.wartość)::NUMERIC(10,2)
FROM (
	SELECT p.nrfaktury, SUM((pr.cena + (pr.cena * pr.vat)) * p.ilosc) AS Wartość
	FROM pozsprzedaz p NATURAL JOIN produkty pr
	GROUP BY p.nrfaktury
	) AS Foo
```
# 23. Nazwy klientów i numery faktur o wartości wyższej niż średnia wartość faktury
```SQL
SELECT k.nazwa, n.nrfaktury
FROM klienci k JOIN (produkty pr NATURAL JOIN (pozsprzedaz p NATURAL JOIN nagsprzedaz n)) USING (idklienta)
GROUP BY k.nazwa, n.nrfaktury
HAVING SUM ((pr.cena + (pr.cena * pr.vat)) * p.ilosc) > 
	(
	SELECT AVG(Foo.wartość)::NUMERIC(10,2)
		FROM (
			SELECT p.nrfaktury, SUM((pr.cena + (pr.cena * pr.vat)) * p.ilosc) AS Wartość
			FROM pozsprzedaz p NATURAL JOIN produkty pr
			GROUP BY p.nrfaktury
		) AS Foo
	)
```
# 24. Jakie ilości poszczególnych produktów kupowano w poszczególnych miesiącach
```SQL
SELECT p.idproduktu, date_part('month', n.datasp) AS Miesiąc, SUM(p.ilosc)
FROM pozsprzedaz p NATURAL JOIN nagsprzedaz n
GROUP BY p.idproduktu, date_part('month', n.datasp)
ORDER BY p.idproduktu
```
# 25. Identyfikatory produktów, których wartość sprzedaży (netto) w marcu wyniosła więcej niż 1000
```SQL
SELECT Foo.idproduktu
FROM (
	SELECT p.idproduktu, SUM((pr.cena + (pr.cena * pr.vat)) * p.ilosc ) AS Wartosc
	FROM produkty pr JOIN (pozsprzedaz p NATURAL JOIN nagsprzedaz n) USING (idproduktu)
	WHERE date_part('month', n.datasp) = 3
	GROUP BY p.idproduktu
	) AS Foo
WHERE Foo.Wartosc > 1000
GROUP BY Foo.idproduktu
```
# 26. Numery dokumentów sprzedaży, na które kupowano farby i taśmę malarską ( na jednym dokumencie)