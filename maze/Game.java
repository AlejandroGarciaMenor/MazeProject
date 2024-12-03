package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.logging.Logger;

public class Game extends JPanel implements KeyListener {
    private Maze maze;
    private Robot robot;

    public Game(Robot robot) {
        this.maze = new Maze();
        this.robot = robot;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        maze.paint(g);
        robot.paint(g);
    }

    public static void main(String[] args) {
        List<Robot> robots = DatabaseManager.loadRobots();
        Robot selectedRobot = RobotSelector.showRobotSelector(robots);

        JFrame window = new JFrame("Maze Game");
        Game game = new Game(selectedRobot);
        window.add(game);
        window.setSize(940, 560);
        window.setVisible(true);
        window.setLocation(300, 0);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Redraw loop
        while (true) {
            game.repaint();
            try {
                Thread.sleep(100); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        robot.move(e);
        repaint(); // Redraw the game panel to reflect the new robot position
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}