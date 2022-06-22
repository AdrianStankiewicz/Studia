using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Zadania_5
{
    class Program
    {
        static void Main(string[] args)
        {
           
            //ZADANIE 1
            Random rnd = new Random();
            Console.WriteLine("Podaj ile chcesz liczb w tabeli:");
            int n = int.Parse(Console.ReadLine());
            int[] tabela = new int[n];

            for(int i=0;i<n;i++)
            {
                tabela[i] = rnd.Next(0,(5*n));
                Console.Write(tabela[i] + " ");
            }
            Console.ReadKey(true);
            
            //ZADANIE 2
            int chwilowa = 0;
            for(int i = 0; i <= n - 2; i++)
            {
                for (int j = 0; j <= n - 2; j++)
                {
                    if(tabela[j] > tabela[j + 1])
                    {
                        chwilowa = tabela[j];
                        tabela[j] = tabela[j + 1];
                        tabela[j + 1] = chwilowa;
                    }
                }
            }

            bool czy=true;
            for(int i = 0; i < n-1; i++)
            {
                if(tabela[i] > tabela[i + 1])
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
