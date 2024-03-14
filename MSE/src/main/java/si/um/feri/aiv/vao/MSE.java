package si.um.feri.aiv.vao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MSE {
    private double latitude;
    private double longitude;
    @NotBlank
    private String name;
    private String surname;
    private String email;
    private double kw;

    public MSE() {
        this(0.0, 0.0, "", "","",0.0);
    }

    public MSE(double latitude, double longitude, String name, String surname, String email, double kw) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.kw = kw;
    }
    
}