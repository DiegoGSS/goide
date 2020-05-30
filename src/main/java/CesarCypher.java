import coreFunctions.StringCoder;

public class CesarCypher {

    private StringCoder stringCoder;

    public CesarCypher(){
        stringCoder = new StringCoder();
    }

    public String cypherText(String originalText){
        return this.stringCoder.codeString(originalText);
    }
}
