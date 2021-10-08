package gfa.inquiry.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();

        d.add("Joel");
        d.add("Abby");
        d.add(10.0);
        d.add("S");

        System.out.println(d);
        System.out.println(d.get(3));

        d.add(1, "Tony");
        System.out.println(d);

    }
}
