# Definicja przykładowej funkcji:
```Scheme
; funkcja oblicza kwadrat podanej liczby
(define (nazwaFunkcji x) (* x x))
```
# Wykorzystanie let:
```Scheme
; funkcja oblicza kwadrat podanych 2 liczb
(define (nazwaFunkcji x y)
  (let (
       (x2 (* x x))
       (y2 (* y y))
        )
    (list x2 y2)
  )
)
```
# Wyciąganie elementu z listy:
```Scheme
; Scheme obsługuje od first do tenth
(define (nazwaMetody parametr) (second parametr))
```

## 4.6
```Scheme
(define (f3param x y z)
  (if (= z 0)
      10000
      (/ (+ (* x x) (* y y)) (* 2 z))
  )-
)
```
## 4.8
```Scheme
#lang racket
(define (row_liniowe x1 y1 z1 x2 y2 z2)
  (let (
       (W (- (* x1 y2) (* x2 y1)))
       (Wx (- (* z1 y2) (* z2 y1)))
       (Wy (- (* x1 z2) (* x2 z1)))
        )
    (list (/ Wx W) (/ Wy W))
  )
)
```
## 4.11
```Scheme
#lang rocket
(define (silnia n)
  (if (< n 1)
      1
      (* n (silnia (- n 1)))
   )
)
```
## 5.1
```Scheme
; liczy długość listy
(define (dl-listy lista)
  (if (null? lista) 0
      (+ 1 (dl-listy (cdr lista)))))
```