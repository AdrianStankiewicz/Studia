using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");

            Random rnd = new Random();
            int n = int.Parse(Console.ReadLine());
            int[] tabela = new int[n];

            for (int i = 0; i < n; i++)
            {
                tabela[i] = rnd.Next(0, (5 * n));
            }

            Stopwatch stoper = new Stopwatch();
            stoper.Start();
            
            int chwilowa = 0;
            bool z;
            /*
            for (int i = 0; 1 < 2; i++)
            {
                z = false;
                for (int j = 0; j <= n - i - 2; j++)
                {
                    if (tabela[j] > tabela[j + 1])
                    {
                        chwilowa = tabela[j];
                        tabela[j] = tabela[j + 1];
                        tabela[j + 1] = chwilowa;
                        z = true;
                    }
                }
                if (z == false) break;
            }
            */

            /*
            int chwilowa;
            for (int i = 0; i <= n - 2; i++)
            {
                for(int j = 0; j <= n - i - 2; j++)
                {
                    if (tabela[j] > tabela[j + 1])
                    {
                        chwilowa = tabela[j];
                        tabela[j] = tabela[j + 1];
                        tabela[j + 1] = chwilowa;
                    }
                }
            }*/
            // ulepszenie 1
            for (int i = 0; 1 < 2; i++)
            {
                z = false;
                for (int j = 0; j <= n - 2; j++)
                {
                    if (tabela[j] > tabela[j + 1])
                    {
                        chwilowa = tabela[j];
                        tabela[j] = tabela[j + 1];
                        tabela[j + 1] = chwilowa;
                        z = true;
                    }
                }
                if (z == false) break;
            }
            

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
