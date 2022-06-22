using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie17
{
    class Program 
    {
        static int[] CreateAndFill(int n)
        {
            Random rnd = new Random();
            int[] tabela = new int[n];

            for (int i = 0; i < n; i++)
            {
                tabela[i] = rnd.Next(0, (5 * n));
            }

            return tabela;
        }
        static int[] Print(int[] tabela)
        {
            for(int i = 0; i < tabela.Length; i++)
            {
                Console.Write(tabela[i] + " ");
            }
            return tabela;
        }
        static bool Check(int[] tabela)
        {
            bool czy = true;
            for (int i = 0; i < tabela.Length-1; i++)
            {
                if (tabela[i] > tabela[i + 1])
                {
                    return false;
                }
            }
            return true;
        }
        static int[] Sort(int[] tabela)
        {
            int tuStoiGnom = 0;
            int tuGnomWroci = 1;
            int chwilowa;

            while (tuStoiGnom < tabela.Length)
            {
                if (tuStoiGnom == 0) //Startujemy od doniczki 0
                {
                    tuStoiGnom = tuGnomWroci; //Krok do przodu
                }

                // Dobra kolejność - idziemy dalej.
                if (tabela[tuStoiGnom] >= tabela[tuStoiGnom - 1])
                {
                    if (tuGnomWroci > tuStoiGnom)
                    {
                        tuStoiGnom = tuGnomWroci;
                    }

                    tuStoiGnom++;
                    tuGnomWroci = tuStoiGnom;
                }
                //Zła kolejność - przestawiamy.
                else
                {
                    if (tuStoiGnom > tuGnomWroci)
                    {
                        tuGnomWroci = tuStoiGnom;
                    }

                    chwilowa = tabela[tuStoiGnom];
                    tabela[tuStoiGnom] = tabela[tuStoiGnom - 1];
                    tabela[tuStoiGnom - 1] = chwilowa;
                    tuStoiGnom--;
                }
            }
            return tabela;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");
            int n = int.Parse(Console.ReadLine());


            if (Check(Print(Sort(CreateAndFill(n))))) Console.WriteLine(Environment.NewLine + "Tabela jest dobrze posortowana.");
            else Console.WriteLine(Environment.NewLine + "Konsola jest źle posortowana.");
            Console.ReadKey(true);

            //Sort(tabela, tabela.Length);

            // Sprawdzanie
            /*bool czy = true;
            for (int i = 0; i < n - 1; i++)
            {
                if (tabela[i] > tabela[i + 1])
                {
                    czy = false;
                }
            }*/

            /*if (czy) Console.WriteLine(Environment.NewLine + Environment.NewLine + "Sprawdzona tabela uzyskała wynik pozytywny");
            else Console.WriteLine(Environment.NewLine + Environment.NewLine + "No coś tu ewidentnie nie poszło");
            Console.ReadKey(true);*/
        }
    }
}
