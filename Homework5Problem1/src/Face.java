public enum Face {
    HEAD("HEAD"),
    TAIL("TAIL");

    private final String faceValue;

    private Face(String faceValue) {
        this.faceValue = faceValue == null ? "HEAD" : faceValue;
    }

    @Override
    public String toString() {
        return "Face{" +
                "faceValue='" + faceValue + '\'' +
                '}';
    }
}
