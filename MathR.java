public class MathR{
    public static Point2D<Double> Project3Dto2D(Point3D<Integer> cameraPosition, Point3D<Integer> pointPosition, Point3D<Double> rot){
        double X = pointPosition.x - cameraPosition.x;
        double Y = pointPosition.y - cameraPosition.y;
        double Z = pointPosition.z - cameraPosition.z;
        double x, y, z, _x, _y;
        Point3D<Double> surfacePos = new Point3D<Double>(1.0, 0.0, 0.0);
        x = Cos(rot.y) * (Sin(rot.z) * Y + Cos(rot.z) * X) - Sin(rot.y) * Z;
        y = Sin(rot.x) * (Cos(rot.y) * Z + Sin(rot.y) * (Sin(rot.z) * Y + Cos(rot.z) * X)) + Cos(rot.x) * (Cos(rot.z) * Y - Sin(rot.z) * X);
        z = Cos(rot.x) * (Cos(rot.y) * Z + Sin(rot.y) * (Sin(rot.z) * Y + Cos(rot.z) * X)) - Sin(rot.x) * (Cos(rot.z) * Y - Sin(rot.z) * X);
        _x = (surfacePos.z / z) * x + surfacePos.x;
        _y = (surfacePos.z / z) * y + surfacePos.y;
        return new Point2D<Double>(_x, _y);
    }
    private static double Cos(double num){
        return Math.cos(num);
    }
    private static double Sin(double num){
        return Math.sin(num);
    }
}