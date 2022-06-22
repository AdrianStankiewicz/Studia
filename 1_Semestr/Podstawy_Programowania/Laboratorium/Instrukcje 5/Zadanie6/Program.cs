using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie6
{
    class Program
    {
        static void Sort(int[] tabela, int dlugosc)
        {
            int tuStoiGnom = 0;
            int tuGnomWroci = 1;

            while (tuStoiGnom < dlugosc)
            {
                if (tuStoiGnom == 0) //Startujemy od doniczki 0
                {
                    tuStoiGnom = tuGnomWroci; //Krok do przodu
                }

                
                if (tabela[tuStoiGnom] >= tabela[tuStoiGnom - 1]) // Dobra kolejność - idziemy dalej.
                {
                    if (tuGnomWroci > tuStoiGnom)
                    {
                        tuStoiGnom = tuGnomWroci;
                    }

                    tuStoiGnom++;
                    tuGnomWroci = tuStoiGnom;
                }
                else //Zła kolejność - przestawiamy
                {
                    if (tuStoiGnom > tuGnomWroci)
                    {
                        tuGnomWroci = tuStoiGnom;
                    }
                    int chwilowa;
                    chwilowa = tabela[tuStoiGnom];
                    tabela[tuStoiGnom] = tabela[tuStoiGnom - 1];
                    tabela[tuStoiGnom - 1] = chwilowa;
                    tuStoiGnom--;
                }
            }
            return;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");
            int n = int.Parse(Console.ReadLine());

            Random rnd = new Random();
            int[] tabela = new int[n];

            for (int i = 0; i < n; i++)
            {
                tabela[i] = rnd.Next(0, (5 * n));
                Console.Write(tabela[i] + " ");
            }

            Stopwatch stoper = new Stopwatch();
            stoper.Start();

            Sort(tabela, tabela.Length);

            stoper.Stop();

            // Sprawdzanie
            bool czy = true;
            for (int i = 0; i < n - 1; i++)
            {
                if (tabela[i] > tabela[i + 1])
                {
                    czy = false;
                }
            }

            if (czy) Console.WriteLine(Environment.NewLine + Environment.NewLine + "Sprawdzona tabela uzyskała wynik pozytywny");
            else Console.WriteLine(Environment.NewLine + Environment.NewLine + "No coś tu ewidentnie nie poszło");
            Console.WriteLine("Czas który upłynął: " + stoper.Elapsed);
            Console.ReadKey(true);
        }
    }
}
