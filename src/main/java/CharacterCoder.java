public class CharacterCoder {

    public char characterRotator(char inputChar){
        //adicionar as operações de subtrair o valor inicial, aplicar módulo 26 (numero caracteres do alfabeto)
        //e a posterior soma do valor inicial para fazer a rotação
        char rotated =  (char) (((inputChar - 'a') + 3)%26 + 'a');
        return rotated;
    }
}
