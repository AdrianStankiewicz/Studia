clear
clc

% Wymagania nakladane na projektowany układ
MrdB = 3;
BW = 5;

% Wyznaczamy wartości bezwzględne modułu
Mr = 10^(MrdB/20);

% Wyznaczenie współczynnika tłumienia
Wzeta = [-4 0 4 0 -1/(Mr^2)];
rzeta = roots(Wzeta); %bierzemy ten pierwiastek który pasuje w przedziale we wzorze

zeta = rzeta(4);

wn = BW/sqrt((1-2*zeta^2) + sqrt(4*zeta^4 - 4*zeta^2 + 2))
