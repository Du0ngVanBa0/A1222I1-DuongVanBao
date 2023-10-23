package dvb.furama.entity.contact;

import dvb.furama.entity.customer.Customer;
import dvb.furama.entity.employee.Employee;
import dvb.furama.entity.service.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ContractDto {
    private Integer contractId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @NotNull(message = "Deposit must not be null")
    @DecimalMin(value = "0",message = "deposit must be a number bigger than or equal 0")
    private Double deposit;
    @DecimalMin(value = "0",message = "money must be a number bigger than or equal 0")
    private Double money;
    private Employee employee;
    private Customer customer;
    private Service service;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ContractDto(Date startDate, Date endDate, Double deposit, Double money, Employee employee, Customer customer, Service service) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.money = money;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public ContractDto() {
    }
}
