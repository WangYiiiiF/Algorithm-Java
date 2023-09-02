package Data_Structure;

import static Util.Swap.swap;
import static Util.Print.ArrayPrint;
public class Heap {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0};
        int heapSize=10;

        Remove(arr,4,heapSize);
        heapSize--;
        ArrayPrint(arr,0,heapSize);

        Insert(arr,5,heapSize);
        heapSize++;
        ArrayPrint(arr,0,heapSize);
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
