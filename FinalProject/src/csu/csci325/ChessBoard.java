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
    private static Tile[][] mtiles;
    public ChessBoard(){
        mtiles = new Tile[SIDELENGTH][SIDELENGTH];
        boolean result;


        for (int frontToBack = 0; frontToBack < SIDELENGTH; frontToBack++) {
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
                mtiles[leftToRight][frontToBack] = new Tile();
                if (leftToRight % 2 != 0 && frontToBack % 2 == 0) {
                    result = mtiles[leftToRight][frontToBack].setColor(WHITE);
                }else if (leftToRight % 2 != 0 && frontToBack % 2 != 0) {
                    result = mtiles[leftToRight][frontToBack].setColor(BLACK);
                }else if (leftToRight % 2 == 0 && frontToBack % 2 == 0) {
                    result = mtiles[leftToRight][frontToBack].setColor(BLACK);
                } else {
                    result = mtiles[leftToRight][frontToBack].setColor(WHITE);
                }
            }
        }
    }

    public boolean Set(){
        // set white pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
                mtiles[leftToRight][0].setPiece(new ChessPiece(new Pawn(),WHITE));
            }
        // set rooks
        mtiles[1][0].setPiece(new Rook());
        mtiles[1][7].setPiece(new ChessPiece(new Rook(),WHITE));
        // set knights
        mtiles[1][1].setPiece(new ChessPiece(new Knight(),WHITE));
        mtiles[1][6].setPiece(new ChessPiece(new Knight(),WHITE));
        // set bishops
        mtiles[1][2].setPiece(new ChessPiece(new Bishop(),WHITE));
        mtiles[1][5].setPiece(new ChessPiece(new Bishop(),WHITE));
        // set king
        mtiles[1][3].setPiece(new ChessPiece(new King(),WHITE));
        // set queen
        mtiles[1][4].setPiece(new ChessPiece(new Queen(),WHITE));



        // set black pawns
        for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++) {
            mtiles[leftToRight][7].setPiece(new ChessPiece(BLACK));
        }
        // set rooks
        mtiles[6][0].setPiece(new ChessPiece(BLACK));
        mtiles[6][7].setPiece(new ChessPiece(BLACK));
        // set knights
        mtiles[6][1].setPiece(new ChessPiece(BLACK));
        mtiles[6][6].setPiece(new ChessPiece(BLACK));
        // set bishops
        mtiles[6][2].setPiece(new ChessPiece(BLACK));
        mtiles[6][5].setPiece(new ChessPiece(BLACK));
        // set king
        mtiles[6][4].setPiece(new ChessPiece(BLACK));
        // set queen
        mtiles[6][3].setPiece(new ChessPiece(BLACK));

        return false;
    }
    public boolean Clear(){

        return false;
    }
    public void Display(){
        //tiles = new Tile[SIDELENGTH][SIDELENGTH];
        for (int frontToBack = 0; frontToBack < SIDELENGTH; frontToBack++){
            for (int leftToRight = 0; leftToRight < SIDELENGTH; leftToRight++){
                System.out.print(mtiles[leftToRight][frontToBack].getPiece().toString()
                + " " + mtiles[leftToRight][frontToBack].getColor());
            }
        }
    }

}
