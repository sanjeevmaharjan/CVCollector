package enums;

public enum Genders {
    Unspecified((short) 0),
    Male((short)1),
    Female((short)2),
    Other((short)3);

    private final short id;

    Genders(short id) { this.id = id; }

    public short getId() { return id; }

    public static Genders fromId(short id) {
        switch (id) {
            case 1:
                return Male;
            case 2:
                return Female;
            case 3:
                return Other;
            default:
                return Unspecified;
        }
    }
}
