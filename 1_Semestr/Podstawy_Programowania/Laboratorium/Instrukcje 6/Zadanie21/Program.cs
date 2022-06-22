using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie21
{
    class Tools
    {
        public static double Calka(double a, double b)
        {
            double h, x = 0;
            double n = 100000;
            h = (b - a) / n;

            for (int i = 1; i <= n; i++)
            {
                x += Math.Pow(a + i * h, 2);
            }
            x *= h;

            return x;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("o-------------------------o");
            Console.WriteLine("Całka funkcji kwadratowej");
            Console.WriteLine("o-------------------------o");
            Console.WriteLine("podaj początek przedziału");
            double a = double.Parse(Console.ReadLine());
            Console.WriteLine("podaj koniec przedziału");
            double b = double.Parse(Console.ReadLine());
            Console.WriteLine("o-------------------------o");
            Console.WriteLine("Całka wynosi {0}", Tools.Calka(a, b));
            Console.ReadKey(true);
        }
    }
}
