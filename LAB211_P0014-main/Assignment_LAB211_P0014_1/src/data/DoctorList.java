
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import myUlti.Inputter;


public class DoctorList extends HashMap<String, Doctor> {
    
    public DoctorList() {
        super();
    }
    
        public static boolean checkGender(String msg) {
        String str;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.print(msg);
            str = sc.nextLine();
            str = str.trim().toUpperCase();
            char c = str.charAt(0);
            try {

                if (null == str) {
                    throw new Exception();
                } else {
                    switch (c) {
                        case 'M':
                        case '1':
                        case 'T':
                            return true;
                        case '0':
                        case 'F':
                            return false;

                        default:
                            throw new Exception();
                    }

                }

            } catch (Exception e) {
                System.out.println("Data Invalid! Try again.");
                flag = true;
            }
        } while (flag);

        return false;
    }
    
   
    
}
