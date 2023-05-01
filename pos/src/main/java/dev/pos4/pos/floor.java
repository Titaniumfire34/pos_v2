package dev.pos4.pos;

import java.util.*;

public class floor {
    HashMap<Integer,table> floorMap = null;
    //int floorWidth;
    //int floorHeight;

    public floor() {
        this.floorMap = new HashMap<Integer,table>(); //int = table num
        //this.floorWidth = 200;
        //this.floorHeight = 200;   
               
    }

    public void addTable() {
        table t = new table(1,1);
        for(int key: this.floorMap.keySet()) {
            if(key == t.getTableNumber()) {
                t.setTableNumber(key+1);
            }
            else {
                this.floorMap.put(t.getTableNumber(),t);
                break;
            }
        }
    }

    public void removeTable(int tableNum) {
        this.floorMap.remove(tableNum);
    }

    public table getTable(int tableNum) {
        return this.floorMap.get(tableNum);
    }
}
