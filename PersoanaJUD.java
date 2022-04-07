public class PersoanaJUD extends Client {

    public double calculareComision() {
        int participari = getNumarParticipari();
        if (participari <= 25) {
            return 0.75;
        } else {
            return 0.9;
        }
    }


}
