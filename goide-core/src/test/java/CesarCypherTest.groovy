import MainCyphers.CesarCypher
import coreFunctions.StringCoder
import spock.lang.*

class CesarCypherTest extends Specification {

    StringCoder mockedStringCoder;
    CesarCypher cesarCypher;

    def setup() {
        mockedStringCoder = Mock(StringCoder)
        cesarCypher = new CesarCypher()
        cesarCypher.setStringCoder(mockedStringCoder)
    }

    //teste basico bem basico da api, agora usando mock e verdadeiramente unitario e de cypher
    def "Simple test of MainCyphers.CesarCypher, to cypher test"() {
        given:
        def original = 'cesar'
        def expected = 'fhvdu'

        when:
        def output = cesarCypher.cypherText(original);

        then:
        1 * mockedStringCoder.codeString(original) >> expected
        output == expected

    }

    //teste basico bem basico da api, agora usando mock e verdadeiramente unitario
    def "Simple test of MainCyphers.CesarCypher to decypher test"() {
        given:
        def original = 'fhvdu'
        def expected = 'cesar'

        when:
        def output = cesarCypher.decypherText(original);

        then:
        1 * mockedStringCoder.decodeString(original) >> expected
        output == expected

    }

    //TESTES INTEGRADOS
    def "Integrated test of MainCyphers.CesarCypher, to cypher test"() {
        given:
        def original = 'cesar'
        def expected = 'fhvdu'

        when:
        CesarCypher integratedCypher = new CesarCypher();
        def output = integratedCypher.cypherText(original);

        then:
        output == expected

    }

    def "Integrated test of MainCyphers.CesarCypher to decypher test"() {
        given:
        def original = 'fhvdu'
        def expected = 'cesar'

        when:
        CesarCypher integratedCypher = new CesarCypher();
        def output = integratedCypher.decypherText(original);

        then:
        output == expected

    }

}
