public class User{
    private String name, password;

    public User(String name, String password){
        setName(name);
        setPassword(password);
    }

    public void setName(String name){
        if (name != null) {
            this.name = name;
        }
        return;
    }
    public void setPassword(String pw){
        if (name != null) {
            this.password = pw;
        }
        return;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
}