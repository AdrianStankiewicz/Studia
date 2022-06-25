clear;
clc;

Gs = tf([5 7],[1 5 13 14 6]);
%sisotool(Gs)

% Kryteria Routha
% [xK * y]
b1t = [0 5*13] - [5 14]
c1t = conv([-5 51], [5 14]) - [0 5 * [35 30]]

rc1t = roots(c1t)
K = rc1t(1)
ps = [(-5*K+51) 0 5*(7*K+6)]
rps = roots(ps)
w = imag(rps(1))

Tosc = 2*pi/w

% Nastawy wregulatora PI
Kp = 0.45*K
Ti = Tosc/1.2
Ki = Kp/Ti

% Nastawy wregulatora PID
Kp = 0.6*K
Ti = Tosc/2
Td = Tosc/8

Ki = Kp/Ti
Kd = Kp*Td