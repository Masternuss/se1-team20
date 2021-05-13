public class Parkhaus {

    private int parkplaetze,
                frauenparkplaetze,
                tageskundenparkplaetze,
                familienparkplaetze,
                handicapparkplaetze;

    Parkhaus(int parkplaetze, int frauenparkplaetze, int tageskundenparkplaetze, int familienparkplaetze, int handicapparkplaetze) {
        this.parkplaetze = parkplaetze;
        this.frauenparkplaetze = frauenparkplaetze;
        this.tageskundenparkplaetze = tageskundenparkplaetze;
        this.familienparkplaetze = familienparkplaetze;
        this.handicapparkplaetze = handicapparkplaetze;
    }

    public int getParkplaetze() {
        return parkplaetze;
    }

    public void setParkplaetze(int parkplaetze) {
        this.parkplaetze = parkplaetze;
    }

    public int getFrauenparkplaetze() {
        return frauenparkplaetze;
    }

    public void setFrauenparkplaetze(int frauenparkplaetze) {
        this.frauenparkplaetze = frauenparkplaetze;
    }

    public int getTageskundenparkplaetze() {
        return tageskundenparkplaetze;
    }

    public void setTageskundenparkplaetze(int tageskundenparkplaetze) {
        this.tageskundenparkplaetze = tageskundenparkplaetze;
    }

    public int getFamilienparkplaetze() {
        return familienparkplaetze;
    }

    public void setFamilienparkplaetze(int familienparkplaetze) {
        this.familienparkplaetze = familienparkplaetze;
    }

    public int getHandicapparkplaetze() {
        return handicapparkplaetze;
    }

    public void setHandicapparkplaetze(int handicapparkplaetze) {
        this.handicapparkplaetze = handicapparkplaetze;
    }
}
