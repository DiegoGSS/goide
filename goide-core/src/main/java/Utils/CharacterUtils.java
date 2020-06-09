package Utils;

public final class CharacterUtils {

    private CharacterUtils(){

    }

    public static boolean isNotLetterCharacter(char testCharacter){
        if(testCharacter < 'A' || testCharacter > 'z' || (testCharacter > 'Z' && testCharacter < 'a')){
            return true;
        }
        return false;
    }

}
