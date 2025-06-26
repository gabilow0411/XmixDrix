package gabi.low.class2ex;


import static gabi.low.class2ex.Basics.COLUMNS;
import static gabi.low.class2ex.Basics.ROWS;
import static gabi.low.class2ex.Basics.EMPTY;
public class Model
{
    // 1 Board  - 2D Array
    private int[][] board;

    public int getTurnCounter() {
        return turnCounter;
    }

    private int turnCounter = 0;

    public Model() {
        board = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

     public String checkWin()
    {
        for(int i=0;i<ROWS;i++)
        {
            int sumR=0;
            int sumC=0;
            for(int j=0;j<COLUMNS;j++)
            {
                sumR+=board[i][j];
                sumC+=board[j][i];
            }
            if(sumR==3 || sumC==3)
                return "x";
            if(sumR==30 || sumR==30)
            {
                return "o";
            }
            sumC=0;
            sumR=0;
        }
        int t=0;
        for (int i=0;i<ROWS;i++)
        {
            t+=board[i][i];
        }
        if(t==3)
            return "x";
        if (t==30)
            return "o";
        return "c";
    }
    public String updateBoard (int row, int column)
    {
        String s ="n";
        if (isvalidmove(row,column)) {
            if (turnCounter % 2 == 0) {
                board[row][column] = 1;
                s = "X";
            }
            else
                {
                    board[row][column] = 10;
                    s = "O";
                }

            turnCounter++;
        }
        return s;
    }
    public boolean isvalidmove(int row,int column)
    {
        if (board[row][column]==0)
            return true;
        return false;
    }
    public boolean TIE()
    {
        if (turnCounter==9)
            return true;
        return false;
    }
    public void resetBoard()
    {
        for (int i=0; i<ROWS;i++)
        {
            for (int j=0; j<COLUMNS;j++)
            {
                board[i][j]=0;
            }
        }
    }







    // 2 currentPlayer




}
