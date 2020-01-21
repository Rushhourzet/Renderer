import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Panel extends JPanel {
    Polygon poly;

    public void DrawLine(Graphics g, Point2D<Integer> p1, Point2D<Integer> p2){
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
    public void SetTestPoly(Point2D<Integer> p1, Point2D<Integer> p2, Point2D<Integer> p3){
        poly = new Polygon(
            new int[]{p1.x, p2.x, p3.x},
            new int[]{p1.y, p2.y, p3.y},
            3);
    }


    @Override
    public void paintComponent(Graphics g){
        Polygon poly = new Polygon(
                new int[]{50, 100, 0},
                new int[]{0, 100, 100},
                3);
        super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fill(poly);
            g2d.dispose();
    }
}