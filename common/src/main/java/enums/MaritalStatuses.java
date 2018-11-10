package enums;

public enum MaritalStatuses {
    Unspecified((short) -1),
    Single((short) 0),
    Unmarried((short) 1),
    Married((short) 2),
    Divorced((short) 3);

    private final short id;

    MaritalStatuses(short id) {
        this.id = id;
    }

    public short getId() {
        return id;
    }

    public static MaritalStatuses getById(short id) {
        switch (id) {
            case 0:
                return Unmarried;
            case 1:
                return Married;
            case 2:
                return Divorced;
        }
        return Unspecified;
    }
}
