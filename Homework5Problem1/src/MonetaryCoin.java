public class MonetaryCoin extends Coin {

    private int monetaryCoinValue;

    public MonetaryCoin(Face face, int monetaryCoinValue) {
        super(face);
        setMonetaryCoinValue(monetaryCoinValue);
    }

    public int getMonetaryCoinValue() {
        return monetaryCoinValue;
    }

    public void setMonetaryCoinValue(int monetaryCoinValue) {
        if(monetaryCoinValue == 1 || monetaryCoinValue == 2 || monetaryCoinValue == 5
        || monetaryCoinValue == 10 || monetaryCoinValue == 20 || monetaryCoinValue == 50
        || monetaryCoinValue == 100 || monetaryCoinValue == 200) {
            this.monetaryCoinValue = monetaryCoinValue;
        } else {
            this.monetaryCoinValue = 100;
        }
    }

    @Override
    public String toString() {
        return String.format("%s value: %d",super.toString(),monetaryCoinValue);

    }
}
