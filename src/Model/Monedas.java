package Model;

import java.util.List;

public class Monedas {

    private List<String[]> supported_codes;

    public Monedas(List<String[]> supported_codes) {
        this.supported_codes = supported_codes;
    }

    @Override
    public String toString() {

        String result = new String();
        for(String[] str : supported_codes) {
            result += String.format("**%10s: %-50s**\n", str[0], str[1]);
         //           str[0] + ", "+ str[1]+ "\n";
        }
        return result;
    }
}
