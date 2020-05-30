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


}