package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class King extends ChessPiece {
    /**
     * motion:  CANNOT MOVE INTO CHECK
     *          up, down, left, right, diagonal one space only
     */
    int mColor;
    public King(){

    }
    public King(int color){
        mColor = color;
    }
    public String toString(){
        if (mColor == 1) {
            return "King W       ";
        }else if (mColor == 0) {
            return "King B       ";
        }else{
            return "";
        }
    }    public int getColor(){
        return mColor;
    }
    public boolean CanMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){


        return false;
    }
}
