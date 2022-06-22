<<<<<<< HEAD
# 1. Które ze stwierdzeń powinno(y) być prawdziwe, aby mówić o polimorfizmie:
- ### 🟩 powinna istnieć hierarchia klas,
- ### 🟩 na różnych poziomach hierarchii istnieją metody o identycznych nazwach i takich samych zbiorach parametrów formalnych,
- ### 🟥 na różnych poziomach hierarchii istnieją metody o identycznych nazwach, lecz o różnych zbiorach parametrów formalnych,
- ### 🟥 obowiązuje późne wiązanie (late binding) adresów.
___
# 2. Na ilustracji pokazano definicję klasy bazowej Pojazdy oraz klas pochodnych Samochody i Dorożki. Następnie zdefiniowano inną klasę, a w niej pokazaną metodę obsługa. Po czym utworzono obiekt i wywołano metodę obsługa: 
```Java
public class Pojazdy {
    String klasa, przeznaczenie;
    public void rysuj(){ ... }
    public void przegląd(){ ... }
}

public class Samochody extends Pojazdy {
    String marka, kolor;
    public void przegląd(){ ... }
}

public class Dorożki extends Pojazdy {
    public void rysuj(){ ... }
    public void przegląd(){ ... }
}

public void obsługa(Pojazdy poj){
    poj.rysuj();
    poj.przegląd();
}
```
```Java
Pojazdy samochód = new Samochody();
obsługa(samochód);
```
# Które metody rysuj i przegląd zostaną w takich warunkach zrealizowane:
- ### 🟩 z klasy bazowej Pojazdy,
- ### 🟥 z klasy pochodnej Samochody,
- ### 🟩 rysuj z klasy bazowej, przegląd z Samochody,
- ### 🟥 rysuj z klasy Dorożki, przegląd z Samochody.
___
# 3. Na ilustracji pokazano definicję klasy bazowej Pojazdy oraz klas pochodnych Samochody i Dorożki. Następnie zdefiniowano inną klasę, a w niej pokazaną metodę obsługa. Po czym utworzono obiekt i wywołano metodę obsługa: 
```Java
Samochody pojazd = new Dorożki();
obsługa(pojazd);
```
# Które metody rysuj i przegląd zostaną w takich warunkach zrealizowane:
- ### 🟥 z klasy bazowej Pojazdy,
- ### 🟥 z klasy pochodnej Dorożki,
- ### 🟩 żadne, gdyż przytoczona konstrukcja tworzenia obiektu jest błędna,
- ### 🟥 rysuj z klasy bazowej, przegląd z Samochody,
- ### 🟥 żadne, gdyż wywołanie jest błędne.
___
# 4. Na poprzedniej ilustracji pokazano definicję klasy bazowej Pojazdy oraz klas pochodnych Samochody i Dorożki. W innej klasie utworzone obiekt, a efekt jego tworzenia pokazano na ilustracji obok. Elementy bezpośrednio niedostępne w nowym obiekcie wyróżniono pochyłą czcionką. Którą z poniższych konstrukcji zastosowano przy tworzeniu obiektu:
- ### 🟥 Pojazdy pojazd = new Samochody();
- ### 🟩 Pojazdy pojazd = new Pojazdy();
- ### 🟥 Samochody pojazd = new Samochody();
- ### 🟥 Dorożki pojazd = new Samochody();
___
# 5. Na powyższej ilustracji możliwych przypadków powstałych w wyniku konstrukcji obiektów w zależności od użytego konstruktora występuje wyróżnienie rodzajem i krojem czcionki pewnego fragmentu powstałej struktury. W jaki sposób dostać się do atrybutu marka, przy założeniu, że obiekt utworzono tak jak w poprzednim pytaniu:
- ### 🟥 pojazd.marka,
- ### 🟩 ((Samochody)pojazd).marka,
- ### 🟥 (Samochody)pojazd.marka.
___
# 6. Na ilustracji obok pokazano kod metody zwróćCałkowitą. Metoda ta po wywołaniu zwróćCałkowitą("Ala") zwróci:
```Java
public int zwróćCałkowitą(String a) {
    int x = 200;
    try {
        x=Integer.parseInt(a);
    }
    catch(NumberFormatException ex) {
        x = 1000;
    }
    return x;
}
```
- ### 🟥 wartość 200,
- ### 🟩 wartość 1000,
- ### 🟥 komunikat o błędzie skladni.
___
# 7. Na ilustracji obok pokazano kod metody zwróćCałkowitą. Metoda ta po wywołaniu zwróćCałkowitą("123") spowoduje? (zaznacz poprawne stwierdzenia):
- ### 🟩 funkcja parseInt wykonana będzie poprawnie i zwróci wartość 123,
- ### 🟥 funkcja parseInt nie wykona się poprawnie i będzie powodem wystąpienia wyjątku klasy NumberFormatException,
- ### 🟥 wyjątek ten zostanie przechwycony, co spowoduje przypisanie zmiennej x wartości 1000,
- ### 🟩 podczas konwersji wyjątek nie powstanie, w związku z tym konstrukcja catch nie będzie realizowana.
___
# 8. W pewnym programie występuje konstrukcja:
```Java
MojakKlasa mk = new MojaKlasa(){}; zapis ten oznacza tworzenie:
```
- ### 🟥 obiektu zwykłej klasy,
- ### 🟩 obiektu klasy anonimowej,
- ### 🟥 interfejsu.
___
# 9. Zakres liczb całkowitych (int) ograniczony jest do pewnego przedziału. Czy w wyniku dodawania dwóch wartości całkowitych dodatnich może powstać wyjątek związany z przepełnieniem stałopozycyjnym:
- ### 🟥 tak, zawsze gdy suma przekroczy granice przedziału
- ### 🟩 nie
- ### 🟩 tak, ale gdy zostanie utworzony przez programistę
___
# 10. Podczas tworzenia aplikacji programista zapisał:
```Java
throw new MójWyjątek(x, y);
```
# Operacja ta służy do tzw. wyrzucenia wyjątku, z punktu widzenia programistycznego wiąże się to z: 
- ### 🟩 utworzeniem obiektu klasy MójWyjątek, klasa ta musi mieć konstruktor przyjmujący dwa argumenty,
- ### 🟥 powstaniem błędu, gdyż utworzenie obiektu klasy obsługującej wyjątki nie jest możliwe,
- ### 🟥 powstaniem błędu, gdyż konstruktor klasy wyjątków z definicji nie akceptuje parametrów.
___
# 11. Podczas tworzenia aplikacji programista zapisał:
```Java
throw new MójWyjątek(x,y);
```
# Klasa MójWyjątek została, najprawdopodobniej, zbudowana na bazie: 
- ### 🟥 dowolnej klasy, w tym klasy Object,
- ### 🟩 klasy Exception lub RuntimeException,
- ### 🟩 klasy Error.
___
# 12. W kodzie aplikacji programista zapisał:
```Java
try {
    throw new MójWyjątek(x,y);
}
catch(MojWjątek wyjątek) {

}
```
# Takie działanie należy ocenić jako: 
- ### 🟩 prawidłowe i praktyczne,
- ### 🟥 prawidłowe, ale niepraktyczne, wyrzucanie własnych wyjątków nie ma sensu,
- ### 🟥 nieprawidłowe, ale praktyczne, nieprawidłowość związana jest z identycznością klas obiektu tworzonego i przechwytywanego.
___
# 13. W pewnym programie zapisano fragment poprawnej formalnie konstrukcji:
```Java
public class Mojaklasa<Typ> {Typ atrybut; ...}
```
# Fragment ten jest przykładem:
- ### 🟩 definiowania uogólnionej, generycznej klasy,
- ### 🟥 parametryzowania klasy, przy czym Typ to nazwa dostępnej klasy,
- ### 🟩 Typ to nazwa „figuranta”, elementu formalnego, który w momencie tworzenia obiektu powinien być zastąpiony nazwą konkretnej klasy.
___
# 14. W kodzie aplikacji występuje nagłówek metody: 
```Java
public void actionPerformed (ActionEvent e)
```
# Parametr formalny tej metody jest klasy ActionEvent. Typowo metoda ta będzie realizowana, gdy:
- ### 🟥 w kodzie aplikacji nastąpi jej wywołanie,
- ### 🟥 zainicjowana w aplikacji akcja spowoduje automatyczne utworzenie obiektu klasy ActionEvent,
- ### 🟩 użytkownik aplikacji kliknie jakiś przycisk albo naciśnie klawisz Enter podczas edycji pola tekstowego.
___
```Java
// KOD DO ZADAŃ OD 15

public class Kolejka <El> implements Iterable<El>{
	public ObiektKolejki pierwszy;
	public ObiektKolejki ostatni;
	private int N;

	public class ObiektKolejki{
		El element;
		ObiektKolejki następny;
    }
    
    public boolean jestPusta() {
        return pierwszy == null;
    }
	
    public int size() {
        return N;
    }

    public void dodajDoKolejki(El el) {
        ObiektKolejki staryOstatni = ostatni;
        ostatni = new ObiektKolejki();
        ostatni.element = el;
        ostatni.następny = null;

        if (jestPusta()) pierwszy=ostatni;
		else staryOstatni.następny=ostatni;
		N++;    
    }
    
    public ObiektKolejki pobierzZKolejki() {
		if (jestPusta()) 
            return null;
		ObiektKolejki el=pierwszy;
		pierwszy=pierwszy.następny;
        if (jestPusta()) 
            ostatni = null;
		N--;
		return el;
    }

    public Iterator<El> iterator() {
        return new LIterator();
    }

    public class LIterator implements Iterator<El> {
        private ObiektKolejki b = pierwszy;
        public boolean hasNext() {
            return b != null;
            }
        
        public El next() {
            El d=b.element;
	        b=b.następny;
	        return d;
        }
    }
}

1.	Kolejka<Student> kSt = new Kolejka<Student>();
2.	Kolejka<Klient> kKl = new Kolejka<Klient>();
3.	Klient xx = new Klient();
4.	kSt.dodajDoKolejki(xx);
5.	Student x = new Student("Kazimierz","Wiśniewski", "PiT","1998-01-11", 4.0);
6.	kSt.dodajDoKolejki(x);
7.	Kolejka<Student>.ObiektKolejki kSOK = kSt.pierwszy;
8.	kSOK.następny= null;
9.	kSOK.następny.następny.następny.element.nazwisko = "Zając";
10.	Kolejka<Student>.ObiektKolejki kSOKD=kolejkaSt.new ObiektKolejki();
11.	ArrayList<Kolejka<Student>.ObiektKolejki> lista = new ArrayList<Kolejka<Student>.ObiektKolejki>();
12.	for(Student x: kolejkaSt) lista.add(x);
13.	for(Student x: kolejkaSt) System.out.println(x);
```
# 15. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Scharakteryzuj pierwsze dwie:
- ### 🟩 pierwsza tworzy kolejkę obiektów klasy Student,
- ### 🟩 druga tworzy kolejkę obiektów klasy Klient,
- ### 🟥 obydwie są niepoprawne, gdyż definicja klasy Kolejka mówi, że przeznaczona jest ona dla obiektów klasy El.
___
# 16. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Trzecia operacja:
- ### 🟩 tworzy obiekt o nazwie xx klasy Klient,
- ### 🟩 angażuje konstruktor bezparametrowy,
- ### 🟩 angażuje konstruktor domyślny,
- ### 🟩 wobec braku parametrów atrybuty będą miały charakter domyślny.
___
# 17. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Czwarta operacja:
- ### 🟥 dopisuje obiekt xx klasy Klient, do listy przeznaczonej dla studentów,
- ### 🟩 jest niepoprawna,
- ### 🟥 jest poprawna,
- ### 🟥 dopisuje obiekt xx klasy Student, do listy przeznaczonej dla studentów.
___
# 18. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Piąta operacja:
- ### 🟥 dopisuje obiekt x klasy Student, do listy przeznaczonej dla studentów,
- ### 🟩 poprawnie tworzy obiekt x klasy Student,
- ### 🟥 niepoprawnie usiłuje stworzyć obiekt x klasy Student,
- ### 🟩 korzysta z parametrowego konstruktora klasy Student.
___
# 19. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Siódma operacja:
- ### 🟥 tworzy obiekt klasy wewnętrznej w stosunku do klasy Kolejka,
- ### 🟩 deklaruje zmienną obiektową klasy wewnętrznej w stosunku do klasy Kolejka, i nadaje jej wartość referencji obiektu kolejki o nazwie pierwszy,
- ### 🟩deklaruje zmienną obiektową klasy wewnętrznej w stosunku do klasy Kolejka, w ten sposób obiekt kolejki o nazwie pierwszy będzie miał alias w postaci nazwy kSOK.
___
# 20. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Dziewiąta operacja:
- ### 🟥 jest zbyt długa, przez to niepoprawna,
- ### 🟩 jest poprawna, jeżeli kolejka zawiera co najmniej cztery elementy, to nazwisko czwartego zmienione zostanie na Zając,
- ### 🟩 jest niepoprawna, jeżeli kolejka nie zawiera co najmniej czterech elementów,
- ### 🟩 jeżeli kolejka nie zawiera przynajmniej czterech elementów, zostanie wygenerowany wyjątek klasy NullPointerException. 
___
# 21. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. Jedenasta operacja:
- ### 🟩 poprawnie deklaruje zmienną obiektową klasy ArrayList, która jest parametryzowana klasą wewnętrzną w stosunku do Kolejka, tworzenie obiektu jest też prawidłowe,
- ### 🟩 przygotowuje listę obiektów klasy wewnętrznej w stosunku do klasy Kolejka, prawidłowo też zapisano parametryzację,
- ### 🟥 przygotowuje listę obiektów klasy wewnętrznej w stosunku do klasy Kolejka, nieprawidłowo zaś zapisano parametryzację.
___
# 22. Obok pokazano kod klasy Kolejka, a także kilka operacji dotyczących tej klasy. W dwunastej i trzynastej operacji występują iteracje po zbiorze elementów kolejki. Poprawność tych konstrukcji wynika z:
- ### 🟩 implementacji interfejsu Iterable w klasie Kolejka,
- ### 🟥 koniecznej parametryzacji interfejsu,
- ### 🟥 zachowania naturalnych właściwości wszystkich kolekcji, także takich jak listy jednokierunkowe.
___
=======
<p style="font-size: 5rem;font-weight: 700;">Notatki do odpowiedzi</p>

# Podstawowe pojęcia OOP:
- ## Klasa
    - ### zbiór atrybutów i metod na podstawie których tworzymy obiekty
- ## Obiekt
    - ### instancja klasy
- ## Dziedziczenie
    - ### zjawisko które pozwala na przejmowanie atrybutów i metod przodka przez klasę potomną
- ## Polimorfizm
    - ### zjawisko występujące między klasami w jednym drzewie hierarchii
- ## Abstrakcja
    - ### jest to ukrywanie niepotrzebnych na tą chwilę szczegółów i skupianie się jedynie na informacji ważnej
___
# Zagnieżdżanie klas:
```Java
class OuterClass {
  int x = 10;

  class InnerClass {
    int y = 5;
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x);
  }
}

// Outputs 15 (5 + 10)
```
>>>>>>> refs/remotes/origin/master
