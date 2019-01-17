package org.evan.study.myJavaConcurrent.vo;

import java.io.Serializable;

/**
 * Created by marvel on 2017/9/10.
 */
public class User implements Serializable {
    private static  final long serialVersionUID = 8294180014912103005L;

    private String username;
    private transient String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
