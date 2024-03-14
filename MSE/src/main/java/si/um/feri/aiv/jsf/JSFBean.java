package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.MSEDao;
import si.um.feri.aiv.dao.MSEMemoryDao;
import si.um.feri.aiv.vao.MSE;
import si.um.feri.aiv.dao.SkupnostDao;
import si.um.feri.aiv.dao.SkupnostMemoryDao;
import si.um.feri.aiv.vao.Skupnost;

@Named("demo")
@SessionScoped
public class JSFBean implements Serializable {

    private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger(JSFBean.class.toString());

    private MSEDao daoMSE= MSEMemoryDao.getInstance();

    private MSE selectedMSE=new MSE();

    private String selectedMSEEmail;

    public List<MSE> getAllMSE() throws Exception {
        return daoMSE.getAll();
    }

    public String saveMSE() throws Exception {
        daoMSE.save(selectedMSE);
        return "all";
    }

    public void deleteMSE(MSE mse) throws Exception {
        daoMSE.delete(mse.getEmail());
    }

    public void setSelectedMSEEmail(String email) throws Exception {
        selectedMSEEmail = email;
        selectedMSE = daoMSE.find(email);
        if(selectedMSE ==null) selectedMSE =new MSE();
    }

    public String getSelectedMSEEmail() {
        return selectedMSEEmail;
    }

    public MSE getSelectedMSE() {
        return selectedMSE;
    }

    public void setSelectedMSE(MSE selectedMSE) {
        this.selectedMSE = selectedMSE;
    }

    //--------------------------------------------------------------------------------

    private SkupnostDao daoSkupnost= SkupnostMemoryDao.getInstance();

    private Skupnost selectedSkupnost=new Skupnost();

    private String selectedSkupnostNaziv;


    public List<Skupnost> getAllSkupnost() throws Exception {
        return daoSkupnost.getAll();
    }

    public String saveSkupnost() throws Exception {
        daoSkupnost.save(selectedSkupnost);
        return "all";
    }

    public void deleteSkupnost(Skupnost skupnosti) throws Exception {
        daoSkupnost.delete(skupnosti.getCommunitiyName());
    }

    public void setSelectedSkupnostNaziv(String nazivSkupnosti) throws Exception {
        selectedSkupnostNaziv = nazivSkupnosti;
        selectedSkupnost =daoSkupnost.find(nazivSkupnosti);
        if(selectedSkupnost ==null) selectedSkupnost =new Skupnost();
    }

    public String getSelectedSkupnostNaziv() {
        return selectedSkupnostNaziv;
    }

    public Skupnost getSelectedSkupnost() {
        return selectedSkupnost;
    }

    public void setSelectedSkupnost(Skupnost selectedSkupnost) {
        this.selectedSkupnost = selectedSkupnost;
    }


}

