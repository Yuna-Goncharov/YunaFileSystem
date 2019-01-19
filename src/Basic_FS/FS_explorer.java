package Basic_FS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FS_explorer implements ExploreFileBS {

    private Directory root = new Directory("");
    private static final String FILE_PATH = "fileSystem.txt";

    public FS_explorer(boolean shouldLoadFromFile) {

        if (shouldLoadFromFile && isRootFileExist()) {

            loadRootFromFile();
        } else {
            createDefaultRoot();
        }
    }

    public void saveDataToFile(){
        writeRootToFile();
    }

    private void createDefaultRoot() {
        this.root.addItem(new Directory("/"));
    }

    //Requested functions
    public void addFile(String parentDirName, String fileName, int fileSize) {
        File newFile = new File(fileName, fileSize);
        addItem(newFile, parentDirName);
    }

    public void addDir(String parentDirName, String dirName) {
        Directory newDir = new Directory(dirName);
        addItem(newDir, parentDirName);
    }

    public void delete(String name) {

        BasicFSItem rmCandidate = Directory.find(this.root, name, true);

        if (rmCandidate == null)
            System.out.println("Cant find " + name);
        else
            rmCandidate.parent.delete(rmCandidate);

    }

    public void showFileSystem() {

        this.root.printData();
    }

    //Utility functions

    private void addItem(BasicFSItem item, String parentDirName) {
        Directory parent;

        if (isItemExists(item.name)) {
            System.out.println(Error.ITEM_EXISTS);
            return;
        }

        BasicFSItem foundItem = Directory.find(this.root, parentDirName, true);
        Directory foundDir = validateFoundDirectory(foundItem, parentDirName);

        if (foundDir != null) {
            parent = foundDir;
            item.setParent(parent);
            parent.addItem(item);
        }
    }

    private boolean isItemExists(String itemName) {
        return Directory.find(this.root, itemName, true) != null;
    }

    private Directory validateFoundDirectory(BasicFSItem foundItem, String searchWord) {
        if (foundItem instanceof Directory) {
            return (Directory) foundItem;
        } else if (foundItem instanceof File) {
            System.out.println("error: " + searchWord + " is a file");
        } else
            System.out.println("error: Cant find " + searchWord);
        return null;

    }

    private boolean isRootFileExist() {

        java.io.File f = new java.io.File(FILE_PATH);

        boolean result = f.exists() && !f.isDirectory() && f.length() > 0;

        return result;
    }

    private void writeRootToFile() {

        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(root);
            os.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            createDefaultRoot();
        }
    }

    private void loadRootFromFile() {

        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream is = new ObjectInputStream(fis);
            this.root = (Directory) is.readObject();
            is.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            createDefaultRoot();
        }
    }
}
