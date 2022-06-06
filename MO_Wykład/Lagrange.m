clc;
clear;

syms x1 x2 x3 x4 l

%g musi mieæ tyle samo co f, ¿eby nie by³o b³êdów
f(x1,x2,x3,x4) = 8*x1^4-7*x2^3-2*x3^2-x4^2;
g(x1,x2,x3,x4) = 2*x1+3*x2-7*x3-6;

%L to funkcja Lagrange (je¿eli wiêcej ograniczeñ to kolejne l(lambdy) * g
L(x1,x2,x3,x4,l) = f + l*g;

%p1-pi to pochodne (diff)
p1 = diff(L, x1);
p2 = diff(L, x2);
p3 = diff(L, x3);
p4 = diff(L, x4);
pi = diff(L, l);

A = [
    p1(1,0,0,0,0) p1(0,1,0,0,0) p1(0,0,1,0,0) p1(0,0,0,1,0) p1(0,0,0,0,1);
    p2(1,0,0,0,0) p2(0,1,0,0,0) p2(0,0,1,0,0) p2(0,0,0,1,0) p2(0,0,0,0,1);
    p3(1,0,0,0,0) p3(0,1,0,0,0) p3(0,0,1,0,0) p3(0,0,0,1,0) p3(0,0,0,0,1);
    p4(1,0,0,0,0) p4(0,1,0,0,0) p4(0,0,1,0,0) p4(0,0,0,1,0) p4(0,0,0,0,1);
    pi(1,0,0,0,0) pi(0,1,0,0,0) pi(0,0,1,0,0) pi(0,0,0,1,0) pi(0,0,0,0,1)
    ];

%b to jest macierz wyrazów wolnych, czyli wpisujemy z nich wyrazy wolne (te
%BEZ LITEREK z linii 11-15)
b = [0,0,0,0,6]';

A\b