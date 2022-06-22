using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie7
{
    class Temperature
    {
        private double celsius;

        public Temperature()
        {
            Console.WriteLine("Utworzono konstruktor\n\n");
        }
        public double Celsius
        {
            get { return celsius; }
            set { celsius = value; }
        }
        //Wersja działająca lepiej i wyglądająca przystojniej
        public double Farenheit
        {
            get { return (celsius * 1.8) + 32; }
            set { celsius = ((value - 32) / 1.8); }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Temperature Temperatura1 = new Temperature { Celsius = 26.6 };

            Console.WriteLine("Temperatura w C wynosi: " + Temperatura1.Celsius);
            Console.WriteLine("Temperatura w F wynosi: " + Temperatura1.Farenheit);

            Temperatura1.Farenheit = 88.3;

            Console.WriteLine("\nTemperatura w F wynosi: " + Temperatura1.Farenheit);
            Console.WriteLine("Temperatura w C wynosi: " + Temperatura1.Celsius);
            Console.ReadKey(true);
        }
    }
}