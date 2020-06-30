import java.util.*;

public class Drwal {

    public static String replaceChar(String str, char ch, int index) { // funkcja zamieniajaca znak w podanym stringu
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    static void findAndReplace(ArrayList<String> Dane, int x, int y, char kolor, int szerokosc, int wysokosc) {

        if (x > szerokosc || y > wysokosc) {
            return;
        }

        String data1 = Dane.get(y);                 //pobranie wiersza

        if (data1.charAt(x) != ' ') {               //jezeli na tymjest jakis znak wyjdz
            return;
        }

        data1 = replaceChar(data1, kolor, x);       //kolorowanie znaku
        Dane.set(y, data1);                         //zapisanie wiersza

        findAndReplace(Dane, x + 1, y, kolor, szerokosc, wysokosc);   //rekurencyjne szukanie wolnego miejsca i jego kolorowanie
        findAndReplace(Dane, x - 1, y, kolor, szerokosc, wysokosc);
        findAndReplace(Dane, x, y + 1, kolor, szerokosc, wysokosc);
        findAndReplace(Dane, x, y - 1, kolor, szerokosc, wysokosc);

        //pzdr
    }

    public static void main(String[] args) {

        int argc = 0;

        //Pobranie ilosci args
        try {
            argc = args.length;
        } catch (ArrayIndexOutOfBoundsException a) {
            argc = 0;
        }

        //Sprawdzenie poprawnisci ilosci args
        if (argc == 5) {

            int xStart = Integer.parseInt(args[0]) - 1;
            int yStart = Integer.parseInt(args[1]) - 1;
            char kolor = args[2].charAt(0);
            int szerokosc = Integer.parseInt(args[3]) - 1;
            int wysokosc = Integer.parseInt(args[4]) - 1;

            Scanner scan = new Scanner(System.in);
            ArrayList<String> listOfStrings = new ArrayList<String>();


            int licznik = 0;
            while (scan.hasNext()) {              //zapisanie pliku do pamieci;
                String line = scan.nextLine();
                licznik++;
                if (line.length() > szerokosc | licznik > szerokosc) {
                    System.out.print("klops");
                    return;
                }
                listOfStrings.add(line);

            }

            findAndReplace(listOfStrings, xStart, yStart, kolor, szerokosc, wysokosc);       //odpalenie rekurencji 

            for (String data : listOfStrings) {     //wypisanie na ekran
                System.out.print(data + "\n");
            }

        } else {
            System.out.print("klops");
        }

    }
}
