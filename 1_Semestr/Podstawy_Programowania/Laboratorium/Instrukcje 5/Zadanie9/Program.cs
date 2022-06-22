using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie9
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
            bool gotowe;
            int chwilowa,losowa;
            Random losI = new Random();
            for (int j = 0; j > -1; j++)
            {
                gotowe = true;
                for (int i = 0; i < n - 1; i++)
                {
                    if(tabela[i] > tabela[i + 1])
                    {
                        gotowe = false;
                        break;
                    }
                }
                if (gotowe) break;
                for(int i = n - 1; i >= 1; i--)
                {
                    losowa = losI.Next(0,n);
                    chwilowa = tabela[i];
                    tabela[i] = tabela[losowa];
                    tabela[losowa] = chwilowa;
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
