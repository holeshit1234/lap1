
import data.*;
import java.util.Date;
import tools.MyUtil;
import java.util.Scanner;

public class StudentManager {

    Scanner sc = new Scanner(System.in);

    SubjectList subList;
    public StudentList stList;
    TranscriptList trList;

    public StudentManager() {
        subList = new SubjectList();
        stList = new StudentList();
        trList = new TranscriptList();
    }

    public void addSubject() {
        String subID;
        int pos;
        do {
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String name = MyUtil.readNonBlankStr("Subject name").toUpperCase();
        int credit = MyUtil.readInt("Credit", 1, 10);
        Subject sb = new Subject(subID, name, credit);
        subList.add(sb);
        System.out.println("A subject was added.");
    }

    public void updateSubject() {
        String subID;
        int pos;
        subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            String oldSubjectName = this.subList.get(pos).getSubName();
            int oldCredit = this.subList.get(pos).getCredit();
            System.out.println("Update subject:");
            System.out.print("Old subject name: " + oldSubjectName);
            System.out.print("\nNew subject name (Enter for bypassing): ");
            String inputSubjectName = sc.nextLine().trim();
            if (inputSubjectName.length() > 0) {
                this.subList.get(pos).setSubName(inputSubjectName);
            }
            System.out.print("Old credit: " + oldCredit);
            System.out.print("\nNew credit (Enter for bypassing): ");
            String inputCredit = sc.nextLine().trim();
            if (inputCredit.length() > 0) {
                this.subList.get(pos).setCredit(Integer.parseInt(inputCredit));
            }
            System.out.println("Updated.");
        }
    }

    public void deleteSubject() {
        String subID;
        Subject sub;
        int pos;

        subID = MyUtil.readNonBlankStr("Subject ID will be remove");
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Not found!");

        } else {
            sub = subList.get(pos);

            if (trList.containsSubject(subID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                boolean res = MyUtil.readBool("Remove the subject. Really?");
                if (res == true) {
                    Subject i = new Subject(subID);
                    subList.remove(i);
                    System.out.println("Removed.");
                }
            }
        }
    }

    public void addStudent() {
        String stID;
        int pos;
        do {
            stID = MyUtil.readPattern("Student ID", MyUtil.FPT_STUDENT_ID).toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String fName = MyUtil.readNonBlankStr("First name");
        String lName = MyUtil.readNonBlankStr("Last name");
        boolean gender = MyUtil.readBool("Gender (Male/Female)");
        Date bDate = MyUtil.readDMY("Birthday");
        String email = MyUtil.readPattern("Email", MyUtil.EMAIL);
        String phone = MyUtil.readPattern("Phone number", MyUtil.PHONE_10to12);
        Student stu = new Student(stID, fName, lName, gender, bDate, email, phone);
        stList.add(stu);
        System.out.println("A student was added.");
    }

    public void updateStudent() {
        String stID;
        int pos;

        stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            String oldfName = this.stList.get(pos).getfName();
            String oldlName = this.stList.get(pos).getlName();
            Boolean Oldgender = this.stList.get(pos).isGender();
            Date OldbDate = this.stList.get(pos).getbDate();
            String Oldemail = this.stList.get(pos).getEmail();
            String Oldphone = this.stList.get(pos).getPhone();
            System.out.println("Update student:");
            System.out.print("Old first name: " + oldfName);
            System.out.print("\nNew first name (Enter for bypassing): ");
            String inputFirstName = sc.nextLine().trim();
            if (inputFirstName.length() > 0) {
                this.stList.get(pos).setfName(inputFirstName);
            }
            System.out.print("Old last name: " + oldlName);
            System.out.print("\nNew last name (Enter for bypassing): ");
            String inputLastName = sc.nextLine().trim();
            if (inputLastName.length() > 0) {
                this.stList.get(pos).setlName(inputLastName);
            }
            System.out.print("Old gender: " + MyUtil.readBoolString(Oldgender));
            boolean inputBool = MyUtil.readBoolUp("\nNew gender (Enter for bypassing) (Male/Female)");

            this.stList.get(pos).setGender(inputBool);

            System.out.print("Old birthday: " + MyUtil.StrDMY(OldbDate));
            Date inputDate = MyUtil.readDMYUp("\nNew birthday (Enter for bypassing)");
            if (inputDate != null) {
                this.stList.get(pos).setbDate(inputDate);
            }
            System.out.print("Old email: " + Oldemail);
            String inputEmail = MyUtil.readPatternUp("\nNew email (Enter for bypassing)", MyUtil.EMAIL);
            if (inputEmail != null) {
                this.stList.get(pos).setEmail(inputEmail);
            }
            System.out.print("Old phone: " + Oldphone);
            String inputPhone = MyUtil.readPatternUp("\nNew phone (Enter for bypassing)", MyUtil.PHONE_10to12);
            if (inputPhone != null) {
                this.stList.get(pos).setPhone(inputPhone);
            }
            System.out.println("Updated.");
        }
    }

