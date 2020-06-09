package MainCyphers;

import Utils.CypherStringUtils;
import coreFunctions.StringCoder;

public class VigenereCypher {

    private StringCoder stringCoder;

    public VigenereCypher(){
        this.stringCoder = new StringCoder();
    }

    public String cypherText(String originalText, String stringKey){
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.codeString(normalizedOriginalText, stringKey);
    }

    public String decypherText(String originalText, String stringKey){
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.decodeString(normalizedOriginalText, stringKey);
    }

    public void setStringCoder(StringCoder stringCoder) {
        this.stringCoder = stringCoder;
    }
}
