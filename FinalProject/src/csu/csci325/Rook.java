package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Rook  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right any value of spaces
     */
    static boolean mColor;
    public Rook(){

    }
    public Rook(boolean color){
        mColor = color;
    }
    public String toString(){
        if (mColor) {
            return "White Rook ";
        }
        return  "Black Rook ";
    }
}
