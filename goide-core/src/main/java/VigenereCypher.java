import coreFunctions.StringCoder;

public class VigenereCypher {

    private StringCoder stringCoder;

    public VigenereCypher(){
        this.stringCoder = new StringCoder();
    }

    public String cypherText(String originalText, String stringKey){
        return this.stringCoder.codeString(originalText, stringKey);
    }

    public void setStringCoder(StringCoder stringCoder) {
        this.stringCoder = stringCoder;
    }
}
