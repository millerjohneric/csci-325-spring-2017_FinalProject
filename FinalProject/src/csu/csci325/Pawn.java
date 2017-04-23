package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Pawn  extends ChessPiece{
    /**
     * motion:  first time only it can move forward two spaces
     *          forward one space
     *          diagonally one space if attacking opponent
     */
    //int mColor;
    public Pawn (){

    }
    public Pawn(int color){
        super.setColor(color);
    }
    public String toString(){
        if (super.getColor() == 1) {
            return "Pawn W       ";
        }else if (super.getColor() == 0) {
            return "Pawn B       ";
        }else{
            return "";
        }
    }

    /**
     *
     * @param mOrigin tile position to start from
     * @param mDestination tile position to go to
     * @param mTiles the board itself
     * @return
     */
   //@Override
    public boolean CantMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles){
        // space is empty
        // is it on row 7, if so it can move to row 6 or 5
        // REMEMBER 1 to 8 for display but 0 to 7 for code
        // check for -1   empty tile
        int directionOfPlay = 0;
        if(mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor()==1){
            directionOfPlay = -1;
        }else if(mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor()==0){
            directionOfPlay = 1;
        }
        if(mTiles [mDestination[0]] [mDestination[1]].getPiece().getColor() == -1) {
            if (mOrigin[1] == 6 && mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor() == 1 ) {
                if (mDestination[1] == 4 && mDestination[0] == mOrigin[0]
                        || mDestination[1] == 5 && mDestination[0] == mOrigin[0]) {
                    //System.out.println("Can Move");
                    return true;
                }
            }else if(mOrigin[1] == 1 && mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor() == 0 ) {
                if (mDestination[1] == 2 && mDestination[0] == mOrigin[0]
                        || mDestination[1] == 3 && mDestination[0] == mOrigin[0]) {
                    //System.out.println("Can Move");
                    return true;
                }
            } else if (mDestination[1] == mOrigin[1] + directionOfPlay && mDestination[0] == mOrigin[0]) {
                //System.out.println("Can Move");
                return true;
            }
            // check for opposite color after checking for empty color
        }else if (mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor() !=
                mTiles [mDestination[0]] [mDestination[1]].getPiece().getColor() ){
            if ((mDestination[1] == mOrigin[1]  + directionOfPlay  && mDestination[0] == mOrigin[0] + 1)
                    ||(mDestination[1] == mOrigin[1]  + directionOfPlay  && mDestination[0] == mOrigin[0] - 1)) {
                //System.out.println("Can Move");
                return true;
            }
        }
        /**
         *
         System.out.println("Can Not Move");
         System.out.println("destination" + mTiles [mDestination[0]][mDestination[1]].getPiece().toString());
         System.out.println("destination" + mTiles [mDestination[0]][mDestination[1]].getPiece().getColor());
         System.out.println("origin" + mDestination[0] + mDestination[1]);
         System.out.println("origin" + mTiles [mOrigin[0]][mOrigin[1]].getPiece().toString());
         System.out.println("origin" + mTiles [mOrigin[0]][mOrigin[1]].getPiece().getColor());
         System.out.println("origin" + mOrigin[0] + mOrigin[1]);
         *
         */
        return false;
    }
}
