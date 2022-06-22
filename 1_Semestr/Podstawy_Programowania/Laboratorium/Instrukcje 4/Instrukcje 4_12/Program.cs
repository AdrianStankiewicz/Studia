using System;
using System.Diagnostics;

namespace Zadanie4_12
{
    class Program
    {
        public static bool czy(int liczba)
        {
            if (liczba <= 1) return false;
            if (liczba == 2) return true;
            if (liczba % 2 == 0) return false;
            
            //int boundary = liczba;
            int boundary = liczba/2;
            //var boundary = Math.Floor(Math.Sqrt(liczba)); //Jeżeli uzywasz tego to w linijce 18 między < a boundary wstaw =

            for (int i = 3; i < boundary; i += 2)
            {
                if (liczba % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj do jakiej liczby chcesz sprawdzić: ");
            Int32 przedzial = Int32.Parse(Console.ReadLine());
            Int32 ile = 0;

            //Inicjalizacja zegarka
            Stopwatch stopWatch = new Stopwatch();

            stopWatch.Start();
            for (Int32 i = 2; i < przedzial; i++)
            {
                if (czy(i))
                {
                    Console.Write(i + " ");
                    ile++;
                }
            }
            stopWatch.Stop();
            Console.WriteLine("Liczb pierwszych jest w tym przedziale " + ile);
            Console.WriteLine("Czas który upłynął: {0}", stopWatch.Elapsed);
            Console.ReadKey(true);
        }
    }
}