load MUX.hdl,
output-file MUX.out,
compare-to MUX.cmp,
output-list x1%B3.1.3 x0%B3.1.3 sel%B3.1.3 out%B3.1.3;

set x1 0,
set x0 0,
set sel 0,
eval,
output;
set x1 0,
set x0 1,
set sel 0,
eval,
output;
set x1 1,
set x0 0,
set sel 1,
eval,
output;
set x1 1,
set x0 1,
set sel 1,
eval,
output;