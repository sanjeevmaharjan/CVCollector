package enums;

public enum Gender {
    Male((short)1),
    Female((short)2),
    Other((short)3);

    private final short id;

    Gender(short id) { this.id = id; }

    public short getId() { return id; }
}
