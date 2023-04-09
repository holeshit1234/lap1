
package myUlti;

import java.util.Scanner;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Date;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    public static boolean inputBoolean(String msg){
        boolean ok=false;
        String data;
        do{
        System.out.println(msg);
            data = sc.nextLine();
            data = data.toUpperCase();
            if (data.equals("T") || data.equals("Y")){
                return true;
            } else {
                if (data.equals("F") || data.equals("N")){
                    return false;
                } else {
                    ok = false;
                    System.out.println("Invalid!");
                }
            }
        } while (!ok);
        return true;
    }
    
    
    // get an integer between min... max
    public static int inputInt(String msg, int min, int max) {
        if(min>max) {
            int t = min; min = max; max = t;
        }
        int data;
        do{
            System.out.println(msg);
            data = sc.nextInt();
            if(data < min || data >max) {
                System.out.println("Invalid!! Input again.");
            }
        } while (data < min || data >max);
        return data;
    }
    // get an double between minn..max 
    
    public static double inputDouble(String msg, double min, double max ) {
          if(min>max) {
            double t = min; min = max; max = t;
        }
        double data;
        do{
            System.out.println(msg);
            data = sc.nextDouble();
            if(data < min || data >max) {
                System.out.println("Invalid!! Input again.");
            }
        } while (data < min || data >max);
        return data;
    }
    // get an integer must be a positive number
    public static int inputInt_Pos(String msg){
        
        int data;
        do{
            System.out.println(msg);
            data = Integer.parseInt(sc.nextLine());
            if (data < 0 ) System.out.println("THE NUMBER MUST BE POSITIVE NUMBER!!!");
        } while (data<0);
        return data;
    }
    //get a string with no condition
    public static String inputStr(String msg) {
        System.out.println(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    //get a nin-blank string
    public static String inputNonBlankStr(String msg) {
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine();
            if(data.length() == 0 ) System.out.println("Invalid. Data must be non Blank!!");
        } while (data.length() == 0);
        return data;
    }
    

    //get a string following a pattern
    
    public static String inputPattern(String msg, String pattern) {
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
            
        }while (!data.matches(pattern));
        return data;
    }
    
    // ----------inputting/validating Date values----------------

    // testing whether the year y is leap or not
    public static boolean isLeap(int y) {
        boolean result = false;
        if((y%400==0) || ((y%4==0) && (y%100!=0))) return true;
        return false;  
    }
    // testing whether the y,m,d is a valid date value or not
    
    public static boolean valid (int y, int m, int d) {
        if(y<0 || m<0 || m>12 || d<0 || d>31) return false;
        int maxD=31;
        if(m == 4 || m == 6 || m == 9 || m == 11);
        else if (m==2) {
            if (isLeap(y)) maxD = 29;
            else maxD = 28;
        }
        return d<=maxD;
    }
    
    // covert y/m/d or y-m-d to mili secs (long number )
    public static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if(!valid(y,m,d)) return -1;
        Calendar cal = Calendar.getInstance();
        cal.set(y, m-1, d); // month number: 0..11
        long t = cal.getTime().getTime();
        return t;
        
    }
    
    //Convert long to Date
    public static Date returnDate(String ymd){
        long t = toDate(ymd);
        Date date = new Date(t);
        return date;
    }
    
    // Print format of date
    public static String strDMY (Date d) {
        String s = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return s + (c.get(Calendar.DATE)+1) + '-' + 
                c.get(Calendar.MONTH) + '-' + c.get(Calendar.YEAR);
    }
    
    
}
