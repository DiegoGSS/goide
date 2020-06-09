package Utils

import spock.lang.Specification

class CypherStringUtilsTest extends Specification{

    def "Special letters in Portuguese should be normalized"() {
        expect:

        char normalized = CypherStringUtils.deAccent(original);
        normalized == expectedNormalized;

        where:
        original << ["á", "à", "ã", "é", "ê", "í", "ó", "ô", "õ", "ú", "ç"]
        expectedNormalized << ["a", "a", "a", "e", "e", "i", "o", "o", "o", "u", "c"]

    }
}
