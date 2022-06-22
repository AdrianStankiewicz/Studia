using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie9
{
    class Program
    {
        static ulong PoliczSilnie(ulong granica) {
            if (granica == 0) return 0;
            if (granica < 0) return 404;
            ulong silnia = 1;
            for(ulong i = 1; i <= granica; i++)
            {
                silnia *= i;
            }
            return silnia;
        }
        static void Main(string[] args)
        {
            Console.Write("Podaj minimum przedziału: ");
            ulong minimum = ulong.Parse(Console.ReadLine());
            Console.Write("Podaj maximum przedziału: ");
            ulong maximum = ulong.Parse(Console.ReadLine());
            Console.WriteLine();

            for(ulong i = minimum; i <= maximum; i++)
            {
                Console.WriteLine("Dla " + i + " wartość silni wynosi: " + PoliczSilnie(i));
            }
            Console.ReadKey(true);
        }
    }
}
