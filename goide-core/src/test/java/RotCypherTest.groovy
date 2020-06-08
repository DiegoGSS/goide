import coreFunctions.StringCoder;
import spock.lang.Specification;

public class RotCypherTest extends Specification {

    StringCoder mockedStringCoder;
    RotCypher rotCypher;

    def setup() {
        mockedStringCoder = Mock(StringCoder);
        rotCypher = new RotCypher();
    }

    //testes basicos da api
    def "Simple test of RotCypher, with number rotation input"() {
        given:
        def original = 'rotation'
        def rotationNumber = 4
        def expected = 'vsxexmsr'
        def expectedKey = "e"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.cypherText(original, rotationNumber);

        then:
        1 * mockedStringCoder.codeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of RotCypher, with char rotation input"() {
        given:
        def original = 'dark souls'
        char rotationChar = 'f'
        def expected = 'ifwp xtzqx'
        def expectedKey = "f"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.cypherText(original, rotationChar);

        then:
        1 * mockedStringCoder.codeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of RotCypher, with invalid char rotation input"() {
        given:
        def original = 'dark souls'
        char rotationChar = ' '
        def expected = 'dark souls'
        def expectedKey = " "

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.cypherText(original, rotationChar);

        then:
        1 * mockedStringCoder.codeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of RotCypher, with invalid int rotation input"() {
        given:
        def original = 'dark souls'
        int rotationNumber = -5
        def expected = 'dark souls'
        def expectedKey = (char) "-"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.cypherText(original, rotationNumber);

        then:
        1 * mockedStringCoder.codeString(original, expectedKey) >> expected
        output == expected

    }

    //Demonstraca o INTEGRADA para seu amigo
    def "Integrated test of RotCypher, with number rotation input"() {
        given:
        def original = 'dark souls'
        int rotationNumber = 8
        def expected = 'lizs awcta'

        when:
        def output = rotCypher.cypherText(original, rotationNumber);

        then:
        output == expected

    }
}
