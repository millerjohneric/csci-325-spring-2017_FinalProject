package csu.csci325;

/**
 * Created by mille on 2/26/2017.
 */
public class Player {
    private String mName;
    private int mColor;
    public Player(String name, int color){
        mName = name;
        mColor = color;
    }
    public int getColor(){
        return mColor;
    }
    public String getName(){
        return mName;
    }

}
