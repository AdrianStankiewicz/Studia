using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2b
{
    class Program
    {
        static void PoliczLogarytmyB(int podstawa)
        {
            Console.WriteLine("Liczba:       Wartość:");
            for (int liczba = 16; liczba <= 256; liczba++)
            {
                Console.WriteLine(liczba + "            " + Math.Log(podstawa, liczba));
            }
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj podstawę dla jakiej chcesz liczyć: ");
            int podstawa = int.Parse(Console.ReadLine());

            PoliczLogarytmyB(podstawa);
            Console.ReadKey(true);
        }
    }
}
