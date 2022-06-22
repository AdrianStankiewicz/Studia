using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborki2Nadrabiam
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            Int32 x;
            Int32 y = 0;
            for (x = 1; x <= 20; x++) {
                y = 2 * x + 1;
                Console.Write("Dla x który wynosi " + x + " y ma wartość " + y + Environment.NewLine);
            }
            Console.ReadKey(true);
            */

            /*
            Int32 x = 1;
            Int32 y = 0;
            do
            {
                y = 2 * x + 1;
                Console.Write("Dla x = " + x + " y wynosi " + y + Environment.NewLine);
                x++;
            }
            while (x <= 20);
            Console.ReadKey(true);
            */

            /*
            Int32 x = 1;
            Int32 y = 0;
            while (x <= 20)
            {
                y = 2 * x + 1;
                Console.WriteLine("Dla x = " + x + " y wynosi " + y);
                x++;
            }
            Console.ReadKey(true);
            */

            /*
            Console.WriteLine("Zapodaj imie:");
            String imie = Console.ReadLine();
            Console.WriteLine("Zapodaj też ilość powtórzeń:");
            double ilosc = double.Parse(Console.ReadLine());

            Console.WriteLine("Jaka metoda? (0 - ciągły, 1 - krokowy)");
            Int32 metoda = Int32.Parse(Console.ReadLine());

            switch (metoda)
            {
                case 0:
                    {
                        Int32 i = 0;
                        while (i <= ilosc) {
                            Console.WriteLine(imie);
                            i++;
                        }
                    }
                    break;
                case 1:
                    {
                        Int32 i;
                        for (i = 0; i < ilosc; i++) {
                            Console.WriteLine(imie);
                        }
                    }
                    break;
                default:
                    {
                        Int32 i = 0;
                        while (i < ilosc) {
                            Console.WriteLine(imie);
                            i++;
                        }
                    }
                    break;
            }
            Console.ReadKey(true);
            */

            /*
            Random liczba = new Random();
            Int32 a, b;
            for (b = 0; b <= 20; b++)
            {
                a = liczba.Next(10, 20);
                Console.WriteLine(a);
            };
            Console.ReadKey();
            */

        }
    }
}
