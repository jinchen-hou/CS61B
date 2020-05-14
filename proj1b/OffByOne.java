import java.security.PublicKey;

public class OffByOne implements CharacterComparator {

    public OffByOne(){

    }
    @Override
    public boolean equalChars(char x, char y){
        int res = x - y;
        return res * res == 1;
    }


}
