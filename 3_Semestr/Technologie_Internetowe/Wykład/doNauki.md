# 1. Protokoły TCP i UDP
## Protokół TCP jest używany, kiedy ważne jest, aby wszystkie dane doratły do celu. Przed wysłaniem danych nawiązuje on połączenie (three-way handshake), które jest następnie utrzymywane przez cały okres transferu danych. Standardowym zastosowaniem TCP są np. strony internetowe.
- ## TCP
    - ### połączeniowy
    - ### niezawodny
    - ### wolniejszy
    - ### dba o kolejność wysyłania danych
    - ### dzięki niemu działa buffering
## Protokół UDP jest używany, kiedy ważniejsza jest szybkość przesyłu danych od niezawodności. Wysyła dane do każdego urządzenia które nasłuchuje bez róznicy, czy dane docierają do celu (fire-and-forget). Standardowym zastosowaniem UDP są np. transmisje audio lub wideo.
- ## UDT
    - ### bezpołączeniowy
    - ### występowanie błędów jest możliwe
    - ### znacznie szybszy
![diference between UDP and TCP](udp_v_tcp.jpg)
___
# 2. Protokół HTTP
- ## Model komunikacji
- ## Metody 
    - ### __GET__ - pobiera zasoby wskazane przez URL
    - ### __HEAD__ - pobiera info o zasobie (do sprawdzania dostępności)
    - ### __PUT__ - przyjmuje dane od klienta do serwera
    - ### __POST__ - wysyłą dane od klienta do serwera 
    - ### __DELETE__ - żądanie usunięcia zasobu (wymaga uprawnień)
    - ### __OPTIONS__ - informacje o opcjach i wymaganiach w kanale komunikacyjnym
    - ### __TRACE__ - diagnostyka, analiza kanału komunikacyjnego
    - ### __CONNECT__ - żądanie przeznaczone dla serwerów pośredniczących pełniących funkcje tunelowania
    - ### __PATCH_-_ - aktualizacja części danych
![Methods in HTTP](HTTP_methods.jpg)
- ## Nagłówki
    - ### __Accept__ – informuje serwer o akceptowanych przez klienta typach dokumentu
    - ### __Content-Type__ – informuje o formacie przesyłanej treści
    - ### __Allow__ - informuje o metodach HTTP obsługiwanych przez serwer
    - ### __Cookie__
    - ### __Accept-Encoding__ / __Content-Encoding__
    - ### __Accept-Language__ / __Content-Language__
    - ### __Accept-Charset__
- ## Kody statusu odpowiedzi
    - ### __100: kody informacyjne:__ które wskazują, że żądanie zainicjonowane przez przeglądarkę jest kontynuowane.
    - ### __200: kody powodzenia__, które zwracane są, gdy żądanie przeglądarki zostało pomyślnie odebrane, zrozumiane, a następnie przetworzone przez serwer.
    - ### __300: kody przekierowań__, które pojawiają się, gdy nowa zawartość została zastąpiona żądanym zasobem.
    - ### __400: kody błędów klienta__, które informują o wystąpieniu problemu z danym żądaniem.
    - ### __500: kody błedów serwera__, które wskazują, że żądanie zostało zaakceptowane, jednak błąd na serwerze uniemożliwił jego spełnienie.
![Error Codes in HTTP](HTTP_codes.png)
# 3. Protokół MQTT
## Prosty i lekki protokół warstwy aplikacji działający na zasadzie publikacja / subskrypcja.
- ## Model komunikacji
    - ### komunikacja w MQTT działa na zasadzie publikacja/subskrypcja. 
    - ### Jedno urządzenie wysyła informacje bo brokera (publikuje) pod konkretnym tematem. Natomiast inne urządzenie nasłuchuje (subskrybuje) konkretny temat na brokerze i bierze stamtąd informacje.
    - ### Dane w protokole MQTT są przesyłane w formacie JSON, który pozwala na bardzo mały rozmiar przesyłanych danych oraz dużą przejrzystość kodu dla programisty.
- ## Broker
    - ### Broker MQTT pełni rolę serwera, z którym łączą się klienci (publikatorzy i subskrybenci), aby za jego pośrednictwem publikować i subskrybować wiadomości.
    - ### Broker wymaga publicznego adresu IP, publikatorzy i subskrybenci nie wymagają. 
