using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stankiewicz3
{
    class Program
    {
        public static Int32 i = 0, j = 0;
        //public static Int32 gora=0, dol=0;
        static void Main(string[] args)
        {
            Random rnd = new Random();

            // Ten-dimensional array.
            int[,] array10D = new int[10, 10];

            for(i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                    Int32 wylosowana = rnd.Next(0, 999);
                    array10D[i, j] = wylosowana;
                    
                    if(array10D[i, j] >= 100) {
                        Console.Write(array10D[i, j] + "  ");
                    }
                    else if (array10D[i, j] >= 10) {
                        Console.Write(array10D[i, j] + "   ");
                    }
                    else {
                        Console.Write(array10D[i, j] + "    ");
                    }
                }
                Console.Write(Environment.NewLine);
            }

            /*
            Console.WriteLine("Podaj dolny zakres: ");
            dol = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj górny zakres: ");
            gora = Int32.Parse(Console.ReadLine());
            Console.Write("Liczby pierwsze w tym przedziale to: ");

            bool czy = true;
            for(Int32 i=dol; i<=gora; i++) {
                for(Int32 j=2;j<(i/2);j++) {
                    if(i%j==0) {
                        czy = false;
                        break;
                    }
                }
                if (czy) {
                    Console.Write(i + " ");
                }
                czy = true;
            }
            */

            Console.ReadKey(true);
        }
    }
}
