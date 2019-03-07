package excise.datastruct.sort;
//插入排序
/*
* 将当前元素插入到左侧已经排好序的元素中并且任然保持有序，交换次数使逆序的次数*/
public class Insertion {
    public static int[] insertion(int[] data){
        int len=data.length;
        for(int i=1;i<len;i++){
            for(int j=i;j>0;){
                if(data[j]<data[j-1]){
                    int temp=data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                    j--;
                }
                else {
                    break;
                }
            }
        }
        return data;
    }
}
