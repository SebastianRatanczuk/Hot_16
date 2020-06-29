public class Kosmolot {
    public static void main(String[] args) {

        int argc = 0;

        //Pobranie ilosci args
        try {
            argc = args.length;
        } catch (ArrayIndexOutOfBoundsException a) {
            argc = 0;
        }

        //Sprawdzenie poprawnisci ilosci args
        if (argc == 2) {

            int sizeOfRocket = Integer.parseInt(args[0]);
            if (1 <= sizeOfRocket & sizeOfRocket <= 75) {//sprawdzenie rozmiaru rakiety

                if (args[1].equals("N")) { //rakieta bez pancerza

                    int height = (int) Math.pow((double) sizeOfRocket, (double) 2);   //obliczenie rozmiaru wysokosci rakiety
                    int width = 2 * sizeOfRocket - 1;                                 //obliczanie rozmiaru szerokosci rakiety

                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {

                            if (j % sizeOfRocket < sizeOfRocket - Math.abs(sizeOfRocket - i - 1)) { //podejmowanie decyzji * czy spacja
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");                          //przejscie do nowej lini
                    }

                } else if (args[1].equals("Y")) {//rakieta z pancerzem

                    //powtorzenie kodu z 21-22
                    int height = (int) Math.pow((double) sizeOfRocket, (double) 2);   //obliczenie rozmiaru wysokosci rakiety
                    int width = 2 * sizeOfRocket - 1;                                 //obliczenie rozmiaru szerokosci rakiety

                    for (int i = 0; i < width / 2; i++) {               //petle dla gornego skrzydla
                        for (int j = 0; j < height; j++) {

                            if (j % sizeOfRocket < sizeOfRocket - Math.abs(sizeOfRocket - i - 1)) {   //sprzwdzenie czy w danum polu ma byc znak czy spacja
                                if (j == 0) {
                                    System.out.print(">");
                                } else {
                                    if (j % sizeOfRocket == i) {
                                        System.out.print("\\");
                                    } else {
                                        System.out.print("*");
                                    }
                                }
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");
                    }

                    for (int i = 0; i < height; i++) {                  //petla kokpitu

                        if (i == 0 | i == height - 1) {
                            System.out.print(">");
                        } else {
                            System.out.print("*");
                        }
                    }

                    System.out.print("\n");

                    for (int i = (width + 1) / 2; i < width; i++) {   //petle dolnego skrzydla
                        for (int j = 0; j < height; j++) {

                            if (j % sizeOfRocket < sizeOfRocket - Math.abs(sizeOfRocket - i - 1)) {               //sprzwdzenie czy w danum polu ma byc znak czy spacja
                                if (j == 0) {
                                    System.out.print(">");
                                } else {
                                    if (j % sizeOfRocket == sizeOfRocket - Math.abs(sizeOfRocket - i - 2)) {
                                        System.out.print("/");
                                    } else {
                                        System.out.print("*");
                                    }
                                }
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print("\n");     //a gdyby tak zhardkodowac wszystkie mozliwosaci
                    }

                } else {
//                  System.out.print("Zly parametr pancerza");
                    System.out.print("klops");
                }

            } else {
//              System.out.print("Zly rozmiar rakiety");
                System.out.print("klops");
            }

        } else {
//          System.out.print("Zla liczba argumentow");
            System.out.print("klops");
        }
    }
}