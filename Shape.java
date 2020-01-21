import java.util.ArrayList;

public class Shape {
    ArrayList<Point3D<Double>> points;
    ArrayList<Line> lines;
    ArrayList<Triangle> faces;
    public Shape(){
        points = new ArrayList<>();
        lines = new ArrayList<>();
        faces = new ArrayList<>();
    }

    public void setPoints(ArrayList<Point3D<Double>> points){
        this.points = points;
    }

    public ArrayList<Point3D<Double>> getPoints(){
        ArrayList<Point3D<Double>> tmp = new ArrayList<Point3D<Double>>();
        for (Point3D<Double> p : points) {
            tmp.add(p);
        }
        return tmp;
    }
}