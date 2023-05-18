package case_study.FuramaResort.model;

public class Employee extends Person{
    private String employeeCode;
    private String level;
    private String position;
    private int salary;

    public Employee(String fullName, String dOB, boolean isMale, String identityCard, String phoneNumber, String email, String employeeCode, String level, String position, int salary) {
        super(fullName, dOB, isMale, identityCard, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
