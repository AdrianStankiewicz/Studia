using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Lifetime;
using System.Text;
using System.Threading.Tasks;

namespace Instrukcje_4
{
    class Program
    {
        public static bool czy(int liczba)
        {
            if (liczba<= 1) return false;
            if (liczba == 2) return true;
            if (liczba % 2 == 0) return false;

            //var boundary = liczba;
            //var boundary = liczba/2;
            var boundary = Math.Floor(Math.Sqrt(liczba));

            for (int i = 3; i <= boundary; i += 2) {
                if (liczba % i == 0) {
                    return false;
                }
            }
            return true;
        }
        static void Main(string[] args)
        {
            /*
            //ZADANIE 1
            Int32 a=0, b=0, r = 0;
            Console.WriteLine("Podaj liczbe a");
            a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj liczbe b");
            b = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Wykonać euklidesa resztą z dzielenia(0) czy odejmowaniem(1)?");
            Int32 czy = Int32.Parse(Console.ReadLine());

            switch (czy)
            {
                case 0:
                    {
                        while (a != b)
                        {
                            if (a > b)
                            {
                                a -= b;
                            }
                            else if (a < b)
                            {
                                b -= a;
                            }
                        }
                        Console.WriteLine("NWD to: " + a);
                        Console.ReadKey(true);
                    }
                    break;
                case 1:
                    {
                        while (b != 0)
                        {
                            r = a % b;
                            a = b;
                            b = r;
                        }
                        Console.WriteLine("NWD = " + a);
                        Console.ReadKey(true);
                    }
                    break;
                default:
                    {
                        break;
                    }
            }
            */

            // ZADANIE 2
            /*
            Int32 a = 0, b = 0;
            Console.WriteLine("Podaj liczbe a");
            a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj liczbe b");
            b = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Wykonać euklidesa resztą z dzielenia(0) czy odejmowaniem(1)?");
            Int32 czy = Int32.Parse(Console.ReadLine());
            Int32 ile = 0;
            switch (czy)
            {
                case 0:
                    {
                        while (a != b)
                        {
                            if (a > b)
                            {
                                a -= b;
                            }
                            else if (a < b)
                            {
                                b -= a;
                            }
                            ile++;
                        }
                        Console.WriteLine("NWD to: " + a + " i zajelo to " + ile + " obrotów.");
                        Console.ReadKey(true);
                    }
                    break;
                case 1:
                    {
                        Int32 r = 0;
                        while (b != 0)
                        {
                            r = a % b;
                            a = b;
                            b = r;
                            ile++;
                        }
                        Console.WriteLine("NWD to: " + a + " i zajelo to " + ile + " obrotów.");
                        Console.ReadKey(true);
                    }
                    break;
                default:
                    {
                        break;
                    }
            }
            // Wniosek: Lepsze jest NWD które generuje mniej obrotów.
            */

            // ZADANIE 5
            /*
            Console.WriteLine("Który element ciągu Fibonacciego chcesz poznać ?");
            Int32 n = Int32.Parse(Console.ReadLine());
            Int32 fa=0, fb=0, fi=0;
            if (n == 0) Console.Write("Fibonacci = 0");
            else if (n == 1) Console.Write("Fibonacci = 1");
            else
            {
                fa = 0;
                fb = 1;

                for (Int32 i = 2; i <= n; i++)
                {
                    fi = fa + fb;
                    fa = fb;
                    fb = fi;
                }
                Console.WriteLine("Fibonacci = " + fi);
                Console.ReadKey(true);
            }
            */

            /*
             // ZADANIE 6
             Console.WriteLine("Ile elementów ciągu Fibonacciego chcesz poznać ?(poniżej zakresu longa)");
             long n = long.Parse(Console.ReadLine());
             long[] tablicaFibonaGucciego = new long[n];
             if (n == 0) {
                 Console.Write("Fibonacci = 0");
             }
             else if (n == 1) Console.Write("Fibonacci = 0 1");
             else
             {
                 tablicaFibonaGucciego[0] = 0;
                 tablicaFibonaGucciego[1] = 1;

                 for (Int32 i = 2; i < n; i++)
                 {
                     tablicaFibonaGucciego[i] = tablicaFibonaGucciego[i - 1] + tablicaFibonaGucciego[i - 2];
                 }
                 for (Int32 i = 0; i < n; i++)
                 {
                     Console.Write(tablicaFibonaGucciego[i] + " ");
                 }
                 Console.ReadKey(true);
             }
            */

            
            // ZADANIE 7
            Console.WriteLine("Podaj liczbe ktora chcesz sprawdzić: ");
            Int32 liczba = Int32.Parse(Console.ReadLine());
            bool czy = true;
            for (Int32 i = 2; i < liczba; i++)
            {
                if (liczba % i == 0)
                {
                    czy = false;
                    break;
                }
            }
            if (czy) Console.WriteLine("Liczba " + liczba + " jest bardzo pierwsza!");
            else Console.WriteLine("Liczba " + liczba + " nie jest pierwsza :c");
            Console.ReadKey(true);
            

            /*
            // ZADANIE 8
            Console.WriteLine("Podaj liczbe ktora chcesz sprawdzić: ");
            Int32 przedzial = Int32.Parse(Console.ReadLine());
            bool czy = true;
            for (Int32 i = 2; i < przedzial; i++)
            {
                czy = true;
                for (Int32 j = 2; j < i; j++)
                {
                    if (i % j == 0)
                    {
                        czy = false;
                        break;
                    }
                }
                if (czy) Console.Write(i + " ");
            }
            Console.ReadKey(true);
            */

            
            // ZADANIE 9
            Console.WriteLine("Podaj do jakiej liczby chcesz sprawdzić: ");
            Int32 przedzial = Int32.Parse(Console.ReadLine());
            Int32 ile = 0;
            for (Int32 i = 2; i < przedzial; i++)
            {
                if (czy(i)) {
                    Console.Write(i + " ");
                    ile++;
                }
            }
            Console.WriteLine("Liczb pierwszych jest w tym przedziale " + ile);
            Console.ReadKey(true);
        }
    }
}
