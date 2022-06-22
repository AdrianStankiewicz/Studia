using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadania22
{
    public static class Tools
    {
        public delegate double Funkcja(double a);
        
        //liczenie calki dla wybranej funkcji
        public static double Calkafunkcja(double a, double b, Funkcja del)
        {
            double h, x = 0;
            double n = 100000000;
            h = (b - a) / n;

            for (int i = 1; i <= n; i++)
            {
                x += del(a + i * h);
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
            Console.WriteLine("Całka wybranej funkcji");
            Console.WriteLine("o-------------------------o");
            Console.WriteLine("podaj początek przedziału");
            double a = double.Parse(Console.ReadLine());
            Console.WriteLine("podaj koniec przedziału");
            double b = double.Parse(Console.ReadLine());
            Console.WriteLine("o-------------------------o");
            Tools.Funkcja del = (x) => x * x; // funkcjia której całkę liczymy
            Console.WriteLine("Całka wynosi {0}", Tools.Calkafunkcja(a, b, del));
            Console.ReadKey(true);
        }
    }
}
