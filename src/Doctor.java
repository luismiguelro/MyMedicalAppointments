import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;


    Doctor(String name, String email){
        super(name,email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
