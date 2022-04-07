public class ProdusFactory {


    public Produs initializareProdus(String[] comenzi, int idProdus) {
        switch (comenzi[1]) {
            case "mobila" -> {
                return new MobilaBuilder()
                        .withId(idProdus)
                        .withNume(comenzi[2])
                        .withVanzare(0)
                        .withMinim(Double.parseDouble(comenzi[3]))
                        .withTip(comenzi[4])
                        .withMaterial(comenzi[5])
                        .build();
            }
            case "tablou" -> {
                return new TablouBuilder()
                        .withId(idProdus)
                        .withNume(comenzi[2])
                        .withVanzare(0)
                        .withMinim(Double.parseDouble(comenzi[3]))
                        .withPictor(comenzi[4])
                        .build();
            }
            case "bijuterie" -> {
                return new BijuterieBuilder()
                        .withId(idProdus)
                        .withNume(comenzi[2])
                        .withVanzare(0)
                        .withMinim(Double.parseDouble(comenzi[3]))
                        .withMaterial(comenzi[4])
                        .withPP(Boolean.valueOf(comenzi[5]))
                        .build();
            }
        }

        return null;
    }

}