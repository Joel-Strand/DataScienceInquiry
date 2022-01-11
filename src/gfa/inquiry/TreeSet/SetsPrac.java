package gfa.inquiry.TreeSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetsPrac {

    public SetsPrac() {
    }

    public void example1() {
        // Create an instance of TreeSet<String>
        Set<String> data = new HashSet<>();
        // add 3 Strings to it
        data.add("Joel");
        data.add("Owen");
        data.add("Zoma");
        // print them out
        Iterator<String> itr = data.iterator();
        while (itr.hasNext()) {
            String item = itr.next();
            System.out.println(item);
        }

//      shorthand
//      for (String item : data {
//          System.out.println(item);
//      }
    }
}