import java.util.ArrayList;
import java.util.Date;

public class Doctor {
    //Atributos
    static int id = 0; //Autoincrement
    private String name;
    private String email;
    private String speciality;


    Doctor(){
        System.out.println("Construyendo el Objeto Doctor");
    }

    Doctor(String name, String speciality){
        System.out.println("El nombre del Doctor asignado es: " + name);
        id++;
        this.name = name;
        this.speciality = speciality;
    }

    //Comportamientos
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("ID Doctor: " + id);
    }

    // **** CLASES ANIDADAS ****//

    // Coleccion de AvailableAppoiment
    ArrayList<AvailableAppoiment> availableAppoiments = new ArrayList<>();

    // Metodo(incrementar la lista, y crear)
    public void addAvailableAppoiment(Date date, String time){
        //cada vez que se este agg un dato, se crea un nuevo objeto con los datos
        availableAppoiments.add(new AvailableAppoiment(date,time));

    }
    
    // Obtener datos
    public ArrayList<AvailableAppoiment> getAvailableAppoiments() {
        return availableAppoiments;
    }

    // Clase AvailableAppoinment
    public static class AvailableAppoiment{
        private int id;
        private Date date;
        private String time;

        //Constructor
        public AvailableAppoiment(Date date, String time){
            this.date=date;
            this.time=time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


}
