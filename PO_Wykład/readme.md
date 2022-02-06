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