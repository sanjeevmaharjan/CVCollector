package client.entities;


// Class to map the js Date type
public class Date {
    public short year;

    public short month;

    public short day;

    public Date(String date) {
        String[] array = date.split("-");
        if (array != null && array.length <= 3) {
        }
        else {
            this.year = Short.parseShort(array[0]);
            this.month = Short.parseShort(array[1]);
            this.day = Short.parseShort(array[2]);
        }
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
