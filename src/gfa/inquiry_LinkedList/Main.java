package gfa.inquiry_LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();

        s.add("Abby");
        s.add("Bob");
        s.add("Chris");

        s.print();

        s.add("Joel");
        s.add(10);
        s.print();
    }
}
