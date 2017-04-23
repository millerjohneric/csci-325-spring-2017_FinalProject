package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class Rook  extends ChessPiece{
    /**
     * motion:
     *          up, down, left, right any value of spaces
     */
    //int mColor;
    public Rook(){

    }
    public Rook(int color){
        super.setColor(color);
    }
    public String toString(){
        if (super.getColor() == 1) {
            return "Rook W       ";
        }else if (super.getColor() == 0) {
            return "Rook B       ";
        }else{
            return "";
        }
    }    public int getColor(){
        return super.getColor();
    }
    public boolean CantMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles) {
        // check each tile on way to destination
        // check direction of motion destination tile for same color (cant move)
        // check                                      for opponent
        // can move any distance in a straight line
        if (mOrigin[0] != mDestination[0] && mOrigin[1] != mDestination[1]) {
            return false;
        }
        int distToGo = 0;
        // determine direction
        // left
        if (mOrigin[0] > mDestination[0]) {
            distToGo = (mOrigin[0] - mDestination[0]);
            System.out.println(mTiles[mOrigin[0] - distToGo][mOrigin[1]].getPiece().getColor());
            for (int distGoing = 1; distGoing < distToGo; distGoing++) {
                System.out.println(distGoing + " " + distToGo);
                if (mTiles[mOrigin[0] - distGoing][mOrigin[1]].getPiece().getColor() != -1) {
                    return false;
                }
            }
            if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() !=
                    mTiles[mOrigin[0]][mOrigin[1]].getPiece().getColor()) {
                return true;
            }
            return false;
            // up
        } else if (mOrigin[1] > mDestination[1]) {
            distToGo = (mOrigin[1] - mDestination[1]);
            System.out.println(mTiles[mOrigin[0]][mOrigin[1] - distToGo].getPiece().getColor() );
            for (int distGoing = 1; distGoing < distToGo; distGoing++) {
                System.out.println(distGoing + " " + distToGo);
                if (mTiles[mOrigin[0]][mOrigin[1] - distGoing].getPiece().getColor() != -1) {
                    return false;
                }
            }
            if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() !=
                    mTiles[mOrigin[0]][mOrigin[1]].getPiece().getColor()) {
                return true;
            }
            return false;
            // down
        } else if (mOrigin[1] < mDestination[1]) {
            distToGo = (mDestination[1] - mOrigin[1]);
            System.out.println(mTiles[mOrigin[0]][mOrigin[1] + distToGo].getPiece().getColor() );
            for (int distGoing = 1; distGoing < distToGo; distGoing++) {
                System.out.println(distGoing + " " + distToGo);
                if (mTiles[mOrigin[0]][mOrigin[1] + distGoing].getPiece().getColor() != -1) {
                    return false;
                }
            }
            if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() !=
                    mTiles[mOrigin[0]][mOrigin[1]].getPiece().getColor()) {
                return true;
            }
            return false;
            // right
        } else {
            distToGo = (mDestination[0] - mOrigin[0]);
            System.out.println(mTiles[mOrigin[0] + distToGo][mOrigin[1]].getPiece().getColor());
            for (int distGoing = 1; distGoing < distToGo; distGoing++) {
                System.out.println(distGoing + " " + distToGo);
                if (mTiles[mOrigin[0] + distGoing][mOrigin[1]].getPiece().getColor() != -1) {
                    return false;
                }
            }
            if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() !=
                    mTiles[mOrigin[0]][mOrigin[1]].getPiece().getColor()) {
                return true;
            }
            return false;
        }
    }
}
