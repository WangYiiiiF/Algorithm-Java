package XOR;

public class Swap {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,7};
        int i;

        swap(arr,1,3);

        for(i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
