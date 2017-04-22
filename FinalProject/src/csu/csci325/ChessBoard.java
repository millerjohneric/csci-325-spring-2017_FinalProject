package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessBoard {
    // white on right bottom corner
    // left to right is a to h
    // back to front is 8 to 1
    private static int SIDELENGTH = 8;
    private static int WHITE = 1;
    private static int BLACK = 0;
    public static Tile[][] mTiles;
    public static Tile[] mBlackOffBoard;
    public static Tile[] mWhiteOffBoard;
    private int[] mOrigin;
    private int[] mDestination;

    private static GUI mGUI;
    public ChessBoard(){
        mTiles = new Tile[SIDELENGTH][SIDELENGTH];
        mBlackOffBoard = new Tile[16];
        mWhiteOffBoard = new Tile[16];
        mOrigin = new int[2];
        mDestination = new int [2];
        int result;
        mOrigin[0] = 9;
        mOrigin[1] = 9;
        GUI vivid = new GUI();
        for (int backToFront = 0; backToFront < SIDELENGTH; backToFront++) {
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
                mTiles[leftToRight][backToFront] = new Tile();
                if (leftToRight % 2 == 0 && backToFront % 2 == 0) {
                    result = mTiles[leftToRight][backToFront].setColor(WHITE);
                }else if (leftToRight % 2 == 0 && backToFront % 2 != 0) {
                    result = mTiles[leftToRight][backToFront].setColor(BLACK);
                }else if (leftToRight % 2 != 0 && backToFront % 2 != 0) {
                    result = mTiles[leftToRight][backToFront].setColor(WHITE);
                } else {
                    result = mTiles[leftToRight][backToFront].setColor(BLACK);
                }
            }
        }

    }

    public boolean Set(){
        mTiles[0][7].setPiece(new Rook(WHITE));
        mTiles[1][7].setPiece(new Knight(WHITE));
        mTiles[2][7].setPiece(new Bishop(WHITE));
        mTiles[3][7].setPiece(new King(WHITE));
        mTiles[4][7].setPiece(new Queen(WHITE));
        mTiles[5][7].setPiece(new Bishop(WHITE));
        mTiles[6][7].setPiece(new Knight(WHITE));
        mTiles[7][7].setPiece(new Rook(WHITE));
        // set white pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
            mTiles[leftToRight][6].setPiece(new Pawn(WHITE));
        }
        for (int backToFront = 2; backToFront < SIDELENGTH-2; backToFront++) {
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
                mTiles[leftToRight][backToFront].setPiece(new EmptyTile());
            }
        }

        // set black pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
            mTiles[leftToRight][1].setPiece(new Pawn(BLACK));
        }
        mTiles[0][0].setPiece(new Rook(BLACK));
        mTiles[1][0].setPiece(new Knight(BLACK));
        mTiles[2][0].setPiece(new Bishop(BLACK));
        mTiles[3][0].setPiece(new Queen(BLACK));
        mTiles[4][0].setPiece(new King(BLACK));
        mTiles[5][0].setPiece(new Bishop(BLACK));
        mTiles[6][0].setPiece(new Knight(BLACK));
        mTiles[7][0].setPiece(new Rook(BLACK));
        return false;
    }
    public boolean Clear(){

        return false;
    }
    public void VividDisplay(){
        mGUI.CreateBoard();
        mGUI.SetThis(mGUI.bbishop,600,400);
    }
    public void Display(){
        //tiles = new Tile[SIDELENGTH][SIDELENGTH];
        for (int backToFront = 0; backToFront < SIDELENGTH; backToFront++){
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print("______________________");

            }
            System.out.println("");
            /*
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print("|");
                System.out.print(mTiles[leftToRight][backToFront].toString());
            }
            System.out.print( "|");

            System.out.println("");
            */
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|");//                     ");
                System.out.print(mTiles[leftToRight][backToFront].toString());
            }
            System.out.print( "|");
            System.out.println("");
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                int temp = 97 + leftToRight;
                int temp2 = 1 + backToFront;
                Character.toString((char) temp);
                System.out.print( "|" + Character.toString((char) temp) + temp2 +
                         "     " + mTiles[leftToRight][backToFront].getPiece().toString() + " ");
            }
            System.out.print( "|");
            System.out.println("");
            /*
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|");//                     ");
                System.out.print(mTiles[leftToRight][backToFront].toString());
            }
            System.out.print( "|");
            System.out.println("");
            */
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|");//                     ");
                System.out.print(mTiles[leftToRight][backToFront].toString());
            }
            System.out.print( "|");
            System.out.println("");
        }
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
            System.out.print("______________________");

        }
        //this.VividDisplay();
    }


    public int MovePiece(String origin, String destination){
        System.out.println("Move Piece");
        if (ValidateMove(origin, destination)){
            if (KilledOpponent(mTiles[mOrigin[0]][mOrigin[1]].getPiece(),mTiles[mDestination[0]][mDestination[1]].getPiece())== true){

            }
            mTiles[mDestination[0]][mDestination[1]].setPiece( mTiles[mOrigin[0]][mOrigin[1]].getPiece());
            mTiles[mOrigin[0]][mOrigin[1]].setPiece(new EmptyTile());

        }
        return 0;
    }
    private boolean ParseLocation(String location, int[] coord){
        String subString;
        location = location.toLowerCase();
        char alpha = location.charAt(0);
        char num = location.charAt(1);
        int yValue =num - 48;
        int xValue =alpha - 97;
        coord[0] =xValue;

        //System.out.println(location);
        //System.out.println(xValue + " " + yValue);
        switch (yValue){
            case 1:
                coord[1] = 0;
                break;
            case 2:
                coord[1] = 1;
                break;
            case 3:
                coord[1] = 2;
                break;
            case 4:
                coord[1] = 3;
                break;
            case 5:
                coord[1] = 4;
                break;
            case 6:
                coord[1] = 5;
                break;
            case 7:
                coord[1] = 6;
                break;
            case 8:
                coord[1] = 7;
                break;
            default:
                return false;
        }
        return true;
    }
    private boolean ValidateMove(String origin, String destination){
        ParseLocation(origin,mOrigin);
        // System.out.println(mOrigin[0] + " " + mOrigin[1]);
        ParseLocation(destination,mDestination);
        System.out.println("about to validate CanMove");
       // System.out.println(mTiles[mOrigin[0]][mOrigin[1]].getPiece().CanMove(mOrigin, mDestination, mTiles));
       if ( mTiles[mOrigin[0]][mOrigin[1]].getPiece().CanMove(mOrigin, mDestination, mTiles) == true){
           System.out.println("can move");
           return true;
       }
        return false;
    }
    private boolean KilledOpponent(ChessPiece thisPlayer, ChessPiece opponentPlayer){
        if (thisPlayer.getColor() != opponentPlayer.getColor() && opponentPlayer.getColor()!=-1){
            System.out.println("Congratulations " + thisPlayer.toString()
            + " You killed the " + opponentPlayer.toString());
            return true;
        }
        return false;
    }
    public boolean SetGui(GUI vividBoard){
        mGUI=vividBoard;
        return true;
    }
}
