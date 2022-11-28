public class Patient {
    //Atributos
    int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    Patient(String name, String email){
        this.name = name;
        this.email = email;
    }

    // Weight
    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String getWeight(){
        return this.weight + " Kg.";
    }

    // Height
    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;

    }// ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 8){
            //Validate
            System.out.println("El número telefónico debe ser de 8 dígitos máximo");
        }else if(phoneNumber.length() == 8){
            this.phoneNumber = phoneNumber;
        }

    }

    //Birthday
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //Blood
    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
