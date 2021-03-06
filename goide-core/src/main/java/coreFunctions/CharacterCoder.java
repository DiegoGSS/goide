package coreFunctions;

import Utils.CharacterUtils;

public class CharacterCoder {

    //mantemos esse metodo na API por ser notável e especialmente útil
    //mas encapsulamos a lógica de codificação para evitar repetição de código
    public char cesarCodeCharacter(char inputChar){
        //rotacao cesar é de tres caracteres, equivalente a um caracter 'd'
        return this.codeCharacter(inputChar, 'd');
    }

    //novo metodo da api para rotacao com fator
    public char codeCharacter(char inputChar, char rotationChar){
        char rotated;
        //obtendo fator de rotacao
        int rotationFactor = getRotationNumber(rotationChar);
        //adicionando if para caracteres especiais
        if(CharacterUtils.isNotLetterCharacter(inputChar)){
            rotated = inputChar;
        }
        //adicionando if para letras maiusculas
        else if(inputChar <= 'Z'){
            rotated =  (char) (((inputChar - 'A') + rotationFactor) %26 + 'A');
        }
        else{
            rotated =  (char) (((inputChar - 'a') + rotationFactor) %26 + 'a');
        }
        return rotated;
    }

    //mantemos esse metodo na API por ser notável e especialmente útil
    //mas encapsulamos a lógica de codificação para evitar repetição de código
    public char cesarDecodeCharacter(char inputChar){
        //rotacao cesar é de tres caracteres, equivalente a um caracter 'd'
        return this.decodeCharacter(inputChar, 'd');
    }

    public char decodeCharacter(char inputChar, char rotationChar){
        char rotated;
        //obtendo fator de rotacao
        int rotationFactor = getRotationNumber(rotationChar);
        //if para caracteres especiais
        if(CharacterUtils.isNotLetterCharacter(inputChar)){
            rotated = inputChar;
        }
        //adicionando if para letras maiusculas
        else if(inputChar <= 'Z'){
            rotated =  (char) ((((inputChar - 'A') - rotationFactor + 26) %26) + 'A');
        }
        else{
            rotated =  (char) ((((inputChar - 'a') - rotationFactor + 26) %26) + 'a');
        }
        return rotated;
    }

    //metodo privado para transformar char de rotacao em int
    private int getRotationNumber(char rotationChar){
        if(rotationChar < 'A' || rotationChar > 'z' || (rotationChar > 'Z' && rotationChar < 'a')){
            return 0;
        }
        else if(rotationChar <= 'Z'){
            return (rotationChar - 'A') %26;
        }
        else {
            return (rotationChar - 'a') %26;
        }
    }

}
