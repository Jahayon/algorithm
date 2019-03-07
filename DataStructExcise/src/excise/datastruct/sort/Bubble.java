package excise.datastruct.sort;
//冒泡排序
/*
* 交换相邻元素，使最大元素下沉到最右或者最小元素上浮到最左
* 出现一轮没有发生交换就说明已经排好序了，则不需要进行下一轮*/
public class Bubble {
    public static int[] bubble(int[] data){
        int len=data.length;
        int flag=1;//确保进行一轮
        for(int i=len-1;i>0&&flag==1;i--){
            flag=0;//没有进行交换
            for(int j=0;j<len-1;j++){
                if(data[j]>data[j+1]){
                    flag=1;//发生交换
                    int temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }

        }
        return data;
    }

}
