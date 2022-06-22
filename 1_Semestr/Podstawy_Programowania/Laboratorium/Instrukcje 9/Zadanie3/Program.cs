using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3
{
    class Program
    {
        class Temperature
        {
            private double celsius;

            public double Celsius
            {
                get { return celsius; }
                set { celsius = value; }
            }
        }
        static void Main(string[] args)
        {
            Temperature Temperatura1 = new Temperature();
            Temperature Temperatura2 = new Temperature();

            Temperatura1.Celsius = 26.6;
            Temperatura2.Celsius = 28.4;

            Console.WriteLine("Temperatura classy1 wynosi: " + Temperatura1.Celsius);
            Console.WriteLine("Temperatura classy2 wynosi: " + Temperatura2.Celsius);

            double chwilowa = Temperatura1.Celsius;
            Temperatura1.Celsius = Temperatura2.Celsius;
            Temperatura2.Celsius = chwilowa;

            Console.WriteLine("Temperatura classy1 po zmianie wynosi: " + Temperatura1.Celsius);
            Console.WriteLine("Temperatura classy2 po zmianie wynosi: " + Temperatura2.Celsius);
            Console.ReadKey(true);
        }
    }
}
