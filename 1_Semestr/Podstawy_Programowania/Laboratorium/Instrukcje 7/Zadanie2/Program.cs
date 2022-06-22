using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Podaj ciag znaków:");
            string ciagZnakow = Console.ReadLine();
            string liczba="";
            for(int i = 0; i < ciagZnakow.Length; i++)
            {
                if (Char.IsDigit(ciagZnakow[i]))
                {
                    liczba += ciagZnakow[i].ToString();
                }
                else if(Char.IsDigit(ciagZnakow[i-1]) && !Char.IsDigit(ciagZnakow[i]))
                {
                    Console.WriteLine(liczba);
                    liczba = "";
                }
                else
                {
                    Console.Write("");
                }
            }
            Console.ReadKey(true);
        }
    }
}
