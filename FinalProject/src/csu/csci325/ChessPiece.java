package csu.csci325;

/**
 * Created by Millerjohneric on 1/27/2017.
 */
public class ChessPiece {
    // color
    // can move
    //private ChessPiece mPiece;
    private int mColor;
    public enum COMPAS { NA, SO, SW, WE, NW, NO, NE, EA, SE}
    public ChessPiece(){

    }

    public ChessPiece(int color){
        mColor = color;
    }
    //public ChessPiece(ChessPiece piece, int color){
    //    mPiece = piece;
     //   mColor = color;
    //}
    public int getColor(){
        return mColor;
    }

    public void setColor(int color){
        mColor = color;
    }

    /**
     *
     * @param mOrigin tile position to start from
     * @param mDestination tile position to go to
     * @return a COMPAS direction
     */
    public COMPAS getDirection(int[] mOrigin, int[] mDestination) {
        // TODO: set a global move that is passed a direction and number of spaces
        // TODO: ALL BUT KNIGHT CAN USE super.canmove function.
        // TODO: check each step toward the destination for an enemy or friendly player.
        COMPAS compas = COMPAS.NA;
        if (mDestination[0] - mOrigin[0] == 0 && mDestination[1] - mOrigin[1] > 0) {
            compas = COMPAS.SO;
        }
        if (mDestination[0] - mOrigin[0] < 0 && mDestination[1] - mOrigin[1] > 0) {
            compas = COMPAS.SW;
        }
        if (mDestination[0] - mOrigin[0] < 0 && mDestination[1] - mOrigin[1] == 0) {
            compas = COMPAS.WE;
        }
        if (mDestination[0] - mOrigin[0] < 0 && mDestination[1] - mOrigin[1] < 0) {
            compas = COMPAS.NW;
        }
        if (mDestination[0] - mOrigin[0] == 0 && mDestination[1] - mOrigin[1] < 0) {
            compas = COMPAS.NO;
        }
        if (mDestination[0] - mOrigin[0] > 0 && mDestination[1] - mOrigin[1] > 0) {
            compas = COMPAS.SE;
        }
        if (mDestination[0] - mOrigin[0] > 0 && mDestination[1] - mOrigin[1] == 0) {
            compas = COMPAS.EA;
        }
        if (mDestination[0] - mOrigin[0] > 0 && mDestination[1] - mOrigin[1] < 0) {
            compas = COMPAS.NE;
        }
        return compas;
    }

    /**
     * returns column and row direction and how far to go
     * @param mOrigin tile position to start from
     * @param mDestination tile position to go to
     * @return int array [0] column direction [1] row direction [2] how many steps
     */
    public int[] howFar(int[] mOrigin, int[] mDestination){
        int[] distance =new int[3];
        COMPAS compas = getDirection(mOrigin, mDestination);

        if ( compas == COMPAS.SO ) {
            distance[0] = 0;
            distance[1] = 1;
            distance[2] = Math.abs(mDestination[1] - mOrigin[1]);
        }
        if ( compas == COMPAS.SW ) {
            distance[0] = -1;
            distance[1] = 1;
            distance[2] = Math.abs(mDestination[1] - mOrigin[1]);
        }
        if ( compas == COMPAS.WE ) {
            distance[0] = -1;
            distance[1] = 0;
            distance[2] = Math.abs(mDestination[0] - mOrigin[0]);
        }
        if ( compas == COMPAS.NW ) {
            distance[0] = -1;
            distance[1] = -1;
            distance[2] = Math.abs(mDestination[0] - mOrigin[0]);
        }
        if ( compas == COMPAS.NO ) {
            distance[0] = 0;
            distance[1] = -1;
            distance[2] = Math.abs(mDestination[1] - mOrigin[1]);
        }
        if ( compas == COMPAS.SE ) {
            distance[0] = 1;
            distance[1] = 1;
            distance[2] = Math.abs(mDestination[1] - mOrigin[1]);
        }
        if ( compas == COMPAS.EA ) {
            distance[0] = 1;
            distance[1] = 0;
            distance[2] = Math.abs(mDestination[0] - mOrigin[0]);
        }
        if ( compas == COMPAS.NE ) {
            distance[0] = 1;
            distance[1] = -1;
            distance[2] = Math.abs(mDestination[0] - mOrigin[0]);
        }

        return distance;
    }

