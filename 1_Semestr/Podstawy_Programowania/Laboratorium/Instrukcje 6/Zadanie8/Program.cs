using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie8
{
    class Tools
    {
        //Znajduje wszystkie możliwe part liczb względnie pierwszych w zakresie podanym przez użytkownika
        public static void wszystkiepierwszewzakresie(int x, int y)
        {
            if (x == 1)
            {
                x++;
            }
            Random liczba = new Random();
            int u1 = x;
            int u2;
            if (x != y)
            {
                for (u2 = u1 + 1; u2 < y; u2++)
                {
                    if (Tools.Czynwdrówne1(u1, u2) == false)
                    {
                        //Console.WriteLine("Dla {0} i {1} NWD != 1", u1, u2);
                    }
                    else
                    {
                        Console.WriteLine("{0} i {1}", u1, u2);
                    }
                }
                Tools.wszystkiepierwszewzakresie(x + 1, y);
            }
        }
        //sprawdza czy najwyższym wspólnym dzielnikiem 2 liczb jest 1 
        public static bool Czynwdrówne1(int NWD, int NWD2)
        {
            while (NWD != NWD2)
            {
                if (NWD > NWD2)
                {
                    NWD = NWD - NWD2;
                }
                else
                {
                    NWD2 = NWD2 - NWD;
                }
            }
            if (NWD != 1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("o-----------------------------------------------------------o");
            Console.WriteLine("Podaj początek zakresu");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("o-----------------------------------------------------------o");
            Console.WriteLine("Podaj koniec zakresu");
            int b = int.Parse(Console.ReadLine());
            Console.WriteLine("o-----------------------------------------------------------o");
            Tools.wszystkiepierwszewzakresie(a, b);
            Console.ReadKey(true);
        }
    }
}
