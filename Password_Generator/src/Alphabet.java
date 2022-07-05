public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    private final StringBuilder pool;

    public Alphabet(boolean includeUpper,boolean includeLower,boolean includeNum,boolean includeSplC){
        pool = new StringBuilder();
        if(includeUpper){pool.append(UPPERCASE_LETTERS);}
        if(includeLower){pool.append(LOWERCASE_LETTERS);}
        if(includeNum){pool.append(NUMBERS);}
        if(includeSplC){pool.append(SYMBOLS);}
    }
    public String getAlphabet(){
        return pool.toString();
    }
}
