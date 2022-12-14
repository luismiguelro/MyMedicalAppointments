package ui;

import model.Doctor;
import model.Patient;
import model.User;

import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {

        //showMenu();
        /*
        Doctor myDoctor = new Doctor("Luis Miguel", "luismiguel@luismiguel.com");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");


        System.out.println(myDoctor);
        /*

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }



        System.out.println();
        System.out.println();
        Patient patient = new Patient("Alejandra", "alejandra@mail.com");
        System.out.println(patient);*/

        User user = new Doctor("Luis","luis@mail.com");
        user.showDataUser();

        User Pa = new Patient("Luis","luis@mail.com");
        Pa.showDataUser();

        // user, obteniendo comportamiento que dio objeto doctor

    }



}