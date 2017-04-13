package strategy;

import enumclass.TileType;
import frame.Map;
import objects.Cells;
import objects.Characters;
import objects.Ground;
import objects.Items;

/**
 *The class is the implementation of strategy interface
 * The class describes the strategy of execution for friendly NPC in the game
 * @author Tann chen
 */
public class Friendly implements Strategy{

    public Map mapFrame;
    public Cells[][] map;
    public int numRows,numCols;
    // to locate the friendly character
    public int characterRow, characterColumn;
    public Characters theFriendly;

    /**
     * The constructor
     * @param map the mapFrame
     * @param theCharacter the friendly
     */
    public Friendly(Map map,Characters theCharacter){
        this.mapFrame=map;
        this.map = this.mapFrame.getMap();
        this.numRows = this.mapFrame.getNumRows();
        this.numCols = this.mapFrame.getNumCols();

        this.theFriendly=theCharacter;
        locateTheFriendly();
    }

    /**
     * The method is used to locate the friendly character
     */
    public void locateTheFriendly(){
        for(int row=0;row<numRows;row++){
            for(int col=0;col<numCols;col++){
                if(map[row][col].getTileType()==TileType.MONSTER){
                    if(theFriendly==map[row][col].getCharacters()){
                        characterRow=row;
                        characterColumn=col;
                        break;
                    }
                }
            }
        }
    }

    /**
     * The method is used to move one step by the friendly
     * @param down move down, -1 if move up
     * @param right  move right ,-1 if move left
     * @return  whether the movement is successful
     */
    public boolean moveOneStep(int down, int right){
        boolean flag=false;
        if(characterRow+down<0||characterRow+down>numRows-1||characterColumn+right<0||characterColumn+right>numCols-1)
            return flag;

        if(map[characterRow+down][characterColumn+right].getTileType() == TileType.GROUND){
            map[characterRow][characterColumn] = new Cells(TileType.GROUND, numRows, numCols, new Ground(TileType.GROUND));
            map[characterRow +down][characterColumn +right] = new Cells(TileType.MONSTER, numRows, numCols,theFriendly);
            flag=true;
            characterRow=characterRow+down;
            characterColumn=characterColumn+right;
        }
        else if(map[characterRow+down][characterColumn+right].getTileType() == TileType.CHEST){
            Items item = map[characterRow+down][characterColumn+right].getItems();
            theFriendly.lootItem(item);
            map[characterRow][characterColumn] = new Cells(TileType.GROUND, numRows, numCols, new Ground(TileType.GROUND));
            map[characterRow +down][characterColumn +right] = new Cells(TileType.MONSTER, numRows, numCols, theFriendly);
            flag=true;
            characterRow=characterRow+down;
            characterColumn=characterColumn+right;
        }

        if(flag){
            System.out.println("[ "+theFriendly.getName()+" ] wander to "+characterRow+","+characterColumn);
            mapFrame.setMap(map,numRows,numCols);
            mapFrame.drawMap(2);
        }

        return flag;
    }



    /**
     * The method implements the execute() in strategy interface
     */
    @Override
    public void execute() {

        int steps=3;
        while (steps>0){
            int random=(int)(Math.random()*4);
            boolean flag;
            if(random==0)
                flag=moveOneStep(1,0);
            else if(random==1)
                flag=moveOneStep(-1,0);
            else if(random==2)
                flag=moveOneStep(0,1);
            else
                flag=moveOneStep(0,-1);
            // walk one step
            if(flag)
                steps--;
        }
    }
}
