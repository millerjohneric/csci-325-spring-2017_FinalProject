package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Rook  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right any value of spaces
     */
    int mColor;
    public Rook(){

    }
    public Rook(int color){
        mColor = color;
    }
    public String toString(){
        if (mColor == 1) {
            return "Rook W       ";
        }else if (mColor == 0) {
            return "Rook B       ";
        }else{
            return "";
        }
    }
}
