package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */

import java.util.Scanner;

public class Main_PlayChess {

    private static boolean WHITE = true;
    private static boolean BLACK = false;
    public static void main(String[] args) {
        ChessBoard gameBoard = new ChessBoard();
        gameBoard.Set();
        gameBoard.Display();

        Scanner scanner = new Scanner(System.in);  // create a scanner
        String origin;
        String destination;
        do {
            System.out.println("");
            System.out.println("Enter the tile name of the piece you wish to move: "); // prompt the user for values
            origin = scanner.nextLine();// input the values
            System.out.println("Enter the tile name of the destination: "); // prompt the user for values
            destination = scanner.nextLine();// input the values
            gameBoard.MovePiece(origin, destination);
            gameBoard.Display();
        } while (origin != "");
        // gameBoard.mTiles[4][4].setPiece( gameBoard.mTiles[4][6].getPiece());
        // gameBoard.mTiles[4][6].setPiece(new EmptyTile());
    }

}
