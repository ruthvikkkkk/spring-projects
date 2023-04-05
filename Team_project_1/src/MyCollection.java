import java.util.ArrayList;
import java.util.List;

public class MyCollection<T> extends ArrayList<T>{
    static int readCounter;
    static int writeCounter;
    static List array = new ArrayList<>();

    @Override
    public synchronized boolean add(T t) {
        writeCounter++;
        return array.add(t);
    }

    @Override
    public synchronized T get(int index) {
        readCounter++;
        return (T) array.get(index);
    }
}
