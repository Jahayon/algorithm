package excise.datastruct.sort;
//选择排序
/*
* 从剩下的元素中选择最小的元素放在前面已经排好顺序的最后*/
public class Selection {
    public static int[] selection(int[] data){
        int len = data.length;
        for(int i =0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(data[j]<data[i]){
                    int temp =data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }
        return data;
    }
}
