package Data_Structure;
import java.util.HashSet;
import java.util.HashMap;

public class Hashset {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        System.out.println(hashSet.contains(3));
        hashSet.remove(3);
        System.out.println(hashSet.contains(3));

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Wang");
        hashMap.put(2,"Yi");
        hashMap.put(3,"Fan");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(2));
        hashMap.remove(3);
        System.out.println(hashMap.get(3));
    }
}
