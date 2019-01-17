package Basic_FS;

import java.util.Date;


//Describes the basics of any item on the file system.
public class BasicFSItem {

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

    String getFilePath(){
        if(this.name.equals("/")){
            return "/";
        }
        return getFilePathRecus(this, "");
    }

    //In case not in first and we need to search file
    private String getFilePathRecus(BasicFSItem item , String path){
        if(item.name.equals("/")){
            return "/";
        }
        String resPath = getFilePathRecus(item.parent , path);
        return resPath + "/" + item.name;
    }

    public Directory getParent(){
        return this.parent;
    }
    public String getName(){
        return this.name;
    }

    public void print(){
        System.out.println("File Name: " + this.name);
    }
}
