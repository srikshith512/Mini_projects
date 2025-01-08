import java.util.*;
public class Main{
    public static void main(String[] args){
       char [][] board  = new char [3][3];
       for( int row = 0; row < board.length; row++){
        for(int col = 0; col < board[row].length;col++){
            board[row][col] = ' ';
        }
       }
       char player = 'X';
       boolean gameOver = false;
       Scanner sc = new Scanner(System.in);
       while(!gameOver){
        display(board);
        System.out.println("Player " + player + " enter:");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if(board[row][col] == ' '){
            board[row][col] = player;
            gameOver = haveWon(board, player);
            if(gameOver){
                System.out.println("Player " + player + " has won");
            }
            else{
                if(player == 'X'){
                    player = 'O';
                }
                else{
                    player = 'X';
                }
            } 
        }
        else{
            System.out.println("Invaid move. Try Again!");
        }
       }
       display(board);
       sc.close(); 
    }
    public static void display(char[][] board){
        for( int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length;col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
           } 
    }
    public static boolean haveWon(char[][] board,char player){
        //check rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player ){
                return true;
            }
        }
        //check cols
        for(int col = 0; col < board.length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player ){
                return true;
        }
        }
        //check diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }    
}