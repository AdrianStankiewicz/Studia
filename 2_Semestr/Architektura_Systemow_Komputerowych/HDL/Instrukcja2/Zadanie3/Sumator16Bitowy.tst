load Sumator16Bitowy.hdl,
output-file Sumator16Bitowy.out,
compare-to Sumator16Bitowy.cmp,
output-list a%B1.16.1 b%B1.16.1 cout%B1.16.1 s%B1.16.1;

set a %B0000000000000000,
set b %B0000000000000000,
eval,
output;
set b %B1000000000000001,
set a %B1000000000000001,
eval,
output;
set b %B0000000000000001,
set a %B0000000000000001,
eval,
output;
set b %B01111111111111111,
set a %B01111111111111111,
eval,
output;
set b %B1111111111111111,
set a %B1111111111111111,
eval,
output;