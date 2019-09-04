public class NQueens {

   private int N;
   private int [][] board;

    NQueens(int n){
        N = n;
        board = new int [N][N];
    }

    public boolean placeNQueens() throws Exception {
        if (N < 1) {
            throw new Exception();
        }

        if (placeQ(0)){
            printToConsole();
            return true;
        } else {
            return false;
        }
    }

    public boolean placeQ(int row){
        if(row == N)
            return true;

        //iterate through whole board until space is not attacked
        for (int col = 0; col < N; col++){
            if (!isAttacked(row, col)) {
                board[row][col] = 1;
                if (placeQ(row + 1))  //recursion
                    return true;
                board[row][col] = 0; //backtrack: undoes that placeQ
            }
        }
        return false;
    }

    public boolean isAttacked(int row, int col){

        //check col
        for (int i = 0; i < N; i++){
            if(board[i][col] == 1){
                return true;
            }
        }

        //check left diagonal - down
        for (int i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return true;
            }
        }

        //check left diagonal - up
        for (int i = row, j = col; i >= 0  && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return true;
            }
        }

        //check right diagonal = down
        for (int i = row, j = col; i >= 0 && j < N; i--, j++){
            if(board[i][j] == 1){
                return true;
            }
        }

        //check right diagonal - up
        for (int i = row, j = col; i < N && j < N; i++, j++) {
            if (board[i][j]==1)
                return true;
        }

        return false;
    }

    public void printToConsole() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }
    }
}