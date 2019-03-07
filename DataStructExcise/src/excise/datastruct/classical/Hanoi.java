package excise.datastruct.classical;

//汉诺塔问题（递归）将A中的碟子转移到C上，B为过渡，2^n-1此交换
public class Hanoi {
    public static void hanoi(int n,char A,char B,char C){
        if(n==1){
            System.out.println("将"+A+"最上面的盘子转移到"+C);
            return;
        }
        hanoi(n-1,A,C,B);//数目，来源，过渡，目的
        hanoi(1,A,B,C);
        hanoi(n-1,B,A,C);
    }

    public static void main(String[] args){
        System.out.println("汉诺塔实验过程");
        System.out.println("4个盘子");
        Hanoi.hanoi(4,'A','B','C');
    }
}
