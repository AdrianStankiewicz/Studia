using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1dTools
{
    public static class Tools
    {
        public static double SinFmDeg(this int Deg)
        {
            double Sin = Math.Sin(Math.PI * Deg / 180.0);
            return Sin;
        }
        public static double CosFmDeg(this int Deg)
        {
            double Cos = Math.Cos(Math.PI * Deg / 180.0);
            return Cos;
        }
    }
}
namespace Zadanie1dRozwiazanie
{
    using Zadanie1dTools;
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Sinusy:");
            for (int i = 0; i <= 90; i += 10)
            {
                Console.WriteLine("Dla " + i + " stopni: " + Math.Round(i.SinFmDeg(), 6));
            }
            Console.WriteLine("------------------------------------------------" + Environment.NewLine + "Cosinusy:");
            for (int i = 0; i <= 90; i += 10)
            {
                Console.WriteLine("Dla " + i + " stopni: " + Math.Round(i.CosFmDeg(), 6));
            }
            Console.ReadKey(true);
        }
    }
}
