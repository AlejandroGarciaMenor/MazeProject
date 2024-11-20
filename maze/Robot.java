package maze;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Robot {
    
    Maze maze = new Maze();
    private int x_position = 40; 
    private int y_position = 40;
    private int width = 40;
    private int length = 40;
    private int movement = 40;


    public void paint(Graphics g){
        g.setColor(Color.pink);
        g.fillOval(x_position, y_position, width, length);
        g.setColor(Color.cyan);
        g.drawOval(x_position, y_position, width, length);

    }

    public void move(KeyEvent event){
        int[][] mazeArray = maze.createMaze();

        if(event.getKeyCode() == 37){   //left
            if(mazeArray[y_position/40][(x_position - movement)/40] == 0){
                x_position = x_position - movement;
            }
            
        }
        if(event.getKeyCode() == 38){   //up
            if(mazeArray[(y_position - movement)/40][x_position/40] == 0){
                y_position = y_position - movement;
            }
        }
        if(event.getKeyCode() == 39){   //right
            if(mazeArray[y_position/40][(x_position + movement)/40] == 0){
                x_position = x_position + movement;
            }
        }
        if(event.getKeyCode() == 40){   //down
            if(mazeArray[(y_position + movement)/40 ][x_position/40] == 0){
                y_position = y_position + movement;
            }
        }
    }


}