package Utils;

import spock.lang.Specification;

class BeautifulStringTest extends Specification {

    //fazemos os testes basicos da api para nossa classe que encapsula operações com strings
    def "Test iteration of BeautifulString"() {
        expect:
        BeautifulString beauty = new BeautifulString(word);
        List<Character> charsAtIndex = new ArrayList<Character>();
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex.add(beauty.iterate());
        charsAtIndex == expectedIndexes;

        where:
        word << ['chave',
                 ' ',
                 'longtest']
        expectedIndexes << [[(char) 'c', (char) 'h', (char) 'a', (char) 'v', (char) 'e', (char) 'c', (char) 'h'],
                            [(char) ' ', (char) ' ', (char) ' ', (char) ' ', (char) ' ', (char) ' ', (char) ' '],
                            [(char) 'l', (char) 'o', (char) 'n', (char) 'g', (char) 't', (char) 'e', (char) 's']]
    }

    def "Test that count of 'laps' is correct and that hasLap is correct"(){
        expect:
        BeautifulString beauty = new BeautifulString(word);
        beauty.iterate();
        beauty.iterate();
        beauty.iterate();
        beauty.iterate();
        beauty.iterate();
        expectedLaps == beauty.getLaps();
        expectedHasLap == beauty.hasLaps();

        where:
        word << ['chave',
                 'chaveTop',
                 'e']
        expectedLaps << [1, 0, 5]
        expectedHasLap << [true, false, true]
    }

}