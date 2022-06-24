load MUXDEMUX.hdl,
output-file MUXDEMUX.out,
compare-to MUXDEMUX.cmp,
output-list x0%B3.1.3 x1%B3.1.3 sel%B3.1.3 xx0%B3.1.3 xx1%B3.1.3;

set x0 0,
set x1 0,
set sel 0,
eval,
output;
set x0 0,
set x1 1,
set sel 0,
eval,
output;
set x0 1,
set x1 0,
set sel 0,
eval,
output;
set x0 1,
set x1 1,
set sel 0,
eval,
output;
set x0 0,
set x1 0,
set sel 1,
eval,
output;
set x0 0,
set x1 1,
set sel 1,
eval,
output;
set x0 1,
set x1 0,
set sel 1,
eval,
output;
set x0 1,
set x1 1,
set sel 1,
eval,
output;