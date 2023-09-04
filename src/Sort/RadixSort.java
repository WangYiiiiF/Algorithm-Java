package Sort;

import static Util.Print.ArrayPrint;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {3,2,2,4,7,1,6,4,1};

        SortProcess(arr, 0, arr.length - 1, maxbits(arr));
        ArrayPrint(arr,0,arr.length);
    }

    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigit(int x, int d){
        return ((x / ((int)Math.pow(10, d - 1))) % 10);
    }

    public static void SortProcess(int[] arr, int l, int r, int digit){   //digit代表最大数的位数
        final int radix = 10;
        int i = 0, j = 0;

        int[] bucket = new int[r-l+1];
        for(int d = 1; d <= digit; d++){

            int[] count = new int[radix]; //生成词频表

            for(i = l;i <= r; i++){
                j = getDigit(arr[i],d);
                count[j]++;
            }

            for(i = 1; i < radix; i++){
                count[i] = count[i] + count[i-1];
            }

            for(i = r; i >= l; i--){
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }

            for(i = l, j = 0; i <= r; i++,j++){
                arr[i] = bucket[j];
            }
        }
    }
}
