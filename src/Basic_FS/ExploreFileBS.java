package Basic_FS;

public interface ExploreFileBS {
    //wanted functions

    void addFile(String parentDirName, String fileName, int fileSize);

    void addDir(String parentDirName, String dirName);

    void delete(String name);

    void showFileSystem();

}
