package CesarCypher;

import coreFunctions.StringCoder;

public class CesarCypher {

    private StringCoder stringCoder;

    public CesarCypher(){
        this.stringCoder = new StringCoder();
    }

    public String cypherText(String originalText){
        return this.stringCoder.codeString(originalText);
    }

    public void setStringCoder(StringCoder stringCoder) {
        this.stringCoder = stringCoder;
    }
}
