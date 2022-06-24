load MUX16.hdl,
output-file MUX16.out,
compare-to MUX16.cmp,
output-list x1%B1.16.1 x0%B1.16.1 sel%B3.1.3 out%B1.16.1;

set x1 %B0000000000000000,
set x0 %B0000000000000000,
set sel 0,
eval,
output;
set x1 %B0000000000000000,
set x0 %B1111111111111111,
set sel 1,
eval,
output;
set x1 %B1111111111111111,
set x0 %B0000000000000000,
set sel 1,
eval,
output;
set x1 %B0000000011111111,
set x0 %B1111111100000000,
set sel 1,
eval,
output;
set x1 %B1111111111111111,
set x0 %B1111111111111111,
set sel 1,
eval,
output;
set x1 %B1111111111111111,
set x0 %B1111111111111111,
set sel 0,
eval,
output;