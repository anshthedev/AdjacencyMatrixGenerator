import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

@SuppressWarnings("resource")
public class MatrixGenerator extends JPanel{

    // variables for randomized vertices
    final int size = 5;  
    final int minX = 50;  
    final int minY = 50;  

    // storing all rectangles
    Rectangle[] rects;  

    // inputed adjacency matrix
    // 0  1  1  0  1  0  0  1
    // 1  0  1  0  0  1  1  1
    // 1  1  0  1  0  0  0  1
    // 0  0  1  0  1  1  0  1
    // 1  0  0  1  0  1  1  0
    // 0  1  0  1  1  0  0  0 
    // 0  1  0  0  1  0  0  1
    // 1  1  1  1  1  0  1  0

    int[][] array = {{0,1,1,0, 1, 0, 0, 1},{1,0,1,0,0, 1, 1, 1},{1,1,0,1,0,0,0,1}, {0,0,1,0,1,1,0,1},{1,0,0,1,0,1,1,0}, {0,1,0,1,1,0,0,0}, {0,1,0,0,1,0,0,1}, {1,1,1,1,1,0,1,0}};

    public MatrixGenerator(){
        setPreferredSize(new Dimension(1000,1000));
        setBackground(Color.WHITE);

        rects = new Rectangle[array.length];
    }   

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int maxX = panelWidth - size - 50;
        int maxY = panelHeight - size - 50;

        // make randomized rectangles
        if (rects[0] == null) {
            for (int i = 0; i < array.length; i++) {
                int x = (int)(Math.random() * (maxX - minX)) + minX;
                int y = (int)(Math.random() * (maxY - minY)) + minY;
                rects[i] = new Rectangle(x, y, size, size);
            }
        }

        // draw verticies
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(rects[i].x, rects[i].y, rects[i].width, rects[i].height);
            g.drawString("V" + (i+1), rects[i].x, rects[i].y);
        }

        // draw edges
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i][j] == 1) {
                    g.drawLine(rects[i].x, rects[i].y, rects[j].x, rects[j].y);
                }
            }
        }
    }
}
