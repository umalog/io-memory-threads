package com.company.byteArray;

import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
        int b;
        while ((b = byteArrayInputStream.read()) != -1) {
            System.out.print(b);
        }
        System.out.println("\n_________");
        String text = "Hello, world";
        array1 = text.getBytes();
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(array1);
        while ((b = byteArrayInputStream2.read()) != -1) {
            System.out.print((char) b);
        }
    }
}
