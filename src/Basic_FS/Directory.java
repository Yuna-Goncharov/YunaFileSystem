package Basic_FS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;



//File system item hold other file systems, they stored in linkedList for big amount of directory
public class Directory extends BasicFSItem {

    private LinkedList<BasicFSItem> data = new LinkedList<>();

    public Directory(String name){
        super(name);
    }

    public void printData(Boolean recursiveData){
        Directory.printDataRecursive(this, 0 , recursiveData );
    }

    //print all data content from directory , @param dir - directory to start from
    //@param - recursiveData indicating if need to print sub directory

    private static void printDataRecursive(Directory dir , int start , boolean recursiveData){
        for(BasicFSItem item : dir.data){
            for(int i = 0 ; i < start*1 ; i++){
                System.out.println("    ---" );
            }
            item.print();
            if(recursiveData && item instanceof Directory){
                printDataRecursive((Directory) item , ++start , true );
                start--;
            }
        }
    }

    public void addItem(BasicFSItem newItem ){
        this.data.add(newItem);
    }

    @Override
    public String toString() {

        return super.name;
    }

    //Find an item on directory, @param dir is the directory to start from , @param name it the item we searching
    //@param recursiveItem boolean if we need to search in sub-direcotry
    //return null is not found or the Basic_FS.BasicFSItem
    public static BasicFSItem find(Directory dir , String name , Boolean recursiveItem){
        for(BasicFSItem item : dir.data){
            if(item.name.equals(name)){
                return item;
            }
            else if(recursiveItem && item instanceof Directory){
                BasicFSItem searchItem = Directory.find((Directory) item , name , true);
                if(searchItem != null){
                    return searchItem;
                }
            }
        }
        return null;
    }

    //method to find item in this directory only

    public BasicFSItem findInCurrDir(String name){
        return Directory.find(this , name , false);
    }

    public void delete(BasicFSItem item){
        if(item.name.equals("/")){
            System.out.println(Error.DELETE_ROOT_FOLDER);
            return;
        }
        this.data.remove(item);
    }

    public void print(){
        DateFormat dateFormat = new SimpleDateFormat("MMM d HH:mm");
        System.out.println(dateFormat.format(super.creationDate) + " " + super.name);
    }

}
