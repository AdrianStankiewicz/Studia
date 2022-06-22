using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie11
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 0, b = 0;
            char wcisnietyGuzik;
            do
            {
                Console.Write("\nWcisnij guzik:");
                wcisnietyGuzik = char.Parse(Console.ReadLine());

                if (wcisnietyGuzik == '?') Console.Write("\nOpcje dostepne w programie: \n? - wyświetla menu\na - Pozwala wpisać pierwszą liczbę (bazowo 0)\nb - Pozwala wpisać drugą liczbę (bazowo 0)\n+ - Liczy sumę obu liczb\n* - Liczy iloczyn obu liczb\n");
                else if (wcisnietyGuzik == 'a') { Console.Write("\nPodaj liczbę a: "); a = int.Parse(Console.ReadLine()); }
                else if (wcisnietyGuzik == 'b') { Console.Write("\nPodaj liczbę b: "); b = int.Parse(Console.ReadLine()); }
                else if (wcisnietyGuzik == '+') Console.Write("\nWynik a+b to: " + (a+b) + "\n");
                else if (wcisnietyGuzik == '*') Console.Write("\nWynik a*b to: " + (a*b) + "\n");
                else Console.Write("\nLepiej przeczytaj instrukcję...\n");
            } while (wcisnietyGuzik != 'x');
        }
    }
}
