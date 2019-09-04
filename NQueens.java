public class NQueens {

   private int N;
   private int [][]board;

    NQueens(int n){
        N = n;
        board = new int[N][N];
    }

    public boolean placeNQueens() throws Exception {
        if (N < 1) {
            throw new Exception();
        }

        return placeQ(0);
    }

    public boolean isAttacked(int row, int col){

        //check row
        for (int i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        //check left to right diagonal - down
        for (int i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check left to right diagonal - up
        for (int i = row, j = col; i < N  && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public boolean placeQ(int row){
        if(row == N)
            return true;

        //iterate through whole board
        for (int col = 0; col < N; col++){
            if (isAttacked(row, col)) {
                board[row][col] = 1;
                if (placeQ(row + 1))
                    return true;
                board[row][col] = 0; //backtrack
            }
        }
        return false;
    }

    public void printToConsole() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0)
                    System.out.print("___ ");
                else
                    System.out.print("Q ");
            }
        }
        System.out.println();
    }
}