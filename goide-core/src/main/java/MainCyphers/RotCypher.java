package MainCyphers;

import Utils.CypherStringUtils;
import coreFunctions.StringCoder;

public class RotCypher {

    private StringCoder stringCoder;

    public RotCypher(){
        this.stringCoder = new StringCoder();
    }

    public String cypherText(String originalText, int rotationNumber){

        return this.cypherText(originalText, this.obtainRotationCharFromNumber(rotationNumber));
    }

    public String cypherText(String originalText, char rotationChar){
        String keyString = "";
        keyString += rotationChar;
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.codeString(normalizedOriginalText, keyString);
    }

    public String decypherText(String originalText, int rotationNumber){

        return this.decypherText(originalText, this.obtainRotationCharFromNumber(rotationNumber));
    }

    public String decypherText(String originalText, char rotationChar){
        String keyString = "";
        keyString += rotationChar;
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.decodeString(normalizedOriginalText, keyString);
    }

    private char obtainRotationCharFromNumber(int rotationNumber){
        char key;
        if(rotationNumber > -1){
            key = (char) (rotationNumber%26 + 'a');
        }
        else{
            key = '-'; //rotacao 0
        }
        return key;
    }

    public void setStringCoder(StringCoder stringCoder) {
        this.stringCoder = stringCoder;
    }
}
