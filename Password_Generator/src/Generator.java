import java.util.*;

public class Generator {
    boolean includeUpper;
    boolean includeLower;
    boolean includeNum;
    boolean includeSplC;
    Alphabet alphabet;
    static Scanner in;

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSplC) {
        this.includeUpper = includeUpper;
        this.includeLower = includeLower;
        this.includeNum = includeNum;
        this.includeSplC = includeSplC;
        alphabet = new Alphabet(includeUpper,includeLower,includeNum,includeSplC);
    }

    public Password GeneratePassword(int length){
        final StringBuilder pass = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();
        for(int i=0;i<length;i++){
            int index = (int)(Math.random()* alphabetLength);
            pass.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }

    public static void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    public static void requestPassword(){
        boolean IncludeUpper=false;
        boolean IncludeLower=false;
        boolean IncludeNum=false;
        boolean IncludeSplC=false;
        String input;
        //final Scanner in = new Scanner(System.in);
        System.out.println("\t\t\tHello, welcome to the Password Generator \n Answer the following questions by Yes or No \n");
        while(true){
            System.out.print("Do you want Upper Case letters in generated password ?\n ->");
            input = in.nextLine();
            if(input.equals("YES") || input.equals("Yes") || input.equals("yes")){
                IncludeUpper = true;
            }else if(input.equals("NO") || input.equals("No") || input.equals("no")){
                PasswordRequestError();
                continue;
            }
            System.out.print("Do you want Lower Case letters in generated password ?\n ->");
            input = in.nextLine();
            if(input.equals("YES") || input.equals("Yes") || input.equals("yes")){
                IncludeLower = true;
            }else if(input.equals("NO") || input.equals("No") || input.equals("no")){
                PasswordRequestError();
                continue;
            }
            System.out.print("Do you want Numbers in generated password ?\n ->");
            input = in.nextLine();
            if(input.equals("YES") || input.equals("Yes") || input.equals("yes")){
                IncludeNum = true;
            }else if(input.equals("NO") || input.equals("No") || input.equals("no")){
                PasswordRequestError();
                continue;
            }
            System.out.print("Do you want Symbols in generated password ?\n ->");
            input = in.nextLine();
            if(input.equals("YES") || input.equals("Yes") || input.equals("yes")){
                IncludeSplC = true;
            }else if(input.equals("NO") || input.equals("No") || input.equals("no")){
                PasswordRequestError();
                continue;
            }
            if(!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSplC) { //No Selection
                System.out.println("You have selected no characters to generate your password at least one of your answers should be Yes");
                System.out.println("Let's Start again.");
                continue;
            }
            System.out.print("Enter the length of the password\n ->");
            int length=in.nextInt();
            in.nextLine();
            final Generator generator = new Generator (IncludeUpper, IncludeLower, IncludeNum, IncludeSplC);
            final Password UserPass = generator.GeneratePassword(length);
            System.out.println(UserPass);
            //in.close();
            break;
        }
    }

    public static void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }

    public static void checkPassword(){
        //final Scanner in = new Scanner(System.in);
        System.out.print("Enter your password\n ->");
        final Password password = new Password(in.nextLine());
        System.out.println(password.PasswordStrength());
        //in.close();
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Enter the desired Service:\n ->");
    }

    public static void main(String[] args) {
        String Input;
        in = new Scanner(System.in);
        System.out.println("Welcome to Password Generator :)" );
        printMenu();
        label:
        while (true) {
            Input = in.nextLine();
            switch (Input) {
                case "1":
                    requestPassword();
                    printMenu();
                    break;
                case "2":
                    checkPassword();
                    printMenu();
                    break;
                case "3":
                    printUsefulInfo();
                    printMenu();
                    break;
                case "4":
                    break label;
                default:
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                    break;
            }
        }
        in.close();
    }
}
