package TicTacToe1;

import java.util.Scanner;

public class TicTacToe {
    private Player player1,player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe t=new TicTacToe();
        t.startGame();
    }

    public void startGame(){
        Scanner s=new Scanner(System.in);
        // Player input
        player1=takePlayerInput(1);
        player2=takePlayerInput(2);
        while(player1.getSymbol()==player2.getSymbol()){   //jabtak both have same Symbol
           System.out.println("Symbol already taken !! Pick Another Symbol !!");
           char symbol=s.next().charAt(0);
           player2.setSymbol(symbol);
        }
        //create board
        board=new Board(player1.getSymbol(), player2.getSymbol());
        // Conduct game
        boolean player1Turn=true;
        int status=Board.INCOMPLETE;
        while (status==Board.INCOMPLETE || status==Board.INVALID) {  //while game is incomplete and move is invalid
            if (player1Turn) {
                System.out.println("Player 1 - "+player1.getName()+" 's turn");
                System.out.println("Enter x: ");  //x coordinate
                int x=s.nextInt();
                System.out.println("Enter y: ");  // y coordinate
                int y=s.nextInt();
                status =board.move(player1.getSymbol(),x,y); //it decide if move is right, win, lose,draw and if is is valid or not...in short ye move chalata hai
                if(status!=Board.INVALID){  //static variable is common for class so called by class name
                    player1Turn=false;   //means 1st ko chance ho gyi
                    board.print();
                }
                else{
                    System.out.println("INVALID MOVE !! TRY AGAIN");
                }    
            }
            else{
                System.out.println("Player 2 - "+player2.getName()+" 's turn");
                System.out.println("Enter x: ");  //x coordinate
                int x=s.nextInt();
                System.out.println("Enter y: ");  // y coordinate
                int y=s.nextInt();
                status =board.move(player2.getSymbol(),x,y); //it decide if move is right, win, lose,draw and if is is valid or not...in short ye move chalata hai
                if(status!=Board.INVALID){  //static variable is common for class so called by class name
                    player1Turn=true;   //so that again player 1 chance come
                    board.print();
                }
                else{
                    System.out.println("INVALID MOVE !! TRY AGAIN");
                }  
            }
        }
        if (status == Board.PLAYER_1_WINS) {
            System.out.println("Player 1- "+ player1.getName()+ " wins !!");
        }
        else if (status == Board.PLAYER_2_WINS) {
            System.out.println("Player 2- "+ player2.getName()+ " wins !!");
        }
        else{
            System.out.println("it's a draw !!");
        }
    }

    private Player takePlayerInput(int num){  //num is konsa player..first or second
        Scanner s=new Scanner(System.in);
        System.out.println(" Enter Player "+num+" name: ");  //player name
        String name=s.nextLine();
        System.out.println(" Enter Player "+num+" Symbol: "); //player symbol
        char symbol=s.next().charAt(0);
        Player p=new Player(name, symbol);
        return p;
    }
}
