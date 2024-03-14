package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.vao.Skupnost;

public class SkupnostMemoryDao implements SkupnostDao {

    Logger log=Logger.getLogger(PersonMemoryDao.class.toString());

    private List<Skupnost> communities =Collections.synchronizedList(new ArrayList<Skupnost>());

    @Override
    public List<Skupnost> getAll() {
        log.info("DAO: get all");
        return communities;
    }

    @Override
    public Skupnost find(String naziv)  {
        log.info("DAO: finding "+naziv);
        for (Skupnost c : communities)
            if (c.getCommunitiyName().equals(naziv))
                return c;
        return null;
    }

    @Override
    public void save(Skupnost c)  {
        log.info("DAO: saving "+c);
        if(find(c.getCommunitiyName())!=null) {
            log.info("DAO: editing "+c);
            delete(c.getCommunitiyName());
        }
        communities.add(c);
    }

    @Override
    public void delete(String naziv) {
        log.info("DAO: deleting "+naziv);
        for (Iterator<Skupnost> i = communities.iterator(); i.hasNext();) {
            if (i.next().getCommunitiyName().equals(naziv))
                i.remove();
        }
    }

    private static SkupnostMemoryDao instance;

    public static synchronized SkupnostMemoryDao getInstance() {
        if (instance == null ) instance = new SkupnostMemoryDao();
        return instance;
    }

    private SkupnostMemoryDao() {

    }

}