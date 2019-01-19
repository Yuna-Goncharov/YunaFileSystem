package Basic_FS;

public interface ExploreFileBS {

    void addFile(String parentDirName, String fileName, int fileSize);

    void addDir(String parentDirName, String dirName);

    void delete(String name);

    void showFileSystem();

    void saveDataToFile();
}
