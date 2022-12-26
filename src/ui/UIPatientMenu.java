package ui;

import model.Doctor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response=0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"\n"
                    + "Welcome "+UIMenu.patientLogged.getName()+"!"+"\n"+
                    "1. Book an appoiment\n" +
                    "2. My Appoinments\n" +
                    "0. Logout"));
            switch (response){
                case 1:  showBookAppoimentMenu();
                    break;
                case 2: showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while(response!=0);
    }

    //book
    private static  void showBookAppoimentMenu(){
        int response=0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,":: Book an appoiment\n"+
                    "Select a date:"));
            //mnumeracion lista de fechas
            //indice fecha seleccionada por el usuarios
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k=0;

            //recorrer doctorA, para extraer las citas
            for (int i = 0; i <UIDoctorMenu.doctorsAvailableAppoiments.size(); i++) {
                //capturar las citas

                //Recorrer doctor que si tiene citas disponibles
                // Al encontrar uno, pide fechas disponibles, y se agina a las fechas disponibles
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppoiments.get(i).getAvailableAppointments();
                
                Map<Integer,Doctor> doctorAppoiments = new TreeMap<>();
                // acceder a availableAppointments y mostrar
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    //Devolver fecha con formato
                    System.out.println(k+". "+availableAppointments.get(j).getDate());

                    //Capturar el indice fecha y el objeto doctor de la fecha seleccionada

                    // llamar doctores disponibles
                    doctorAppoiments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppoiments.get(i));

                    /*enviar a: Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();*/
                    doctors.put(Integer.valueOf(k),doctorAppoiments);
                }
                
            }
            int responseDateSelected = Integer.parseInt(JOptionPane.showInputDialog(null,""));
            // map igual al anterior
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);

            //Guardar indice
            Integer indexDate =0;
            Doctor doctorSelected = new Doctor("","");

            //recorrer map
            for (Map.Entry<Integer,Doctor> doc:doctorAvailableSelected.entrySet()) {
                //Obtener datos confirmandos
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            JOptionPane.showMessageDialog(null,doctorSelected.getName()+ "\nDate:"+doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    "\nTime:" + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            int rsponse = Integer.parseInt(JOptionPane.showInputDialog(null, "Confirm your appoiment \n1.Yes \n2. Change date"));

            if (rsponse==1){
                UIMenu.patientLogged.addAppoimentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatientMenu();
            }
        }while(response!=0);
    }
    private static void showPatientMyAppointments(){
        int response =0;
        do {
            JOptionPane.showMessageDialog(null,":: MY APPOINTMESTS");
            if (UIMenu.patientLogged.getAppoimentDoctors().size()==0){
                JOptionPane.showMessageDialog(null,"::don't have appoiments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppoimentDoctors().size(); i++) {
                int j = i+1;
                JOptionPane.showMessageDialog(null,j+ ":"+ UIMenu.patientLogged.getAppoimentDoctors().get(i).getDate()+" Time: "+UIMenu.patientLogged.getAppoimentDoctors().get(i).getTime()+
                "\n Doctor:"+ UIMenu.patientLogged.getAppoimentDoctors().get(i).getDoctor().getName());
            }
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"0.Return"));
        }while (response!=0);
    }
}
