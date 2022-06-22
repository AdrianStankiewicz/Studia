using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Stankiewicz3._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Random liczba = new Random();
            Int32[,] tab1 = new Int32[4, 6];
            Int32 suma = 0, maks = 0, minimum = 1000, iiMax = 0, iiMin = 1000, ijMax = 0, ijMin = 1000;
            for (Int32 i = 0; i <= 3; i++)
            {
                for (Int32 j = 0; j <= 5; j++)
                {
                    tab1[i, j] = liczba.Next(100, 999);
                    Console.Write(tab1[i, j] + " ");

                    suma += tab1[i, j];

                    if (tab1[i, j] > maks)
                    {
                        maks = tab1[i, j];
                        iiMax = i;
                        ijMax = j;
                    }

                    if (tab1[i, j] < minimum)
                    {
                        minimum = tab1[i, j];
                        iiMin = i;
                        ijMin = j;

                    }
                }
                Console.WriteLine();
            }

            Console.WriteLine();
            Console.WriteLine("Wynik wynosi: " + suma);
            Console.WriteLine("Największa liczba to: " + maks + ", a jej współrzędne to i=" + iiMax + " oraz j=" + ijMax + ".");
            Console.WriteLine("Najmniejsza liczba to: " + minimum + ", a jej współrzędne to i=" + iiMin + " oraz j=" + ijMin + ".");
            Console.ReadKey(true);
            Console.WriteLine();

            Int32[,] tab2 = new Int32[6, 4];
            Int32 x = 3, y = 0;
            for (Int32 i = 0; i <= 5; i++)
            {
                x = 3;
                for (Int32 j = 0; j <= 3; j++)
                {
                    tab2[i, j] = tab1[x, y];
                    Console.Write(tab2[i, j] + " ");
                    x--;
                }
                y++;
                Console.WriteLine();
            }
            Console.ReadKey(true);
        }
    }
}
