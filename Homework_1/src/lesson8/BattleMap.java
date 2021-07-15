package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private Window window;
    private ShowTheWinner showTheWinner;
    private int fieldSize;
    private int dotsToWin;
    private int cellWidth;
    private int cellHeight;

    private boolean isInit;

    public BattleMap(Window window) {
        this.window = window;
        setBackground(Color.BLUE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (isInit && !Logic.gameFinished && Logic.isCellValid(cellX, cellY)) {
                    Logic.humanTurn(cellY, cellX);
                    drawX(getGraphics(), cellX, cellY);
                    showTheWinner.tryShow();
                    if (isInit && !Logic.gameFinished) {
                        Logic.aiTurn();
                        drawO(getGraphics(), Logic.ai_Turn_x, Logic.ai_Turn_y);
                        showTheWinner.tryShow();
                    }
                }
            }
        });
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        this.fieldSize = fieldSize;
        this.dotsToWin = dotsToWin;
        isInit = true;
        Logic.who_Is_Winner = 0;
        showTheWinner = new ShowTheWinner(window);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        g.setColor(Color.BLACK);
    }

    private void drawX(Graphics g, int x, int y) {
        if (!isInit) {
            return;
        }
        g.setColor(Color.BLACK);
        x *= cellWidth;
        y *= cellHeight;
        g.drawLine(x, y, x + cellWidth, y + cellHeight);
        g.drawLine(x, y + cellHeight, x + cellWidth, y);
    }

    public void drawO(Graphics g, int x, int y) {
        if (!isInit) {
            return;
        }
        g.setColor(Color.RED);
        x *= cellWidth;
        y *= cellHeight;
        g.drawOval(x, y, cellWidth, cellHeight);
    }
}
