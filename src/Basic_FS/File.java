package Basic_FS;

import Basic_FS.BasicFSItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Basic_FS.File System item storing and shown data written
//Represent data written to disk

class File extends BasicFSItem {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public void print(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d HH:mm");
        System.out.println(this.size + "The size file " + dateFormat.format(super.creationDate) + " " + super.name);
    }

    @Override
    public String toString() {
        return super.name;
    }
}
