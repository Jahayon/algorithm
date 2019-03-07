package excise.datastruct.sort;
//堆排序(选择排序的改进)
/*
* 将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。
* 将它移走(其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值)，
* 然后将剩余的n-1个序列重新构造成一个堆
* 不适用数组索引为0的位置
* */
public class HeapSort {
    public static int[] heapSort(int[] data){
        for(int i =data.length/2;i>=0;i--){
            heap(data,i,data.length);
        }
        for(int i=data.length-1;i>=0;i--){
            int temp=data[0];
            data[0]=data[i];
            data[i]=temp;
            heap(data,0,i);
        }
        return data;
    }

    //将待排序的数组构建为一个大根堆，node是根节点，len是数组长度
    public static int[] heap(int[] data,int node,int len){
        int child=leftChild(node);//较大孩子的索引
        for(int father=data[node];leftChild(node)<len;node=child){
            //保证child是较大的孩子
            if(data[leftChild(node)]<data[leftChild(node)+1]){
                child++;
            }
            //若父节点比孩子小，则和孩子交换
            if(father<data[child]){
                int temp=data[node];
                data[node]=data[child];
                data[child]=temp;
            }
            else {break;}//不需要调整
        }
        return data;
    }
    public static int leftChild(int f){
        return f*2+1;//这里数组第0位作为有效位，也可以不作为有效位，更能体现父子关系
    }
}
