package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Queen  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right, diagonal any value of spaces
     */
   //int mColor;
    public Queen(){

    }

    public Queen(int color){
        super.setColor(color);
    }
    public String toString(){
        if (super.getColor() == 1) {
            return "Queen W      ";
        }else if (super.getColor() == 0) {
            return     "Queen B      ";
        }else{
            return "";
        }
    }
    // public int getColor(){
    //    return super.getColor();
    //}
    public boolean CantMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){


        return false;
    }
}
