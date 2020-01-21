public class Vector3<T>{
    public T x, y, z;
    public Vector3(){}
    public Vector3(T x, T y){
        this.x = x;
        this.y = y;
    }
    public Vector3(T x, T y, T z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}