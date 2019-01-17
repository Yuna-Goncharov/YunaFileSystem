
    public class Main {

        public static void main(String[] args) {

            int  BASIC = 1;
            int selection = ExampleDemo.getUserImput();

            if(selection == BASIC)
                ExampleDemo.runBasicExplorer();

            else{
                System.out.println("Close the program");
            }

        }

}
