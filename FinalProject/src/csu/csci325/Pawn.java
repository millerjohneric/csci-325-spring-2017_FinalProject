package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Pawn  extends ChessPiece{
    /**
     * motion:  first time only it can move forward two spaces
     *          forward one space
     *          diagonally one space if attacking opponent
     */
    static boolean mColor;
    public Pawn (){

    }
    public Pawn(boolean color){
        mColor = color;
    }
    public String toString(){
        if (mColor) {
            return "White King ";
        }
        return  "Black Pawn ";
    }
}
