import java.util.ArrayList;

public class Renderer{
    ArrayList<Point3D<Integer>> points;
    ArrayList<Camera> calc;

    public Renderer(){
        points = new ArrayList<>();
    }

    public void Run(){
        Init();
        Refresh();
        //if end condition met =>
        End();
    }

    public void Init(){
        points.add(new Point3D<Integer>(0,0));
        points.add(new Point3D<Integer>(10,0));
        points.add(new Point3D<Integer>(5,5));

    }
    public void Refresh(){
        RefreshPoints();
        DrawEdges();
        Fill();
    }
    public void End(){
        //end program on hotkey
        //close JFrame
    }

    public void TransformObject(){

    }

    public void RefreshPoints(){
        for (final Point3D<Integer> p : points) {
            final Camera tmp = new Camera(p);
            // Recalculate matrix for p
            // Apply recalculation to List of Points to render
        }
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