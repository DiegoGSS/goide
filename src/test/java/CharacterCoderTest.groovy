import spock.lang.*

class CharacterCoderTest extends Specification {

    //Primeiro montamos o teste sem a classe para ele falhar
    def "Character input should be cyphered to character +3"() {
        given:
        char original = 'a'

        when:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.characterRotator(original);

        then:
        coded == 'd'
    }
}
