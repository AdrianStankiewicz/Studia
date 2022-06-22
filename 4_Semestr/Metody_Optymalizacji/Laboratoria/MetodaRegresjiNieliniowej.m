% Regresja liniowa funkcji y(x0) = ax + b
clear;
clc;

% Generacja danych wejœciowych
xk = linspace(-2, 2, 1e2); %To zmiana

% Tworzenie wspó³czynników modelu (losowe)
terms = zeros(1,3); % TO NA 3
range = 2; %To zmiana
Coefs = (range+range).*rand(1,max(size(terms)));

% definicja modelu
fun = @(u)Coefs(1).*cos(u) + Coefs(2).*sin(u) + Coefs(3).*exp(u);    % To jest jako funkcja
yk = fun(xk);       % Uruchamiamy funkcjê

% definicja szumu
a = 3;  %To zmiana
r = -a+(a*a).*rand(1,max(size(yk)));

% Dodanie szumu
yk = yk + r;

% Wykreœlenie Rysunku
plot(xk, yk,'o');

% Definicja sk³adowych modelu
% (to jest to co robimy z funkcj¹ - np. u nas f to x a g to wyraz wolny funkcji
f = @(u) cos(u);
g = @(u) sin(u);
h = @(u) exp(u);

% Definicja tablicy typu 'cell' dla sk³adowych modelu
funTab = {f,g,h};      % Dodane h

% Alokacja pamiêci
A = zeros(max(size(terms)));
b = zeros(max(size(terms)),1);

% Uk³ad równañ
for i=1:1:max(size(terms))
    for j=1:1:max(size(terms))
        
        firstFun = funTab{i};
        secondFun = funTab{j};
        
        % Obliczenie elementów macierzy
        A(i,j) = sum(firstFun(xk).*secondFun(xk));
    end
end

% Obliczenie wartoœci wektora wyrazów wolnych
for j=1:1:max(size(b))
    thisFun = funTab{j};
    
    b(j) = sum(thisFun(xk).*yk);
end

% Rozwi¹zanie uk³adu równañ
Coefs2 = A\b;

% Tworzenie modelu przy pomocy obliczonych wspó³czynników ZMIANA
fun2 = @(u)Coefs2(1).*cos(u) + Coefs2(2).*sin(u) + Coefs2(3).*exp(u);
yk2 = fun2(xk);

% Rysunek
plot(xk, yk2);
hold on
plot(xk, yk, 'o');

% Definicja i obliczenie wartoœci funkcji b³êdu
psi = sum((Coefs2(1).*cos(xk) + Coefs2(2).*sin(xk) + Coefs2(3).*exp(xk)).^2)