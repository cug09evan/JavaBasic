package org.evan.study;

import java.util.List;

/**
 * Created by marvel on 2017/9/2.
 * 1. getClass方法
 */
public class ClassObject {
    List list = null;
    Class clz = list.getClass();

    Class clz2 = List.class;

//    Class clz3 = Class.forName(list.toString());
}
