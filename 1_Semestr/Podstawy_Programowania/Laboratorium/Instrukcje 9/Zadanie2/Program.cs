using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2
{
    class Program
    {
        class Temperature
        {
            public double Celsius;
        }
        static void Main(string[] args)
        {
            Temperature Temperatura1 = new Temperature();
            Temperature Temperatura2 = new Temperature();
            Temperatura1.Celsius = 26.6;
            Temperatura2.Celsius = Temperatura1.Celsius;

            Console.WriteLine("Temperatura classy2 wynosi: " + Temperatura2.Celsius);
            Console.ReadKey(true);
        }
    }
}
