using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdrianStankiewicz1Projekt
{
    class Program
    {
        static double a, b, c, delta, deltaSqrt, p, q, xJeden, xDwa, xR, xI;

        static void Main(string[] args)
        {
            Console.WriteLine("Podaj wartość argumentu a równania:");
            a = double.Parse(Console.ReadLine());

            Console.WriteLine("Podaj wartość argumentu b równania");
            b = double.Parse(Console.ReadLine());

            Console.WriteLine("Podaj wartość argumentu c równania");
            c = double.Parse(Console.ReadLine());

            //Funkcja ogólna
            Console.Write(Environment.NewLine + "POSTAĆ OGÓLNA: f(x)=" + a + "x\xB2");
            if (b >= 0) Console.Write("+" + b + "x");
            else Console.Write(b + "x");

            if (c >= 0) Console.Write("+" + c + Environment.NewLine + Environment.NewLine);
            else Console.Write(c + Environment.NewLine + Environment.NewLine);

            delta = Math.Pow(b, 2) - (4 * a * c);
            deltaSqrt = Math.Sqrt(delta);
            p = ((-b) / (2 * a));
            q = ((-1) * (delta / (4 * a)));

            //Wypisanie delty
            Console.WriteLine(Environment.NewLine + "Delta wynosi: " + delta + "." + Environment.NewLine);

            if (delta >= 0)
            {
                xJeden = (((-b) - deltaSqrt) / (2 * a));
                xDwa = (((-b) + deltaSqrt) / (2 * a));

                //Wypisanie x1 i x2
                Console.WriteLine("x\x2081 wynosi: " + xJeden + ", " + "x₂ wynosi: " + xDwa + "." + Environment.NewLine);

                //Funkcja iloczynowa
                Console.Write("POSTAĆ ILOCZYNOWA: f(x)=" + a + "(x");
                if (xJeden >= 0) Console.Write("-" + xJeden + ")(x");
                else Console.Write("+" + Math.Abs(xJeden) + ")(x");

                if (xDwa >= 0) Console.Write("-" + xDwa + ")" + Environment.NewLine);
                else Console.Write("+" + Math.Abs(xDwa) + ")" + Environment.NewLine);

                //Funkcja kanoniczna
                Console.WriteLine();
                Console.Write("POSTAĆ KANONICZNA: f(x)=" + a + "(x");
                if (p >= 0) Console.Write("-" + p + ")\xB2");
                else Console.Write("+" + Math.Abs(p) + ")\xB2");

                if (q >= 0) Console.Write("+" + q + Environment.NewLine + Environment.NewLine);
                else Console.Write(q + Environment.NewLine + Environment.NewLine);

                //Wypisanie p & q
                Console.WriteLine("p wynosi: " + p + ".");
                Console.WriteLine("q wynosi: " + q + ".");
                Console.ReadKey(true);
            }
            else
            {
                xR = (-b / (2 * a));
                xI = (Math.Sqrt(Math.Abs(delta)) / (2 * a));

                xJeden = xR - xI;
                xDwa = xR + xI;
                Console.WriteLine("x1 = {0}+j*{1}", xR, xI);
                Console.WriteLine("x2 = {0}-j*{1}", xR, xI);
                Console.ReadKey(true);
            }
        }
    }
}
