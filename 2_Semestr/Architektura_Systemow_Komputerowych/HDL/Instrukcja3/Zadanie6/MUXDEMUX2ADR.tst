load MUXDEMUX2ADR.hdl,
output-file MUXDEMUX2ADR.out,
compare-to MUXDEMUX2ADR.cmp,
output-list x3%B3.1.3 x2%B3.1.3 x1%B3.1.3 sel1%B3.1.3 sel0%B3.1.3 xx3%B3.1.3 xx2%B3.1.3 xx1%B3.1.3 xx0%B3.1.3;

set x3 1,
set x2 0,
set x1 0,
set x0 0,
set sel1 0,
set sel0 0,
eval,
output;
set x3 1,
set x2 0,
set x1 0,
set x0 0,
set sel1 0,
set sel0 1,
eval,
output;
set x3 1,
set x2 0,
set x1 0,
set x0 0,
set sel1 1,
set sel0 0,
eval,
output;
set x3 1,
set x2 0,
set x1 0,
set x0 0,
set sel1 1,
set sel0 1,
eval,
output;
set x3 0,
set x2 1,
set x1 0,
set x0 0,
set sel1 0,
set sel0 0,
eval,
output;
set x3 0,
set x2 1,
set x1 0,
set x0 0,
set sel1 0,
set sel0 1,
eval,
output;
set x3 0,
set x2 1,
set x1 0,
set x0 0,
set sel1 1,
set sel0 0,
eval,
output;
set x3 0,
set x2 1,
set x1 0,
set x0 0,
set sel1 1,
set sel0 1,
eval,
output;
set x3 0,
set x2 0,
set x1 1,
set x0 0,
set sel1 0,
set sel0 0,
eval,
output;
set x3 0,
set x2 0,
set x1 1,
set x0 0,
set sel1 0,
set sel0 1,
eval,
output;
set x3 0,
set x2 0,
set x1 1,
set x0 0,
set sel1 1,
set sel0 0,
eval,
output;
set x3 0,
set x2 0,
set x1 1,
set x0 0,
set sel1 1,
set sel0 1,
eval,
output;
set x3 0,
set x2 0,
set x1 0,
set x0 1,
set sel1 0,
set sel0 0,
eval,
output;
set x3 0,
set x2 0,
set x1 0,
set x0 1,
set sel1 0,
set sel0 1,
eval,
output;
set x3 0,
set x2 0,
set x1 0,
set x0 1,
set sel1 1,
set sel0 0,
eval,
output;
set x3 0,
set x2 0,
set x1 0,
set x0 1,
set sel1 1,
set sel0 1,
eval,
output;