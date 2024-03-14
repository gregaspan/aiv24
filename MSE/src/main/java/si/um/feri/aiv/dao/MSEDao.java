package si.um.feri.aiv.dao;

import java.util.List;
import si.um.feri.aiv.vao.MSE;

public interface MSEDao {

    List<MSE> getAll();
    MSE find(String email);
    void save(MSE mse);
    void delete(String email);

}