
package data;

import java.util.Date;
import java.util.Objects;
import myUlti.Inputter;


public class Department {

    String departmentID;
    String name;
    Date createDate;
    Date lastUpdateDate;

    public Department(String departmentID, String name, Date createDate, Date lastUpdateDate) {
        this.departmentID = departmentID;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Department(String departmentID, String name, Date createDate) {
        this.departmentID = departmentID;
        this.name = name;
        this.createDate = createDate;

    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        int hash = 7;
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.departmentID, other.departmentID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        return Objects.equals(this.lastUpdateDate, other.lastUpdateDate);
    }

    @Override
    public String toString() {
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
 
        return "["  + departmentID + ", " + name + ", " + createDate + ", " + updateDate + "]";
    }

    public void displayDepartment() {
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
        System.out.printf("\n| %-15s | %-20s | %-15s | %-15s |", departmentID, name, createDate, updateDate);

    }

}
