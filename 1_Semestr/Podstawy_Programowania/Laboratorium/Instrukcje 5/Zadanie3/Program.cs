using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie_3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");
            
            Random rnd = new Random();
            int n = int.Parse(Console.ReadLine());
            int[] tabela = new int[n];

            // Tworzenie
            for (int i = 0; i < n; i++)
            {
                tabela[i] = rnd.Next(0, (5 * n));
            }

            Stopwatch stoper = new Stopwatch();
            stoper.Start();

            // Sortowanie
            int chwilowa = 0;
            for (int i = 0; i <= n - 2; i++)
            {
                for (int j = 0; j <= n - 2; j++)
                {
                    if (tabela[j] > tabela[j + 1])
                    {
                        chwilowa = tabela[j];
                        tabela[j] = tabela[j + 1];
                        tabela[j + 1] = chwilowa;
                    }
                }
            }

            // Sprawdzanie
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
