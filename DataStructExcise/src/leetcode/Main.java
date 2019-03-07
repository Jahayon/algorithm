package leetcode;


public class Main {
    public static void main(String[] args) {
        Molution ss=new Molution();
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{3,4};
        double result=ss.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);


    }
}
class Molution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] num3=new int[(m+n)/2+1];
        int p=0;
        int q=0;
        for(int i=0;i<(m+n)/2+1;i++){
            if(p<m&&q<n){
                if(nums1[p]<=nums2[q]){
                    num3[i]=nums1[p];
                    p++;
                }
                else{
                    num3[i]=nums2[q];
                    q++;
                }
            }else if(p<m&&q==n){
                num3[i]=nums1[p];
                p++;
            }else{
                num3[i]=nums2[q];
                q++;
            }
        }
        if((m+n)%2==0){
            return (double)(num3[(m+n)/2-1]+num3[(m+n)/2])/2;
        }else{
            return (double)num3[(m+n)/2];
        }
    }
}
