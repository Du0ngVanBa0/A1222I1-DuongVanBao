package dvb.controller;

import dvb.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/showForm")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "/create";
    }

    @PostMapping("/addEmployee")
    public String submit(ModelMap modelMap, @ModelAttribute("employee") Employee employee){
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id",employee.getId());
        return "/info";
    }
}
