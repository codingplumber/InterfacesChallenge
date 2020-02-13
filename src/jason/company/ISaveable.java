package jason.company;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    void saveList(List<String> list);
    List<String> returnList();
    void getDamage(int damage);
    int attack();
}
