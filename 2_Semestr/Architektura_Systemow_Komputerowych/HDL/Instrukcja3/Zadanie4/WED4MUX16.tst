load WED4MUX16.hdl,
output-file WED4MUX16.out,
compare-to WED4MUX16.cmp,
output-list x3%B1.16.1 x2%B1.16.1 x1%B1.16.1 x0%B1.16.1 sel%B3.2.3 out%B1.16.1;

set x3 %B0111111111110000,
set x2 %B0011111111111000,
set x1 %B0001111111111100,
set x0 %B0000111111111110,
set sel %B00,
eval,
output;
set x3 %B0111111111110000,
set x2 %B0011111111111000,
set x1 %B0001111111111100,
set x0 %B0000111111111110,
set sel %B01,
eval,
output;
set x3 %B0111111111110000,
set x2 %B0011111111111000,
set x1 %B0001111111111100,
set x0 %B0000111111111110,
set sel %B10,
eval,
output;
set x3 %B0111111111110000,
set x2 %B0011111111111000,
set x1 %B0001111111111100,
set x0 %B0000111111111110,
set sel %B11,
eval,
output;
