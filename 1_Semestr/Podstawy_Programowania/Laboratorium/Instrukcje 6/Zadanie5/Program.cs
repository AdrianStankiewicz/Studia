using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie5Funkcje
{
    public static class Tools
    {
        public static double Dodaj(this double a, double b) { return a + b; }
        public static double Odejmij(this double a, double b) { return a - b; }
        public static double Pomnoz(this double a, double b) { return a * b; }
        public static double Podziel(this double a, double b) { return a / b; }
    }
}

namespace Zadanie5
{
    using Zadanie5Funkcje;
    class Program
    {
        static double a, b, c, delta, deltaSqrt, xJeden, xDwa;
        public static double Dodaj(double a, double b) { return a + b; }
        public static double Odejmij(double a, double b) { return a - b; }
        public static double Pomnoz(double a, double b) { return a * b; }
        public static double Podziel(double a, double b) { return a / b; }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj wartość argumentu a równania:");
            a = double.Parse(Console.ReadLine());

            Console.WriteLine("Podaj wartość argumentu b równania");
            b = double.Parse(Console.ReadLine());

            Console.WriteLine("Podaj wartość argumentu c równania");
            c = double.Parse(Console.ReadLine());

            delta = b.Pomnoz(b).Odejmij(a.Pomnoz(4).Pomnoz(c));
            deltaSqrt = Math.Sqrt(delta);

            //Wypisanie delty
            Console.WriteLine(Environment.NewLine + "Delta wynosi: " + delta + "." + Environment.NewLine);

            if (delta >= 0)
            {
                xJeden = (-b).Odejmij(deltaSqrt).Podziel(a.Pomnoz(2));
                xDwa = (-b).Dodaj(deltaSqrt).Podziel(a.Pomnoz(2));

                //Wypisanie x1 i x2
                Console.WriteLine("x\x2081 wynosi: " + xJeden + ", " + "x₂ wynosi: " + xDwa + "." + Environment.NewLine);
                Console.ReadKey(true);
            }
            else
            {
                Console.WriteLine("Że li pa pą, że tu nie tę x1 i x2?");
                Console.ReadKey(true);
            }
        }
    }
}