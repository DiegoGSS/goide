package Utils

import spock.lang.Specification

class CharacterUtilsTest extends Specification {

    def "Letras não devem ser reconhecidos como especiais"(){
        expect:
        def result = CharacterUtils.isNotLetterCharacter(character)
        result == false;

        where:
        character << [(char) 'a', (char) 'b', (char) 'c', (char) 'd', (char) 'e', (char) 'f', (char) 'g', (char) 'h',
                           (char) 'i', (char) 'j', (char) 'k', (char) 'l', (char) 'm', (char) 'n', (char) 'o', (char) 'p',
                           (char) 'q', (char) 'r', (char) 's', (char) 't', (char) 'u', (char) 'v', (char) 'w', (char) 'x',
                           (char) 'y', (char) 'z',
                           (char) 'A', (char) 'B', (char) 'C', (char) 'D', (char) 'E', (char) 'F', (char) 'G', (char) 'H',
                           (char) 'I', (char) 'J', (char) 'K', (char) 'L', (char) 'M', (char) 'N', (char) 'O', (char) 'P',
                           (char) 'Q', (char) 'R', (char) 'S', (char) 'T', (char) 'U', (char) 'V', (char) 'W', (char) 'X',
                           (char) 'Y', (char) 'Z']
    }

    def "Caracteres especiais devem ser reconhecidos como especiais"(){
        expect:
        def result = CharacterUtils.isNotLetterCharacter(character)
        result == true;

        where:
        character << [(char) ' ', (char) '!', (char) '[', (char) '_', (char) '{', (char) '|']
    }

}
