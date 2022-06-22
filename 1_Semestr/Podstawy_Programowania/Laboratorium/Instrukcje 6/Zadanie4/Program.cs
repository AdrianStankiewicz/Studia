using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie4
{
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

            delta = Odejmij(Math.Pow(b, 2),(Pomnoz(Pomnoz(4,a),c)));
            deltaSqrt = Math.Sqrt(delta);

            //Wypisanie delty
            Console.WriteLine(Environment.NewLine + "Delta wynosi: " + delta + "." + Environment.NewLine);

            if (delta >= 0)
            {
                xJeden = Podziel(Odejmij((-b),deltaSqrt),Pomnoz(2,a));
                xDwa = Podziel(Dodaj((-b),deltaSqrt),Pomnoz(2,a));

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