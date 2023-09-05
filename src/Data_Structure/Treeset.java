package Data_Structure;
import java.util.TreeSet;
import java.util.TreeMap;

public class Treeset {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("b");
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(7,"I'm 7");
        treeMap.put(8,"I'm 8");
        treeMap.put(5,"I'm 5");
        treeMap.put(2,"I'm 2");
        treeMap.put(0,"I'm 0");

        System.out.println(treeMap.containsKey(5));
        System.out.println(treeMap.get(5));
        System.out.println(treeMap.lastEntry());

        System.out.println(treeMap.firstKey() + " is smallest");
        System.out.println(treeMap.lastKey() + " is biggest");


    }


}
