using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3
{
    class Program
    {
        static double Suma(double a, double b) {
            return a + b;
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj pierwszą liczbę:");
            double a = double.Parse(Console.ReadLine());
            Console.Write("Podaj drugą liczbę:");
            double b = double.Parse(Console.ReadLine());

            //Podpunkt A
            Console.WriteLine("Wynik A: " + Suma((2*a),(3*b)));

            //Podpunkt B
            Console.WriteLine("Wynik B: " + Suma((a*b), 7));

            //Podpunkt C
            Console.WriteLine("Wynik C: " + Suma(Math.Sqrt(a), Math.Pow(b,2)));

            //Podpunkt D (działa "wystarczająco dobrze")
            Console.WriteLine("Wynik A: " + (Suma(Suma(a,b),1)));
            Console.ReadKey(true);
        }
    }
}
