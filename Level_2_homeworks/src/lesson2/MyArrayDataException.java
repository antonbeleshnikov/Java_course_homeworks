package lesson2;

public class MyArrayDataException extends NumberFormatException {
    private int line;
    private int column;

    public MyArrayDataException(int line, int column) {
        super("Неверные данные в ячейке со строкой " + line + " столбцом " + column);
        this.line = line;
        this.column = column;
    }
}
