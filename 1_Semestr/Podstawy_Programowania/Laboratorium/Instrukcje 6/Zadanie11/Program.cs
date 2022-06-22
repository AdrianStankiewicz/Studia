using System;

namespace Zadanie11Funkcje
{
    public static class Tools
    {
        public static ulong Silnia_Rekurencyjna(this ulong liczba)
        {
            if (liczba == 1) return 1;
            else return liczba * Silnia_Rekurencyjna(liczba - 1);
        }
    }
}
namespace Zadanie11
{
    using Zadanie11Funkcje;
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Podaj minimum przedziału: ");
            ulong minimum = ulong.Parse(Console.ReadLine());
            Console.Write("Podaj maximum przedziału: ");
            ulong maximum = ulong.Parse(Console.ReadLine());
            Console.WriteLine();
            for (ulong i = minimum; i <= maximum; i++)
            {
                Console.WriteLine("Dla " + i + " silnia wynosi:  " + i.Silnia_Rekurencyjna());
            }
            Console.ReadKey(true);
        }
    }
}
