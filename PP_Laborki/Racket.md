# Przydatne funkcje
## cond
```Scheme
(cond 
    (warunek1) ;if
    (warunek2) ;else if
    (warunek3) ;else
)
```
## if
```Scheme
(if (> x y)     ;jeżeli x jest większy od y
    (- x y)     ;wartość jeżeli true
    (- y x)     ;wartość jeżeli false
)
```
## lambda i map
```Scheme
(map (lambda 
    (x)         ;liczba który będzie za każdym razem wyjęty z listy
    (* x 2))    ;operacja która będzie wykonana na każdej liczbie i zamyka lambde
    lista       ;lista z której będą wyjmowane liczby do lambdy
)               ;zamyka map
```
## cons
```Scheme
(cons 'a (cons 'b (cons 'c '())))   ;składa listę z pojedynczych elementów.
      ;output:  '(a b c).
(cons 1 '(2 3 4))                   ;pozwala na łączenie list w jedną
      ;output:  '(1 2 3 4)
```
## car
```Scheme
(car 1 . 2)     ;zwraca pierwszy element pary
      ;output:    1
(car '(1 2 3))  ;zwraca głowę listy
      ;output:    1
```
## cdr
```Scheme
(cdr 1 . 2)     ;zwraca drugi element pary
      ;output:    2
(cdr '(1 2 3))  ;zwraca ogon listy
      ;output:    '(2 3)
```
## list i '()
```Scheme
(list 'a 'b 'c) ;tworzy listę z liter
      ;output:    '(a b c)
(list 1 2 3)    ;tworzy listę z cyfr
      ;output:    '(1 2 3)
```

# Zadania
## 1. Wygenerowac liste o danej dlugosci, kolejne cyfry to mnozniki podanej liczby.
```Scheme
(define (razy dlugosc mnoznik)
  (cond
    ( (eq? dlugosc 0) '())
    ( (eq? dlugosc 1) mnoznik)
    (else (cons (* mnoznik dlugosc) (razy (- dlugosc 1) mnoznik)))))

    ;input:     (razy 3 4)
    ;output:    '(12 8 . 4)
```

## 2. Dla danej listy li i jej elementu el zamień każde wystąpienie elementu el jego kwadratem.
```Scheme
(define (zamien lista el)
  (map (lambda (x) (if (= x el) (* x x) x)) lista)
  )

    ;input:     (zamien '(2 3 4 3 5 2 3 1 5) 3)
    ;output:    '(2 9 4 9 5 2 9 1 5)
```

## 3. Dla danej listy li zmień wszystkie jej elementy (n) na odwrotność (1/n)
```Scheme
(define (zamien lista)
  (map (lambda (x) (/ 1 x)) lista))

    ;input:     (zamien '(2 3 4 5 6))
    ;output:    '(1/2 1/3 1/4 1/5 1/6)
```

## 4. Dla podanej listy z podlistami utwórz jedną bez podlist.
```Scheme
;wersja z apply
(define (scal li)
  (apply append (map (lambda (x) (if (list? x) x (list x))) li))
  )

;wersja bez apply
(define (scal lista)
   (cond [(null? lista)
          null]
         [(list? (car lista))
          (append (scal (car lista)) (scal (cdr lista)))]
         [else
          (cons (car lista) (scal (cdr lista)))]
         ))

    ;input:     (scal (list 2 (list 2 4 5) 3 5 (list 1 3) 4 (list 3 1)))
    ;output:    '(2 2 4 5 3 5 1 3 4 3 1)
```

## 5. Napisz program na dzielenie całkowitoliczbowe liczby n przez k metodą kolejnych odejmowań
```Scheme
(define (dzielenie n k)
  (if (< n k)
      0
      (+ (dzielenie (- n k) k) 1)
  )
)

    ;input:     (dzielenie 10 2)
    ;output:    5
```

## 6. Dla podanej listy z podlistami policz ilość elementów nie będących listami.
```Scheme
(define (funkcja li)
  (+ (if (list? (car li)) 0 1) (if (null? (cdr li)) 0 (funkcja (cdr li))))
  )

    ;input:     (funkcja '('(1 2 3) 4 5 '(7 8) 9 '(0 1 2)))
    ;output:    3
```

