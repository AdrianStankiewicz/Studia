using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BibliotekaCeSzarp
{
    class Książka
    {
        private string tytuł;
        private string autor;
        private bool czyWypożyczona;

        public Książka(string tytuł, string autor, bool czyWypożyczona)
        {
            this.tytuł = tytuł;
            this.autor = autor;
            this.czyWypożyczona = czyWypożyczona;
        }
        public string Tytuł
        {
            get { return tytuł; }
            set { tytuł = value; }
        }
        public string Autor
        {
            get { return autor; }
            set { autor = value; }
        }
        public bool CzyWypożyczona
        {
            get { return czyWypożyczona; }
            set { czyWypożyczona = value; }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ConsoleKeyInfo cki;
            Console.WriteLine("Witamy w systemie biblioteki. Aby zobaczyć możliwe opcje prosimy wpisać \"?\"");
            string title = "";   string author = "";   string stanWypożyczenia = ""; string tytułDoEdycji = ""; bool czyDobrze = false; ;
            List<Książka> ListaKsiążek = new List<Książka>();
            ListaKsiążek.Add(new Książka("Wiedzmin", "Andrzej Sapkowski", true));
            ListaKsiążek.Add(new Książka("Gra o Tron", "George R. R. Martin", true));
            ListaKsiążek.Add(new Książka("Uczta dla wron", "George R. R. Martin", true));
            ListaKsiążek.Add(new Książka("Igrzyska Śmierci", "Suzanne Collins", true));
            ListaKsiążek.Add(new Książka("Grobowiec Cesarza", "Steve Berry", false));
            ListaKsiążek.Add(new Książka("Lew, czarownica i stara szafa", "C. S. Lewis", true));
            ListaKsiążek.Add(new Książka("Wieża Jaskółki", "Andrzej Sapkowski", false));
            ListaKsiążek.Add(new Książka("Krew Elfów", "Andrzej Sapkowski", false));
            ListaKsiążek.Add(new Książka("Vertical", "Rafal Kosik", false));
            do
            {
                cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.Oem2)
                {
                    Console.Write("\n=============================================================\n");
                    Console.Write("Wszystkie opcje dostepne w programie: \n\n? - wyświetla menu\nn - Dodaje nową książkę\n* - Wypisuje wszystkie ksiazki w bibliotece\nw - Zmień stan wypożyczenia książki\ne - Pozwala na edycję książki\nDel - Usuwa rekord ksiazki\nx - Wychodzi z programu\n");
                }
                else if (cki.Key == ConsoleKey.N)
                {
                    Console.Write("\n=============================================================\nPodaj tytuł książki: "); title = Console.ReadLine();
                    Console.Write("Podaj autora książki: "); author = Console.ReadLine();
                    ListaKsiążek.Add(new Książka(title, author, false));
                    Console.Write("\nKsiążka została dodana!\n");
                    Console.Write("Aby zobaczyć możliwe opcje prosimy wpisać \"?\"\n");
                }
                else if (cki.Key == ConsoleKey.Multiply || (cki.Key == ConsoleKey.D8 && (cki.Modifiers & ConsoleModifiers.Shift) != 0))
                {
                    Console.Write("\n=============================================================\n");
                    Console.Write("Wszystkie ksiazki w bibliotece:\n\n");
                    foreach (var Książka in ListaKsiążek)
                    {
                        if (Książka.CzyWypożyczona) stanWypożyczenia = "wypożyczona";
                        else stanWypożyczenia = "dostępna";

                        Console.WriteLine("\"{0}\", {1}, {2}", Książka.Tytuł, Książka.Autor, stanWypożyczenia);
                    }
                }
                else if (cki.Key == ConsoleKey.E)
                {
                    Console.Write("\n=============================================================\n");
                    Console.WriteLine("Podaj tytuł książki której rekord chcesz edytować: "); tytułDoEdycji = Console.ReadLine();
                    foreach (var Książka in ListaKsiążek)
                    {
                        if (Książka.Tytuł == tytułDoEdycji)
                        {
                            Console.Write("\nPodaj poprawny tytuł książki: "); Książka.Tytuł = Console.ReadLine();
                            Console.Write("Podaj poprawnego autora książki: "); Książka.Autor = Console.ReadLine();
                            czyDobrze = true;
                        }
                    }
                    if (czyDobrze) Console.Write("Pozycja została poprawnie edytowana!\n");
                    else Console.Write("Wystąpił błąd z edycją\n");

                    tytułDoEdycji = ""; czyDobrze = false;
                }
                else if (cki.Key == ConsoleKey.W)
                {
                    Console.Write("\n=============================================================\n");
                    Console.WriteLine("Podaj tytuł książki której stan wypożyczenia chcesz zmienic: "); tytułDoEdycji = Console.ReadLine();
                    foreach (var Książka in ListaKsiążek)
                    {
                        if (Książka.Tytuł == tytułDoEdycji)
                        {
                            if (Książka.CzyWypożyczona) Książka.CzyWypożyczona = false;
                            else Książka.CzyWypożyczona = true;
                            czyDobrze = true;
                        }
                    }
                    if (czyDobrze) Console.Write("\nStan wypożyczenia został zmieniony!\n");
                    else Console.Write("\nWystąpił błąd ze zmianą wypożyczenia\n");

                    tytułDoEdycji = ""; czyDobrze = false;
                }
                else if (cki.Key == ConsoleKey.Delete)
                {
                    Console.Write("\n=============================================================\n");
                    Console.WriteLine("Podaj tytuł książki którą chcesz usunąć: "); tytułDoEdycji = Console.ReadLine();
                    ListaKsiążek.RemoveAll(Książka => Książka.Tytuł == tytułDoEdycji);
                    tytułDoEdycji = "";
                }
                else Console.Write("\nProgram nie obsługuje tego polecenia. Proszę spróbować ponownie.\n");
            } while (cki.Key != ConsoleKey.X);
        }
    }
}
