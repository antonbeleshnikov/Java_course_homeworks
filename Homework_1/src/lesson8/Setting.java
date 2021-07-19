package lesson8;

import javax.swing.*;
import java.awt.*;

public class Setting extends JFrame {
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private Window window;

    private JSlider sliderFieldSize;
    private JSlider sliderDotsToWin;

    public Setting(Window window) {
        this.window = window;
        setBounds(250, 250, 450, 450);
        setTitle("Настройки");
        setLayout(new GridLayout(5, 1));
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintTicks(true);
        sliderFieldSize.setPaintLabels(true);
        sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintTicks(true);
        sliderDotsToWin.setPaintLabels(true);
        sliderFieldSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderFieldSize.getValue()));
        add(new Label("Укажите размер поля"));
        add(sliderFieldSize);
        add(new Label("Укажите количество символов для победы"));
        add(sliderDotsToWin);
        JButton buttonStartGame = new JButton("Начать игру");
        buttonStartGame.addActionListener(e -> {
            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();
            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initmap();
            Logic.gameFinished = false;
            window.startNewGame(fieldSize, dotsToWin);
            setVisible(false);
        });
        add(buttonStartGame);
        setVisible(false);
    }
}
