package Krestik;

import java.util.Scanner;

public class KrestikiNoliki {
    public static class Main {
        static boolean gameFinished = false;
        static final char[][] gameGrid = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };


        public static void main(String[] args) {
            Player playerGame = new Player();
            byte moveOfPlayers = 1;
            while (gameFinished == false) {

                playerGame.update(gameGrid);
                moveOfPlayers = playerGame.getMoveCounter();
                if (moveOfPlayers > 9) {
                    gameFinished = true;
                }
                for (int i = 0; i < gameGrid.length; i++) {
                    for (int j = 0; j < gameGrid[i].length; j++) {


                        if (moveOfPlayers > 5) {

                            if ((gameGrid[0][0] == gameGrid[0][1]) && (gameGrid[0][1] == gameGrid[0][2]) && (gameGrid[0][0] != '-')) {
                                gameFinished = true;
                            }
                            if ((gameGrid[1][0] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[1][2]) && (gameGrid[1][1] != '-')) {
                                gameFinished = true;
                            }
                            if ((gameGrid[2][0] == gameGrid[2][1]) && (gameGrid[2][1] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                                gameFinished = true;
                            } //проверка на победу по горизонтали

                            if ((gameGrid[0][0] == gameGrid[1][0]) && (gameGrid[1][0] == gameGrid[2][0]) && (gameGrid[0][0] != '-')) {
                                gameFinished = true;
                            }
                            if ((gameGrid[0][1] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][1]) && (gameGrid[1][1] != '-')) {
                                gameFinished = true;
                            }
                            if ((gameGrid[0][2] == gameGrid[1][2]) && (gameGrid[1][2] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                                gameFinished = true;
                            }

                            if ((gameGrid[0][0] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                                gameFinished = true;
                            }
                            if ((gameGrid[0][2] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][0]) && (gameGrid[2][0] != '-')) {
                                gameFinished = true;
                            }
                        }

                        System.out.print(gameGrid[i][j] + "\t");
                    }
                    System.out.println();
                }
            }

            if (gameFinished == true) {
                if (moveOfPlayers < 9) {
                    if (moveOfPlayers % 2 == 0) {
                        System.out.println("Нолики выйграли, поздравляем!");
                    } else {
                        System.out.println("Крестики выйграли, поздравляем!");
                    }
                } else {
                    System.out.println("Ничья!");
                }
                System.out.println("Конец игры!");
            }
        }
    }


    public static class Player {
        String coordinates;
        char coordinateX, coordinateY;
        byte moveCounter = 1;


        public byte getMoveCounter() {
            return moveCounter;
        }

        public char[][] update(char gridOfGame[][]) {

            if (moveCounter % 2 == 0) {
                System.out.println("\tХод №" + moveCounter + ". Крестики, ваша очередь! Введите координаты хода (пример:a2): ");
            } else {
                System.out.println("\tХод №" + moveCounter + ". Нолики, ваша очередь! Введите координаты хода (пример:a2): ");
            }
            Scanner scannerOfPlayerMove = new Scanner(System.in);


            coordinates = scannerOfPlayerMove.next();//заполняю строку

            if (coordinates.length() != 2) {
                System.out.println("Вы ввели не верные цифры. Попробуйте снова");
                return gridOfGame;
            }

            coordinateX = coordinates.charAt(0);
            coordinateY = coordinates.charAt(1);

            int x = 0, y = 0;
            switch (coordinateX) {
                case 'a':
                    x = 0;
                    break;
                case 'b':
                    x = 1;
                    break;
                case 'c':
                    x = 2;
                    break;
                default:
                    System.out.println("Вы ввели не верные цифры. Попробуйте снова.\n");
                    return gridOfGame;
            }
            switch (coordinateY) {
                case '1':
                    y = 0;
                    break;
                case '2':
                    y = 1;
                    break;
                case '3':
                    y = 2;
                    break;
                default:
                    System.out.printf("Вы ввели не верные цифры. Попробуйте снова.\n");
                    return gridOfGame;
            }


            if (gridOfGame[x][y] == '-') {
                if ((moveCounter % 2 == 0) && (gridOfGame[x][y] != 'x') && (gridOfGame[x][y] != 'o')) {
                    gridOfGame[x][y] = 'x';
                    moveCounter++;
                } else {
                    gridOfGame[x][y] = 'o';
                    moveCounter++;
                }
            } else {
                System.out.println("Клетка занята,попробуйте снова \t");
            }

            return gridOfGame;
        }
    }
}
