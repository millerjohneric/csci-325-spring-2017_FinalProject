package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class King extends ChessPiece {
    /**
     * motion:  CANNOT MOVE INTO CHECK
     *          up, down, left, right, diagonal one space only
     */
   // int mColor;
    public King(){

    }
    public King(int color){
        super.setColor(color);
    }
    public String toString(){
        if (super.getColor() == 1) {
            return "King W       ";
        }else if (super.getColor() == 0) {
            return "King B       ";
        }else{
            return "";
        }
    }
    //public int getColor(){
    //    return super.getColor();
    //}
    public boolean CantMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){


        return false;
    }
}
