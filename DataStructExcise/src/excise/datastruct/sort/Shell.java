package excise.datastruct.sort;

import java.util.Arrays;

//希尔排序  https://www.jianshu.com/p/0115a6cadc53
/*
 *分组，组内元素数量从小到大，组内插入排序；
 * 不相邻元素分为一组，而不是相邻元素为一组，使得一次交换减少较多逆序 */
public class Shell {
    public static int[] shell(int[] data) {
        int len = data.length;
        for (int width = 2; width < len; width = width * 2) {
            int h =(len+1)/width;//跨度,组数,注意计算
            for (int i = h; i < len; i++) {
                for (int j = i; j >=h; ) {//注意j的判断
                    if (data[j] < data[j - h]) {
                        int temp = data[j];
                        data[j] = data[j - h];
                        data[j - h] = temp;
                        j = j - h;
                    } else {
                        break;
                    }
                }
            }
            if(width*2>len){
               width=(len+1)/2;
            }
        }
        return data;
    }
}