    /**
     * determine if the destination is an enemy player
     * @param mOrigin
     * @param mDestination
     * @param mTiles
     * @return
     */
    public boolean isEnemy(int[] mOrigin, int[] mDestination, Tile[][] mTiles){
        // if destination is same color it is obstructed
        if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() == -1) {
            //System.out.println(mTiles[mOrigin[0] + distGoing * distance[0]]
            //        [mOrigin[1] +  distGoing * distance[1]].getPiece().toString());
            return false;
        }else if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() != this.mColor) {
            //System.out.println(mTiles[mOrigin[0] + distGoing * distance[0]]
            //        [mOrigin[1] +  distGoing * distance[1]].getPiece().toString());
            return true;
        }
        return false;
    }

    /**
     * determine if there are any obstructions along the way
     * @param mOrigin
     * @param mDestination
     * @param mTiles
     * @return
     */
    public boolean isObstructed(int[] mOrigin, int[] mDestination, Tile[][] mTiles){
        COMPAS compas = getDirection(mOrigin, mDestination);
        int[] distance =new int[3];
        distance = howFar( mOrigin, mDestination);

        //System.out.println(distance[2])
        for (int distGoing = 1; distGoing < distance[2]; distGoing++) {
            //System.out.println(distGoing + " " + distance[0] + " " + distance[1] + " " + distance[2]);
            //System.out.println(mOrigin[0] + distGoing * distance[0]);
            // if the tile along the path to the destination has a piece
            // with the same color or enemy color it is obstructed
            if (mTiles[mOrigin[0] + distGoing * distance[0]]
                    [mOrigin[1] +  distGoing * distance[1]].getPiece().getColor() != -1) {
                //System.out.println(mTiles[mOrigin[0] + distGoing * distance[0]]
                //        [mOrigin[1] +  distGoing * distance[1]].getPiece().toString());
                return true;
            }
            // if destination is same color it is obstructed
            if (mTiles[mDestination[0]][mDestination[1]].getPiece().getColor() == this.mColor) {
                //System.out.println(mTiles[mOrigin[0] + distGoing * distance[0]]
                //        [mOrigin[1] +  distGoing * distance[1]].getPiece().toString());
                return true;
            }
            // this is just to see it.  delete for actual running
            // mTiles[mOrigin[0] + distGoing * distance[0]]
            //        [mOrigin[1] +  distGoing * distance[1]].setPiece(mTiles[mOrigin[0]][mOrigin[1]].getPiece());
        }
        return false;
    }
    /**
     * returns a boolean indicating whether or not the move is valid
     * @param mOrigin tile position to start from
     * @param mDestination tile position to go to
     * @param mTiles  the board itself
     * @return  "True" if the piece can move to destination, "False" otherwise.
     */
    public boolean CanMove(int[] mOrigin, int[] mDestination, Tile[][] mTiles, String[] err){//}, COMPAS compas){
        COMPAS compas = getDirection(mOrigin, mDestination);
        int[] distance =new int[3];
        distance = howFar( mOrigin, mDestination);
        // todo: determine type of chesspiece.
        if (this instanceof Pawn) {
            if (isObstructed(mOrigin, mDestination, mTiles) == true){
                //System.out.println("Obstructed");
                err[0]="Obstructed";
                return false;
            }
            // distance of one except first move
            //System.out.println("Pawn attempting to move. ");

            if (this.mColor == 1){  // white
                //System.out.println("color is " + this.mColor);
                //System.out.println("good on color so far pawn can move ");

                //System.out.println(compas.toString());
                switch (compas) {
                    case NO:
                        // first move can move two spaces forward only
                        if(mOrigin[1] == 6){
                            //err[0]="pawn can move two spaces on first move ";
                            if (distance[2] > 2) {
                                err[0]="distance > 2  pawn can't move ";
                            return false;
                            }
                        } else if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                        }
                        if (isEnemy(mOrigin, mDestination, mTiles) == true){
                            err[0]="Pawn can only attack an enemy diagonally.";
                            return false;
                        }
                        return true;
                        //break;

                    case NW:                        // pawn can only move one space otherwise
                        if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                        }

                        if (isEnemy(mOrigin, mDestination, mTiles)!= true){
                            err[0]="Pawn can only move diagonally when attacking.";
                            return false;
                        }
                        return true;
                    case NE:
                        // pawn can only move one space otherwise
                        if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                            }

                        if (isEnemy(mOrigin, mDestination, mTiles)!= true){
                            err[0]="Pawn can only move diagonally when attacking.";
                            return false;
                        }
                        return true;
                    default:
                        return false;
                }
            }else if (this.mColor ==0){ // black
                switch (compas) {
                    case SO:
                        // first move can move two spaces forward only
                        if(mOrigin[1] == 1){
                            //err[0]="pawn can move two spaces on first move ");
                            if (distance[2] > 2) {
                                err[0]="distance > 2  pawn can't move ";
                                return false;
                            }
                        } else if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                        }
                        if (isEnemy(mOrigin, mDestination, mTiles) == true){
                            err[0]="Pawn can only attack an enemy diagonally.";
                            return false;
                        }
                        return true;
                    //break;
                    case SW:// pawn can only move one space otherwise
                        if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                        }

                        if (isEnemy(mOrigin, mDestination, mTiles)!= true){
                            err[0]="Pawn can only move diagonally when attacking.";
                            return false;
                        }
                    case SE:
                        // pawn can only move one space otherwise
                        if (distance[2] > 1) {
                            err[0]="distance > 1  pawn can't move ";
                            return false;
                        }

                        if (isEnemy(mOrigin, mDestination, mTiles)!= true){
                            err[0]="Pawn can only move diagonally when attacking.";
                            return false;
                        }
                        return true;
                    default:
                        return false;
                }
            }
            // move to each tile and display.
            // check if empty, friendly or opponent.

            //System.out.println("good so far pawn can move ");
            return true;
        }
        if (this instanceof Rook) {
            if (isObstructed(mOrigin, mDestination, mTiles) == true){
                err[0]="Obstructed";
                return false;
            }
            // no limit on distance
            // color does not matter
            switch (compas){
                case NW:
                case NE:
                case SW:
                case SE:
                    return false;
                default:
                    return true;
            }
        }
        if (this instanceof Bishop) {
            if (isObstructed(mOrigin, mDestination, mTiles) == true){
                err[0]="Obstructed";
                return false;
            }
            // no limit on distance
            // color does not matter
            switch (compas){
                case NO:
                case WE:
                case SO:
                case EA:
                    return false;
                default:
                    if(Math.abs(mDestination[0] - mOrigin[0])!= Math.abs(mDestination[1] - mOrigin[1])){
                        return false;
                    }

                    return true;
            }
        }

        if (this instanceof Queen) {
            if (isObstructed(mOrigin, mDestination, mTiles) == true){
                err[0]="Obstructed";
                return false;
            }
            // no limit on distance
            // color does not matter
            switch (compas){
                case NO:
                case WE:
                case SO:
                case EA:
                case NW:
                case NE:
                case SW:
                case SE:
                    return true;
                default:
                    return true;
            }
        }
        if (this instanceof King) {
            if (isObstructed(mOrigin, mDestination, mTiles) == true){
                err[0]="Obstructed";
                return false;
            }
            if (distance[2] > 1) {
                err[0]="distance > 1  king can't move ";
                return false;
            }
            // no limit on distance
            // color does not matter
            switch (compas){
                case NO:
                case WE:
                case SO:
                case EA:
                case NW:
                case NE:
                case SW:
                case SE:
                    return true;
                default:
                    return true;
            }
        }
        if (this instanceof Knight) {
            // no such thing as obstructed for a knight
            // distance will be tricky.  must be 2 then 1 or 1 then 2 in any direction
            if (distance[2] > 2) {
                err[0]="distance > 1  knight can't move ";
                return false;
            }
            // color does not matter
            // compas does not matter
            //System.out.println("column " + Math.abs(mDestination[0] - mOrigin[0]) );
            //System.out.println("row " + Math.abs(mDestination[1] - mOrigin[1]) );
            if (Math.abs(mDestination[0] - mOrigin[0])==1 && Math.abs(mDestination[1] - mOrigin[1])==2){
                return true;
            }else if (Math.abs(mDestination[0] - mOrigin[0])==2 && Math.abs(mDestination[1] - mOrigin[1])==1){
                return true;
            }
            err[0]="Knights must move over two and up/down one OR over one and up/down two.";
            return false;
        }


        return true;
    }
}
