using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie9
{
    class Program
    {
        class Temperature
        {
            private double celsius;
            
            public Temperature(double temp)
            {
                this.celsius = temp;
            }
            public double Celsius
            {
                get { return celsius; }
                set { celsius = value; }
            }
        }
        static void Main(string[] args)
        {
            ConsoleKeyInfo cki;
            List<Temperature> listaMeteo = new List<Temperature>();
            double temp;

            Console.WriteLine("Aby dodać nową temperaturę proszę wprowadzić \"N\", a aby zakończyć program \"Enter\": ");
            while(true)
            {
                Console.Write("\nPodaj guzik: ");
                cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.N)
                {
                    Console.WriteLine("\n\nProszę podać nową temperature: ");
                    temp = double.Parse(Console.ReadLine());
                    listaMeteo.Add(new Temperature(temp));
                }
                else if (cki.Key == ConsoleKey.Multiply)
                {
                    Console.Write("\n=============================================================\n");
                    Console.Write("Wszystkie temperatury w histori programu:\n\n");
                    foreach (var Temperature in listaMeteo)
                    {
                        Console.WriteLine("Temperatura: {0}", Temperature.Celsius);
                    }
                }
                else if (cki.Key == ConsoleKey.Enter) break;
            }
            Console.ReadKey(true);
        }
    }
}
