package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessBoard {
    // width
    // height
    // tileCount
    // tileContents[]
    // tileColor - checkerboard
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
                }else if (leftToRight % 2 != 0 && backToFront % 2 != 0) {
                    result = mTiles[leftToRight][backToFront].setColor(BLACK);
                }else if (leftToRight % 2 != 0 && backToFront % 2 == 0) {
                    result = mTiles[leftToRight][backToFront].setColor(BLACK);
                } else {
                    result = mTiles[leftToRight][backToFront].setColor(WHITE);
                }
            }
        }
    }

    public boolean Set(){
        // set white pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
                mTiles[leftToRight][1].setPiece(new Pawn(WHITE));
            }
        // set rooks
        mTiles[0][0].setPiece(new Rook(WHITE));
        mTiles[0][7].setPiece(new Rook(WHITE));
        // set knights
        mTiles[0][1].setPiece(new Knight(WHITE));
        mTiles[0][6].setPiece(new Knight(WHITE));
        // set bishops
        mTiles[0][2].setPiece(new Bishop(WHITE));
        mTiles[0][5].setPiece(new Bishop(WHITE));
        // set king
        mTiles[0][3].setPiece(new King(WHITE));
        // set queen
        mTiles[0][4].setPiece(new Queen(WHITE));



        // set black pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
            mTiles[leftToRight][7].setPiece(new Pawn(BLACK));
        }
        // set rooks
        mTiles[7][0].setPiece(new Rook(BLACK));
        mTiles[7][7].setPiece(new Rook(BLACK));
        // set knights
        mTiles[7][1].setPiece(new Knight(BLACK));
        mTiles[7][6].setPiece(new Knight(BLACK));
        // set bishops
        mTiles[7][2].setPiece(new Bishop(BLACK));
        mTiles[7][5].setPiece(new Bishop(BLACK));
        // set king
        mTiles[7][4].setPiece(new King(BLACK));
        // set queen
        mTiles[7][3].setPiece(new Queen(BLACK));
        return false;
    }
    public boolean Clear(){

        return false;
    }
    public void Display(){
        //tiles = new Tile[SIDELENGTH][SIDELENGTH];
        for (int backToFront = 0; backToFront < SIDELENGTH; backToFront++){
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print(mTiles[leftToRight][backToFront].toString());
                       // + " " + mTiles[leftToRight][backToFront].getPiece().toString() + "     ");
            }
            System.out.println("");
        }
    }

}
