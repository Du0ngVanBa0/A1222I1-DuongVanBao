package dvb.sign_form.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Bắt buộc")
    @Size(min = 5, max = 45, message = "Có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @NotBlank(message = "Bắt buộc")
    @Size(min = 5, max = 45, message = "Có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @Size(min = 10, max = 10, message = "Số điện thoại phải có 10 số")
    @Pattern(regexp = "(84|0[3|5|7|8|9])([0-9]{8})", message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    private int age;
    @Email(message = "Email không đúng định dạng")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User() {
    }
}
