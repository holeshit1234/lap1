
package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import myUlti.Inputter;

public class Doctor {

    String doctorID;
    String name;
    boolean sex;
    String address;
    String departmentID;
    Date createDate;
    Date lastUpdateDate;

    public Doctor(String doctorID, String name, boolean sex, String address, String departmentID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Doctor(String doctorID, String name, boolean sex, String address, String departmentID, Date createDate) {
        this.doctorID = doctorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.doctorID, other.doctorID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.departmentID, other.departmentID)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if( !Objects.equals(this.lastUpdateDate, other.lastUpdateDate)){
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String StrGender = "female";
        String createDate;
        String updateDate;
        if (this.createDate == null) {
            createDate = "null";

        } else {
            createDate = Inputter.strDMY(this.createDate);

        }
        if (this.lastUpdateDate == null) {
            updateDate = "null";
        } else {
            updateDate = Inputter.strDMY(this.lastUpdateDate);
        }

//        if (this.sex = true) {
//            StrGender = "male";
//        }
        return "[" + doctorID + ", " + name + ", " + convertToString(sex) + ", " + address + ", " + departmentID + ", " + createDate + ", " + updateDate + "]";
    }


    
    public String convertToString(boolean sex) {
        if (sex == true) {
            return "Male";
        } else {
            return "Female";
        }
    }
    
    public void displayDoctor(){
    String StrGender = "female";
        String createDate;
        String updateDate;
        if (this.createDate == null) {
            createDate = "null";

        } else {
            createDate = Inputter.strDMY(this.createDate);

        }
        if (this.lastUpdateDate == null) {
            updateDate = "null";
        } else {
            updateDate = Inputter.strDMY(this.lastUpdateDate);
        }
//
//        if (this.sex = true) {
//            StrGender = "Male";
//        } else StrGender = "Female";
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("\n| %-10s | %-20s | %-10s | %-25s | %-15s | %-15s | %-15s |", doctorID, name, convertToString(sex), address, departmentID, createDate, updateDate);
    }
    
    
    
    

}
