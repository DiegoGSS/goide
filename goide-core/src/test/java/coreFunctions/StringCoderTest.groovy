package coreFunctions

import spock.lang.*

class StringCoderTest extends Specification {

    //criando teste basico de texto
    //a principio, seguindo ao principio de composable, precisamos apenas testar que o texto funciona,
    //porque já confiamos que todos os caracteres são rotacionados corretamente
    def "Simple text should be cyphered rotating characters by 3"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.codeString(original);
        coded == rotated;

        where:
        original << ['cesar']
        rotated << ['fhvdu']

    }

    def "Simple text should be decyphered rotating characters by 3"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.decodeString(original);
        coded == rotated;

        where:
        original << ['fhvdu']
        rotated << ['cesar']

    }

    //demonstracao para seu amigo
    def "Demonstration" (){
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.codeString(original);
        coded == rotated;

        where:
        original << ['Hello World']
        rotated << ['Khoor Zruog']
    }

    //primeiro fazemos o teste
    //esse teste deve ser sucifiente dados os testes de rotacao de caracteres e iteracao de strings
    def "Simple text should be cyphered rotating characters by according to key"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.codeString(original, key);
        coded == rotated;

        where:
        original << ['cesar']
        key << ['cesar']
        rotated << ['eikai']

    }

    //teste para garantir que a chave não roda quando o caractere do texto é especial
    def "Text with special characters should be correctly cyphered"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.codeString(original, key);
        coded == rotated;

        where:
        original << ['teste com caractere especial']
        key << ['ridim']
        rotated << ['kmvbq twp kmiifbqim habvklix']

    }


}