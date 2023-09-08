package ViolentRecursion;

public class PrintAllSubsquences {

    public static void main(String[] args) {
        printAllSubsquences("abcde");
    }

    public static void printAllSubsquences(String str){
        char[] chs = str.toCharArray();
        PrintProcess(chs,0);
    }

    public static void PrintProcess(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        PrintProcess(str,i + 1);
        char tmp = str[i];
        str[i] = 0;
        PrintProcess(str,i + 1);
        str[i] = tmp;
    }
}
