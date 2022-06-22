using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace instrukcje_4_3
{
    class Program
    {
        // ZADANIE 3 i 4
        // notka: Częściowo stochastyczny jest szybszy ponieważ musi losować tylko jedną liczbę
        static public Int32 WylosujWieksza(Int32 minimum)
        {
            Random rnd = new Random();
            Int32 a = rnd.Next();
            while (a < minimum)
            {
                a = rnd.Next();
            }
            return a;
        }
        static public Int32 SprawdzNWD(Int32 a, Int32 b)
        {
            Int32 r = 0;
            while (b != 0)
            {
                r = a % b;
                a = b;
                b = r;
            }
            return a;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Podaj liczbe do obliczenia:");
            Int32 minimum = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Wykonać wersję częściowo suchoklatyczny(0) czy stoplastyczny(1)?");
            Int32 wersja = Int32.Parse(Console.ReadLine());

            //Inicjalizacja zegarka
            Stopwatch stopWatch = new Stopwatch();
            switch (wersja)
            {
                case 0:
                    {
                        // Liczenie czasu
                        stopWatch.Start();

                        // Poczatek programu
                        Int32 wieksza = WylosujWieksza(minimum);
                        Int32 NWD = SprawdzNWD(minimum, wieksza);

                        while(NWD != 1)
                        {
                            wieksza = WylosujWieksza(minimum);
                            NWD = SprawdzNWD(minimum, wieksza);
                        }

                        // Zatrzymanie liczenia czasu
                        stopWatch.Stop();

                        // Wyniki
                        Console.WriteLine("Liczba większa od " + minimum + " to " + wieksza);
                        Console.WriteLine("Ich NWD wynosi: " + NWD);
                        Console.WriteLine("Liczby " + minimum + " oraz " + wieksza + " są częściowo stochastyczne.");
                        Console.WriteLine("Czas który upłynął: {0}", stopWatch.Elapsed);
                        Console.ReadKey(true);
                    }
                    break;
                case 1:
                    {
                        // Liczenie czasu
                        stopWatch.Start();

                        // Poczatek programu
                        Int32 wieksza1 = WylosujWieksza(minimum), wieksza2 = WylosujWieksza(minimum);
                        Int32 NWD = SprawdzNWD(wieksza1, wieksza2);

                        while (NWD != 1)
                        {
                            //Tutaj można optymalizować np. losować tylko 1 za każdym razem
                            wieksza1 = WylosujWieksza(minimum);
                            wieksza2 = WylosujWieksza(minimum);
                            NWD = SprawdzNWD(wieksza1, wieksza2);
                        }

                        // Zatrzymanie liczenia czasu
                        stopWatch.Stop();

                        // Wyniki
                        Console.WriteLine("Liczby większe od " + minimum + " to: " + wieksza1 + " oraz " + wieksza2 + ".");
                        Console.WriteLine("Ich NWD wynosi: " + NWD);
                        Console.WriteLine("Liczby " + wieksza1 + " oraz " + wieksza2 + " są stochastyczne.");
                        Console.WriteLine("Czas który upłynął: {0}", stopWatch.Elapsed);

                        Console.ReadKey(true);
                     }
                     break;
                default:
                    {
                        break;
                    }
            }
        }
    }
}
