clear
clc
close

% Uzyskana funkcja operatorowa
num = [-2 0]
den = conv([1 1], [1 5 6])
printsys( num, den)

% Wyznaczenie parametrów opisujących funkcje elementarne
[r,p,k] = residue(num, den)

% Wykreśleie rozwiązania
t = [0:0.01:10]';
y = 3*exp(-3*t) - 4*exp(-2*t) + exp(-1*t);

% Wyliczenie ze zmiennych
ya = r(1)*exp(p(1)*t) + r(2)*exp(p(2)*t) + r(3)*exp(p(3)*t);

% Rozwiązanie równania różniczkowego metodą numeryczną
name_mdl = 'Zadanie_M3b';
%open_system(name_mdl)
out = sim(name_mdl, 10);
tS = out.simout.time;
yS = out.simout.data;

% Wykresy rozwiązań
id = figure;
plot(t, y, "b-", "LineWidth", 2)
title("Rozwiązanie równania różniczkowego");
xlabel("t [s]");
ylabel("y(t) [-]");
hold on
plot(tS, yS, "k-", "Linewidth", 2)
hold off
grid on