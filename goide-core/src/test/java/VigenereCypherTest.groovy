import coreFunctions.StringCoder
import spock.lang.Specification

class VigenereCypherTest extends Specification {

    StringCoder mockedStringCoder;
    VigenereCypher vigenereCypher;

    def setup() {
        mockedStringCoder = Mock(StringCoder);
        vigenereCypher = new VigenereCypher();
    }

    //testes basicos da api
    def "Simple test of VigenereCypher"() {
        given:
        def original = 'rotation'
        def key = 'test'
        def expectedResult = 'ksltmmgg'

        when:
        vigenereCypher.setStringCoder(mockedStringCoder);
        def output = vigenereCypher.cypherText(original, key);

        then:
        1 * mockedStringCoder.codeString(original, key) >> expectedResult
        output == expectedResult

    }

    //Demonstração do INTEGRADO para seu amigo
    def "Integrated test of RotCypher, with number rotation input"() {
        given:
        def original = 'Dark Souls'
        def key = 'MIDIR'
        def expected = 'Pius Jacoa'

        when:
        def output = vigenereCypher.cypherText(original, key)

        then:
        output == expected

    }

}
