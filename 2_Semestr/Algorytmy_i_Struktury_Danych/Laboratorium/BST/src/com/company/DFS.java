package com.company;

public class DFS
{
    private int s=0;
    boolean[] oznakowane;
    int[] krawędzDo;

    /* private void bfs(Graf g, int v) {
        Kolejka<Integer> kolejka = new Kolejka<Integer>();
        oznakowane[v]=true;
        kolejka.dodajDoKolejki(v);
        while(!kolejka.jestPusta()) {
            int vv=kolejka.pobierzZKolejki();
            for (int w : g.sąsiedzi[vv]) {

                if(!oznakowane[w]) {
//System.out.println("badanie bfs "+w);
                    krawędzDo[w]=vv;
                    oznakowane[w]=true;
                    kolejka.dodajDoKolejki(w);
                }
            }}} */

    private void dfs(Graf g, int v)
    {
        oznakowane[v]=true;
        for (int w : g.sasiedzi[v])
        {
            System.out.println("badanie dfs "+w+" ("+v+")");
            if(!oznakowane[w]) {
                System.out.println("nieoznakowane "+w+" ("+v+")");
                krawędzDo[w]=v;
                dfs(g, w);
            }//System.out.println("zakończenie dla "+w);
        }System.out.println("gotowe "+v);
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

        DFS jakaśtam = new DFS();
        jakaśtam.oznakowane = new boolean[graf.V];
        jakaśtam.krawędzDo = new int[graf.V];

        jakaśtam.dfs(graf,0);

        for (int i=0; i< graf.V; i++)
        {
            System.out.println(i + " " + jakaśtam.krawędzDo[i]);
        }
    }
}