- ## Poziomy jakości usługi
    - ### __0__ - (najwyżej raz) najprostszy sposób publikacji. Publikator raz wysyła wiadomość i nie dostaje żadnej informacji zwrotnej od Brokera.
    - ### __1__ - (co najmniej raz) gwarantuje doratcie wiadomości (kiedyś). Po każdym wysłaniu danych publikator oczekuje na potwierdzenie od Brokera. Jeżeli takie potwierdzenie nie przyjdzie - wysyła ponownie.
    - ### __2__ - (raz) najwyższy poziom jakości. Działa na zasadzie podobnej do three-way handshake w TCP. Między publikatorem a brokerem następuje połączenie, podczas którego ustalane jest, czy wiadomość została wysłana i potwierdzenie otrzymania zwrócone. Gwarantuje to wysłanie wiadomości dokładnie jeden raz.
- ## Opcja Retain
    ### Normalny stan MQTT powoduje, że po opublikowaniu wiadomości w temacie nie zasubskrypowanym przez żadnego subskrybenta, wiadomość taka jest odrzucana przez Broker. Jednak gdy wyślamy flagę "message retained" na dany kanał, ostatnia wiadomość w temacie będzie utrzymywana przez Broker. Tylko jedna wiadomość może być utrzymywana przez jeden temat. 
# 4. Usługi REST i SOAP
- ## Soap
    - ### komunikacja klient (konsument) - usługa używa zazwyczaj XML, jednak inne formaty również są dozwolone
    - ### dostarcza metody sieciowe dla aplikacji klienta
    - ### nie dostarcza interfejsu użytkownika
- ## Rest, w odróżnieniu od SOAP, jest nie standardem, lecz zbiorem zasad.
    - ### komunikacja klient (konsument) - usługa używa zazwyczaj JSON, jednak inne formaty też są dozwolone (HTML, XML, YAML, txt)
    - ### Komunikacja klienta z usługą odbywa się z wykorzystaniem protokołu HTTP 
        - ### __POST__ - tworzenie zasobu   (C - CREATE)
        - ### __GET__ - czytanie zasobu     (R - READ)
        - ### __PUT__ - aktualizacja zasbu  (U - UPDATE)
        - ### __DELETE__ - usuwanie zasobu  (D - DELETE)
# 5. AJAX
- ### AJAX nie jest standardem a nazwą sposobu wykorzystania technik
- ### Odpowiedź w formacie XML, tekstowym lub JSON
- ### AJAX (Asynchronous JavaScript and XML) - językiem programowania jest JavaScript
# 6. Ciasteczka
## Ciasteczka służą do przechowywania danych na komputerze klienta. Za ich obsługę i przechowywanie odpowiada przeglądarka internetowa, a wysyłane są przez serwer.
- ## Parametry:
    - ### __Name__ – nazwa
    - ### __Value__ – wartość
    - ### __Expires__ – data ważności
    - ### __Domain__ – rozszerza zasięg ciasteczka do domeny
    - ### __Path__ – zawęża zasięg ciasteczka do aplikacji
    - ### __Values__ – kolekcja parametrów klucz-wartość
    - ### __HasKeys__ – informuje czy ciasteczko zawiera kolekcję wartości
- ### Ciasteczko ponownie wysłane do przeglądarki nadpisuje poprzednie o tej samej nazwie.
- ### Po upłynięciu daty ważności ciasteczko jest usuwane przez przeglądarkę.
# 7. Aplikacja ASP.NET
- ## Stan:
    - ### sesji jest widoczny i może być modyfikowany przez wszystkie strony __wywoływane w ramach sesji__.
    - ### aplikacji jest widoczny i może być modyfikowany przez wszystkie strony __wszystkich sesji__.
    - ### widoku jest widoczny i może być modyfikowany __tylko przez stronę na której został użyty__ (nie wymaga sesji)
- ## Identyfikator sesji:
    - ### generowany przez serwer
    - ### przesyłany do przeglądarki jako:
        - ### ciasteczko cookies
        - ### część zmodyfikowanego adresu URL
        - ### w trybie AutoDetect, w zależności od tego, czy przeglądarka obsługuje ciasteczka.
- ### Każde nowe żądanie wysłane do strony ASP.NET rozpoczyna nową sesję.
# 8. Hierarchiczna konfiguracja serwera IIS
- ### Na szczycie hierarchii stoi plik machine.config umieszczony w katalogu: C:\Windows\Microsoft.NET\Framework\nr_?\CONFIG\.
- ### Pozostałe pliki konfiguracyjne noszą nazwę web.config.
- ### Pliki konfiguracyjne to pliki tekstowe w formacie XML.
- ### W pliku konfiguracyjnym aplikacji można nadpisać konfigurację pliku nadrzędnego.
- ### Hierarchiczna struktura plików konfiguracyjnych to katalogi  wirtualne aplikacji.
- ### Plików konfiguracyjnych nie można zobaczyć w przeglądarce, ich wysłanie jest blokowane przez serwer.