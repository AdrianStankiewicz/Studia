using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Instrukcje_4_11
{
    class Program
    {
        public static bool czy(int liczba)
        {
            if (liczba <= 1) return false;
            if (liczba == 2) return true;
            if (liczba % 2 == 0) return false;

            var boundary = Math.Floor(Math.Sqrt(liczba));

            for (int i = 3; i <= boundary; i += 2)
            {
                if (liczba % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj minimum ktora chcesz sprawdzić: ");
            Int32 minimum = Int32.Parse(Console.ReadLine());
            if (minimum < 2)
            {
                Console.Write("Nie psuj programu, wpisz 2 lub więcej!");
                Console.ReadKey(true);
                return;
            }
            Console.Write("Podaj ile liczb chcesz znaleźć: ");
            Int32 ile = Int32.Parse(Console.ReadLine());
            Int32 znalezione = 0;
            Int32[] tablicaZnalezionych = new Int32[ile+10];
            while (znalezione < ile)
            {
                for (Int32 i = minimum; znalezione <= ile ; i++)
                {
                    if (czy(i))
                    {
                        tablicaZnalezionych[znalezione] = i;
                        znalezione++;
                    }
                }
            }

            for(int i = 0; i < znalezione-1; i++)
            {
                Console.Write(tablicaZnalezionych[i] + " ");
            }
            Console.ReadKey(true);
        }
    }
}
