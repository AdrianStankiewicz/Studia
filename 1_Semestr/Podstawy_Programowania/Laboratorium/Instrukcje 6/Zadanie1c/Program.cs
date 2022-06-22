using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1c
{
    class Program
    {
        class Tools
        {
            static double SinFmDeg(double Deg)
            {
                double Sin = Math.Sin(Math.PI * Deg / 180.0);
                return Sin;
            }
            static double CosFmDeg(int Deg)
            {
                double Cos = Math.Cos(Math.PI * Deg / 180.0);
                return Cos;
            }
            public static void PoliczSinCosC()
            {
                Console.WriteLine("Sinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Tools.SinFmDeg(i), 6));
                }
                Console.WriteLine("------------------------------------------------" + Environment.NewLine + "Cosinusy:");
                for (int i = 0; i <= 90; i += 10)
                {
                    Console.WriteLine("Dla " + i + " stopni: " + Math.Round(Tools.CosFmDeg(i), 6));
                }
            }
        }
        static void Main(string[] args)
        {
            Tools.PoliczSinCosC();
            Console.ReadKey(true);
        }
    }
}
