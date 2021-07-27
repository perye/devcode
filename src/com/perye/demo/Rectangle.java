package com.perye.demo;

/**
 * 矩形
 * 封装案例
 * @author perye
 */
public class Rectangle {

    /**
     * 长度
     */
    private int length;

    /**
     * 宽度
     */
    private int width;

    /**
     * 设置矩形的长度和宽度
     * @param length
     * @param width
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }


    /**
     * 获得矩形面积
     * @return
     */
    public int getArea() {
        return this.length * this.width;
    }

}
