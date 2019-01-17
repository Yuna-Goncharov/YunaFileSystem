

//Will we the controller for the operations

import Basic_FS.*;
import Basic_FS.Error;

public class FS_explorer implements ExploreFileBS {

    Directory start = new Directory("");

    public FS_explorer(){
        this.start.addItem(new Directory("/"));
    }

    //Requested functions
    public void addFile (String parentDirName, String fileName, int fileSize){
        File newFile = new File(fileName, fileSize);
        addItem(newFile, parentDirName);
    }

    public void addDir (String parentDirName, String dirName){
        Directory newDir = new Directory(dirName);
        addItem(newDir, parentDirName);
    }

    public void delete (String name){

        BasicFSItem rmCandidate = Directory.find(this.start, name, true);

        if(rmCandidate == null)
            System.out.println("Cant find " + name);
        else
            rmCandidate.parent.delete(rmCandidate);

    }

    public void showFileSystem (){
        this.start.printData(true);
    }

    //Utility functions

    private void addItem(BasicFSItem item, String parentDirName){
        Directory parent;

        if(isItemExists(item.name)) {
            System.out.println(Error.ITEM_EXISTS);
            return;
        }

        BasicFSItem foundItem = Directory.find(this.start, parentDirName, true);
        Directory foundDir = validateFoundDirectory(foundItem, parentDirName);

        if(foundDir != null){
            parent = foundDir;
            item.setParent(parent);
            parent.addItem(item);
        }
    }

    private boolean isItemExists(String itemName){
        return Directory.find(this.start , itemName , true) != null;
    }

    private Directory validateFoundDirectory(BasicFSItem foundItem , String searchWord){
        if(foundItem instanceof Directory){
            return (Directory) foundItem;
        }
        else if(foundItem instanceof File) {
            System.out.println("error: " + searchWord + " is a file");
        }
        else
            System.out.println("error: Cant find " + searchWord);
            return null;

    }
}
