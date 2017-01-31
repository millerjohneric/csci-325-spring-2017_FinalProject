package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Queen  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right, diagonal any value of spaces
     */
    int mColor;
    public Queen(){

    }
    public Queen(int color){
        mColor = color;
    }
    public String toString(){
        if (mColor == 1) {
            return "Queen W      ";
        }else if (mColor == 0) {
            return     "Queen B      ";
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
