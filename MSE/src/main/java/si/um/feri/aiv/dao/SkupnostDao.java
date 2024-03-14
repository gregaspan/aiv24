package si.um.feri.aiv.dao;

import java.util.List;
import si.um.feri.aiv.vao.Skupnost;

public interface SkupnostDao {

    List<Skupnost> getAll();
    Skupnost find(String naziv);
    void save(Skupnost skupnost);
    void delete(String naziv);

}