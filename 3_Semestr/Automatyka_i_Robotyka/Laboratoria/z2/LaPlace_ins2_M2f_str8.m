clear
clc
close

% Uzyskana funkcja operatorowa

% po kolei co jest u góry równania
num = [1 1]
%po kolei co jest na dole równania
den = conv([1 2 0], [1 2 2])


printsys( num, den)

% Wyznaczenie parametrów opisujących funkcje elementarne
[r,p,k] = residue(num, den)

t=[0:0.01:10];

y = r(1)*exp(p(1)*t) + 0.5*exp(-t) .* cos(t+pi) + r(4);


id = figure;
plot(t, y, "LineWidth", 2)
grid on