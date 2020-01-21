import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Frame{
    public void DrawFrame(){
        JFrame frame = new JFrame("Renderermath Test");
        frame.setSize(600,400);
        frame.setLayout(new BorderLayout());
        frame.add(new Panel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    
}