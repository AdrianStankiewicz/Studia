using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie18
{
    public static class Tools
    {
        //sprawdzanie czy dane w tablicy są posortowane 
        public static bool TablicaStan(int[] tab)
        {
            bool stan1 = true;
            bool stan2 = true;
            for (int i = 1; i < tab.Length; i++)
            {
                if (tab[i - 1] > tab[i])
                {
                    stan1 = false;
                }

                if (tab[i - 1] < tab[i])
                {
                    stan2 = false;
                }
            }
            if ((stan1 && stan2) == false)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        //Tworzenie tablicy wypelnionej losowymi liczbami
        public static int[] PelnaTablica(int a)
        {
            Random liczba = new Random();
            int[] tab1 = new int[a];
            for (int i = 0; i < a; i++)
            {
                tab1[i] = liczba.Next(1, 999);
            }
            return tab1;
        }
        //drukowanie tablicy jednowymiarowej
        public static void DrukujTablica(int[] tab)
        {
            for (int i = 0; i < tab.Length; i++)
            {
                Console.WriteLine("{0}", tab[i]);
            }
        }
        //Poćwiartowany gnom
        public static int[] ZSortujTablica(int[] tab)
        {

            int a;
            a = tab.Length;
            int p = 0;
            while (p < a - 1)
            {


                if (tab[p] > tab[p + 1])
                {
                    tab.Zamien(p);
                    if (p > 0)
                    {
                        p = Tools.Lewo(p);

                    }
                }
                else
                {
                    p = Tools.Prawo(p);

                }

            }
            return tab;
        }
        //prawa reka
        public static int Prawo(int p)
        {
            p = p + 1;
            return p;
        }
        //lewa ręka 
        public static int Lewo(int p)
        {
            p--;
            return p;
        }
        public static int[] Zamien(this int[] tab, int p)
        {
            int stara1, stara2;
            stara1 = tab[p];
            stara2 = tab[p + 1];
            tab[p] = stara2;
            tab[p + 1] = stara1;
            return tab;
        }
        //sortowanie dowolnej tablicy jednowymiarowej gnomem Referencyjne
        public static int[] RSortujTablica(this int[] tab)
        {

            int a, stara1, stara2;
            a = tab.Length;
            int p = 0;
            while (p < a - 1)
            {


                if (tab[p] > tab[p + 1])
                {
                    stara1 = tab[p];
                    stara2 = tab[p + 1];
                    tab[p] = stara2;
                    tab[p + 1] = stara1;

                    if (p > 0)
                    {
                        p--;
                    }
                }
                else
                {
                    p = p + 1;
                }

            }
            return tab;
        }
        //sortowanie dowolnej tablicy jednowymiarowej gnomem
        public static int[] SortujTablica(int[] tab)
        {

            int a, stara1, stara2;
            a = tab.Length;
            int p = 0;
            while (p < a - 1)
            {


                if (tab[p] > tab[p + 1])
                {
                    stara1 = tab[p];
                    stara2 = tab[p + 1];
                    tab[p] = stara2;
                    tab[p + 1] = stara1;

                    if (p > 0)
                    {
                        p--;
                    }
                }
                else
                {
                    p = p + 1;
                }

            }
            return tab;
        }
    }
        class Program
    {
        static void Main(string[] args)
        {
            int b = 0;
            Console.WriteLine("o-------------------------o");
            Console.WriteLine("Podaj długośc tablicy");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("o-------------------------o");
            int[] tab1 = new int[a];

            //Tworze tablice
            tab1=Tools.PelnaTablica(a);

            //Drukuje tablice
            Tools.DrukujTablica(tab1);
            Console.WriteLine("o-------------------------o");

            if (Tools.TablicaStan(tab1) == true)
            {
                Console.WriteLine("Tablica jest posortowana");
            }
            else
            {
                Console.WriteLine("Tablica nie jest posortowana");
                Console.WriteLine("o-------------------------o");

                //tab1=Tools.SortujTablica(tab1);  // 17
                //tab1=Tools.ZSortujTablica(tab1); // 18
                tab1.RSortujTablica();           // 19
            }

            Console.WriteLine("o-------------------------o");
            Tools.DrukujTablica(tab1);
            Console.WriteLine("o-------------------------o");

            Console.ReadKey(true);
        }
    }
}
