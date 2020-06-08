package coreFunctions;

import Utils.BeautifulString;
import Utils.CharacterUtils;

public class StringCoder {

    private CharacterCoder characterCoder;

    public StringCoder(){
        characterCoder = new CharacterCoder();
    }

    public String codeString(String inputString){
        //funcao simplesmente itera no string, utiliza a funcao de rotacionar char e monta o string cifrado
        String outputString  = "";
        //implementando a função, vemos que o esquema de for não está legal
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

    public String codeString(String inputText, String key){
        String outputString  = "";
        BeautifulString inputBeautifulString = new BeautifulString(inputText);
        BeautifulString keyBeautifulString = new BeautifulString(key);
        while(!inputBeautifulString.hasLaps()){
            if(CharacterUtils.isSpecialCharacter(inputBeautifulString.iterate())){
                outputString+= this.characterCoder.codeCharacter(inputBeautifulString.getCurrentChar(), keyBeautifulString.getCurrentChar());
            }
            else{
                outputString+= this.characterCoder.codeCharacter(inputBeautifulString.getCurrentChar(), keyBeautifulString.iterate());
            }
        }
        return outputString;
    }
}
