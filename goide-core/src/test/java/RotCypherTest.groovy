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
    def "Simple test of cypher of RotCypher, with number rotation input"() {
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

    def "Simple test of cypher of RotCypher, with char rotation input"() {
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

    def "Simple test of cypher ofRotCypher, with invalid char rotation input"() {
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

    def "Simple test of cypher of RotCypher, with invalid int rotation input"() {
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

    //testes basicos da api
    def "Simple test of decypher of RotCypher, with number rotation input"() {
        given:
        def original = 'vsxexmsr'
        def rotationNumber = 4
        def expected = 'rotation'
        def expectedKey = "e"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.decypherText(original, rotationNumber);

        then:
        1 * mockedStringCoder.decodeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of decypher of RotCypher, with char rotation input"() {
        given:
        def original = 'ifwp xtzqx'
        char rotationChar = 'f'
        def expected = 'dark souls'
        def expectedKey = "f"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.decypherText(original, rotationChar);

        then:
        1 * mockedStringCoder.decodeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of decypher of RotCypher, with invalid char rotation input"() {
        given:
        def original = 'dark souls'
        char rotationChar = ' '
        def expected = 'dark souls'
        def expectedKey = " "

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.decypherText(original, rotationChar);

        then:
        1 * mockedStringCoder.decodeString(original, expectedKey) >> expected
        output == expected

    }

    def "Simple test of decypher of RotCypher, with invalid int rotation input"() {
        given:
        def original = 'dark souls'
        int rotationNumber = -5
        def expected = 'dark souls'
        def expectedKey = (char) "-"

        when:
        rotCypher.setStringCoder(mockedStringCoder);
        def output = rotCypher.decypherText(original, rotationNumber);

        then:
        1 * mockedStringCoder.decodeString(original, expectedKey) >> expected
        output == expected

    }

    //TESTES INTEGRADOS
    def "Integrated test of cypher of RotCypher, with number rotation input"() {
        given:
        def original = 'dark souls'
        int rotationNumber = 8
        def expected = 'lizs awcta'

        when:
        def output = rotCypher.cypherText(original, rotationNumber);

        then:
        output == expected

    }

    //Demonstraca o INTEGRADA para seu amigo
    def "Integrated test of decypher of RotCypher, with number rotation input"() {
        given:
        def original = 'lizs awcta'
        int rotationNumber = 8
        def expected = 'dark souls'

        when:
        def output = rotCypher.decypherText(original, rotationNumber);

        then:
        output == expected

    }
}
