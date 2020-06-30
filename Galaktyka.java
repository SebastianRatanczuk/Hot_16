public class Galaktyka {
    public static void main(String[] args) {
        int argc = 0;

        //Pobranie ilosci args
        try {
            argc = args.length;
        } catch (ArrayIndexOutOfBoundsException a) {
            argc = 0;
        }

        if (argc == 0) {    //czy argumenty zostaly podane?
            System.out.print("klops");

        } else {

            String str = args[0];

            int galaxySize = Integer.parseInt(str.substring(0, str.length() - 1));     //wyciagniecie wymieru galaktyki z napisu

            if (galaxySize == 0 | galaxySize > 1000) {                                //sprawdzenie poprawnosci rozmiaru
                System.out.print("klops");
                return;
            }
//            System.out.print(galaxySize+"\n");

            char Option = str.charAt(str.length() - 1);
//            System.out.print(Option);

            int xSize = galaxySize + 2;               //obliczenie rozmiaru macierzy
            int ySize = galaxySize + 3;

            char[][] Table = new char[ySize][xSize];  //wypelnienie macierzy spacjami
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    Table[i][j] = ' ';
                }
            }

            int counter = 0;

            int xPos = 0;
            int yPos = 0;
            int direction = 0;


            do {    //0-2 wedrowanie od punktu do krawedzi
                    //3-6 by bylo wolne jedno miejsce miedzy gwiazdkami -> ***.*
                    //to fix: moze da sie jakos polaczyc warunki w jeden warunek

                Table[yPos][xPos] = '*';


                switch (direction) {
                    case 0:                         //-->
                        if (xPos < xSize - 1) {
                            xPos++;                //przesuniecie w bok
                            counter = 0;            //reset warunku
                        } else {
                            direction = 1;          //zmiana kierunku
                            counter++;              //zwiekszenie licznika stopu
                        }
                        break;

                    case 1:
                        if (yPos < ySize - 1) {
                            yPos++;
                            counter = 0;
                        } else {
                            direction = 2;
                            counter++;
                        }
                        break;

                    case 2:
                        if (xPos > 0) {
                            xPos--;
                            counter = 0;

                        } else {
                            direction = 3;
                            counter++;
                        }
                        break;

                    case 3:
                        if (Table[yPos - 2][xPos] != '*') {
                            yPos--;
                            counter = 0;
                        } else {
                            direction = 4;
                            counter++;
                        }
                        break;

                    case 4:
                        if (Table[yPos][xPos + 2] != '*') {
                            xPos++;
                            counter = 0;
                        } else {
                            direction = 5;
                            counter++;
                        }
                        break;

                    case 5:
                        if (Table[yPos + 2][xPos] != '*') {
                            yPos++;
                            counter = 0;
                        } else {
                            direction = 6;
                            counter++;
                        }
                        break;

                    case 6:
                        if (Table[yPos][xPos - 2] != '*') {
                            xPos--;
                            counter = 0;
                        } else {
                            direction = 3;
                            counter++;
                        }
                        break;
                }
            } while (counter < 2);  // jezeli wystapia min 2 przejscia miedzy kierunkami bez zmiany pozycji wyjdz z petli


            counter = 0;
            switch (Option) {       //wyswietlanie tej samej macierzy w roznych permutacjach
                case 'W':
                    for (int j = 0; j < ySize; j++) {
                        for (int k = 0; k < xSize; k++) {
                            System.out.print(Table[j][k]);

                            if (Table[j][k] == ' ') {
                                counter++;
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print(counter);
                    break;

                case 'N':
                    for (int k = 0; k < xSize; k++) {
                        for (int j = ySize - 1; j >= 0; j--) {
                            System.out.print(Table[j][k]);

                            if (Table[j][k] == ' ') {
                                counter++;
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print(counter);
                    break;

                case 'E':
                    for (int j = ySize - 1; j >= 0; j--) {
                        for (int k = xSize - 1; k >= 0; k--) {
                            System.out.print(Table[j][k]);

                            if (Table[j][k] == ' ') {
                                counter++;
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print(counter);
                    break;

                case 'S':
                    for (int k = xSize - 1; k >= 0; k--) {
                        for (int j = 0; j < ySize; j++) {
                            System.out.print(Table[j][k]);

                            if (Table[j][k] == ' ') {
                                counter++;
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print(counter);
                    break;

                default:
                    System.out.print("klops");
            }
        }
    }
}