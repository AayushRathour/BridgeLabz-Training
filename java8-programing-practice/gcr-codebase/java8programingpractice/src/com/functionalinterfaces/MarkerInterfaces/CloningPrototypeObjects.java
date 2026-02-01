package com.functionalinterfaces.MarkerInterfaces;

class Product implements Cloneable {

    int id;

    Product(int id) {
        this.id = id;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloningPrototypeObjects {
    public static void main(String[] args) throws Exception {

        Product p1 = new Product(101);
        Product p2 = (Product)p1.clone();

        System.out.println(p1.id);
        System.out.println(p2.id);
    }
}
