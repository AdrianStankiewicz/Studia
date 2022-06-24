load SumatorPelny.hdl,
output-file SumatorPelny.out,
compare-to SumatorPelny.cmp,
output-list cin%B3.1.3 a%B3.1.3 b%B3.1.3 cout%B3.1.3 s%B3.1.3;

set cin 0,
set a 0,
set b 0,
eval,
output;
set cin 0,
set a 0,
set b 1,
eval,
output;
set cin 0,
set a 1,
set b 0,
eval,
output;
set cin 0,
set a 1,
set b 1,
eval,
output;
set cin 1,
set a 0,
set b 0,
eval,
output;
set cin 1,
set a 0,
set b 1,
eval,
output;
set cin 1,
set a 1,
set b 0,
eval,
output;
set cin 1,
set a 1,
set b 1,
eval,
output;