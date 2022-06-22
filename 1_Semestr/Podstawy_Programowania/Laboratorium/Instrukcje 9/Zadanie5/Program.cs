using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie5
{
    class Program
    {
        class Temperature
        {
            private double celsius;

            //Jak zakomentarzujemy get i set to nei działa
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

            //Tutaj to nie działa i program samodzielnie przekształca to w set
            Console.Write("Podaj temperature 1 obiektu: ");
            try {
                Temperatura1.Celsius = int.Parse(Console.ReadLine()); 
                if (Temperatura1.Celsius < (-273)) { Console.WriteLine("Aut of rendż"); Console.ReadKey(true); Environment.Exit(0); }
            }
            catch { Console.WriteLine("Obiekt1 ma zła temp."); Environment.Exit(0); }

            Console.WriteLine("Podaj temperature 2 obiektu: ");
            try {
                Temperatura2.Celsius = int.Parse(Console.ReadLine()); 
                if (Temperatura2.Celsius < (-273)) { Console.WriteLine("Aut of rendż"); Console.ReadKey(true); Environment.Exit(0); } 
            }
            catch { Console.WriteLine("Obiekt2 ma zła temp."); Environment.Exit(0); }

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
