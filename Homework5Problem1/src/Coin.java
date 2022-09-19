import java.util.Random;

public class Coin  {

    private Random rand;
    private Face face;

    Coin(Face face) {
        setFace(face);
        rand = new Random();
    }

    public final Face getFace() {
        return face;
    }

    public final void setFace(Face face) {
        this.face = face == null ? Face.TAIL : face;
    }

    public void flip() {
       face = rand.nextBoolean() ? Face.HEAD : Face.TAIL;
    }

    public boolean isHeads() {
        return this.face == Face.HEAD;
    }

    @Override
    public String toString() {
        return face.toString();
    }
}
