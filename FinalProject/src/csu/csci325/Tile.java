package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Tile {
    private int mColor;
    private ChessPiece mPiece;
    public Tile(){

    }
    public int setColor(int color){
        mColor = color;
        return mColor;
    }
    public int getColor(){
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
     if (mColor == 1) {
         return Character.toString((char)87) + "####################";
     }else if (mColor == 0) {
         return Character.toString((char) 66) + "                    ";
     }else{
         return "";
     }
 }
}
