package gfa.inquiry_LinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();

        d.add(10);
        d.add(19);
        d.add(15);

        String s = d.toString();
        System.out.println(s);
    }
}
