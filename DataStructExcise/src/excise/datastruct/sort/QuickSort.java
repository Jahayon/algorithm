package excise.datastruct.sort;
/*
* 快读排序的改进：
*   1.小数组递归调用快排改用插入排序
*   2.取三个元素中大小居中的元素作为基准元素
*   3.对于有大量重复元素的数组，采用三项切分（大于，等于，小于）*/
//快速排序：找一个基准数，比基准数小的在左边，比基准数大的在右边，分别排序
public class QuickSort {
    public static int[] quickSort(int[] data){
        return quickSort(data,0,data.length-1);
    }
    public static int[] quickSort(int[] data,int start,int end) {
        int p=partition(data,start,end);//进行却分后的基准元素的index；
        quickSort(data,start,p);
        quickSort(data,p+1,end);
        return data;
    }
    public static int partition (int[]data,int start,int end){
            int i=start+1;
            int j=end;
            while (i<j-1){
                if(data[i]<=data[start]){i++;}
                if(data[j]>=data[start]){j--;}
                if(data[i]>data[start]&&data[j]<data[start]){
                    int temp=data[i];
                    data[i++]=data[j];
                    data[j++]=temp;
                }

            }
            if(i==j-1){
                int temp=data[i];
                data[i]=data[start];
                data[start]=temp;
                return i;
            }
            return start;
        }

}
