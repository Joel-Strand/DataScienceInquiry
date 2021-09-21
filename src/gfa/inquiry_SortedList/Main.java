package gfa.inquiry_SortedList;

public class Main {
    public static void main(String[] args) {
        SortedList s = new SortedList();

        s.add("Abba");
        s.add("a");

        System.out.println(s);
        s.clear();
        System.out.println(s);

        s.add("Alex");
        System.out.println(s);

    }
}
