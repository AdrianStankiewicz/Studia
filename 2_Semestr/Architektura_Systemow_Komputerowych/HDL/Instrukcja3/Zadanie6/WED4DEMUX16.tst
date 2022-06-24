load WED4DEMUX16.hdl,
output-file WED4DEMUX16.out,
compare-to WED4DEMUX16.cmp,
output-list a%B1.16.1 sel%B3.2.3 x0%B1.16.1 x1%B1.16.1 x2%B1.16.1 x3%B1.16.1;

set a %B1111111100000000,
set sel %B00,
eval,
output;
set a %B1111111100000000,
set sel %B01,
eval,
output;
set a %B1111111100000000,
set sel %B10,
eval,
output;
set a %B1111111100000000,
set sel %B11,
eval,
output;