    public void deleteStudent() {
        String stID;
        Student st;
        int pos;

        stID = MyUtil.readNonBlankStr("Subject ID will be remove");
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");

        } else {
            st = stList.get(pos);
            if (trList.containsStudent(stID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                boolean res = MyUtil.readBool("Remove the student. Really?");
                if (res == true) {
                    Student i = new Student(stID);
                    this.stList.remove(i);
                    System.out.println("Removed.");
                }
            }
        }
    }

    public void addGrade() {
        String stID, subID;
        Student st = null;
        Subject sub = null;
        int pos;
        do {
            stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Not found!");
            } else {
                st = stList.get(pos);
            }
        } while (pos < 0);
        do {
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Not found!");
            } else {
                sub = subList.get(pos);
            }
        } while (pos < 0);
        pos = trList.indexOf(new Transcript(st, sub));
        double labMark = MyUtil.readDouble("Lab mark", 0, 10);
        double testMark = MyUtil.readDouble("Test mark", 0, 10);
        double finalMark = MyUtil.readDouble("Final mark", 0, 10);

        Transcript t = new Transcript(st, sub, labMark, testMark, finalMark);
        if (pos < 0) {
            trList.add(t);
        } else {
            trList.set(pos, t);
        }
    }

    public void reportStudent() {
        String stID, subID;
        Student st;
        Subject sub;
        int pos;
        do {
            stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Not found!");
            } else {
                st = stList.get(pos);
            }
        } while (pos < 0);

        boolean check = trList.containsStudent(stID);
        if (check == false) {
            System.out.println("It is not deployed yet!");
        } else {
            System.out.println("|++No++|++Subjectname++|++Averagemark++|++Status++|");

            for (Transcript t : this.trList) {
                if (t.st.stID.equals(stID)) {
                    String status;
                    if (t.average() < 5) {
                        status = "not pass";
                    } else {
                        status = "pass";
                    }
                    System.out.printf(" %-4s  %8s\t  \t %8f\t %-6s %n", t.sub.subID, t.sub.subName, t.average(), status);
                }
            }
        }
    }

    public void reportSubject() {
        String stID, subID;
        Student st;
        Subject sub;
        int pos;
        do {
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Not found!");
            } else {
                sub = subList.get(pos);
            }
        } while (pos < 0);

        boolean check = trList.containsSubject(subID);
        if (check == false) {
            System.out.println("It is not deployed yet!");
        } else {
            System.out.println("|++Student ID++|+++++++Student name++++++++|++Averagemark++|++Status++|");
            for (Transcript t : this.trList) {
                if (t.sub.subID.equals(subID)) {
                    String status;
                    if (t.average() < 5) {
                        status = "not pass";
                    } else {
                        status = "pass";
                    }
                    System.out.printf(" %-4s  %12s %-12s\t  \t %f  %6s %n", t.st.stID, t.st.getlName(), t.st.getfName(), t.average(), status);
                }
            }
        }
    }
}
