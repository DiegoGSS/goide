import spock.lang.*

class CharacterCoderTest extends Specification {
    
    def "Character input should be cyphered to character +3"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.characterRotator(original);
        coded == rotated;

        where:
        original << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                     (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                     (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                     (char) 'y', (char) 'z']
        rotated << [(char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h', (char) 'i', (char) 'j', (char) 'k',
                    (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p', (char) 'q', (char) 'r', (char) 's',
                    (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x', (char) 'y', (char) 'z', (char) 'a',
                    (char) 'b', (char) 'c']

    }
}
