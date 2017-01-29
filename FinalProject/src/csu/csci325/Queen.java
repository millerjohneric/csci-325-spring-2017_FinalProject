package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Queen  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right, diagonal any value of spaces
     */
    boolean mColor;
    public Queen(){

    }
    public Queen(boolean color){
        mColor = color;
    }
    public String toString(){
        if (mColor) {
            return "Queen W      ";
        }
        return     "Queen B      ";
    }
}
