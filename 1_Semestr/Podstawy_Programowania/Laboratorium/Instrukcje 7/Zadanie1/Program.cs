using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj ciąg znaków:");
            string ciagZnakow = Console.ReadLine();

            for(int i = 0; i < ciagZnakow.Length; i++)
            {
                if(Char.IsDigit(ciagZnakow[i]))
                {
                    Console.Write(ciagZnakow[i] + " ");
                }
            }
            Console.ReadKey(true);
        }
    }
}
