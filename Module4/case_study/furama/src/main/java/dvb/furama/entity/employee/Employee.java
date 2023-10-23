package dvb.furama.entity.employee;

import dvb.furama.entity.division.Division;
import dvb.furama.entity.education_degree.EducationDegree;
import dvb.furama.entity.position.Position;
import dvb.furama.entity.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private Date birthday;
    private String card;
    private Double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name= "position_id",referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_id",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "userName")
    private User user;

    public Employee() {
    }

    public Employee(String name, Date birthday, String card, Double salary, String phone, String email, String address, Position position, Division division, EducationDegree educationDegree, User user) {
        this.name = name;
        this.birthday = birthday;
        this.card = card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
        this.user = user;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
