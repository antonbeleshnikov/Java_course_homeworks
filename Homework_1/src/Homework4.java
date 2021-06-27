import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initmap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initmap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате x,y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static Random random = new Random();

    /**
     * Этот метод переделан в сооветствии с заданием 4,
     * с помощью дополнительного метода aiCheckPotentialWin АИ сперва проверяет, может ли он выиграть сам,
     * если да, то выигрывает
     * далее проверяет, может ли выиграть игрок на следующий ход, и, если да, то блокирует выигрышную клетку,
     * если в обоих предыдущих случаях нет, то ходит рандомно, что забавно,
     * выиграть у такого АИ все равно можно за счёт вилки
     */
    public static void aiTurn() {
        int x, y;
        if (aiCheckPotentialWin(DOT_O) != null) {
            y = aiCheckPotentialWin(DOT_O)[0];
            x = aiCheckPotentialWin(DOT_O)[1];
        } else if (aiCheckPotentialWin(DOT_X) != null) {
            y = aiCheckPotentialWin(DOT_X)[0];
            x = aiCheckPotentialWin(DOT_X)[1];
        } else {
            do {
                y = random.nextInt(SIZE);
                x = random.nextInt(SIZE);

            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    /**
     * Этот метод переделан в соответствии с заданием 3,
     * т.е будет работать для произвольных значений
     * SIZE и DOTS_TO_WIN
     */
    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j][i + k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN) return true;
                    count = 0;
                }
                if (j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN) return true;
                    count = 0;
                }
                if (i + DOTS_TO_WIN <= SIZE && j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i + k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN) return true;
                    count = 0;
                }
                if (i >= DOTS_TO_WIN - 1 && j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i - k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN) return true;
                    count = 0;
                }
            }
        }
        return false;
    }

    public static int[] aiCheckPotentialWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j][i + k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN - 1) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[j][i + k] == DOT_EMPTY) {
                                int[] coordinates = new int[2];
                                coordinates[0] = j;
                                coordinates[1] = i + k;
                                return coordinates;
                            }
                        }
                    }
                    count = 0;
                }
                if (j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN - 1) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[j + k][i] == DOT_EMPTY) {
                                int[] coordinates = new int[2];
                                coordinates[0] = j + k;
                                coordinates[1] = i;
                                return coordinates;
                            }
                        }
                    }
                    count = 0;
                }
                if (i + DOTS_TO_WIN <= SIZE && j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i + k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN - 1) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[j + k][i + k] == DOT_EMPTY) {
                                int[] coordinates = new int[2];
                                coordinates[0] = j + k;
                                coordinates[1] = i + k;
                                return coordinates;
                            }
                        }
                    }
                    count = 0;
                }
                if (i >= DOTS_TO_WIN - 1 && j + DOTS_TO_WIN <= SIZE) {
                    int count = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[j + k][i - k] == symb) {
                            count++;
                        }
                    }
                    if (count == DOTS_TO_WIN - 1) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[j + k][i - k] == DOT_EMPTY) {
                                int[] coordinates = new int[2];
                                coordinates[0] = j + k;
                                coordinates[1] = i - k;
                                return coordinates;
                            }
                        }
                    }
                    count = 0;
                }
            }
        }
        return null;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
