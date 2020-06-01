import CesarCypher.CesarCypher
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

    //teste basico bem basico da api, agora usando mock e verdadeiramente unitario
    def "Simple test of CesarCypher"() {
        given:
        def original = 'cesar'
        def expected = 'fhvdu'

        when:
        def output = cesarCypher.cypherText(original);

        then:
        1 * mockedStringCoder.codeString(original) >> expected
        output == expected

    }

}
