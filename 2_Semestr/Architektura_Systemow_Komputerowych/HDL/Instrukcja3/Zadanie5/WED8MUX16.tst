load WED8MUX16.hdl,
output-file WED8MUX16.out,
compare-to WED8MUX16.cmp,
output-list x0%B1.16.1 x1%B1.16.1 x2%B1.16.1 x3%B1.16.1 x4%B1.16.1 x5%B1.16.1 x6%B1.16.1 x7%B1.16.1 sel%B3.3.3 out%B1.16.1;

set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B000,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B001,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B010,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B011,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B100,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B101,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B110,
eval,
output;
set x0 %B0111111100000000,
set x1 %B0011111110000000,
set x2 %B0001111111000000,
set x3 %B0000111111100000,
set x4 %B0000011111110000,
set x5 %B0000001111111000,
set x6 %B0000000111111100,
set x7 %B0000000011111110,
set sel %B111,
eval,
output;