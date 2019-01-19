package Basic_FS;

import java.io.Serializable;
import java.util.Date;

//Describes the basics of any item on the file system.
public abstract class BasicFSItem implements Serializable {
    String name;
    Date creationDate;
    Directory parent = null;

    BasicFSItem(String name) {
        this.name = name.length() <= 32 ? name : name.substring(0,32);
        this.creationDate = new Date();
    }

    void setParent(Directory parent){
        this.parent = parent;
    }

    void printTab(int index){
        for (int i = 0; i < index; i++) {
            System.out.print("\t");
        }
    }

    public abstract void print(int index);
}
