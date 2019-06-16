package com.java;

import java.io.IOException;

/**
 * @author: Guazi.
 * @date : 2019/6/13.
 */
public class 异常 {

    public static void main(String[] args) {
        Appendable sb = new StringBuffer();
        try {
            sb.append("x");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
