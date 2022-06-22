using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie12
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 0, b = 0;
            ConsoleKeyInfo cki;
            do
            {
                Console.Write("\nWcisnij guzik:");
                cki = Console.ReadKey();

                if (cki.Key == ConsoleKey.Oem2) Console.Write("\nOpcje dostepne w programie: \n? - wyświetla menu\na - Pozwala wpisać pierwszą liczbę (bazowo 0)\nb - Pozwala wpisać drugą liczbę (bazowo 0)\n+ - Liczy sumę obu liczb\n* - Liczy iloczyn obu liczb\n");
                else if (cki.Key == ConsoleKey.A) { Console.Write("\nPodaj liczbę a: "); a = int.Parse(Console.ReadLine()); }
                else if (cki.Key == ConsoleKey.B) { Console.Write("\nPodaj liczbę b: "); b = int.Parse(Console.ReadLine()); }
                else if (cki.Key == ConsoleKey.Add) Console.Write("\nWynik a+b to: " + (a + b) + "\n");
                else if (cki.Key == ConsoleKey.Multiply) Console.Write("\nWynik a*b to: " + (a * b) + "\n");
                else Console.Write("\nLepiej przeczytaj instrukcję...\n");
            } while (cki.Key != ConsoleKey.X);
        }
    }
}
