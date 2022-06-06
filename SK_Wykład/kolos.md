## Opracowanie do kolosa z Sieci. Kolos to zestaw pytań zamkniętych, wszędzie będzie tylko jedna dobra odpowiedź
___

# Wykład 1:
###### ===================================================
## Dobra sieć komputerowa jest:
- ## Niezawodna - brak awarii
- ## Skalowalna - łatwość w rozbudowie
- ## Bezpieczna - ochrona przed atakami
###### ===================================================
## Rozróżniamy rodzaje sieci:
- ## LAN (Local)
    - Małe / Jedno biuro
    - Ethernet
    - Jednoosobowe / Jednoorganizacyjne
- ## MAN (Metropolitan)
    - Miasto
    - Światłowód
    - Jednoorganizacyjne
- ## WAN (Wide)
    - Wielkie (kraj/kontynent)
    - Szeregowe / Satelitarne
    - Wieloorganizacyjne
###### ===================================================
## Urządzenia w sieci:
- ## końcowe
    - Serwer (komputer świadczący usługę)
    - Klient (wysyła zapytania do serwera)
- ## pośredniczące
    - Router (kieruje ruchem sieciowym między sieciami)
    - Switch (przełącza ruch sieciowy w sieci lokalnej)
    - Koncentrator (przekazuje odebrany ruch sieciowy na wszystkie porty)
    - Modem (łączy sieć abonenta z siecią operatora)
###### ===================================================
## Media transmisyjne:
- ## Przewodowe
    - miedziane
    - szklane
- ## Bezprzewodowe
    - fale radiowe
    - podczerwień
###### ===================================================
## Topologia to sposób łączenia się ze sobą urządzeń sieciowych. Znane topologie:
- ## Gwiazdy
    - Elastyczna, skalowanla, odporna
    - Droga, awaryjna, brak rozwoju hostow
- ## Magistrali
    - Tania, nieawaryjna
    - kolizyjna, niebezpieczna, 
- ## Pierścienia
    - Tania
    - Awaryjna, jednokierunkowa
- ## Siatki
    - Brak kolizji, szybka, nieawaryjna
    - Droga
___
# Wykład 2:
###### ===================================================
## Warstwy OSI:
- ## Aplikacji
    - Umożliwia użytkownikom wprowadzanie danych
    - HTTP, POP3, SSH, FTP
- ## Prezentacji
    - Spójny format danych do niższych warstw
    - JPG, GIF, MPEG
- ## Sesji
    - Synchronizacja danych
    - PPTP
- ## Transportowa
    - Łączy konkretne urządzenia
    - TCP, UDP
- ## Sieci
    - Łączność pomiędzy różnymi sieciami
    - IP, ICMP
- ## Łącza danych
    - Organizacja logiczna bitów (np. w ramki)
    - Ethernet, Token Ring
- ## Fizyczna
    - Organizacja przesyłu bitów przez media
    - WiFi, Ethernet
###### ===================================================
## Warstwy TCP:
- ## Aplikacji
- ## Transportowa
- ## Internetu
- ## Dostępu do Sieci
###### ===================================================
## Enkapsulacja
### Polega na wysyłaniu danych w dół modelu OSI (opakowaniu ich w kolejne nagłówki)
## Deenkapsulacja
### Rozpakowanie nagłówka w górę modelu OSI
___
# Wykład 3
###### ===================================================
## Skrętka
- ## Sygnały są przesyłane na zasadzie różnic potencjałów między żyłami.
- ## Końcówka to 8P8C.
- ## Tania, łatwa
- ## Zakłócalna, Ograniczona długość
## Światłowód
- ## Sygnały przesyłane są w postaci ipulsów świetlnych
- ## Zasada działania światłowodu opiera się na zjawiskucałkowitegowewnętrznego odbicia
- ## Promień świetlny załamuje się nagranicy rdzenia i płaszcza
## Koncentryk
- ## składa się z dwóch współosiowychprzewodów (oplotu i rdzenia) oddzielonych dielektrykiem
- ## Sygnały przesyłane są w postaci różnicy potencjałów pomiędzyoplotem a rdzeniem.
___
# Wykład 4
###### ===================================================
## Ethernet
- ## Maksymalna ramka 1500 bajtów
- ## Budowa
    - Preambuła (synchronizacja)
    - adres docelowy
    - adres źródłowy
    - Typ
    - Dane
    - Suma kontrolna
###### ===================================================
## Adres MAC
- ## Jednoznacznie identyfikujący
- ## Zapisany w pamięci ROM
- ## 48 bitów
    - pierwsza połowa producent
    - druga połowa sprzęt
###### ===================================================
## Protokół ARP
- ## Tłumaczy adresy IP na Mac i odwrotnie