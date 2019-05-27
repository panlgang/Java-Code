package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/5/26 17:49
 */
public class Contacts {
    private String name;
    private String id;
    private String gender;
    private String phone;
    private String email;
    private String adders;
    public Contacts(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdders(String adders) {
        this.adders = adders;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", adders='" + adders + '\'' +
                '}';
    }
}
