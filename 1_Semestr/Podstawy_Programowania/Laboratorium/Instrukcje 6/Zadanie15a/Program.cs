using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie15a
{
    class Program
    {
        delegate int Del(int a, int b);
        public static int Suma(int a, int b)
        {
            return a + b;
        }
        // Tworzę delegata.
        public static int DelegateMethod(int a, int b)
        {
            int wynik = Suma(a,b);
            return wynik;
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj pierwsza liczbe: ");
            int a = int.Parse(Console.ReadLine());
            Console.Write("Podaj drugą liczbę: ");
            int b = int.Parse(Console.ReadLine());
            
            // Tutaj tworzym delegata
            Del handler = DelegateMethod;

            // Wywołujemy delegata
            Console.WriteLine("Wynik to: " + handler(a,b));
            Console.ReadKey();
        }
    }
}
