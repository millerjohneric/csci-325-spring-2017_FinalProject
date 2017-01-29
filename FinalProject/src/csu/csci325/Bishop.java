package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Bishop  extends ChessPiece{
    /**
     * motion:  MUST STAY ON THE COLOR OF ORIGIN
     *          diagonal any value of spaces
     */
    // color
    // tileColor

    static boolean mColor;
    public Bishop(){

    }
    public Bishop(boolean color){
        mColor = color;
    }

    public String toString(){
        if (mColor) {
            return "White Bishop ";
        }
        return "Black Bishop ";
    }
}
