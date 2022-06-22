clear;  clc;

% deklatujemy x
syms x
% deklarujemy funkcje
y(x) = log(x) * sin(x) - cos(3*x);
%deklatujemy precyzje wyniku
precyzja = 0.00001;
iteracja = 0;
% a i b to granice przedzialu
a = 0.5;
b = 1;

% dajemy przedzia³ w jakim szukamy (przód na dole wykresu, ty³ na dole
% wykreu, tylko jeden x0)
x = [a:0.1:b];
% Dzieki temu mozemy ladnie znaleŸæ dobry przedzia³
plot(x, y(x))
grid on

% Wzór na x0
x0 = (a+b)/2;

while(abs(y(x0)) > precyzja)
    iteracja = iteracja +1;
    if((y(x0) * y(a)) < 0)
        b = x0;
        x0 = (a+b)/2;
    end
    if((y(x0) * y(b)) < 0)
        a = x0;
        x0 = (a+b)/2;
    end
end

fun = @testBisekcja;
[x,fval,exitflag,output] = fzero(fun, b)

iteracja
x0
double(y(x0))