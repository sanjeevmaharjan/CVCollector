package enums;

public enum Genders {
    Male((short)1),
    Female((short)2),
    Other((short)3),
    Unspecified((short) -1);

    private final short id;

    Genders(short id) { this.id = id; }

    public short getId() { return id; }
}
