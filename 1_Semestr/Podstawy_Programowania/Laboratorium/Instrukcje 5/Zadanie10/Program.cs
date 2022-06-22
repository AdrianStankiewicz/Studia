using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadanie10
{
    class Program
    {
        // Odwalają się tu cuda ale działa
        static void Countsort(int[] tabela)
        {
            int n = tabela.Length;

            // Tworzę tabelę wyniku
            int[] tabelaWyniku= new int[n];

            // Tworzę tabelę gdzie będą zliczane wszystkie wystąpienia każdej liczby
            int[] tabelaZliczania = new int[5*n];

            for (int i = 0; i < 5*n; ++i) tabelaZliczania[i] = 0;

            // tutaj zliczam ilość wystąpień każdej liczby
            for (int i = 0; i < n; ++i) ++tabelaZliczania[tabela[i]];

            // -1 żeby odpowiadało miejscom liczb w tabeli
            for (int i = 1; i <= ((5*n)-1); ++i) tabelaZliczania[i] += tabelaZliczania[i - 1];

            // Tu robię wynik
            // Kazali go robić na odwrót bo stabilniej podobno 
            for (int i = n - 1; i >= 0; i--)
            {
                tabelaWyniku[tabelaZliczania[tabela[i]] - 1] = tabela[i];
                --tabelaZliczania[tabela[i]];
            }

            // Wbijamy wynik w normalną dla uproszczenia sobie życia
            for (int i = 0; i < n; ++i) tabela[i] = tabelaWyniku[i];
        }
        static void Main(string[] args)
        {
            Random rnd = new Random();
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");
            int n = int.Parse(Console.ReadLine());
            int[] tabela = new int[n];

            for (int i = 0; i < n; i++)
            {
                tabela[i] = rnd.Next(0, (5 * n));
                Console.Write(tabela[i] + " ");
            }
            Console.ReadKey(true);

            Countsort(tabela);

            bool czy = true;
            for (int i = 0; i < n - 1; i++)
            {
                if (tabela[i] > tabela[i + 1])
                {
                    czy = false;
                }
            }

            Console.WriteLine();
            if (czy)
            {
                Console.WriteLine("Sprawdzona tabela uzyskała wynik pozytywny i wygląda w ten sposób: ");
                for (int i = 0; i < n; i++)
                {
                    Console.Write(tabela[i] + " ");
                }
            }
            else
            {
                Console.WriteLine("No coś tu ewidentnie nie poszło");
            }
            Console.ReadKey(true);
        }
    }
}
