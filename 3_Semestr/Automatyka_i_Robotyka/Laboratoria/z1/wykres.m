clear
close all
t=[0:0.01:10];
% y=exp(-2*t).*sin(3*t+deg2rad(15));
y=10+(5*exp(-t)).*cos((2*t)+(0.5))
id1=figure(1)
plot(t,y,'k-')
xlabel('t [s]')
ylabel('y(t)')
title('Wykres funkcji')
grid on