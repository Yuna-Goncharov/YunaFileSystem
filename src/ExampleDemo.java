import Basic_FS.*;
import Basic_FS.ExploreFileBS;

import java.util.Scanner;

//User demo for file system operations

public class ExampleDemo {

    static int getUserImput(){

        Scanner scanner = new Scanner(System.in);
        boolean waitingForInput = true;
        String selection = "-1";


        System.out.println("Choose demonstration type:");
        System.out.println("    1: Basic Example - Run a demo that calls the required functions");
        System.out.println("                    addFile, addDir, delete, showFileSystem");
        System.out.println("    Or Close this window. ");


        while(waitingForInput){
            selection = scanner.next().substring(0);
            if(selection.matches("1")){
                waitingForInput = false;
            }
            else{
                System.out.println("Select '1' or close");
            }

        }
        return Integer.parseInt(selection);
    }
    static void runBasicExplorer() {

        Scanner scanner = new Scanner(System.in);

        ExploreFileBS exploreFile = new FS_explorer();

        System.out.println("Starting basic demonstration, hit enter each step in order to continue");
        scanner.nextLine();

        System.out.println("Building a mock example file system using the addFile and addDir methods");

        buildFileSystem(exploreFile);

        scanner.nextLine();

        System.out.println("Printing file system using showFileSystem method");
        System.out.println("Starting from the root file");
        scanner.nextLine();

        exploreFile.showFileSystem();

        System.out.println("Press enter button to continue");
        scanner.nextLine();

        System.out.println("Deleting '/file_2Test' using the delete method");
        System.out.println("Deleting '/dir_c' using the delete method");
        exploreFile.delete("file_2Test");
        exploreFile.delete("dir_c");

        System.out.println("\nPrinting file system after deletion");
        scanner.nextLine();

        exploreFile.showFileSystem();

        System.out.println("\nEnd of basic demonstration");
        scanner.nextLine();
    }

    static void buildFileSystem(ExploreFileBS exploreFile) {

//        exploreFile.addFile("/", "file_1Test", 10);
//        exploreFile.addFile("/", "file_2Test", 20);

        exploreFile.addDir("/", "dir_a");
        exploreFile.addFile("dir_a", "file_a1", 30);
        exploreFile.addFile("dir_a", "file_a2", 40);

        exploreFile.addDir("/", "dir_b");
        exploreFile.addFile("dir_b", "file_b1", 30);
        exploreFile.addFile("dir_b", "file_b2", 40);

        exploreFile.addDir("dir_b", "dir_ba");
        exploreFile.addFile("dir_ba", "file_ba1", 30);
        exploreFile.addFile("dir_ba", "file_ba2", 40);
        exploreFile.addFile("dir_ba", "file_ba3", 40);
        exploreFile.addFile("dir_ba", "file_ba4", 40);

        exploreFile.addDir("/", "dir_c");
        exploreFile.addDir("dir_c", "dir_ca");
        exploreFile.addDir("dir_c", "dir_cb");
        exploreFile.addFile("dir_ca", "file_ca1", 30);
        exploreFile.addFile("dir_cb", "file_cb1", 40);
    }

}
