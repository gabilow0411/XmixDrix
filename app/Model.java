public class Model {

    private  int[][] board;
    private boolean turn;
    public String weight;

    public  Model()
    {
        turn=true;
        board = new  int[3][3];
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3; j++)
            {
               board[i][j]=0;
            }
        }

    }
    public void changeTurn()
    {
        turn=!turn;
    }
    public boolean win()
    {
        int sum=0;
        int sumR=0;
        for (int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                sum+=board[i][j];
                sumR+=board[j][i];
            }
            if(sum==3 || sumR==6)
                return true;
            if(sum==3 || sumR==6)
                return true;
            sum=0;
        }
        return false;
    }
    public void  update(int row, int colum, int p)
    {
        if(p==1)
        {
            board[row][colum]=1;
            p=2;

        }
        else
        {
            board[row][colum]=2;
            p=1;
        }
    }
}
