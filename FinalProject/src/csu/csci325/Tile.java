package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Tile {
    private static boolean mColor;
    private static ChessPiece mPiece;
    public Tile(){

    }
    public boolean setColor(boolean color){
        mColor = color;
        return mColor;
    }
    public boolean getColor(){
        return mColor;
    }
    public boolean setPiece(ChessPiece piece){
        mPiece = piece;
        return true;
    }
    public ChessPiece getPiece(){
        return mPiece;
    }
}
