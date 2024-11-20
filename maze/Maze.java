package maze;

import java.awt.Graphics;
import java.awt.Color;

public class Maze {

    private int row = 0;
    private int column = 0;
    private final int numRows = 13;
    private final int numColumns = 23;
    private final int widthBlock = 40;
    private final int heightBlock = 40;

    public void paint(Graphics g) {
        int[][] maze = createMaze();
        Color blockColor = new Color(41, 171, 135);

        for(row = 0; row < numRows; row++){
            for(column = 0; column < numColumns; column++){
                if(maze[row][column] == 1){
                    g.setColor(blockColor);
                    g.fillRect(column * widthBlock, row * heightBlock, widthBlock, heightBlock);
                    g.setColor(Color.black);
                    g.drawRect(column * widthBlock, row * heightBlock, widthBlock, heightBlock);
                } else {
                    g.setColor(Color.white);
                    g.fillRect(column * widthBlock, row * heightBlock, widthBlock, heightBlock);
                }
            }
       }
    }

    public int[][] createMaze() {
        int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };        
        return maze;
    }

}
