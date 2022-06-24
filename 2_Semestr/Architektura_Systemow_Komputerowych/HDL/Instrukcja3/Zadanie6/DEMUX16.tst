load DEMUX16.hdl,
output-file DEMUX16.out,
compare-to DEMUX16.cmp,
output-list a%B1.16.1 sel%B3.1.3 x0%B1.16.1 x1%B1.16.1;

set a %B1111111100000000,
set sel 0,
eval,
output;
set a %B1111111100000000,
set sel 1,
eval,
output;