package excise.datastruct.classical;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

//统计一个数组中和为 0 的三元组数量
public class ThreeSum {

    /*
    * 方法一：一般方法，列举三个数判断是否和为0，效率低
    * */
    public static int threeSum1(int[] data){
        int len=data.length;
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(data[i]+data[j]+data[k]==0){
                        System.out.print(data[i]+" "+data[j]+" "+data[k]);
                        count++;
                        System.out.println();
                    }
                }
            }
        }
        return count;
    }

    /*
    * 方法二：将数组进行排序，先求两个数的和，再用二分法求数组中是否有相反数（）数组不可以有重复元素
    * */
    public static int threeSum2(int[] data){
        Arrays.sort(data);
//
        int len=data.length;
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int sum=data[i]+data[j];
                int target=-sum;
                if(binarySearch(target,data)>j){
                    // 应该注意这里的下标必须大于 j，否则会重复统计。
                    count++;
                    System.out.println(data[i]+" "+data[j]+" "+target);
                }
            }
        }
        return count;
    }
    public static int binarySearch(int e,int[] data){

        //返回e在数组data中的下表index
        int low=0;
        int high=data.length-1;
        int index=0;
        while(low <= high){//注意这里的小于等于号，错误总是出现在细节
            int m=low+(high-low+1)/2;
            if(data[m]==e){
                index=m;
            }
            if(data[m]>=e){
                high=m-1;
            }
            else{
                low=m+1;
            }
        }
        return index;
    }

    /*
    * 方法三：将数组排序，然后双指针法,数组可以有重复元素
    * 效率最高*/
    public static int threeSum3(int[] data){
        Arrays.sort(data);
        int count=0;
        for(int n=0;n<data.length;n++){
            int target=-data[n];
            int low=n;int high =data.length-1;
            while (low<high){
                int sum=data[low]+data[high];
                if(sum==target){
                    count++;
                    System.out.println(data[low]+" "+data[high]+" "+data[n]);
                    while(data[low]==data[low+1]){low++;}
                    while(data[high]==data[high-1]){high--;}
                    low++;
                    high--;
                }
                if(sum<target){
                    //说明两数之和偏小，而数组是经过排序的
                    low++;
                }
                else{high--;}
            }

        }
        return count;
    }
    public static void main(String[] args){
        int[] testData={7,3,-1,9,0,12,-9,10,-10,5,6,1};//测试数据

        //System.out.println("方法一："+ThreeSum.threeSum1(testData)+"组");
        //System.out.println("方法二："+ThreeSum.threeSum2(testData)+"组");
        System.out.println("方法三："+ThreeSum.threeSum3(testData)+"组");

    }

}

