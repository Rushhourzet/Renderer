public class Camera{
//________________________________________Data_Fields____________________________________
    private final double SCALE = 1.0;
    double X, Y, Z, x, y, z, scale;
    Point3D<Double> globalTransform, localTransform, rot; 
    Point2D<Double> sensorSize, offset, resolution;
    private double focalPoint, skew;
//_______________________________________Constructor_____________________________________________
    public Camera(){
        scale = SCALE;
    }
    public Camera(double X, double Y, double Z){
        setXYZ(X,Y,Z);
        this.x = X;
        this.y = Y;
        this.z = Z;
        scale = SCALE;
    }
    public Camera(Point3D<Integer> p){
        setXYZ(p.x,p.y,p.z);
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
        scale = SCALE;
    }

    public Point3D<Double> getXYZ(){
        return new Point3D<Double>(X,Y,Z);
    }
    public void setXYZ(double x, double y, double z){
        X = x;
        Y = y;
        Z = z;
    }
    public void setXYZ( Point3D<Double> p){
        X = p.x;
        Y = p.y;
        Z = p.z;
    }
//______________________________________Camera_Math_____________________________________________
    
    
    /* 
    private void GlobalTransform(){
        scale = 1*-globalTransform.x+1*-globalTransform.y+1*globalTransform.z+1;
    } 
    private void RotateZ(){
        x = X * Cos(rot.z) + X * -Sin(rot.z);
        y = Y * Sin(rot.z) + Y * Cos(rot.z);
    }
    private void RotateY(){
        x = x * Cos(rot.y) + x * Sin(rot.y);
        z = z * -Sin(rot.y) + z * Cos(rot.y);
    }
    private void RotateX(){
        y = y * Cos(rot.x) + y * -Sin(rot.x);
        z = z * Sin(rot.x) + z * Cos(rot.x);
    }
    public void OrthogonalProjection(){
        GlobalTransform();
        RotateZ();
        RotateY();
        RotateX();
        x = x * (resolution.x) / (2 * sensorSize.x);
        y = y * (resolution.y) / (2 * sensorSize.y);
    }
    public void PerspectiveProjection(){
        OrthogonalProjection();
        x = x * (1/z);
        y = y * (1/z);
    }
    */
}