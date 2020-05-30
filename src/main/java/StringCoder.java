public class StringCoder {

    public String codeString(String inputString){
        //funcao simplesmente itera no string, utiliza a funcao de rotacionar char e monta o string cifrado
        String outputString  = "";
        CharacterCoder characterCoder = new CharacterCoder();
        for (int i = 0, n = inputString.length(); i < n; i++) {
            outputString+= characterCoder.characterRotator(inputString.charAt(i));
        }
        return outputString;
    }
}
