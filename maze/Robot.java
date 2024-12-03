package maze;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Robot {
    
    Maze maze = new Maze();
    private int id;
    private int x_position = 40; 
    private int y_position = 40;
    private int movement = 40;
    private int width;
    private int length;
    private Color headColor;
    private Color bodyColor;
    private Color eyeColor;
    private Color armColor;
    private Color legColor;
    private String bodyShape;

    public Robot(int id, int width, int length, Color bodyColor, Color headColor, Color eyeColor, Color armColor, Color legColor, String bodyShape){
        this.id = id;
        this.width = width;
        this.length = length;
        this.headColor = headColor;
        this.bodyColor = bodyColor;
        this.eyeColor = eyeColor;
        this.armColor = armColor;
        this.legColor = legColor;
        this.bodyShape = bodyShape;
    }


    public void paint(Graphics g) {
        int bodyWidth = width / 2;
        int bodyHeight = length / 2;
        int headSize = width / 4;
        int eyeSize = width / 8;
        int armWidth = width / 8;
        int armHeight = length / 2;
        int legWidth = width / 8;
        int legHeight = length / 2;

        // Body
        g.setColor(bodyColor);
        if (bodyShape.equals("rectangle")) {
            g.fillRect(x_position + width / 4, y_position + length / 4, bodyWidth, bodyHeight);
        } else if (bodyShape.equals("oval")) {
            g.fillOval(x_position + width / 4, y_position + length / 4, bodyWidth, bodyHeight);
        }

        // Head
        g.setColor(headColor);
        g.fillRect(x_position + width / 2 - headSize / 2, y_position, headSize, headSize);

        // Eyes
        g.setColor(eyeColor);
        g.fillOval(x_position + width / 2 - headSize / 4, y_position + headSize / 4, eyeSize, eyeSize);
        g.fillOval(x_position + width / 2, y_position + headSize / 4, eyeSize, eyeSize);

        // Arms
        g.setColor(armColor);
        g.fillRect(x_position + width / 4 - armWidth, y_position + length / 4, armWidth, armHeight);
        g.fillRect(x_position + width / 4 + bodyWidth, y_position + length / 4, armWidth, armHeight);

        // Legs
        g.setColor(legColor);
        g.fillRect(x_position + width / 4 + bodyWidth / 4, y_position + length / 4 + bodyHeight, legWidth, legHeight);
        g.fillRect(x_position + width / 4 + bodyWidth / 2, y_position + length / 4 + bodyHeight, legWidth, legHeight);
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