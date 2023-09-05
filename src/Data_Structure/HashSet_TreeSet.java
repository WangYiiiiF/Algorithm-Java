package Data_Structure;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSet_TreeSet {

    public static void main(String[] args) {
        System.out.println("===========HashSet===========");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        System.out.println(hashSet.contains(3));
        hashSet.remove(3);
        System.out.println(hashSet.contains(3));
        System.out.println("===========HashMap===========");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Wang");
        hashMap.put(2,"Yi");
        hashMap.put(3,"Fan");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(2));
        hashMap.remove(3);
        System.out.println(hashMap.get(3));
        System.out.println("===========TreeSet===========");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("b");
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println("===========TreeMap===========");
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
