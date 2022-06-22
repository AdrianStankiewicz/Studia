using System;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie9
{
    class Program
    {
        static void Main(string[] args)
        {
            CultureInfo ci = new CultureInfo("en-US");
            DateTime biezacaData = DateTime.Now;
            Console.WriteLine(biezacaData);
            Console.ReadKey(true);
        }
    }
}
