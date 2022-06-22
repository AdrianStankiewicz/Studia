using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie10
{
    class Program
    {
        public static long Silnia_Rekurencyjna(int liczba)
        {
            if (liczba == 1) return 1;
            else return liczba * Silnia_Rekurencyjna(liczba - 1);
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj minimum przedziału: ");
            int minimum = int.Parse(Console.ReadLine());
            Console.Write("Podaj maximum przedziału: ");
            int maximum = int.Parse(Console.ReadLine());
            Console.WriteLine();
            for (int i = minimum; i <= maximum; i++)
            {
                Console.WriteLine("Dla " + i + " silnia wynosi:  " + Silnia_Rekurencyjna(i));
            }
            Console.ReadKey(true);
        }
    }
}
