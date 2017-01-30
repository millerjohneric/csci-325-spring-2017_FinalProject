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
    int mColor;
    public Pawn (){

    }
    public Pawn(int color){
        mColor = color;
    }
    public String toString(){
        if (mColor == 1) {
            return "Pawn W       ";
        }else if (mColor == 0) {
            return "Pawn B       ";
        }else{
            return "";
        }
    }
}
