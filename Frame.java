import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Frame{
    Panel panel;
    public void DrawFrame(){
        if(panel ==null){
            panel = new Panel();
        }
        JFrame frame = new JFrame("Renderermath Test");
        frame.setSize(600,400);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    

    public void RotateTestPoly(Vector3<Double> rotate){
        
    }
}