package com.perye.demo;

/**
 * 多态
 * 需满足三个条件
 * 1、有类继承或者接口实现
 * 2、子类要重写父类的方法
 * 3、父类的引用指向子类对象
 * @author perye
 */
public class Parent {

    public void call() {
        System.out.println("I'm parent");
    }

    // 有类继承或者接口实现
    public static class Son extends Parent {
        // 子类要重写父类的方法
        @Override
        public void call() {
            System.out.println("I'm Son");
        }
    }

    // 有类继承或者接口实现
    public static class Daughter extends Parent {
        // 子类要重写父类的方法
        @Override
        public void call() {
            System.out.println("I'm Daughter");
        }
    }

    public static class Test {
        public static void main(String[] args) {
            // 3、父类的引用指向子类对象
            Parent parent = new Son();
            parent.call();
            // 3、父类的引用指向子类对象
            Parent parent1 = new Daughter();
            parent1.call();
        }
    }






}
