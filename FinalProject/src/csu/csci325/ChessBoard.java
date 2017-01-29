package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessBoard {
    // white on right bottom corner
    private static int SIDELENGTH = 8;
    private static boolean WHITE = true;
    private static boolean BLACK = false;
    private static Tile[][] mTiles;
    public ChessBoard(){
        mTiles = new Tile[SIDELENGTH][SIDELENGTH];
        boolean result;


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
    public void Display(){
        //tiles = new Tile[SIDELENGTH][SIDELENGTH];
        for (int backToFront = 0; backToFront < SIDELENGTH; backToFront++){
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print("______________________");

            }
            System.out.println("");
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print("|");
                System.out.print(mTiles[leftToRight][backToFront].toString());
            }
            System.out.print( "|");

            System.out.println("");
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|                     ");
            }
            System.out.print( "|");
            System.out.println("");
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|   " + mTiles[leftToRight][backToFront].getPiece().toString() + "     ");
            }
            System.out.print( "|");
            System.out.println("");
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                // System.out.print(mTiles[leftToRight][backToFront].toString());

                //System.out.println("");
                System.out.print( "|                     ");
            }
            System.out.print( "|");
            System.out.println("");
        }
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
            System.out.print("______________________");

        }
    }

}
