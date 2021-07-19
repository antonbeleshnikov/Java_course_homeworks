package lesson8;

import javax.swing.*;

public class ShowTheWinner extends JFrame {

    private Window window;

    public ShowTheWinner(Window window) {
        this.window = window;
    }

    public void tryShow() {
        setBounds(250,250,250,250);
        switch (Logic.who_Is_Winner) {
            case 1:
                add(new JLabel("Вы выиграли"));
                setVisible(true);
                break;
            case 2:
                add (new JLabel("Компьютер выиграл"));
                setVisible(true);
                break;
            case 3:
                add (new JLabel("Ничья"));
                setVisible(true);
                break;
            default:
                break;
        }
    }
}
