package user;

import java.util.Date;

/**
 * @Author: Harlan
 * @Date: 2020/6/27 15:54
 */
public class User {

    private int empNo;
    private String eName;
    private String job;
    private int manager;
    private Date hireDate;
    private int sale;
    private int comm;
    private int deptNo;

    public User() {
    }

    public User(int empNo, String eName, String job, int manager, Date hireDate, int sale, int comm, int deptNo) {
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.sale = sale;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", manager='" + manager + '\'' +
                ", hireDate=" + hireDate +
                ", sale=" + sale +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                '}';
    }
}
