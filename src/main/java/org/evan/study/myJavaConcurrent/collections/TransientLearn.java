package org.evan.study.myJavaConcurrent.collections;

import org.evan.study.myJavaConcurrent.vo.User;

import java.io.*;

/**
 * Created by marvel on 2017/9/10.
 *@description java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
 * @description  使用transient关键字不序列化某个变量
 * @description 注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 */
public class TransientLearn {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("evan");
        user.setPwd("5201314");

        System.out.println("read before Serilizable");
        System.out.println("username="+user.getUsername());
        System.out.println("pwd="+user.getPwd());

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("E:/user.txt"));
            os.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream("E:/user.txt"));
            user = (User)is.readObject();

            System.out.println("read after Serilizable");
            System.out.println("username="+user.getUsername());
            System.out.println("pwd="+user.getPwd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