## 7. Dla podanej listy podaj jej ostatni element.
```Scheme
(define (ostatni li)
  (cond
    ((null? (cdr li)) (car li))
    (else (ostatni (cdr li)))
  )
)

    ;input:     (ostatni '(1 2 3 4 5))
    ;output:    5
```

## 8. Dana jest lista L, która może zawierać podlisty. Wyeliminuj z listy wszystkie elementy nie będące listami.
```Scheme
;wersja z filter
(define (usunPojedyncze li) (filter list? li))

;wersja bez filter
(define (usunPojedyncze lista)
   (cond [(null? lista)
          null]
         [(list? (car lista))
          (cons (car lista) (usunPojedyncze (cdr lista)))]
         [else
          (usunPojedyncze (cdr lista))]))

      ;input:    (usunPojedyncze '(1 '( 2 3 4) 5 6 '(7 8) 9 '(0 1 10)))
      ;output:   '('(2 3 4) '(7 8) '(0 1 10))
```

## 9. Zamienić miejscami pierwszy i ostatni element listy.
```Scheme
(define (zamianaPierwszyOstatni li)
  (define (ostatni li)
    (if (null? (cdr li)) (car li) (ostatni (cdr li)))
    )
  (define (bez_ostatniego li)
    (reverse (cdr (reverse li)))
    )
  (cons (ostatni li) (append (cdr (bez_ostatniego li)) (list (car li))))
  )

      ;input:   (zamianaPierwszyOstatni '(1 2 3 4))
      ;output:  '(7 2 3 4 5 6 1)
```

## 10. Podzielić listę na dwie podlisty: jedną z liczbami parzystymi a drugą nie.
```Scheme
(define (podziel lst)
  (list (filter odd? lst)
        (filter even? lst)))

      ;input:   (podziel '(1 2 3 4 5 6 7 8 9 10 11 13 15))
      ;output:  '((1 3 5 7 9 11 13 15) (2 4 6 8 10))
```
## 11. Dana jest lista L zawierająca podlisty. Zamień wszystkie podlisty na 0.
```Scheme
(define (zera L) (map (lambda (x) (if (list? x) 0 x)) L))

      ;input:    (zera '('(2 3 4) 5 6 '( 7 8) 9))
      ;output:    '(0 5 6 0 9)
```
## 12. Dla podanych dwóch list L1 i L2 sprawdź, czy lista L1 dominuje L2. To znaczy każdyelement listy L1 jest większy od odpowiedniego elementu L2.
```Scheme
(define (dominuje A B)
  (cond
    ((null? A) #t)
    ((null? B) #t)
    ((< (car A) (car B)) #f)
    ((> (car A) (car B)) (dominuje (cdr A) (cdr B)))
  )
)

      ;input:    (dominuje (list 2 3 4 5) (list 1 2 3 4))
      ;output:   #t
```
## 13. Wygeneruj n elementów w listę z danego zakresu i następnie przekonwertuj ją na *coś tam Sidiu niewyraźnie mówił*. Następnie wylicz średnią listy.
```Scheme
      ;input:
      ;output:
```
## 14. Dla podanej listy z podlistami, utwórz listę w której każda z podlist zamieniona jest na sumę jej elementów
```Scheme
(define (suma lista)
  (if (list? (car lista)) (suma (car lista))
      (if (empty? (cdr lista)) (car lista) (+ (car lista) (suma (cdr lista))))
  )
)

(define (wykonaj lista)
  (map (lambda (argument)
        (if (list? argument) (suma argument) argument)
       )
  lista)
)

      ;input:     (wykonaj (list 1 (list 2 3 4) 5 6 (list 7 8) 9 (list 0 1 10)))
      ;output:    '(1 9 5 6 15 9 11)
```
## 15. Napisz program na wyliczanie reszty z dzielenia liczby n przez liczbę k metodą kolejnych odejmowań. Np. dla n=10 k=3 : 10-3; 7-3; 4-3; wynik wynosi 1
```Scheme
(define (dzielenie n k)
  (if (< n k)
      n
      (dzielenie (- n k) k)
      )
  )

      ;input:     (dzielenie 11 3)
      ;output:    2
```