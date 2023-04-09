
package data;


public class dataDepartment {
    Department department;
    Doctor aDoctor;

    public dataDepartment(Department department, Doctor aDoctor) {
        this.department = department;
        this.aDoctor = aDoctor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getaDoctor() {
        return aDoctor;
    }

    public void setaDoctor(Doctor aDoctor) {
        this.aDoctor = aDoctor;
    }
        
}
