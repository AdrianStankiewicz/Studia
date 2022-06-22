using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie8
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");

            Random rnd = new Random();
            int zakres = int.Parse(Console.ReadLine());
            int[] tabela = new int[zakres];

            for (int i = 0; i < zakres; i++)
            {
                tabela[i] = rnd.Next(0, (5 * zakres));
            }

            Stopwatch stoper = new Stopwatch();
            stoper.Start();

            int chwilowa, minimum;

            //1. Dla każdego elementu w tabeli
            for (int i = 0; i < zakres - 1; i++)
            {
                //2. zakładamy, że pierwszy z obecnego zakresu jest minimum
                minimum = i;
                //3. Cycle through the rest of the array
                for (int j = i + 1; j < zakres; j++)
                {
                    //4. If any of the remaining values are smaller, find the smallest of these
                    if (tabela[j] < tabela[minimum])
                    {
                        minimum = j;
                    }
                }
                // Zamienia najmniejszy znaleziony z obecną wartością i
                chwilowa = tabela[minimum];
                tabela[minimum] = tabela[i];
                tabela[i] = chwilowa;
            }

            bool czy = true;
            for (int i = 0; i < zakres - 1; i++)
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
