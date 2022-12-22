package ui;

import javax.swing.*;

public class UIPatientMenu {
    public  static void showPatientMenu{
        int response=0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,"\n"
                    + "Welcome "+UIMenu.patientLogged.getName()+"!"+"\n"+
                    "1. Book an appoiment\n" +
                    "2. My Appoinments\n" +
                    "0. Logout"));
            switch (response){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while(response!=0);
    }

    //book
    private static  void ShowBookAppoimentMenu(){
        int response=0;
        do {
            response=Integer.parseInt(JOptionPane.showInputDialog(null,":: Book an appoiment\n"+
                    "Select a date:");
        }while(response!=0);
    }
}
