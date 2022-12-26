package model;

import com.sun.org.apache.bcel.internal.generic.DCONST;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppoimentDoctor>appoimentDoctors = new ArrayList<>();
    private ArrayList<AppoimentNurse>appoimentNurses = new ArrayList<>();

    public ArrayList<AppoimentDoctor> getAppoimentDoctors() {
        return appoimentDoctors;
    }

    public void addAppoimentDoctors(Doctor doctor, Date date, String time) {
        AppoimentDoctor appoimentDoctor = new AppoimentDoctor(this,doctor);
        appoimentDoctor.schedule(date,time);
        appoimentDoctors.add(appoimentDoctor);
    }

    public ArrayList<AppoimentNurse> getAppoimentNurses() {
        return appoimentNurses;
    }

    public void setAppoimentNurses(ArrayList<AppoimentNurse> appoimentNurses) {
        this.appoimentNurses = appoimentNurses;
    }

    public Patient(String name, String email) {
        super(name, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\n Weight: " +getWeight()+ "\n Height"+getHeight()+"\nBlood"+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println(super.toString());
    }
}