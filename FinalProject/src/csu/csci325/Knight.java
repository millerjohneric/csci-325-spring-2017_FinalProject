package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Knight extends ChessPiece {
    /**
     * motion:  MUST MOVE TWO SPACES THEN ONE PERPENDICULAR TO ORIGINAL DIRECTION
     *          up, down, left, right, diagonal any value of spaces
     */
    int mColor;
    public Knight(){

    }
    public Knight(int color){
        mColor = color;
    }
    public String toString(){
        if (mColor == 1) {
            return "King W       ";
        }else if (mColor == 0) {
            return "Knight B     ";
        }else{
            return "";
        }
    }
    public int getColor(){
        return mColor;
    }
    public boolean CanMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){


        return false;
    }
}
