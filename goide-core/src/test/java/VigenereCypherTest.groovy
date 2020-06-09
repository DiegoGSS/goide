import MainCyphers.VigenereCypher
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
    def "Simple test of cypher of MainCyphers.VigenereCypher"() {
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

    //testes basicos da api
    def "Simple test of decypher of MainCyphers.VigenereCypher"() {
        given:
        def original = 'ksltmmgg'
        def key = 'test'
        def expectedResult = 'rotation'

        when:
        vigenereCypher.setStringCoder(mockedStringCoder);
        def output = vigenereCypher.decypherText(original, key);

        then:
        1 * mockedStringCoder.decodeString(original, key) >> expectedResult
        output == expectedResult

    }

    //TESTES INTEGRADOS
    def "Integrated test of cypher of MainCyphers.VigenereCypher, with number rotation input"() {
        given:
        def original = 'Dark Souls'
        def key = 'MIDIR'
        def expected = 'Pius Jacoa'

        when:
        def output = vigenereCypher.cypherText(original, key)

        then:
        output == expected

    }

    def "Integrated test of decypher of MainCyphers.VigenereCypher, with number rotation input"() {
        given:
        def original = 'PiUs JaCoA'
        def key = 'MIDIR'
        def expected = 'DaRk SoUlS'

        when:
        def output = vigenereCypher.decypherText(original, key)

        then:
        output == expected

    }

}
