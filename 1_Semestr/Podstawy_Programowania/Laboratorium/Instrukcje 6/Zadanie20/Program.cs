using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie20
{
    class Tools
    {
        public delegate int[] Del_tab(int[] tab);
        
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
        //sortowanie dowolnej tablicy jednowymiarowej gnomem(malejąco)
        public static int[] Sortujmalejąco(int[] tab)
        {

            int a, stara1, stara2;
            a = tab.Length;
            int p = 0;
            while (p < a - 1)
            {


                if (tab[p] < tab[p + 1])
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
        public static int[] Sortujparzyste(int[] tab)
        {
            tab = SortujTablica(tab);
            int a, stara1, stara2;
            a = tab.Length;
            int p = 0;
            while (p < a - 1)
            {


                if ((tab[p] % 2 == 0) && (tab[p + 1] % 2 == 1))
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

            tab1 = Tools.PelnaTablica(a);

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
                Console.WriteLine("Wybierz sposób sortowania:");
                Console.WriteLine("o-------------------------o");
                Console.WriteLine("1.Od największej do najmniejszej");
                Console.WriteLine("2.Parzyste i Nieparzyste");
                Console.WriteLine("Inna liczba = zwykły gnom");
                Console.WriteLine("o-------------------------o");
                Tools.Del_tab del = Tools.SortujTablica;
                b = int.Parse(Console.ReadLine());
                if (b == 1)
                {
                    del = Tools.Sortujmalejąco;
                }
                if (b == 2)
                {
                    del = Tools.Sortujparzyste;
                }
                tab1=del(tab1);
            }
            Console.WriteLine("o-------------------------o");
            Tools.DrukujTablica(tab1);
            Console.WriteLine("o-------------------------o");
            Console.ReadKey(true);
        }
    }
}
