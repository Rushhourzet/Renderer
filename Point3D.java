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
}