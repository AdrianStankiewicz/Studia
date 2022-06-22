using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie10
{
    class Program
    {
        static void Main(string[] args)
        {
            ConsoleKeyInfo cki;

            do
            {
                cki = Console.ReadKey();
                Console.Write(" --- Wcisnąłeś: ");
                if ((cki.Modifiers & ConsoleModifiers.Alt) != 0) Console.Write("ALT+"); //wykrywa ALT
                if ((cki.Modifiers & ConsoleModifiers.Shift) != 0) Console.Write("SHIFT+"); //wykrywa SHIFT
                if ((cki.Modifiers & ConsoleModifiers.Control) != 0) Console.Write("CTL+"); //wykrywa CTRL
                Console.WriteLine(cki.Key.ToString());
            } while (cki.Key != ConsoleKey.End);
        }
    }
}
