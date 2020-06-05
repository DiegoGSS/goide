package Utils;

/*
* Classe que possui um string e expõe funções de iteração pelo string
 */
public class BeautifulString {

    private String word;
    private int index;
    private int laps;

    public BeautifulString(String word){
        this.word = word;
        this.index = 0;
        this.laps = 0;
    }

    public char iterate(){
        char character;
        character = word.charAt(index);
        updateIndex();
        return character;
    }

    private void updateIndex(){
        if(this.index == this.word.length() - 1){
            this.index = 0;
            this.laps++;
        }
        else{
            index++;
        }
    }

    public int getLaps(){
        return this.laps;
    }

    public boolean hasLaps(){
        return this.laps > 0;
    }

}