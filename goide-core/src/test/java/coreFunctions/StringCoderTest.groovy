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

    //esse teste deve ser suficiente dados os testes de rotacao de caracteres e iteracao de strings
    def "Simple text should be cyphered rotating characters according to key"() {
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

    def "Special characters in key should not be able to cypher text"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.codeString(original, key);
        coded == rotated;

        where:
        original << ['teste']
        key << ['ridi-']
        rotated << ['kmvbe']

    }

    //esse teste deve ser suficiente dados os testes de rotacao de caracteres e iteracao de strings
    def "Simple text should be decyphered rotating characters according to key"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.decodeString(original, key);
        coded == rotated;

        where:
        original << ['eikai']
        key << ['cesar']
        rotated << ['cesar']

    }

    //teste para garantir que a chave não roda quando o caractere do texto é especial
    def "Text with special characters should be correctly decyphered"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.decodeString(original, key);
        coded == rotated;

        where:
        original << ['kmvbq twp kmiifbqim habvklix']
        key << ['ridim']
        rotated << ['teste com caractere especial']

    }

    def "Special characters in key should not be able to decypher text"() {
        expect:
        StringCoder coder = new StringCoder();
        String coded = coder.decodeString(original, key);
        coded == rotated;

        where:
        original << ['kmvbe']
        key << ['ridi-']
        rotated << ['teste']

    }


}