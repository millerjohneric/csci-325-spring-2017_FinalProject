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

    int mColor;
    public Bishop(){

    }
    public Bishop(int color){
        mColor = color;
    }

    public String toString(){
        if (mColor == 1) {
            return "Bishop W     ";
        }else if (mColor == 0) {
            return "Bishop B     ";
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
