/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import myUlti.Menu;
import data.*;


public class Program {

    public static void main(String args[]) throws Exception {

        String Doc_DataFname = "Doctor_Data.txt";
        String Dept_DataFname = "Department_Data.txt";
        
        String BackUp_Doc_DataFname = "BackUp_Doctor_Data.txt";
        String BackUp_Dept_DataFname = "BackUpDepartment_Data.txt";
        
        DoctorList docList = new DoctorList();
        DepartmentList departmentList = new DepartmentList();
        
        HospitalManager manager = new HospitalManager(departmentList, docList);
        String[] options = {"Show information.", "Add new.", "Update information.", "Delete information.", "Search information.", "Load data from file.", "Store data to file.", "Other to Exist."};
        String[] addOptions = {"Add new doctor.", "Add new department." };
        String[] showOptions = {"Show doctor list.", "Show department list." };
        String[] upDateOptions = {"Update doctor.", "Update department." };
        String[] delOptions = {"Remove doctor.", "Remove department." };
        String[] searchOptions = {"Search doctor by name.", "Search department by ID." };
        String[] loadOptions = {"Load doctors data.", "Load department data." };
        String[] saveOptions = {"Save doctors data.", "Save department data." };
        int intChoice;
        do {
            System.out.println("\n----------MENU----------");
            intChoice = Menu.getChoice(options);
            
            switch (intChoice) {
                case 1: {
                    System.out.println("\n----------Show----------");
                    int getSubChoice = Menu.getChoice(showOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.printAllDoctorList();
                            break;
                        case 2:
                            manager.printAllDepartmentList();
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n----------Add----------");
                    int getSubChoice = Menu.getChoice(addOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.addNewDoctor();
                            break;
                        case 2:
                            manager.addNewDepartment();
                            break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n----------Update----------");
                    int getSubChoice = Menu.getChoice(upDateOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.updateDoctor();
                            break;
                        case 2:
                            manager.updateDepartment();
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("\n----------Remove----------");
                    int getSubChoice = Menu.getChoice(delOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.removeDoctor();
                            break;
                        case 2:
                            manager.removeDepartment();
                            break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n----------Search----------");
                    int getSubChoice = Menu.getChoice(searchOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.searchDoctorByName();
                            break;
                        case 2:
                            manager.searchDepartmentByID();
                            break;
                    }
                    break;
                }
                case 6: {
                    System.out.println("\n----------Load----------");
                    int getSubChoice = Menu.getChoice(loadOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.loadFromFileDoc_Data(Doc_DataFname);
                            manager.printAllDoctorList();
                            break;
                        case 2:
                            manager.loadFromFileDept_Data(Dept_DataFname);
                            manager.printAllDepartmentList();
                            break;
                    }
                    break;
                }
                case 7: {
                    System.out.println("\n----------Save----------");
                    int getSubChoice = Menu.getChoice(saveOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.SaveToDocFile(BackUp_Doc_DataFname);
                            break;
                        case 2:
                            manager.SaveToDeptFile(BackUp_Dept_DataFname);
                            break;
                    }
                    break;
                }
            }

        } while (intChoice > 0 && intChoice < 8);

    }
}
