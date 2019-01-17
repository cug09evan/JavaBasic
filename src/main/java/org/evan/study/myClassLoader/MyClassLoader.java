package org.evan.study.myClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by marvel on 2017/9/2.
 * 可以复写两个接口
 *
 * 类的动态加载  类的热加载
 */
public class MyClassLoader extends ClassLoader {
    private String path;    //加载类路径
    private String name;    //类加载器名称

    public MyClassLoader(String name, String path) {
        super();    //让系统加载器成为当前加载器的父加载器
        this.name = name;
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String name, String path) {
        super(parent);
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取文件转成byte数组
        byte[] date = readClassFileToByteArray(name);

        return this.defineClass(name, date, 0, date.length);
    }

    /**
     *
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;

        name = name.replaceAll("\\.", "/");
        String filePath = path + name + ".class";

        File file = new File(filePath);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(file);
            int tem = 0;
            while((tem = is.read()) != -1) {
                os.write(tem);
            }

            returnData = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();     //需要判断流过程是否完成
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return returnData;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
