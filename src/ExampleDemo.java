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

        System.out.println("Starting basic demonstration, hit enter each step to continue");
        scanner.nextLine();

        System.out.println("Building a mock file system using the addFile and addDir methods");

        builFileSystem(exploreFile);

        scanner.nextLine();

        System.out.println("Printing file system using showFileSystem method");
        System.out.println("starting from the root");
        scanner.nextLine();

        exploreFile.showFileSystem();

        System.out.println("Hit enter to continue");
        scanner.nextLine();

        System.out.println("Deleting '/file_2' using the delete method");
        System.out.println("Deleting '/dir_c' using the delete method");
        exploreFile.delete("file_2");
        exploreFile.delete("dir_c");

        System.out.println("\nPrinting file system after deletion");
        scanner.nextLine();

        exploreFile.showFileSystem();

        System.out.println("\nEnd of basic demonstration");
        scanner.nextLine();
    }

    static void builFileSystem(ExploreFileBS exploreFile) {

        ExploreFileBS.addFile("/", "file_1", 10);
        ExploreFileBS.addFile("/", "file_2", 20);

        ExploreFileBS.addDir("/", "dir_a");
        ExploreFileBS.addFile("dir_a", "file_a1", 30);
        ExploreFileBS.addFile("dir_a", "file_a2", 40);

        ExploreFileBS.addDir("/", "dir_b");
        ExploreFileBS.addFile("dir_b", "file_b1", 30);
        ExploreFileBS.addFile("dir_b", "file_b2", 40);

        ExploreFileBS.addDir("dir_b", "dir_ba");
        ExploreFileBS.addFile("dir_ba", "file_ba1", 30);
        ExploreFileBS.addFile("dir_ba", "file_ba2", 40);
        ExploreFileBS.addFile("dir_ba", "file_ba3", 40);
        ExploreFileBS.addFile("dir_ba", "file_ba4", 40);

        ExploreFileBS.addDir("/", "dir_c");
        ExploreFileBS.addDir("dir_c", "dir_ca");
        ExploreFileBS.addDir("dir_c", "dir_cb");
        ExploreFileBS.addFile("dir_ca", "file_ca1", 30);
        ExploreFileBS.addFile("dir_cb", "file_cb1", 40);
    }

}
