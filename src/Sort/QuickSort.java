package Sort;

import static Util.Swap.swap;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0,2,4,5,1,3};
        int i;

        SortProcess(arr,0,arr.length-1);

        for(i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void SortProcess(int[] arr, int l, int r){
        if(l<r){

            swap(arr,l+(int)(Math.random()*(r-l+1)),r);

            int[] p = partition(arr,l,r);
            SortProcess(arr,l,p[0]-1); // <区域
            SortProcess(arr,p[1]+1,r); // >区域
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l-1; // < 区右边界
        int more = r;   // > 区左边界
        while(l < more){
            if(arr[l] < arr[r]){    // 当前数 < 划分值
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){  // 当前数 > 划分值
                swap(arr, --more, l);
            }else { // 当前数 = 划分值
                l++;
            }
        }
        swap(arr,more,r);
        return new int[] {less+1,more};
    }

}
