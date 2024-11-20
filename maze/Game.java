package maze;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.logging.Logger;


public class Game extends JPanel {

    Maze maze = new Maze();
    Robot robot = new Robot();

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                robot.move(e);
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {

            }
        });
        setFocusable(true); // To ensure the panel can receive the keyboard input
    }

    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        maze.paint(g);
        robot.paint(g);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Maze Game");
        Game game = new Game();
        window.add(game);
        window.setSize(940, 560);
        window.setVisible(true);
        window.setLocation(300,0);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){    // To keep the window open
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
            game.repaint();
        }
    }

}