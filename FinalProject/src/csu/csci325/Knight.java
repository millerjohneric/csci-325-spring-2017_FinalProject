package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Knight extends ChessPiece {
    /**
     * motion:  MUST MOVE TWO SPACES THEN ONE PERPENDICULAR TO ORIGINAL DIRECTION
     *          up, down, left, right, diagonal any value of spaces
     */
   // int mColor;
    public Knight(){

    }
    public Knight(int color){
        super.setColor(color);
    }
    public String toString(){
        if (super.getColor() == 1) {
            return "Knight W       ";
        }else if (super.getColor() == 0) {
            return "Knight B     ";
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
