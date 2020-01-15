public class Line{
    public Point3D pointA, pointB;
    private double length;
    public Line(Point3D pointA, Point3D pointB){
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public double getLength(){
        if(length != 0){
            setLength();
        }
        return length;
    }
    private void setLength(){
        int deltaX = pointB.x - pointA.x;
        int deltaY = pointB.y - pointA.y;
        int deltaZ = pointB.z - pointA.z;
        length = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2));
    }

}