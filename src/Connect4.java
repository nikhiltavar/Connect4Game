import java.util.Objects;
import java.util.Scanner;

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

    //Valid Input
    //Taking Input from user
    //returns true id valid otherwise returns false
    private boolean validInput(String input){
        return ((Objects.equals(input,"1") ||
                Objects.equals(input,"2") ||
                Objects.equals(input,"3") ||
                Objects.equals(input,"4") ||
                Objects.equals(input,"5") ||
                Objects.equals(input,"6") ||
                Objects.equals(input,"7")));
    }

    /**
     * Is column full
     * @param column
     * @return true if column full -false otherwise
     */
    private boolean isColumnFull(int column){
        return (board[0][column-1] == " X " || board[0][column-1]== " 0 ");

    }

    /**
     * Get next available slot
     * @param column
     * @return the next available row position od a given column
     */
    private int getnextAvailableSlot(int column){
        int position=5;
        boolean found =false;
        while (position>=0 && !found){
            if (!Objects.equals((board[position][column])," X")&& !Objects.equals(board[position][column]," 0")){

                found = true;
            } else {
                position--;
            }
        }
        return position;
    }

    // Swap turn for current player
    private void swapPlayerTurn() {
        if (playerTurn == 1) {
            playerTurn = 2;
        } else {
            playerTurn = 1;
        }
    }

    private void placePiece() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + playerTurn + " - Please select which column to place your piece(1-7):");
        String input = sc.nextLine();

        while (!validInput(input) || isColumnFull(Integer.parseInt(input))) {
            while (!validInput(input)) {
                System.out.println("Invalid input - please select a column from 1-7");
                input = sc.nextLine();
            }
            while (isColumnFull(Integer.parseInt(input))) {
                System.out.println("Column full, choose another column");
                input = sc.nextLine();
                if (!validInput(input)) {
                    break;
                }
            }
        }
        int columnchoice = Integer.parseInt(input) - 1; //players column choice

        //get available row
        System.out.println("Next available row in column: " + getnextAvailableSlot(columnchoice));

        //place piece
        String pieceToPlace;
        if (playerTurn == 1) {
            pieceToPlace = " X ";
        } else {
            pieceToPlace = " 0 ";
        }
        board[getnextAvailableSlot(columnchoice)][columnchoice] = pieceToPlace;
        displayBoard();
        swapPlayerTurn();
    }










    public static void main(String[] args) {
        Connect4 c4 = new Connect4();
    }
}