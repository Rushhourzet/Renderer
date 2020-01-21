import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Renderer{
    ArrayList<Point3D<Integer>> points;
    Panel panel;
    Vector3<Double> rotation;
    boolean running;
    JFrame frame;

    public Renderer(){
        panel = new Panel();
        points = new ArrayList<>();
    }

    public void Run(){
        Init();
        Refresh();
        //if end condition met =>
        End();
    }

    public void Init(){
        points.add(new Point3D<Integer>(100 , 1, 50));
        points.add(new Point3D<Integer>(1 , 100, 20));
        points.add(new Point3D<Integer>(200 , 100, 1));

        DrawFrame(new Vector2<Integer>(600, 400));

        rotation = new Vector3<Double>(Math.toRadians(5.0),1.0,1.0);

        running = true;

    }
    public void Refresh(){
        while (running == true){
            RefreshPoints(points.get(0), points.get(1), points.get(2), rotation);
            panel.revalidate();
            panel.repaint();          
            frame.revalidate();
            frame.repaint();       
        }
    }
    public void End(){
        //end program on hotkey
        //close JFrame
    }

    public void TransformObject(){

    }
    public void DrawFrame(Vector2<Integer> frameSize){
        frame = new JFrame("Renderermath Test");
        frame.setSize(frameSize.x,frameSize.y);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    

    public void RefreshPoints(Point3D<Integer> p1, Point3D<Integer> p2, Point3D<Integer> p3, Vector3<Double> rotation){
        Point3D<Integer> cameraPos = new Point3D<Integer>(100,100,100);
        Point2D<Integer> _p1 = new Point2D<Integer>(p1.x,p1.y); //MathR.Project3Dto2DInteger(p1, cameraPos, rotation);
        Point2D<Integer> _p2 = new Point2D<Integer>(p2.x,p2.y); //MathR.Project3Dto2DInteger(p2, cameraPos, rotation);
        Point2D<Integer> _p3 = new Point2D<Integer>(p3.x,p3.y); //MathR.Project3Dto2DInteger(p3, cameraPos, rotation);
        panel.SetTestPoly(_p1, _p2, _p3);
    }

    public void DrawEdges(){
        //Draw line for every defined edge from the predefined Points
    }

    public void Fill(){
        //Fill the defined spaces in between edges
        //Only render facing side
        //Only render areas that are noth covered up by other areas
    }
}