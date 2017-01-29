package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Knight extends ChessPiece {
    /**
     * motion:  MUST MOVE TWO SPACES THEN ONE PERPENDICULAR TO ORIGINAL DIRECTION
     *          up, down, left, right, diagonal any value of spaces
     */
    boolean mColor;
    public Knight(){

    }
    public Knight(boolean color){
        mColor = color;
    }
    public String toString(){
        if (mColor) {
            return "King W       ";
        }
        return     "Knight B     ";
    }
}
