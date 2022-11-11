public class Connect4 {



    //Global Variables
    String[][] board;
    Boolean winner;
    Boolean draw;
    int winningPlayer;
    int playerTurn;

    //Constructor
    public Connect4(){
        winningPlayer =0;
        draw = false;
        playerTurn = 1;
        board = new String[6][7];
        newBoard();
        displayBoard();
    }


    private void newBoard(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j]= " - ";
            }
        }
    }

    private void displayBoard(){
        System.out.println(" ");
        System.out.println("*** CONNECT 4 GAME ***");
        System.out.println(" ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Connect4 c4 = new Connect4();
    }
}