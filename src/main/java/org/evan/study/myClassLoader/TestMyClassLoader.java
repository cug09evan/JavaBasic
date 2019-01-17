package org.evan.study.myClassLoader;

/**
 * Created by marvel on 2017/9/2.
 */
public class TestMyClassLoader {

    public static void main(String[] args) throws Exception {

        MyClassLoader loader1  = new MyClassLoader("loader1", "E:/tem/a/");

        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2", "E:/tem/b/");     //父类为MyClassLoader1

        MyClassLoader loader3 = new MyClassLoader(null, "load3", "E:/tem/c/");      //父类为Bootstrap ClassLoader

        Class clazz = loader2.loadClass("com.evan.Demo");

        clazz.newInstance();    //相当于Demo demo = new Demo()

    }
}
