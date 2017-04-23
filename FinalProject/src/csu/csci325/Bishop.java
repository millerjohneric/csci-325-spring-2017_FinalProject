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

    //int mColor;
    public Bishop(){

    }
    public Bishop(int color){
        super.setColor(color);
    }

    public String toString(){
        if (super.getColor() == 1) {
            return "Bishop W     ";
        }else if (super.getColor() == 0) {
            return "Bishop B     ";
        }else{
            return "";
        }
    }
<<<<<<< HEAD
    public boolean CanMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){
        return false;
    }
=======
    //public int getColor(){
    //    return super.getColor();
   // }

>>>>>>> refs/remotes/origin/master
}
