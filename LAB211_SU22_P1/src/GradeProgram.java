
import java.util.Scanner;

public class GradeProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu mainMnu = new Menu();
        mainMnu.add("Add new Student");
        mainMnu.add("Update Student");
        mainMnu.add("Add new Subject");
        mainMnu.add("Update Subject");
        mainMnu.add("Enter Grade");
        mainMnu.add("Student Grade Report");
        mainMnu.add("Subject Grade Report");

        Menu stMnu = new Menu();
        stMnu.add("Update Student");
        stMnu.add("Delete Student");

        Menu subMnu = new Menu();
        subMnu.add("Update Subject");
        subMnu.add("Delete Subject");

        StudentManager mng = new StudentManager();
        int choice1, choice2;
        do {
            System.out.println("\nSTUDENT MANAGEMENT");
            choice1 = mainMnu.getChoice();
            switch (choice1) {
                case 1:
                    int choose1;
                    do {
                        mng.addStudent();
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose1 = sc.nextInt();
                    } while (choose1 == 1);
                    break;
                case 2:
                    int choose2;
                    do {
                        choice2 = stMnu.getChoice();
                        switch (choice2) {
                            case 1:
                                mng.updateStudent();
                                break;
                            case 2:
                                mng.deleteStudent();
                                break;
                            default:
                                System.out.println("bye!");
                        }
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose2 = sc.nextInt();
                    } while (choose2 == 1);
                    break;
                case 3:
                    int choose3;
                    do {
                        mng.addSubject();
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose3 = sc.nextInt();
                    } while (choose3 == 1);
                    break;
                case 4:
                    int choose4;
                    do {
                        choice2 = subMnu.getChoice();
                        switch (choice2) {
                            case 1:
                                mng.updateSubject();
                                break;
                            case 2:
                                mng.deleteSubject();
                                break;
                            default:
                                System.out.println("bye!");
                        }
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose4 = sc.nextInt();
                    } while (choose4 == 1);
                    break;
                case 5:
                    int choose5;
                    do {
                        mng.addGrade();
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose5 = sc.nextInt();
                    } while (choose5 == 1);
                    break;
                case 6:
                    int choose6;
                    do {
                        mng.reportStudent();
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose6 = sc.nextInt();
                    } while (choose6 == 1);
                    break;                  
                case 7:
                    int choose7;
                    do {
                        mng.reportSubject();
                        System.out.print("\nDo you want to continue? (1-Yes/2-No): ");
                        choose7 = sc.nextInt();
                    } while (choose7 == 1);
                    break;
                default:
                    System.out.println("Goodbye!");
            }

        } while (choice1 > 0 && choice1 <= mainMnu.size());
    }
}
