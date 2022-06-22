using System;

namespace Zadanie7
{
    class Program
    {
        static public Int32 WylosujLiczbe(Int32 minimum, Int32 maximum)
        {
            Random rnd = new Random();
            Int32 a = rnd.Next(minimum, maximum);
            return a;
        }
        static public Int32 SprawdzNWD(Int32 a, Int32 b)
        {
            if (b == 0)
            {
                return a;
            }
            else
            {
                return SprawdzNWD(b, a % b);
            }
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj minimum: ");
            Int32 minimum = Int32.Parse(Console.ReadLine());
            Console.Write("Podaj maximum: ");
            Int32 maximum = Int32.Parse(Console.ReadLine());

            // Poczatek programu
            Int32 liczba1 = WylosujLiczbe(minimum, maximum), liczba2 = WylosujLiczbe(minimum, maximum);
            Int32 NWD = SprawdzNWD(liczba1, liczba2);

            while (NWD != 1)
            {
                liczba1 = WylosujLiczbe(minimum, maximum);
                liczba2 = WylosujLiczbe(minimum, maximum);
                NWD = SprawdzNWD(liczba1, liczba2);
            }

            // Wyniki
            Console.WriteLine("Liczby " + liczba1 + " oraz " + liczba2 + " są stochastyczne.");
            Console.WriteLine("Ich NWD wynosi: " + NWD);
            Console.ReadKey(true);
        }
    }
}
