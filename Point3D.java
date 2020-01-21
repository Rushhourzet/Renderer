public class Point3D<T>{
    public T x, y, z;
    public Point3D(){}
    public Point3D(T x, T y){
        this.x = x;
        this.y = y;
    }
    public Point3D(T x, T y, T z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static Point3D<Integer> NULL_INT(){
        return new Point3D<Integer>(0,0,0);
    }
    public static Point3D<Double> NULL_DOUBLE(){
        return new Point3D<Double>(0.0,0.0,0.0);
    }
}