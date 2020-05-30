public class CharacterCoder {

    public char characterRotator(char inputChar){
        char rotated;
        //adicionando if para letras maiusculas
        if(inputChar < 'a'){
            rotated =  (char) (((inputChar - 'A') + 3)%26 + 'A');
        }
        else{
            rotated =  (char) (((inputChar - 'a') + 3)%26 + 'a');
        }
        return rotated;
    }
}
