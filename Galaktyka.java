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

            int Galaxy_Size = Integer.parseInt(str.substring(0, str.length() - 1));     //wyciagniecie wymieru galaktyki z napisu

            if (Galaxy_Size == 0 | Galaxy_Size > 1001) {                                //sprawdzenie poprawnosci rozmiaru
                System.out.print("klops");
                return;
            }
//            System.out.print(Galaxy_Size+"\n");

            char Option = str.charAt(str.length() - 1);
//            System.out.print(Option);

            int X_Size = Galaxy_Size + 2;               //obliczenie rozmiaru macierzy
            int Y_Size = Galaxy_Size + 3;

            char[][] Table = new char[Y_Size][X_Size];  //wypelnienie macierzy spacjami
            for (int i = 0; i < Y_Size; i++) {
                for (int j = 0; j < X_Size; j++) {
                    Table[i][j] = ' ';
                }
            }

            int counter = 0;

            int X_pos = 0;
            int Y_pos = 0;
            int Direction = 0;


            do {                //0-2 wedrowanie od punktu do krawedzi
                //3-6 by bylo wolne jedno miejsce miedzy gwiazdkami -> ***.*
                //to fix: moze da sie jakos polaczyc warunki w jeden warunek

                Table[Y_pos][X_pos] = '*';


                switch (Direction) {
                    case 0:                         //-->
                        if (X_pos < X_Size - 1) {
                            X_pos++;                //przesuniecie w bok
                            counter = 0;            //reset warunku
                        } else {
                            Direction = 1;          //zmiana kierunku
                            counter++;              //zwiekszenie licznika stopu
                        }
                        break;

                    case 1:
                        if (Y_pos < Y_Size - 1) {
                            Y_pos++;
                            counter = 0;
                        } else {
                            Direction = 2;
                            counter++;
                        }
                        break;

                    case 2:
                        if (X_pos > 0) {
                            X_pos--;
                            counter = 0;

                        } else {
                            Direction = 3;
                            counter++;
                        }
                        break;

                    case 3:
                        if (Table[Y_pos - 2][X_pos] != '*') {
                            Y_pos--;
                            counter = 0;
                        } else {
                            Direction = 4;
                            counter++;
                        }
                        break;

                    case 4:
                        if (Table[Y_pos][X_pos + 2] != '*') {
                            X_pos++;
                            counter = 0;
                        } else {
                            Direction = 5;
                            counter++;
                        }
                        break;

                    case 5:
                        if (Table[Y_pos + 2][X_pos] != '*') {
                            Y_pos++;
                            counter = 0;
                        } else {
                            Direction = 6;
                            counter++;
                        }
                        break;

                    case 6:
                        if (Table[Y_pos][X_pos - 2] != '*') {
                            X_pos--;
                            counter = 0;
                        } else {
                            Direction = 3;
                            counter++;
                        }
                        break;
                }
            } while (counter < 2);  // jezeli wystapia min 2 przejscia miedzy kierunkami bez zmiany pozycji wyjdz z petli


            counter = 0;
            switch (Option) {       //wyswietlanie tej samej macierzy w roznych permutacjach
                case 'W':
                    for (int j = 0; j < Y_Size; j++) {
                        for (int k = 0; k < X_Size; k++) {
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
                    for (int k = 0; k < X_Size; k++) {
                        for (int j = Y_Size - 1; j >= 0; j--) {
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
                    for (int j = Y_Size - 1; j >= 0; j--) {
                        for (int k = X_Size - 1; k >= 0; k--) {
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
                    for (int k = X_Size - 1; k >= 0; k--) {
                        for (int j = 0; j < Y_Size; j++) {
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