package labs.lab6.sortedlist;



public interface Keyable {
    public int getKey();
    public boolean lessThan(Keyable x);
}