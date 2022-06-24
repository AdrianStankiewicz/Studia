package com.company;

import java.util.Iterator;

public class Graf {
    final int V;
    private int E;
    public Worek<Integer>[] sasiedzi;

    public Graf(int V) {
        this.V = V;
        this.E = 0;
        sasiedzi = (Worek<Integer>[]) new Worek[V];
        for (int v = 0; v < V; v++) sasiedzi[v] = new Worek<Integer>();
    }

    public void dodajKrawedz(int v, int w) {
        sasiedzi[v].dodaj(w);
        sasiedzi[w].dodaj(v);
        E++;
    }

    public static void main(String[] args) {
        Graf graf = new Graf(6);
        graf.dodajKrawedz(0, 5);
        graf.dodajKrawedz(2, 4);
        graf.dodajKrawedz(2, 3);
        graf.dodajKrawedz(1, 2);
        graf.dodajKrawedz(0, 1);
        graf.dodajKrawedz(3, 4);
        graf.dodajKrawedz(3, 5);
        graf.dodajKrawedz(0, 2);
        for (int j=0;j< graf.V;j++) {
            for (int i : graf.sasiedzi[j]) System.out.print(i + " ");
            System.out.println();
        }


    }
}
class Worek<Item> implements
        Iterable<Item> {
    private Wezel pierwszy;

    private class Wezel {
        Item item;
        Wezel nastepny;
    }

    public void dodaj(Item a) {
        Wezel popPierwszy = pierwszy;
        pierwszy = new Wezel();
        pierwszy.item = a;
        pierwszy.nastepny = popPierwszy;
    }

    public Iterator<Item> iterator() {
        return new LIterator();
    }


    public class LIterator implements Iterator<Item> {
        private Wezel biezacy = pierwszy;

        public boolean hasNext() {
            return biezacy != null;
        }

        public Item next() {
            Item item = biezacy.item;
            biezacy = biezacy.nastepny;
            return item;
        }
    }
}