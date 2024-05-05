package Model;

public record Conversion(String base_code,
                         String target_code,
                         double conversion_rate,
                         double conversion_result) {

    @Override
    public String toString() {
        //************************************************************
        return String.format("**%25s: %-35.4f**\n", "Tasa de conversion:", conversion_rate)+
                String.format("**%25s: %-35.2f**\n", "Resultado conversion", conversion_result);

    }
}
