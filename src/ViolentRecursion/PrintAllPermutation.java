package ViolentRecursion;

public class PrintAllPermutation {

    public static void main(String[] args) {
        printAllPermutation("hello");
    }

    public static void printAllPermutation(String str){
        if(str == null || str.isEmpty()){
            return;
        }
        char[] chs = str.toCharArray();
        PrintProcess(chs, 0);
    }

    public static void PrintProcess(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for(int j = i; j < str.length; j++){
            if(!visit[str[j] - 'a']){
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                PrintProcess(str, i + 1);
                swap(str, i, j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        if (i >= 0 && i < str.length && j >= 0 && j < str.length) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        } else {
            System.out.println("无效的索引");
        }
    }

}
