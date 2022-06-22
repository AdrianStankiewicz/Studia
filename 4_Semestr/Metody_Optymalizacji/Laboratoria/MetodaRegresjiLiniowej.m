% Regresja liniowa funkcji y(x0 = ax + b
clear;
clc;

% Generacja danych wej�ciowych
xk = linspace(0, 10, 1e2);
xx = linspace(0, 10, 1e3);

% Tworzenie wsp�czynnik�w modelu (losowe)
terms = zeros(1,2);
range = 10;
Coefs = (range+range).*rand(1,max(size(terms)));

% definicja modelu
yk = Coefs(1).*xk+Coefs(2);

% definicja szumu
a = 20;
r = -a+(a*a).*rand(1,max(size(yk)));

% Dodanie szumu
yk = yk + r;

% Wykre�lenie Rysunku
plot(xk, yk,'o');

% Definicja sk�adowych modelu
% (to jest to co robimy z funkcj� - np. u nas f to x a g to wyraz wolny funkcji
f = @(u) u.^1;
g = @(u) u.^0;

% Definicja tablicy typu 'cell' dla sk�adowych modelu
funTab = {f,g};

% Alokacja pami�ci
A = zeros(max(size(terms)));
b = zeros(max(size(terms)),1);

% Uk�ad r�wna�
for i=1:1:max(size(terms))
    for j=1:1:max(size(terms))
        
        firstFun = funTab{i};
        secondFun = funTab{j};
        
        % Obliczenie element�w macierzy
        A(i,j) = sum(firstFun(xk).*secondFun(xk));
    end
end

% Obliczenie warto�ci wektora wyraz�w wolnych
for j=1:1:max(size(b))
    thisFun = funTab{j};
    
    b(j) = sum(thisFun(xk).*yk);
end

% Rozwi�zanie uk�adu r�wna�
Coefs2 = A\b;

% Tworzenie modelu przy pomocy obliczonych wsp�czynnik�w
yk2 = Coefs2(1).*xk+Coefs2(2);

% Rysunek
plot(xk, yk2);
hold on
plot(xk, yk, 'o');

% Definicja i obliczenie warto�ci funkcji b��du
psi = sum((Coefs2(1).*xk+Coefs2(2)).^2)