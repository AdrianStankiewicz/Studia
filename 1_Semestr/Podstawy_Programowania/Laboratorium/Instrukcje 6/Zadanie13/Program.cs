using System;
using System.Diagnostics;

namespace Zadanie13
{
    class Program
    {
        public static int Fib(int n1)
        {
            if (n1 <= 2)
                return 1;
            else
                return Fib(n1 - 1) + Fib(n1 - 2);
        }

        public static void Main()
        {
            Stopwatch stoper = new Stopwatch();
            for (int i = 1; i <= 50; i++)
            {
                stoper.Start();
                Console.Write("\n\nFibonacci na {0} miejscu ma wartosc {1}, ", i, Fib(i));
                stoper.Stop();
                Console.Write("A czas który mu to zajęło to {0}", stoper.Elapsed);
                stoper.Reset();
            }
            Console.ReadKey(true);
        }
    }
}
