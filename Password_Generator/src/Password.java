public class Password {
    String value;
    int length;
    int score;

    public Password(String value) {
        this.value = value;
        length = value.length();
    }

    public int CharType(char c){
        if(c>='A' && c<='Z')//UpperCase
        {return 1;}
        else if(c>='a' && c<='z')//LowerCase
        {return 2;}
        else if(c>='0' && c<='9')//Number
        {return 3;}
        else//Symbol
        {return 4;}
    }

    public int calculateScore(){
        boolean UsedUpper=false;
        boolean UsedLower=false;
        boolean UsedNum=false;
        boolean UsedSplC=false;
        score=0;
        for(int i=0;i<value.length();i++){
            switch (CharType(value.charAt(i))){
                case 1 -> UsedUpper = true;
                case 2 -> UsedLower = true;
                case 3 -> UsedNum = true;
                case 4 -> UsedSplC = true;
            }
        }
        if(UsedUpper){score+=1;}
        if(UsedLower){score+=1;}
        if(UsedNum){score+=1;}
        if(UsedSplC){score+=1;}
        if(value.length()>=8){score+=1;}
        if(value.length()>=16){score+=1;}
        return score;
    }
    public String PasswordStrength() {
        int Score = this.calculateScore();
        if (Score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (Score >= 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }
        @Override
    public String toString() {
        return value;
    }
}
