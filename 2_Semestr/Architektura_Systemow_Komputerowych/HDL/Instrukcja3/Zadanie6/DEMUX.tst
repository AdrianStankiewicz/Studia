load DEMUX.hdl,
output-file DEMUX.out,
compare-to DEMUX.cmp,
output-list a%B3.1.3 sel%B3.1.3 x0%B3.1.3 x1%B3.1.3;

set a 0,
set sel 0,
eval,
output;
set a 0,
set sel 1,
eval,
output;
set a 1,
set sel 0,
eval,
output;
set a 1,
set sel 1,
eval,
output;