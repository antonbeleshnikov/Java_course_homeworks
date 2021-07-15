package lesson8;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private BattleMap battleMap;
    private Setting setting;
    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,500,500,500);
        setTitle("Крестики-нолики");
        JPanel panel =  new JPanel(new GridLayout(1,2));
        JButton buttonNewGame = new JButton("Новая игра");
        buttonNewGame.addActionListener(e -> setting.setVisible(true));
        panel.add(buttonNewGame);
        JButton buttonExit = new JButton("Выход");
        buttonExit.addActionListener(e -> System.exit(0));
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);
        battleMap = new BattleMap(this);
        add(battleMap,BorderLayout.CENTER);
        setting = new Setting(this);
        setVisible(true);
    }
    void startNewGame(int fieldSize, int dotsToWin) {
        battleMap.startNewGame(fieldSize,dotsToWin);
    }
}
