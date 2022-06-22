using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie5
{
    class Program
    {
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

            int p = 0, chwilowa = 0;
            while (p < n - 1)
            {
                if (tabela[p] > tabela[p + 1]) 
                {
                    chwilowa = tabela[p];
                    tabela[p] = tabela[p + 1];
                    tabela[p + 1] = chwilowa;

                    if (p > 0) p -= 1;
                }
                else p += 1;
            }
            Console.WriteLine();
            bool czy = true;
            for (int i = 0; i < n - 1; i++)
            {
                if (tabela[i] > tabela[i + 1])
                {
                    czy = false;
                }
            }

            stoper.Stop();

            if (czy) Console.WriteLine(Environment.NewLine + Environment.NewLine + "Sprawdzona tabela uzyskała wynik pozytywny");
            else Console.WriteLine(Environment.NewLine + Environment.NewLine + "No coś tu ewidentnie nie poszło");
            Console.WriteLine("Czas który upłynął: " + stoper.Elapsed);
            Console.ReadKey(true);
        }
    }
}
