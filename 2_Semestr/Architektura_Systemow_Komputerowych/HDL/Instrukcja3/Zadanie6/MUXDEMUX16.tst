load MUXDEMUX16.hdl,
output-file MUXDEMUX16.out,
compare-to MUXDEMUX16.cmp,
output-list x0%B1.16.1 x1%B1.16.1 sel%B3.1.3 xx0%B1.16.1 xx1%B1.16.1;

set x0 %B0000000000000000,
set x1 %B0000000000000000,
set sel 0,
eval,
output;
set x0 %B0000000000000000,
set x1 %B0000000000000000,
set sel 0,
eval,
output;
set x0 %B1111111111111111,
set x1 %B1111111111111111,
set sel 1,
eval,
output;
set x0 %B1111111111111111,
set x1 %B1111111111111111,
set sel 1,
eval,
output;
set x0 %B1111111111111111,
set x1 %B0000000000000000,
set sel 1,
eval,
output;
set x0 %B0000000000000000,
set x1 %B1111111111111111,
set sel 0,
eval,
output;
set x0 %B0000000000000000,
set x1 %B1111111111111111,
set sel 1,
eval,
output;
set x0 %B1111111111111111,
set x1 %B0000000000000000,
set sel 0,
eval,
output;