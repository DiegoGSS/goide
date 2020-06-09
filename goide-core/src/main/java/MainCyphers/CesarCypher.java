package MainCyphers;

import Utils.CypherStringUtils;
import coreFunctions.StringCoder;

public class CesarCypher {

    private StringCoder stringCoder;

    public CesarCypher(){
        this.stringCoder = new StringCoder();
    }

    public String cypherText(String originalText){
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.codeString(normalizedOriginalText);
    }

    public String decypherText(String originalText){
        String normalizedOriginalText = CypherStringUtils.deAccent(originalText);
        return this.stringCoder.decodeString(normalizedOriginalText);
    }

    public void setStringCoder(StringCoder stringCoder) {
        this.stringCoder = stringCoder;
    }
}
