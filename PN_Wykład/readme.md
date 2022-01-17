# 1. Stwórz typ osoba (przepis na strukturę) która zawiera imię, nazwisko oraz numer indeksu. Stwórz funkcję , wyświetlającą zawartość tej struktury. Na podstawie stworzonego typu zadeklaruj 2 struktury. Jedną stałą, która będzie która będzie zawierała twoje dane, a jedną zmienną, wyświetlającą informację o twoim najlepszym wyimaginowanym przyjacielu. Następnie wywołaj funkcję wyświetlającą na obu strukturach. Pomiń wszystkie #include.

```C
typedef struct osoba {
    char imie[20];
    char nazwisko[40];
    uint16_t nr;
};

void wypisz(struct *osoba wypisywany) {
    printf("%s", wypisywany->imie);
    printf("\n%s", wypisywany->nazwisko);
    printf("\n%d", wypisywany->nr);
}

const struct osoba ja = {
    .imie = "Adrian",
    .nazwisko = "Stankiewicz",
    .nr = 47576
};

int main(void) {
    struct osoba przyjaciel = {
        .imie = "Jajami",
        .nazwisko = "O'Mate",
        .nr = 007
    }

    wypisz(&ja);
    wypisz(&przyjaciel);
    
    return 0;
}
```
___
# 2. Uzupełnij komórki tak, aby każda liczba była przedstawiona w systemie dziesiętnym, heksadecymalnym i binarnym.

| Decimal | Hexadecimal | Binary         |
|:--------|:------------|:---------------|
| _243_   | __0xF3__    | _0b11110011_   |
| _202_   | _0xCA_      | __0b11001010__ |
| __181__ | _0xB5_      | _0b10110101_   |
| _235_   | __0xEB__    | _0b11101011_   |
| _101_   | _0x65_      | __0b01100101__ |
| __214__ | _0xD6_      | _0b11010110_   |
| __73__  | _0x49_      | _0b01001001_   |
| _25_    | __0x19__    | _0b00011001_   |
___
# 3. Wykonaj te operacje i podaj wynik w systemie dziesiętnym:
## a) uint8_t a = ((9 / 2) | (6 << 4)) & ~1
## b) uint8 t b = (166 + 99) ^ 0x5C
## c) uint8 t c = (((uint16 t)166 + 99) >> 1)
> ### mimo, że uint8_t przyjmuje wartość maksymalną 255, to dzięki rzutowaniu dodawania na uint16_t nie ma przepełnienia:
>> #### ((uint16 t)166 + 99) = 265
> ### Następnie przesuwamy wynik dodawania o jeden bit w prawo:
>> #### zapis binarny 265 to 100001001
>> #### 100001001 >> 1 = 010000100 = 10000100
>> #### zapis dziesiętny 10000100 to 132
___
# 4.
___
# 5. Ponizszy kod powinien wyświetlać kolejno znaki z ciagu znaków "exam". Popraw błędy w kodzie, jeżeli wystepuja. (4pkt)
```C
// KOD BŁĘDNY
char str[] = "\0exam\0";
char *p = str;
while(p) {
    printf("%s", *p) ;
    p++;
}
```
```C
// KOD POPRAWNY
char str[] = "exam\0";  // "\0" to oznaczenie końca ciągu znaków.
                        // Umieszczamy go jedynie na końcu, nie na początku 
char *p = str;
while(*p) {             // "*p" to odniesienie do wskaźnika
                        // pętla while potrafi operować w taki sposób jedynie na Boolean lub wskaźniku, nie na typie char

    printf("%c", *p) ;  // "%c" to skrót od character, a "%s" od string.
                        // Ten program ma wypisywać kolejno ciąg znaków, a nie całe słowo co obrót, więc musimy to zmienić 
    p++;
}
```
___
# 6. Odpowiedz na jedno z ponizszych pytań. (6pkt)
## -  Czym jest pre-compilator i do czego słuzy?
## - Dlaczego warto uczyc sie jezyka C? (4pkt)
## - Czy w jezyku C możemy pracowac na obiektach i tancuchach znaków?

### Nie, poniewaz język C nie jest językiem obiektowym. Łańcuch znaków (String) domyślnie jest obiektem, zatem równiez go nie ma.
### Da się natomiast pracować na wskaźnikach do tablicy znaków i tablicach znaków. Np. w printf("%s", char[]) mozna wypisacć całą tablicę niczym string.
### Co prawda C nie posiada __domyślnie__ obiektów, ale posiada struktury. Możemy dzięki nim tworzyć paraobiekty, które do wielu zastosować są wystarczające (np. osoba w Zad1).
## - Czy i dlaczego w jezyku C standardowo wystepuja struktury/obiekty dynamiczne?