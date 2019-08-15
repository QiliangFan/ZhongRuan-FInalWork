package com.springboot.health.domain.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 21:41
 */
@Entity
@Table(name = "users")
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String birthday;
    private String headimage;
    private String authority;
    private String phone ;

    public User() {
    }

    public User(String name, String email, String password, String gender, String birthday, String headimage, String authority, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.headimage = headimage;
        this.authority = authority;
        this.phone = phone;
    }

    public User(String email, String password, String gender, String birthday, String headimage, String authority, String phone) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.headimage = headimage;
        this.authority = authority;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", headimage='" + headimage + '\'' +
                ", authority='" + authority + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
