import CesarCypher.CesarCypher
import spock.lang.*

class CesarCypherTest extends Specification {

    //teste basico bem basico da api
    def "Simple text of CesarCypher"() {
        expect:
        CesarCypher cesarCypher = new CesarCypher();
        String coded = cesarCypher.cypherText(original);
        coded == rotated;

        where:
        original << ['cesar']
        rotated << ['fhvdu']

    }

}
