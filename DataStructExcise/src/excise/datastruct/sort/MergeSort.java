package excise.datastruct.sort;

public class MergeSort {
    /*
    *归并方法将数组中两个已经排序的部分归并成一个
     */

    //将a,b两个有序数组合并为一个新的有序数组
    public static int[] mergeSort(int[] a ,int[] b){
        int lenA=a.length;
        int lenB=b.length;
        int[] c=new int[lenA+lenB];
        int i,m,n;
        i=m=n=0;
        while(m<lenA&&n<lenB){
            if(a[m]<=b[n]){
                c[i++]=a[m++];
            }
            else {
                c[i++]=b[n++];
            }
        }
        while (m>=lenA&&n<lenB){
            c[i++]=b[n++];
        }
        while (n>=lenB&&m<lenA){
            c[i++]=a[m++];
        }
        return c;
    }
    //a数组前后两部分分别有序，归并为一个新的有序数组
    public static int[] mergeSort2(int[] a,int start,int mid,int end){
        int len = a.length;
        int[] b=new int[len];
        int i,j,k;
        i=start;
        k=0;
        j=mid;
        while (i<mid&&j<end){
            if(a[i]<=a[j]){
                b[k++]=a[i++];
            }
            else {
                b[k++]=a[j++];
            }
        }
        while(i<mid){
            b[k++]=a[i++];
        }
        while (j<end){
            b[k++]=a[j++];
        }
        return b;
    }

    /*
    * 归并排序*/

    //自上而下的归并排序，将大数组分为两个小数组
    public static int[] up2DownMergeSort(int[] data){
        int len=data.length;
        MergeSort.up2DownMergeSort(data,0,len);
        return data;
    }
    public static void up2DownMergeSort(int[] data,int start,int end){
        if(end<=1){
            return;
        }
        int len=data.length;
        int mid=(len+1)/2;
        MergeSort.up2DownMergeSort(data,0,mid);
        MergeSort.up2DownMergeSort(data,mid+1,len);
        mergeSort2(data,start,mid,end);
    }

    //自下而上的归并排序，将小数组两两合并一直到最大数组
    public static int[] down2UpMergeSort(int[] data){
        for(int size=1;size<data.length;size+=size){
            for(int s=0;s<data.length-size;s+=size){
                mergeSort2(data,s,s+size,s+size+size-1);
            }
        }
        return data;
    }


}
