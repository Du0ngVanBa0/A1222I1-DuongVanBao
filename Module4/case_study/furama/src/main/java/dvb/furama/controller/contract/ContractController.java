package dvb.furama.controller.contract;

import dvb.furama.entity.contact.Contract;
import dvb.furama.entity.contact.ContractDto;
import dvb.furama.service.contract.ContractService;
import dvb.furama.service.customer.CustomerService;
import dvb.furama.service.employee.EmployeeService;
import dvb.furama.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new ContractDto());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("services", serviceService.findToCreateContract(1, 2));
        return "/contract/create";
    }

    @PostMapping("/create")
    public String createContract(@Valid @ModelAttribute(name = "contract") ContractDto contractDto,BindingResult bindingResult,Model model ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("services", serviceService.findToCreateContract(1, 2));
            return "/contract/create";
        }
        Contract contract = new Contract();
        copyPropertiesToEntity(contractDto, contract);
        contractService.save(contract);
        return "redirect:/contract/create";
    }

    private void copyPropertiesToEntity(ContractDto contractDto, Contract contract) {
        contract.setContractId(contractDto.getContractId());
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
        contract.setDeposit(contractDto.getDeposit());
        contract.setMoney(contractDto.getMoney());
        contract.setEmployee(contractDto.getEmployee());
        contract.setCustomer(contractDto.getCustomer());
        contract.setService(contractDto.getService());
    }
}
