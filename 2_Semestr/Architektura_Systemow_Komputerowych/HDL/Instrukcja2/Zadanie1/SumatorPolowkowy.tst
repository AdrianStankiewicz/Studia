load SumatorPolowkowy.hdl,
output-file SumatorPolowkowy.out,
compare-to SumatorPolowkowy.cmp,
output-list a%B3.1.3 b%B3.1.3 c%B3.1.3 s%B3.1.3;

set a 0,
set b 0,
eval,
output;
set a 0,
set b 1,
eval,
output;
set a 1,
set b 0,
eval,
output;
set a 1,
set b 1,
eval,
output;