import javax.swing.*;
import java.util.Scanner;

//A上的二元关系R的自反，对称和传递的判断
public class Main {
    public static void main(String[] args) {
        int[] A=new int[100];
        int[][] R=new int[100][100];
        int i=1;
        int max=0,min=0;
        int x=0;
        int y;

        Underline u=new Underline();
        Judge judge=new Judge();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个集合A，中间以空格隔开,输入32767结束输入\n");

        for(int n=0;n<100;n++){
            A[n]=sc.nextInt();

            if(n==0){
                min=A[0];
            }
            if(A[n]==32767) {
                break;
            }
            if(A[n]>=100){
                System.out.println("输入的元素超出范围，请输入1-99以内的元素");
                break;
            }
            if(max<A[n]){
                max=A[n];
            }
            if(min>A[n]){
                min=A[n];
            }
        }

        u.underline();

        System.out.println("请输入A上的关系矩阵R,输入32767输入结束");

        while(true){
            System.out.println("请输入第"+i+"个序偶的第一个元素");
            x=sc.nextInt();//序偶的第一个元素
            System.out.println("请输入第"+i+"个序偶的第二个元素");
            y=sc.nextInt();//序偶的第二个元素

            if(x==32767||y==32767)break;
            Boolean bool=judge.judge_R(x,y,max,A);
            if(bool){
                R[x][y]=1;
                i++;
            }else{
                System.out.println("输入的序偶不在A中！！!");
            }

        }



        u.underline();

        int ZF=judge.judge_ZFAndFZF(R,max,min);
        int DC=judge.judge_DCAndFDC(R,max,min);
        int CD=judge.CD(R,max,min);

        System.out.println(ZF);
        System.out.println(DC);
        System.out.println(CD);

        //判断是否为偏序关系
        if(ZF==1&&DC==3&&CD==1){
            System.out.println("该关系拥有偏序关系");
        }
        if(ZF==2&&DC==3&&CD==1){
                System.out.println("该关系是拟序");
            }
        if(ZF==1&&DC==2&&CD==1){
                System.out.println("该关系是等价关系的");
        }else {
                System.out.println("啥也不是");
            }

}
}
