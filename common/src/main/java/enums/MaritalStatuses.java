package enums;

public enum MaritalStatuses {
    Unspecified((short) -1),
    Unmarried((short) 0),
    Married((short) 1),
    Divorced((short) 2);

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
