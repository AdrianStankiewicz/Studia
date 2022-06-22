using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie16
{
    class Program
    {
        delegate int Del(int a, int b);
        static void Main(string[] args)
        {
            Console.Write("Podaj pierwsza liczbe: ");
            int LiczbaA = int.Parse(Console.ReadLine());
            Console.Write("Podaj drugą liczbę: ");
            int LiczbaB = int.Parse(Console.ReadLine());

            // Tutaj tworzym delegata
            Del suma = (x, y) => { return x + y; };
            Del iloczyn = (x, y) => { return x * y; };

            // Wywołujemy delegata
            Console.WriteLine("Suma to: " + suma(LiczbaA, LiczbaB) + " a iloczyn to: " + iloczyn(LiczbaA, LiczbaB));
            Console.ReadKey();
        }
    }
}
