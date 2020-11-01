public class Judge {

    public Boolean judge_R(int x, int y, int max, int[] A) {
        int f = 0;
        for (int i = 0; i <= max; i++) {
            if (x == A[i]) {
                f++;
                break;
            }
        }
        for (int j = 0; j <= max; j++) {
            if (y == A[j]) {
                f++;
                break;
            }
        }
        if (f == 2)
            return true;
        return false;
    }

    //自反性的判断：关系R是自反的，当且仅当关系R的矩阵的主对角线都为1
    //反自反的判断：关系R是反自反的，当且仅当关系R的矩阵的主对角线都为0
    //注：空集既有自反性又有反自反性
    public int judge_ZFAndFZF(int[][] R, int max,int min) {
        //1表示自反性，2表示反自反性，3表示既没有自反性也没有反自反性，4表示既具有自反性又具有反自反性（空关系）
        int sum = 0;

        if (max == 0) return 4;

        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {
                if (i == j && R[i][j] == 1) {
                    sum++;
                }
            }
        }
        if (sum == max) return 1;
        if (sum == 0) return 2;
        else return 3;
    }

    //判断对称：关系R是对称的，当且仅当其关系矩阵关于主对角线对称
    //判断反对称：关系R是反对称的，当且仅当其关系矩阵中关于主对角线对称的元素不同时为1
    //注：空集既是对称的，也是反对称的

    public int judge_DCAndFDC(int[][] R, int max,int min) {
        int sum = 0;
        int flag = 0;
        int i, j;
        int t = 0;

        if (max == 0) return 1;//既是对称又是反对称

        for (i = min; i < max; i++) {
            for (j = min; j < max; j++) {
                if (R[i][j] != R[j][i])
                    flag = 1;
                if (i != j)
                    sum++;
            }
        }

        if (sum > 0 && flag == 0) return 2;//对称的
        else {
            for (i = min; i < max; i++) {
                for (j = min; j < max; j++) {
                    if (i != j)
                        t += R[i][j] * R[j][i];
                }
            }
        }
        if (t == 0) return 3;//反对称
        else if (t > 0) return 4;//既不是对称，也不是反对称
        return 0;
    }

    //判断传递性：当R[i][j]==1且R[j][k]==1时则R[i][k]==1时有传递性
    public int CD(int[][] R, int max,int min) {

        int i=0,j=0,k=0,flag=0;
        for(i=min;i<=max;i++){
            for(j=min;j<=max;j++){
                for(k=min;k<=max;k++){
                    if(R[i][j]==1&&R[j][k]==1){
                        if(R[i][k]!=1)return 0;
                        else {
                            flag=1;
                        }
                    }
                }

            }
        }

        if(flag==1)return 1;
        return 0;
}
}
