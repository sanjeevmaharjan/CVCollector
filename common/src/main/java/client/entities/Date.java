package client.entities;


// Class to map the js Date type
public class Date {
    public short year;

    public short month;

    public short day;

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
