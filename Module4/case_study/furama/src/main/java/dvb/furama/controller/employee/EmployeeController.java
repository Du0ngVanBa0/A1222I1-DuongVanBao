package dvb.furama.controller.employee;

import dvb.furama.entity.employee.Employee;
import dvb.furama.entity.employee.EmployeeDto;
import dvb.furama.service.division.DivisionService;
import dvb.furama.service.education_degree.EducationDegreeService;
import dvb.furama.service.employee.EmployeeService;
import dvb.furama.service.position.PositionService;
import dvb.furama.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private UserService userService;
    @Autowired
    private EducationDegreeService educationDegreeService;

    @GetMapping
    public String showList(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        Page<Employee> employeePage = employeeService.findAllPaging(pageable);
        List<Employee> employeeList = employeePage.getContent();
        List<EmployeeDto> employeeDtoPage = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDto dto = new EmployeeDto();
            copyPropertiesToDto(employee, dto);
            employeeDtoPage.add(dto);
        }
        model.addAttribute("employees", employeeDtoPage);
        model.addAttribute("totalPage", employeePage.getTotalPages());
        model.addAttribute("pageNumber", employeePage.getNumber());
        model.addAttribute("size", employeePage.getSize());
        model.addAttribute("currentPage", employeePage.getNumber());
        return "/employee/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/employee/create";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeDto employeeDto = new EmployeeDto();
            copyPropertiesToDto(employee, employeeDto);
            model.addAttribute("employee", employeeDto);
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("divisions", divisionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            model.addAttribute("users", userService.findAll());
            return "/employee/edit";
        }
        return "redirect:/employee";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        copyPropertiesToEntity(employeeDto, employee);
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String editEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());
        if (employeeOptional.isPresent()) {
            Employee employee = new Employee();
            copyPropertiesToEntity(employeeDto, employee);
            employeeService.save(employee);
        }
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public String showSearchList(Model model, @RequestParam("search_inp") String inp, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        Page<Employee> employeePage = employeeService.findAllByName(inp, pageable);
        List<Employee> employeeList = employeePage.getContent();
        List<EmployeeDto> employeeDtoPage = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDto dto = new EmployeeDto();
            copyPropertiesToDto(employee, dto);
            employeeDtoPage.add(dto);
        }
        model.addAttribute("searchAttr", inp);
        model.addAttribute("employees", employeeDtoPage);
        model.addAttribute("totalPage", employeePage.getTotalPages());
        model.addAttribute("pageNumber", employeePage.getNumber());
        model.addAttribute("size", employeePage.getSize());
        model.addAttribute("currentPage", employeePage.getNumber());
        return "/employee/index";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            employeeService.deleteById(id);
        }
        return "redirect:/employee";
    }

    private void copyPropertiesToDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setCard(employee.getCard());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setDivision(employee.getDivision());
        employeeDto.setEducationDegree(employee.getEducationDegree());
        employeeDto.setUser(employee.getUser());
        employeeDto.setName(employee.getName());
    }

    private void copyPropertiesToEntity(EmployeeDto employeeDto, Employee employee) {
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setCard(employeeDto.getCard());
        employee.setSalary(employeeDto.getSalary());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setPosition(employeeDto.getPosition());
        employee.setDivision(employeeDto.getDivision());
        employee.setEducationDegree(employeeDto.getEducationDegree());
        employee.setName(employeeDto.getName());
        employee.setUser(employeeDto.getUser());
        employee.setAddress(employeeDto.getAddress());
    }
}
