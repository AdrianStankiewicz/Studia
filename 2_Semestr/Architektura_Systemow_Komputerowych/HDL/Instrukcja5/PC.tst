load PC.hdl,
compare-to PC.cmp,
output-file PC.out,
output-list in%B1.16.1 inc%B1.16.1 load%B3.1.3 reset%B3.1.3 out%B1.16.1;

set in %B0000000000101111,
set load 1,
tick,
output;
tock,
output;
set in %B0000001000001111,
set reset 1,
set load 0,
tick,
output;
tock,
output;
set reset 0,
tick,
output;
tock,
output;
set inc %B0000000000000001,
set load 0,
tick,
output;
tock,
output;
tick,
output;
tock,
output;
tick,
output;
tock,
output;
tick,
output;
tock,
output;
set load 1,
tick,
output;
tock,
output;
set load 0,
tick,
output;
tock,
output;
tick,
output;
tock,
output;
tick,
output;
tock,
output;
set inc %B0000000000000000,
tick,
output;
tock,
output;
tick,
output;
tock,
output;