package Basic_FS;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Basic_FS.File System item storing and shown data written
//Represent data written to disk

class File extends BasicFSItem implements Serializable {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public void print(int index){
        printTab(index);
        DateFormat dateFormat = new SimpleDateFormat("MMM d HH:mm");
        System.out.println(super.name  + "   " + "[" +  dateFormat.format(super.creationDate) + " " + "  The File size is: " + this.size + "K]");
    }

    @Override
    public String toString()
    {
        return super.name;
    }
}
