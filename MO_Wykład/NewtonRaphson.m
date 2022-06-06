syms x;
x0 = 1;
dokladnosc = 0.0001;

f(x) = sin(2*x) * cos(x);

fplot(f,[0 6])
grid on

if diff(f, x) ~= 0
    while abs(f(x0)) > dokladnosc
    
        diffX = diff(f, x);
    
        x0 = double(x0 - (f(x0) / diffX(x0)))
        wynik = double(f(x0))
    end 
end