/**
 * @auther plg
 * @date 2019/7/10 14:24
 */
public class User {
    private String usrrname;
    private String password;

    public String getUsrrname() {
        return usrrname;
    }

    public void setUsrrname(String usrrname) {
        this.usrrname = usrrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "usrrname='" + usrrname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
