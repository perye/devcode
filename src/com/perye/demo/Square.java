package com.perye.demo;

/**
 * 正方形，继承矩形
 *
 * @author perye
 */
public class Square extends Rectangle {


    /**
     * 设置正方形的边长
     *
     * @param length
     */
    public Square(int length) {
        super(length, length);
    }

}
