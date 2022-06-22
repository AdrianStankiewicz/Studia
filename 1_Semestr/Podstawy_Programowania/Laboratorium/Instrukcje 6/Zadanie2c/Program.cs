using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2cFunkcje
{
    public static class Tools
    {
        public static double PoliczLogarytmyC(this int podstawa, int liczba)
        {
            return Math.Log(podstawa, liczba);
        }
    }
}
namespace Zadanie2c
{
    using Zadanie2cFunkcje;
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Podaj podstawę dla jakiej chcesz liczyć: ");
            int podstawa = int.Parse(Console.ReadLine());

            for (int liczba = 16; liczba <= 256; liczba++)
            {
                Console.WriteLine(liczba.PoliczLogarytmyC(podstawa));
            }
            Console.ReadKey(true);
        }
    }
}
