package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.vao.MSE;

public class MSEMemoryDao implements MSEDao {

    Logger log=Logger.getLogger(MSEMemoryDao.class.toString());

    private List<MSE> MSEs=Collections.synchronizedList(new ArrayList<MSE>());

    @Override
    public List<MSE> getAll() {
        log.info("DAO: get all");
        return MSEs;

    }

    @Override
    public MSE find(String email)  {
        log.info("DAO: finding "+email);
        for (MSE mse : MSEs)
            if (mse.getEmail().equals(email))
                return mse;
        return null;
    }

    @Override
    public void save(MSE mse)  {
        log.info("DAO: saving "+mse);
        if(find(mse.getEmail())!=null) {
            log.info("DAO: editing "+mse);
            delete(mse.getEmail());
        }
        MSEs.add(mse);
    }

    @Override
    public void delete(String email) {
        log.info("DAO: deleting "+email);
        for (Iterator<MSE> i = MSEs.iterator(); i.hasNext();) {
            if (i.next().getEmail().equals(email))
                i.remove();
        }
    }
    private static MSEMemoryDao instance;

    public static synchronized MSEMemoryDao getInstance () {
        if (instance == null ) instance = new MSEMemoryDao();
        return instance;
    }

    private MSEMemoryDao() {

    }



}