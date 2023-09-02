package Sort;

import static Util.Print.ArrayPrint;
import static Util.Swap.swap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3,2,2,4,7,1,6,4,1};

        SortProcess(arr, 0, arr.length-1);
        ArrayPrint(arr,0,arr.length);
    }

    public static void SortProcess(int[] arr, int l, int r){
        if(r>l){
            int[] help = new int[r-l+1];
            int i, tempSize, heapSize = 0;

            //转换为大根堆
            for(i = l; i < (r + 1); i++){
                Insert(help, arr[i], heapSize);
                heapSize++;
            }

            tempSize = heapSize;

            for(i = 0; i < tempSize; i++){
                Remove(help,0,heapSize);
                heapSize--;
            }

            for(i=l; i< r+1; i++){
                arr[i] = help[i];
            }
        }

    }

    public static void Insert(int[] arr, int num, int heapSize){
        arr[heapSize] = num;
        heapInsert(arr,heapSize);
    }

    public static void Remove(int[] arr, int index, int heapSize){
        if(index < heapSize){
            swap(arr,index,heapSize-1);
            heapSize--;
            heapify(arr,index,heapSize);
        }
    }


    //将index位置的数向上移动
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,((index-1)/2));
            index = (index-1)/2;
        }
    }

    //将index位置的数向下移动
    public static void heapify(int[] arr, int index, int heapSize){
        int leftcIn = index * 2 + 1;   //左子位置
        int rightcIn = leftcIn + 1;     //右子位置

        int largestIn;

        while(leftcIn < heapSize){
            largestIn = rightcIn < heapSize && arr[rightcIn] > arr[leftcIn] ? rightcIn : leftcIn;
            largestIn = arr[index] > arr[largestIn] ? index : largestIn;

            if(largestIn == index)
                break;

            swap(arr,largestIn,index);
            index = largestIn;
            leftcIn = index * 2 + 1;
            rightcIn = leftcIn + 1;
        }

    }
}
