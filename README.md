# Gra w labirynt

## Spis treści

1. [Instrukcja obsługi](#1-instrukcja-obsługi)
2. [Opis algorytmu](#2-opis-algorytmu)
3. [Opis klas i plików](#3-opis-klas-i-plików)

## 1. Instrukcja Obsługi

1. Do skompilowania i uruchomienia projektu wymagana jest Java w wersji 11
2. Projekt nie używa żadnych zewnętrznych paczek, ani bibliotek
3. Dane do uruchomienia projektu należy umieścić w pliku data.txt w głównym folderze projektu
4. Dane powinny być podane w formie:
- W pierszej lini dwie liczby oznaczające wysokość i szerokość labiryntu,
- W kolejnych obraz labiryntu.
```
5 6
#$.###
##...#
#..###
##..##
###.@#

```
5. Aby uruchomić program możemy skorzystać z opcji Uruchom z środowiska programistycznego, dla przykładu w Visual Studio Code jest to opcja Run -> Run Without Debugging (Ctrl+F5), bądź za pośrednictwem Konsoli w głównym folderze projektu uruchomić dwie komendy
```
javac Main.java
java Main
``` 

## 2. Opis algorytmu

Program działa na zasadzie [Ataku Brute Force](https://pl.wikipedia.org/wiki/Atak_brute_force), buduje wszystkie możliwe ścieżki od startu labiryntu do ślepych zaułków oraz do mety. Algorytm w pętli buduję kolejne kroki ścieżek analizując możliwe ruchy i wykluczając je ze względu na ściany bądź zapętlenia. Pętla analizująca kolejne niezakończone ścieżki będzie działa póki każda z możliwych dróg nie zostanie zakończona ze względu na wystąpione zapętlenie, brak możliwości ruchu bądź znaleziony koniec labiryntu. Następnie po wywołaniu odpowiedniej metody program zwróci najkrótszą z możliwych ścieżek w postaci kodu literowego oznaczającego kolejne kroki od staru do mety labiryntu(kroki oznaczone są pierwszymi literami wykonanego ruchu, np.: krok w prawo - P, krok w górę - G, koniec labiryntu - K).

## 3. Opis klas i plików

1. Main.java

Główny plik programu. Jego zadaniem jest pobrać dane z pliku wejściowego i przekazać je do wcześniej zainicjowanego obiektu klasy `Analizer`, a następnie "zapytać" wspomniany obiekt o kod najkrótszej trasy ukończenia labiryntu.

2. Analizer.java

W tym pliku zaimplementowany jest algorytm opisany w punkcie 2. Klasa w momencie inicjalizacji tworzy z podanej listy ciągów znaków obiekt klasy `Maze` oraz inicjuje obiekt listy wszystkich ścieżek. Metoda `analize()` odpowiedzialna jest za zbudowanie wszystkich możliwych ścieżek labiryntu.
Algorytm działa na dwóch pętlach - pierwsza odpowiedzialna za powtarzanie analizy wszystkich ścieżek póki wszystkie nie zostaną doprowadzone do końca oraz druga pętla głębsza odpowiedzialna za przejście po kolejnych ścieżkach i dodanie do nich kolejnych kroków bądź duplikację ścieżki w momencie możliwości pójścia w kilku różnych kierunkach. W głębszej pętli algorytm działa zgodnie z następującymi krokami: w pierszej kolejności sprawdzamy czy ścieżka nie jest zakończone i jeśli jest to ją pomijamy, następnie zbieramy listę kroków możliwych do wykonania a na kończu na bazie tej listy dodajemy kroki bądź duplikujemy ścieżki.

3. Pliki MazeBuilder.java oraz RouteBuilder.java

W tych plikach znajduje się logika budowania konkretnych obiektów oraz ich klonowania.

4. Pliki Maze.java, Route.java oraz Step.java

To pliki zawierające aktualny stan aplikacji oraz funkcje pomocnicze operujące na danych tych obiektów.
