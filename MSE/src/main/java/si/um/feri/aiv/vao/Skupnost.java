package si.um.feri.aiv.vao;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Skupnost {

    private List<MSE> MSEs;
    @NotBlank
    private String communitiyName;
    private String adminName;
    private String adminSurname;
    private String adminEmail;

    public Skupnost() {
        this("","","", "");
    }

    public Skupnost(String communitiyName, String adminName, String adminSurname, String adminEmail) {
        this.communitiyName = communitiyName;
        MSEs =new ArrayList<MSE>();
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.adminEmail = adminEmail;
    }

    public List<MSE> getMSEs() {
        return MSEs;
    }

    public void setMSEs(List<MSE> kontakti) {
        this.MSEs = kontakti;
    }


}