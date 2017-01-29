package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Tile {
    private boolean mColor;
    private ChessPiece mPiece;
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
 //   public ChessPiece getPieceName(){
 //       return mPiece.toString();
 //   }
 public String toString(){
     if (mColor) {
         return Character.toString((char)87) + "                    ";
     }
     return Character.toString((char)66) + "                    ";
 }
}
