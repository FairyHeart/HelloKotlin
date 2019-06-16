package com.java;

import com.kotlin.MyFile;
import com.kotlin.itf.IOrderServcie;
import com.kotlin.itf.Order;

public class 默认函数 {
    public static final void main(String[] args) {
//        Person p = new Person("name");

//        System.out.println(p.getAge());

        MyFile myFile = new MyFile();
        myFile.setVersion("1.1");

        Order order = new Order("xx");
        order.confirmOrder("xx");
        order.confirmOrder();

        IOrderServcie iorder = new Order("x");
        iorder.confirmOrder("xx");
    }
}
