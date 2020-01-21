import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Renderer{
    ArrayList<Point3D<Integer>> points;
    ArrayList<Camera> calc;
    Panel panel;
    Vector3 rotation;

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
        points.add(new Point3D<Integer>(00 , 00, 50));
        points.add(new Point3D<Integer>(100 , 00));
        points.add(new Point3D<Integer>(50 , 50));

        rotation = new Vector3<Double>(Math.toRadians(5.0),0.0,0.0);
    }
    public void Refresh(){
        
        RefreshPoints(points.get(0), points.get(1), points.get(2), rotation);

        DrawFrame(new Vector2<Integer>(600, 400));
    }
    public void End(){
        //end program on hotkey
        //close JFrame
    }

    public void TransformObject(){

    }
    public void DrawFrame(Vector2<Integer> frameSize){
        if(panel ==null){
            panel = new Panel();
        }
        JFrame frame = new JFrame("Renderermath Test");
        frame.setSize(frameSize.x,frameSize.y);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    

    public void RefreshPoints(Point3D<Integer> p1, Point3D<Integer> p2, Point3D<Integer> p3, Vector3<Double> rotation){
        Point2D<Integer> _p1 = MathR.Project3Dto2DInteger(Point3D.NULL_INT(), p1, rotation);
        Point2D<Integer> _p2 = MathR.Project3Dto2DInteger(Point3D.NULL_INT(), p2, rotation);
        Point2D<Integer> _p3 = MathR.Project3Dto2DInteger(Point3D.NULL_INT(), p3, rotation);
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