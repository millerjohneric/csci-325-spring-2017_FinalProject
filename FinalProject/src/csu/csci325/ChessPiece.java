package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessPiece {
    // color
    // can move
    private static ChessPiece mPiece;
    private static int mColor;
    public ChessPiece(){

    }

    public ChessPiece(int color){
        mColor = color;
    }
    public ChessPiece(ChessPiece piece, int color){
        mPiece = piece;
        mColor = color;
    }
    public int getColor(){
        return mColor;
    }


    public boolean CanMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){


        return true;
    }
}
