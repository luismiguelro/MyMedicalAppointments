package ui;

import model.Doctor;

import javax.print.Doc;
import javax.swing.*;
import java.util.ArrayList;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppoiments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response=0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"\n"
            + "Welcome "+UIMenu.doctorLogged.getName()+"!"+"\n"+
                    "1. Add Available Appoiment\n" +
                    "2. My Scheduled Appoinments\n" +
                    "0. Logout"));
            switch (response){
                case 1: showAddAvailableAppoiments();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while(response!=0);
    }
     private static void showAddAvailableAppoiments(){
        int response=0;
         String salida="";
        //Select Month
        do {

            for (int i = 0; i <3 ; i++) {
                int j = i+1;

                        salida+=j+UIMenu.MONTHS[i]+"\n";
            }
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"ADD Available Appoiment\n"+"Select a Month:\n "+salida+" 0.Return"));
            String date;
            if (response>0 && response<4){
                int monthSelected = response;
                 date=JOptionPane.showInputDialog(null,monthSelected+"."+UIMenu.MONTHS[monthSelected-1]+
                        "\n"+"Insert the date available:[dd/ "+UIMenu.MONTHS[monthSelected-1]+" /yyyy]");
                int responseDate=Integer.parseInt(JOptionPane.showInputDialog(null,"Your date is "+date+" \n1.Correct"+
                        "\n2.Change Date"));
                if (responseDate ==2) continue;     // no se sale del ciclo

                // Select Time
                int responseTime=0;
                String time;
                do{
                    time=JOptionPane.showInputDialog(null,"Insert the time available for date: "+date+" [16:00]");

                     responseTime=Integer.parseInt(JOptionPane.showInputDialog(null,"Your time is"+time+"\n1.Correct"+
                            "\n2.Change Date"));

                }while (responseTime==2);

                //asignacion fecha disponible y doctor loggeado
                UIMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppoiments(UIMenu.doctorLogged);

            }else  if (response==0){
                showDoctorMenu();
            }

        }while (response!=0);
     }

     // validar si el doctor tiene disponbilidad, y si no existe agregarlo
     private static void checkDoctorAvailableAppoiments(Doctor doctor){
        if(doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppoiments.contains(doctor)){
            doctorsAvailableAppoiments.add(doctor);
        }
     }
}
