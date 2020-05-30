package coreFunctions;

public class CharacterCoder {

    public char characterRotator(char inputChar){
        char rotated;
        //adicionando if para caracteres especiais
        if(inputChar < 'A' || inputChar > 'z' || (inputChar > 'Z' && inputChar < 'a')){
            rotated = inputChar;
        }
        //adicionando if para letras maiusculas
        else if(inputChar <= 'Z'){
            rotated =  (char) (((inputChar - 'A') + 3)%26 + 'A');
        }
        else{
            rotated =  (char) (((inputChar - 'a') + 3)%26 + 'a');
        }
        return rotated;
    }
}
