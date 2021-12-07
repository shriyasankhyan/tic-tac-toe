package TicTacToe;

import java.util.*;

public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
//        As tic-tac-toe board has 3 rows and 3 columns separated by 2 lines in between.
        char [][] gameBoard = {{'1', '|' , '2', '|','3'}
                ,{'-', '+' , '-', '+','-'},
                {'4', '|' , '5', '|','6'},
                {'-', '+' , '-', '+','-'},
                {'7', '|' , '8', '|','9'}};
        printGameBoard(gameBoard);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Type the position of the number you want to place your number in. ");
            int playerPosition = sc.nextInt();
            while( playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)){
                System.out.println("Position taken ! Enter a correct position.");
                playerPosition = sc.nextInt();
            }
            placePiece(gameBoard,playerPosition,"player");
            if(checkWinner(gameBoard)!=null){
                System.out.println(checkWinner((gameBoard)));
                break;
            }

            Random rd = new Random();
//         As rd.nextInt(9) generates numbers 0-8. So +1 is used.
            int cpuPosition = rd.nextInt(9)+1;
            while( playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)){
//                Message for cpu is not needed.
//                System.out.println("Position taken ! Enter a correct position.");
                cpuPosition = rd.nextInt(9)+1;
            }
            placePiece(gameBoard,cpuPosition,"cpu");
            printGameBoard(gameBoard);
            if(checkWinner(gameBoard)!= null){
                System.out.println(checkWinner(gameBoard));
                break;
            }

        }
    }
    public static void printGameBoard(char [][] gameBoard){
        for(char[] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][]gameBoard, int position , String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
        }
        switch (position) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }
    }
    public static String checkWinner(char[][] gameBoard){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List lastRow = Arrays.asList(7,8,9);
        List leftColumn = Arrays.asList(1,4,7);
        List midColumn = Arrays.asList(2,5,8);
        List lastColumn = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(3,5,7);
        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(lastRow);
        winning.add(leftColumn);
        winning.add(midColumn);
        winning.add(lastColumn);
        winning.add(diagonal1);
        winning.add(diagonal2);
        for(List l : winning ){
            if(playerPositions.containsAll(l)){
                return " Congratulations !! you won :) .";
            }
            else if(cpuPositions.containsAll(l)){
                return "CPU wins! Sorry :(";
            }
            else if(playerPositions.size() + cpuPositions.size()== 9){
                return "It is a tie.  -_- "  ;
            }
        }
        return null;
    }
}
