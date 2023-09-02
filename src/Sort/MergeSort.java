package Sort;

import static Util.Print.ArrayPrint;

public class MergeSort {
    public static void main(String[] args)
    {
        int[] arr = {0,2,4,5,1,3};

        SortProcess(arr,0,arr.length-1);

        ArrayPrint(arr,0,arr.length);
    }

    public static void SortProcess(int[] arr, int l, int r)
    {
        if(l==r){
            return;
        }
        int mid = l + ((r-l)>>1);
        SortProcess(arr,l,mid);
        SortProcess(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int m, int r)
    {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= m){
            help[i++] = arr[p1++];
        }

        while(p2 <= r){
            help[i++] = arr[p2++];
        }

        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
}