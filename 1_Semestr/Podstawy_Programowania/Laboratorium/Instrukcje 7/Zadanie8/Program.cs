using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace Zadanie8
{
    class Program
    {
        static void Main(string[] args)
        {
            CultureInfo ci = new CultureInfo("pl-PL");
            double wartosc = 1234.5678;            
            wartosc.ToString("C2", ci); //Wartość po C to precyzja
        }
    }
}
