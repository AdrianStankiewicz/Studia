load DEMUX2ADR.hdl,
output-file DEMUX2ADR.out,
compare-to DEMUX2ADR.cmp,
output-list a%B3.1.3 sel1%B3.1.3 sel0%B3.1.3 x3%B3.1.3 x2%B3.1.3 x1%B3.1.3 x0%B3.1.3;

set a 1,
set sel1 0,
set sel0 0,
eval,
output;
set a 1,
set sel1 0,
set sel0 1,
eval,
output;
set a 1,
set sel1 1,
set sel0 0,
eval,
output;
set a 1,
set sel1 1,
set sel0 1,
eval,
output;