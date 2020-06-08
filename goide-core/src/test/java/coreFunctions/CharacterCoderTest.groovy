package coreFunctions

import spock.lang.*

class CharacterCoderTest extends Specification {

    //
    // CYPHER TESTS
    //

    def "Lowercase character input should be cyphered to character +3"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.cesarCodeCharacter(original);
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

    def "Uppercase character input should be cyphered to character +3"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.cesarCodeCharacter(original);
        coded == rotated;

        where:
        original << [(char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                     (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                     (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                     (char) 'Y', (char) 'Z']
        rotated << [(char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H', (char) 'I', (char) 'J', (char) 'K',
                    (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P', (char) 'Q', (char) 'R', (char) 'S',
                    (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X', (char) 'Y', (char) 'Z', (char) 'A',
                    (char) 'B', (char) 'C']

    }

    def "Special character input should NOT be rotated"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.cesarCodeCharacter(original);
        coded == rotated;

        where:
        //teste com dois exemplos de caracteres especiais de cada região a tabela ascii sem letras
        original << [(char) ' ', (char) '!', (char) '[', (char) '_', (char) '{', (char) '|']
        rotated << [(char) ' ', (char) '!', (char) '[',  (char) '_', (char) '{', (char) '|']

    }

    def "Character 'a' input should be cyphered to a character according to rotation factor"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char original = 'a'
        char coded = coder.codeCharacter(original, rotationFactor);
        coded == rotated;

        where:
        rotationFactor << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                     (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                     (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                     (char) 'y', (char) 'z',
                    //testando tambem rotacoes maiusculas que devem ser equivalentes
                     (char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                     (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                     (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                     (char) 'Y', (char) 'Z']
        rotated << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                    (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                    (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                    (char) 'y', (char) 'z',
                    (char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                    (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                    (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                    (char) 'y', (char) 'z']

    }

    def "Character 'A' input should be cyphered to a character according to rotation factor"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char original = 'A'
        char coded = coder.codeCharacter(original, rotationFactor);
        coded == rotated;

        where:
        rotationFactor << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                           (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                           (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                           (char) 'y', (char) 'z',
                            //testando tambem rotacoes maiusculas que devem ser equivalentes
                           (char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                           (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                           (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                           (char) 'Y', (char) 'Z']
        rotated << [(char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                    (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                    (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                    (char) 'Y', (char) 'Z',
                    (char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                    (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                    (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                    (char) 'Y', (char) 'Z']

    }

    def "Special character input should NOT be rotated despite of rotation factor"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char rotationFactor = 'e' //fator exemplo
        char coded = coder.codeCharacter(original, rotationFactor);
        coded == rotated;

        where:
        //teste com dois exemplos de caracteres especiais de cada região a tabela ascii sem letras
        original << [(char) ' ', (char) '!', (char) '[', (char) '_', (char) '{', (char) '|']
        rotated << [(char) ' ', (char) '!', (char) '[',  (char) '_', (char) '{', (char) '|']

    }

    //
    // DECYPHER TESTS
    //


    def "Lowercase character input should be decyphered to character -3"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.decodeCharacter(original);
        coded == rotated;

        where:
        original << [(char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h', (char) 'i', (char) 'j', (char) 'k',
                     (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p', (char) 'q', (char) 'r', (char) 's',
                     (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x', (char) 'y', (char) 'z', (char) 'a',
                     (char) 'b', (char) 'c']
        rotated << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                    (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                    (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                    (char) 'y', (char) 'z']
    }

    def "Uppercase character input should be decyphered to character -3"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.decodeCharacter(original);
        coded == rotated;

        where:
        original << [(char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H', (char) 'I', (char) 'J', (char) 'K',
                     (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P', (char) 'Q', (char) 'R', (char) 'S',
                     (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X', (char) 'Y', (char) 'Z', (char) 'A',
                     (char) 'B', (char) 'C']
        rotated << [(char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                    (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                    (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                    (char) 'Y', (char) 'Z']

    }

    def "Special character input should NOT be reversely rotated"() {
        expect:
        CharacterCoder coder = new CharacterCoder();
        char coded = coder.decodeCharacter(original);
        coded == rotated;

        where:
        //teste com dois exemplos de caracteres especiais de cada região a tabela ascii sem letras
        original << [(char) ' ', (char) '!', (char) '[', (char) '_', (char) '{', (char) '|']
        rotated << [(char) ' ', (char) '!', (char) '[',  (char) '_', (char) '{', (char) '|']

    }
}
