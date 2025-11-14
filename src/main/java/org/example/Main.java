package org.example;

public class Main {
    public static void main(String[] args) {
        NewStringBuilder msb = new NewStringBuilder("Пример");
        System.out.println(msb);

        msb.append(" снапшота");
        System.out.println(msb);

        msb.delete(6, 15);
        System.out.println(msb);

        msb.undo();
        System.out.println(msb);

        msb.undo();
        System.out.println(msb);

        msb.undo();
        System.out.println(msb);
    }
}