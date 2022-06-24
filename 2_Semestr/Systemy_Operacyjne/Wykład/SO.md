___
# Zasób stały to
### 🟢 Zasób, który po zwolnieniu może być ponownie użyty  
### 🟢 Zasób sprzętowy komputera 
### 🔴 Zasób programowy środowiska operacyjnego  
### 🔴 Zasób wytwarzany przez jeden proces, a zużywany przez drugi  
___
# Zasada wzajemnego wykluczania
### 🔴 Okresla, że proces może pozostawiać w sekcji krytycznej przez skończony czas  
### 🟢 Określa, że w danej chwili czasu tylko jeden proces może pozostawać w sekcji krytycznej  
### 🔴 Narzuca sekwencję wykonywanych operacji  
### 🟢 Realizowana jest za pomocą sematorów
___
# Wskaż właściwości semafora binarnego S:
### 🔴 Operacja V(S) spowoduje zablokowanie procesu wykonującego te operacje, jeśli przyjmie ona wartość false
### 🔴 Jest to semafor ograniczony
### 🔴 Jest to semafor uogólniony
### 🟢 Może przyjmować wyłącznie wartości true oraz false
___
# Windows NT
### 🔴 Jest systemem nieprzenośnym i można go stosować tylko na platformie sprzętowej x86
### 🟢 Ma architeklturę warstwową opartą o mikrojądro
### 🟢 Jest systemem zgodnym ze specyfikacją POSIX
### 🔴 Może być stosowany wyłącznie w systemach jednoprocesorowych
___
# Warunki konieczne wystąpienia zakleszczenia
### 🟢 Wzajemne wykluczenie
### 🟢 Cykl w oczekiwaniu
### 🟢 Brak wywłaszczeń
### 🟢 Przetrzymywanie i oczekiwanie
### 🔴 Wzajemne zakluczenie
___
# W wyniku odebrania sygnału 3
### 🟢 Proces ulega zakończeniu
### 🔴 Proces ulega zatrzymaniu
### 🟢 Następuje wyjście z procesu ze zrzuceniem obrazu pamięci
### 🔴 Proces ulega "zabiciu"
___
# W skład systemu linux wchodzą
### 🟢 Jądro systemu
### 🟢 Aplikacje użytkowe
### 🔴 Narzędzia do zarządzania systemem
### 🟢 Biblioteki systemowe
___
# System plików NT
### 🔴 Oparty jest na tablicy FAT
### 🟢 Wykorzystuje listowy podział miejsca na dysku
### 🟢 Wykorzystuje Logiczne Numery Clusterów (LCN) do odwoływania się do plików
### 🟢 Umożliwia kompresję danych na dysku
___
# System plików FAT
### 🟢 Prowadzi do powstawania fragmentacji wewnętrznej
### 🔴 Wykorzystuje indeksowy przydział miejsca na dysku
### 🟢 Wykorzystuje listowy przydział miejsca na dysku
### 🔴 Prowadzi do powstania fragmentacji zewnętrznej
___
# System plików ext2fs
### 🔴 Wykorzystuje tablicę jednostek alokacji do adresowania bloków na dysku
### 🔴 Jest listowym systemem plików
### 🟢 Jest indeksowym systemem plików
### 🟢 Wykorzystuje i-węzły do adresowania bloków dyskowych
___
# System operacyjny Linux
### 🟢 Jest zgodny z SVR4 Unixa
### 🔴 Jest 32-bitowym systemem operacyjnym
### 🔴 Pracuje tylko na platformie sprzętowej x86
### 🟢 Jest zgodny z BSD Unixem
___
# Struktura katalogów NT
### 🔴 Jest płaska
### 🔴 Umożliwia realizację cykli tylko przez odwołania do plików
### 🟢 Ma budowę drzewa
### 🟢 Umożliwia realizację cykli przez odwołania do plików i katalogów
___
# Statyczna relokacja pamięci
### 🔴 Powoduje powstawanie fragmentacji wewnętrznej
### 🟢 Powoduje powstawanie fragmentacji zewnętrznej
### 🔴 Polega na przydzieleniu pliku wymiany o określonej wielkości
### 🔴 Wykorzystuje stronnicowanie
### 🟢 Polega na przydzieleniu strefy pamięci przed wykonaniem programu
### 🔴 Jest stosowana w systemach pamięci wirtualnej
___
# Słowo kluczowe order
### 🔴 Jest stosowane w pliku resolv.conf
### 🟢 Określa kolejność zadawania pytań serwerom DNS
### 🔴 Określa kolejność rozwiązywania nazw
### 🟢 Jest stosowane w pliku host.conf
___
# Restart procesu init można wykonać za pomocą
### 🟢 shutdown -r
### 🟢 init 6
### 🟢 reboot
### 🔴 inittab
___
# Redirector
### 🟢 Przejmuje odwołania zasobów i przekierowuje je do sieci lub systemu lokalnego
### 🟢 Jest jednym ze składników systemu operacyjnego klienta
### 🟢 Jest jednym ze składników systemu operacyjnego serwera
### 🔴 Jest zawsze realizowany jako niezależny procesor poleceń
___
# Programy służące do zarządzania modułami jądra to
### 🔴 vi
### 🔴 ldconfig / Idcondif
### 🟢 ifconfig
### 🟢 modprobe
___
# Program route
### 🟢 Służy do edycji tablicy routingu
### 🔴 Służy do konfiguracji serwerów DNS
### 🔴 Znajduje się w katalogu \etc
### 🔴 Jest wykonywany przy każdym starcie systemu
___
# Procesy współbieżne to
### 🔴 Procesy składające się z wątków
### 🟢 Procesy współdzielące zasoby
### 🟢 Procesy wykonujące się w tym samym czasie
### 🔴 To samo co procesy interakcyjne
___
# Procesy interakcyjne to
### 🟢 Procesy współdzielące zasoby sprzętowe komputera
### 🟢 Procesy działające na tym samym komputerze
### 🟢 Procesy współdzielące zasoby programowe komputera
### 🔴 Procesy działające w tym samym czasie
___
# Polecenie ping host
### 🟢 Pozwala ustalić status hosta zdalnego
### 🔴 Pozwala wyznaczyć trasę do hosta
### 🔴 Umożliwia tylko dokonanie testu sieci lokalnej
### 🟢 Nie umożliwia wyznaczenia liczby routerów do hosta
___
# Polecenie ifconfig
### 🔴 Służy wyłącznie do konfiguracji interface'ów ethernet
### 🔴 Służy do określenia tras routingu
### 🟢 Może być użyte do konfiguracji dowolnych interface'ów sieciowych
### 🟢 Służy do przypisania adresów IP interface'om sieciowym
___
# Polecenie chown user plik
### 🔴 Usunie plik "plik" jeśli jego właścicielem jest "user"
### 🔴 Przesunie "plik" do katalogu domowego użytkownika "user"
### 🟢 Ustali właściciela pliku "plik" na użytkownika "user"
### 🔴 Umożliwi wykonywanie pliku "plik" przez użytkownika "user"
___
# Polecenie chmod 753 file ustawi
### 🟢 Prawo modyfikacji pliku "file" dla wszystkich użytkowników
### 🔴 Prawo wykonywania pliku "file" tylko dla członków grupy
### 🟢 Prawa odczytu przez właściciela pliku "file"
### 🔴 Zablokuje dostęp do pliku wszystkim użytkownikom
__
# Polecenie chmod 751 plik
### 🟢 Ustawi atrybut wykonywalności dla wszystkich użytkowników
### 🔴 Ustawi atrybut odczytu dla wszystkich użytkowników
### 🔴 Umożliwi edycję pliku wszystkim użytkownikom
### 🔴 Zablokuje dostęp do pliku użytkownikom nie będącym członkami grupy do której należy właściciel
___
# Polecenie apropos
### 🔴 Wyświetli listę stron podręcznika systemowego zawierajacych wskazaną frazę
### 🔴 Wyświetli wskazaną stronę podręcznika systemowego
### 🟢 Wyświetli listę stron podręcznika systemowego zawierających wskazane słowo kluczowe
### 🔴 Wyświetli informację o zalogowanych użytkownikach
___
# Plik resolv.conf
### 🔴 Znajduje się w katalogu \usr\bin
### 🔴 Służy do konfiguracji interface'u eth
### 🔴 Zawiera listę hostów i ich numerów IP
### 🟢 Określa wykorzystywane serwery DNS i ścieżki poszukiwań
___
# Plik hosts
### 🟢 Zawiera listę hostów i ich numerów IP
### 🔴 Służy do konfigurtacji interface'u eth
### 🔴 Znajduje się w katalogu \usr\bin
### 🟢 Pozwala na wyznaczanie nazw komputerów w sieci
___
# Planowanie wywłaszczeniowe uwzględnia przejścia procesu
### 🟢 Od stanu czekania do gotowości
### 🟢 Od stanu aktywności do gotowości
### 🔴 Od stanu aktywności do czekania
### 🔴 Gdy proces kończy działanie
___
# Pamięć wirtualna
### 🔴 Jest realizowana na zewnętrznym nośniku pamięci
### 🟢 Może byćź realizowana na zewnętrznym nośniku pamięci
### 🔴 Wykorzystuje mechanizm rejestrów granicznych do ochrony
### 🔴 To to samo, co pamięć stronnicowana
### 🟢 Wykorzystuje metodę stronnicowania na żądanie
___
# Pamięć wirtualna w Linuxie
### 🟢 Może być realizowana jako plik w systemie plików UMSDOS
### 🔴 Jest realizowana w pamięci fizycznej komputera
### 🟢 Może być realizowana jako plik w systemie plików ext2fs
### 🔴 Jest realizowana jako osobna partycja na nośniku fizycznym
### 🟢 Może być realizowana jako osobna partycja na nośniku fizycznym
___
# Modyły jądra
### 🟢 Realizują obsługę podstawowych funkcji jądra
### 🟢 Są ładowane do pamięci tylko wtedy, gdy są niezbędne do wykonania okreslonych funkcji
### 🔴 Stanowią tylko sterowniki urządzeń fizycznych komputera
### 🟢 Mogą być stosowane z innymi wersjami jądra
___
# man 1 cat
### 🔴 Zwróci błąd
### 🟢 Wyświetli pierwszą stronę opisu polecenia cat
### 🟢 Wyświetli opis cat z pierwszej sekcji podręcznika systemowego
### 🔴 Wyświetli opis polecenia cat na pierwszym terminalu
___
# ls -R \home 2>\dev\null > homes &
### 🔴 Zostanie wykonane jako pierwszoplanowe
### 🔴 Wynik jego działania zostanie umieszczony w pliku /dev/null
### 🟢 Utworzy w katalogu użytkownika plik homes niezawierający błędów wykonania
### 🟢 Zostanie wykonany w tle
___
# Init to
### 🟢 Pierwszy proces uruchamiany w systemie UNIX
### 🟢 Proces, który można wykorzystać do zatrzymania systemu UNIX
### 🔴 Proces służący do ładowania jądra
### 🟢 Proces konfigurowany za pomocą pliku inittab
___
# Listowy przydział miejsca na dysku
### 🟢 Wykorzystuje listę dyskowych jednostek alokacji
### 🔴 Wykorzystuje listę bloków indeksowych pliku
### 🟢 Prowadzi do powstawania fragmentacji wewnętrznej
### 🔴 Prowadzi do powstawania fragmentacji zewnętrznej
___
# Jądro linuxa
### 🔴 Jest jednym plikiem wykonywalnym
### 🟢 Pracuje w trybie umożliwiającym dostęp do wszystkich zasobów komputera
### 🟢 Ma strukturę modularną
### 🔴 Jest ostatnim plikiem ładowanym do pamięci wtrakcie uruchamiania komputera
___
# Jaki wpływ na szybkość działania systemu zarządzania bazą danych ma stosowanie indeksów
### 🟢 Spowalnia wprowadzanie danych
### 🔴 Przyspiesza wprowadzanie danych
### 🟢 Przyspiesza wybieranie danych
### 🔴 Spowalnia wybieranie danych
___
# HAL w WinNT to
### 🟢 Biblioteka, zawierająca kod assemblerowy, zależny od procesora
### 🔴 Biblioteka dołączana dynamicznie do każdej aplikacji
### 🟢 Moduł systemu pracujący w trybie chronionym
### 🔴 Moduł systemu pracujący w systemie użytkownika
___
# Polecenie: echo `echo $PATH`
### 🔴 Wypisze napis $PATH
### 🔴 Wypisze napis "echo $PATH"
### 🔴 Wywoła błąd
### 🟢 Wypisze ścieżkę systemową
___
# Dyskowy system plików
### 🔴 Umożliwia tylko dostęp swobodny (odczyt/zapis dowolnej liczby rekordów)
### 🟢 Umożliwia aktualizację zawartości pliku bez zmiany jego lokalizacji
### 🔴 Umożliwia tylko dostęp sekwencyjny (rekord po rekordzie)
### 🟢 Nie jest stosowany na nośnikach wymiennych
___
# Drzewiasta struktura katalogów
### 🟢 Nie dopuszcza istnienia cykli w drzewach katalogów
### 🟢 Dopuszcza istnienie plików i dowiązań symbolicznych
### 🔴 Nie dopuszcza istnienia plików i podkatalogów w katalogach
### 🔴 Dopuszcza istnienie tylko katalogów "domowych" dla poszczególnych użytkowników
___
# Domena NT to
### 🟢 Sieć z conajmniej jednym komputerem pracyjącym pod kontrolą WinNT
### 🔴 Komputer na którym pracuje system WindowsNT
### 🟢 Sieć w której uwierzytelnianie następuje na dedykowanym serwerze NT
### 🔴 Sieć w której uwierszytelnianie następuje na wszystkich serwerach
___
# Do zmiany hasła użytkownika w UNIX stosowane jest polecenie
### 🔴 su
### 🔴 useradd
### 🔴 userdel
### 🟢 passwd
___
# Do zarządzania procesami w UNIXie słuzą polecenia
### 🟢 ps
### 🔴 ntop
### 🟢 jobs
### 🔴 grep
___
# Do atrybutów plików zalicza się
### 🟢 Nazwę pliku
### 🟢 Lokalizację na nośniku pamięci zewnętrznej
### 🟢 Właściciela pliku
### 🟢 Wielkość pliku
___
# Algorytm rotacyjny (R/R)
### 🟢 Jest wywłaszczeniową implementacją algorytmu FCFS
### 🔴 Jest niewywłaszczeniową implementacją algorytmu FCFS
### 🟢 Polega na przydziale procesora na określony czas
### 🔴 Polega na przydziale procesora do zakończenia procesu
___
# Algorytm FCFS
### 🟢 Wykorzystuje kolejkę FIFO do obsługi zadań
### 🔴 Polega na obsłudze zadań według oczekiwanego czasu ich wykonania
### 🟢 Polega na obsłudze zadań według kolejności ich zgłaszania
### 🔴 Jest algorytmem czasu rzeczywistego
___
# Algorytm FCFS polega na
### 🟢 Przydziale procesora pierwszemu zgłaszającemu się procesorowi
### 🔴 Przydziale procesora najkrótszemu procesowi
### 🔴 Jest algorytmem wywłaszczeniowym
### 🟢 Jest algorytmem niewywłaszczeniowym
___
# Aby znaleźć słowo kluczowe w podręczniku systemowym
### 🟢 Należy wykonać polecenie whatis słowokluczowe
### 🟢 Należy wykonaćpolecenie apropos słowokluczowe
### 🟢 Należy wykonać polecenie: man słowokluczowe
### 🔴 Należy wykonać polecenie: help słowokluczowe
___
# Aby znaleźć plik bootlog w katalogu /var należy wykonać:
### 🔴 cat /var | grep bootlog > /dev/null
### 🔴 chgrp /var/bootlog
### 🔴 dmesg | grep bootlog
### 🟢 |ls -R /var | grep bootlog
___
# Aby zmiany dokonane w pliku inittab zostały wykonane należy:
### 🔴 Zapisać plik
### 🔴 Wpisać komendę kill all
### 🟢 Zresetować komputer
### 🟢 Wpisać komendę reboot
___
# Aby zapisać edytowany plik i wyjść z vi należy
### 🟢 Wydać polecenie ZZ
### 🔴 Nacisnąć sekwencję klawiszy !q
### 🔴 Wydać polecenie zw
### 🔴 Nacisnąć sekwencję klawiszy !wq
___
# Aby zakończyć sesję w UNIXIE
### 🟢 Należy wykonać polecenie logout
### 🔴 Należy wykonać polecenie logoff
### 🔴 Należy wykonać polecenie logon
### 🔴 Należy wysłać do systemu znak końca pliku