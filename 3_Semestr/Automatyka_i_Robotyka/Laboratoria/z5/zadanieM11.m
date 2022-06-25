clear
clc

% Wymagania nakładane na projektoway układ\
tp = 1;
tr = 2;

% Wyznaczenie parametrów transmitancji wzorcowej
a = (pi*tr)/(4.6*tp);
zeta = sqrt(1/(a^2 + 1));

wn = pi/(tp * sqrt(1-zeta^2));

% Sprawdzenie wyznaczonych parametrów
sprTp = pi / (wn * sqrt(1-zeta^2));
sprTr = 4.6/(zeta*wn);

% Poszukiwane wartosci projektowanego układu

K1 = wn^2;
K2 = 2*zeta*wn-1;