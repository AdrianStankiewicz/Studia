load WED8DEMUX16.hdl,
output-file WED8DEMUX16.out,
compare-to WED8DEMUX16.cmp,
output-list a%B1.16.1 sel%B2.3.2 x0%B1.16.1 x1%B1.16.1 x2%B1.16.1 x3%B1.16.1 x4%B1.16.1 x5%B1.16.1 x6%B1.16.1 x7%B1.16.1;

set a %B0011001100110011,
set sel %B000,
eval,
output;
set a %B0011001100110011,
set sel %B001,
eval,
output;
set a %B0011001100110011,
set sel %B010,
eval,
output;
set a %B0011001100110011,
set sel %B011,
eval,
output;
set a %B0011001100110011,
set sel %B100,
eval,
output;
set a %B0011001100110011,
set sel %B101,
eval,
output;
set a %B0011001100110011,
set sel %B110,
eval,
output;
set a %B0011001100110011,
set sel %B111,
eval,
output;