package coreFunctions;

public class StringCoder {

    private CharacterCoder characterCoder;

    public StringCoder(){
        characterCoder = new CharacterCoder();
    }

    public String codeString(String inputString){
        //funcao simplesmente itera no string, utiliza a funcao de rotacionar char e monta o string cifrado
        String outputString  = "";
        for (int i = 0, n = inputString.length(); i < n; i++) {
            outputString+= this.characterCoder.cesarCodeCharacter(inputString.charAt(i));
        }
        return outputString;
    }

    public String decodeString(String inputString){
        //funcao simplesmente itera no string, utiliza a funcao de rotacionar char e monta o string decifrado
        String outputString  = "";
        for (int i = 0, n = inputString.length(); i < n; i++) {
            outputString+= this.characterCoder.decodeCharacter(inputString.charAt(i));
        }
        return outputString;
    }
}
