package ui;

import model.Doctor;
import model.Patient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        int response = 0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"Welcome to My Appointments\n"+
                    "Selecciona la opción deseada " +
                    "\n1.Doctor" +
                    "\n2.Patient" +
                    "\n0.Salir"));
            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response=0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Thank you for you visit");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Please select a correct answer");
            }
        }while (response != 0);
    }
    private static void authUser(int userType){
        //usertype = 1 Doctor
        //usertype = 1 Patient


        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "Alejandro@mail.com"));
        doctors.add(new Doctor("Alejandra Marquez", "Alejandra@mail.com"));
        doctors.add(new Doctor("Miguel Martinez", "miguel@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        doctors.add(new Doctor("Jeronimo", "jeronimo@mail.com"));
        doctors.add(new Doctor("Luis Miguel", "luismi@mail.com"));
        doctors.add(new Doctor("Maicol Martinez", "maicol@mail.com"));

        boolean emailCorrect = false;
        do{
            String email =JOptionPane.showInputDialog ("Insert your email: [a@a].com");
             if (userType==1){
                 for (Doctor d : doctors){
                     if (d.getEmail().equals(email)){
                         emailCorrect=true;
                         //Obtener usuario logeado, e inicializar con doctor localizado
                         doctorLogged=d;
                         //showDoctor menu
                         UIDoctorMenu.showDoctorMenu();

                     }
                 }
             }
             if (userType==2){
                 for (Patient p : patients){
                     if (p.getEmail().equals(email)){
                         emailCorrect=true;
                         //Obtener usuario logeado, e inicializar con doctor localizado
                         patientLogged=p;

                         //showDoctor menu

                     }
                 }

             }
        }while(!emailCorrect);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

}
