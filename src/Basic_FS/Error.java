package Basic_FS;

public enum Error {
    DELETE_ROOT_FOLDER("Cant delete root folder"),
    ITEM_EXISTS("Item already exists. All files should be uniq in file system ");


    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
