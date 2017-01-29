package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessPiece {
    // color
    // can move
    private static ChessPiece mPiece;
    private static boolean mColor;
    public ChessPiece(){

    }

    public ChessPiece(boolean color){
        mColor = color;
    }
    public ChessPiece(ChessPiece piece, boolean color){
        mPiece = piece;
        mColor = color;
    }
    public boolean getColor(){
        return mColor;
    }


}
