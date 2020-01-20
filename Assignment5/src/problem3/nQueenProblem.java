package problem3;

public class nQueenProblem {
    private int number0 = 0, number1 = 1;

    /**
     * Verify that queen can be place horizontal, vertical,and diagonal on the board
     *
     * @param board the first {@code int[][]} to verification the queen place
     *        board array contain number of Integer  
     * @param nQueenArray the second {@code int[]} to verification the queen place
     *        nQueenArray array contain number of Integer which define the Queen place        
     * @param row the third {@code int} to verification the queen place  
     * @param column the fourth {@code int} to verification the queen place       
     * @param dimention the fifth {@code int} to verification the queen place        
     * 
     * @return boolean value 
     */
    public boolean checkNQueen(int board[][], int nQueenArray[], int row, int coloumn, int dimention) {

        //check the queen in row and column
        for (int i = number0; i < dimention; i++)
            if (board[row][i] == number1 || board[i][coloumn] == number1)
                return false;

        //check the queen in left upper diagonal
        for (int i = row, j = coloumn; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == number1 || board[i][j] == number1)
                return false;

      //check the queen in right upper diagonal
        for (int i = row, j = coloumn; i >= 0 && j < dimention; i--, j++)
            if (board[i][j] == number1 || board[i][j] == number1)
                return false;

        return true;
    }

    /**
     * Place the queen on the board
     *
     * @param board the first {@code int[][]} to Place the queen on the board
     *        board array contain number of Integer  
     * @param nQueenArray the second {@code int[]} to Place the queen on the board
     *        nQueenArray array contain number of Integer which define the Queen place        
     * @param row the third {@code int} to Place the queen on the board      
     * @param dimention the fourth {@code int} to Place the queen on the board        
     * 
     * @return boolean value 
     */
    public boolean nQueenPlace(int board[][], int nQueenArray[], int row, int dimention) {
        if (row == dimention) 
            return true;
        
        for (int i = number0; i < dimention; i++) {
            if (checkNQueen(board, nQueenArray, row, i, dimention)) {

                //place the queen on board
                board[row][i] = number1;
                //Queen position store in array
                nQueenArray[row] = i;

                if (nQueenPlace(board, nQueenArray, row + number1, dimention))
                    return true;

                board[row][i] = number0;
            }
        }
        return false;
    }

    /**
     * Initialize the board with zero element 
     *    
     * @param dimention the first {@code int} to Initialize the board        
     * 
     * @return Integer array  
     */
    public int[] setNQueenBoard(int dimention) {
        int board[][] = new int[dimention][dimention];
        int nQueenArray[] = new int[dimention];

        for (int i = number0; i < dimention; i++)
            for (int j = number0; j < dimention; j++)
                board[i][j] = number0;

        if (nQueenPlace(board, nQueenArray, number0, dimention) == false) 
            return new int[] { -number1 };

        return nQueenArray;
    }
}
