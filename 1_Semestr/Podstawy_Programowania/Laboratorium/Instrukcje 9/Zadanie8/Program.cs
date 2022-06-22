using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie8
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
        public override string ToString()
        {
            return "Temperatura wynosi: " + celsius + " stopni C";
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Temperature Temperatura1 = new Temperature { Celsius = 26.6 };

            Console.WriteLine(Temperatura1.ToString());

            Temperatura1.Farenheit = 88.3;

            Console.ReadKey(true);
        }
    }
}