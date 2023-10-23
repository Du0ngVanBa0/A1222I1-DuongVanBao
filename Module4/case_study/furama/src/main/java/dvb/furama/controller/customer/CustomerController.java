package dvb.furama.controller.customer;

import dvb.furama.entity.customer.Customer;
import dvb.furama.entity.customer.CustomerDto;
import dvb.furama.service.customer.CustomerService;
import dvb.furama.service.customer_type.CustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping
    public String showList(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        Page<Customer> customerPage = customerService.findAllPaging(pageable);
        List<Customer> customerList = customerPage.getContent();
        List<CustomerDto> customerDtoPage = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto dto = new CustomerDto();
            copyPropertiesToDto(customer, dto);
            customerDtoPage.add(dto);
        }
        model.addAttribute("customers", customerDtoPage);
        model.addAttribute("totalPage", customerPage.getTotalPages());
        model.addAttribute("pageNumber", customerPage.getNumber());
        model.addAttribute("size", customerPage.getSize());
        model.addAttribute("currentPage", customerPage.getNumber());
        return "/customer/index";
    }

    @GetMapping("/search")
    public String showSearchList(Model model, @RequestParam("search_inp") String inp, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        Page<Customer> customerPage = customerService.findAllByName(inp, pageable);
        List<Customer> customerList = customerPage.getContent();
        List<CustomerDto> customerDtoPage = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto dto = new CustomerDto();
            copyPropertiesToDto(customer, dto);
            customerDtoPage.add(dto);
        }
        model.addAttribute("searchAttr", inp);
        model.addAttribute("customers", customerDtoPage);
        model.addAttribute("totalPage", customerPage.getTotalPages());
        model.addAttribute("pageNumber", customerPage.getNumber());
        model.addAttribute("size", customerPage.getSize());
        model.addAttribute("currentPage", customerPage.getNumber());
        return "/customer/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/create";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            CustomerDto customerDto = new CustomerDto();
            copyPropertiesToDto(customer, customerDto);
            model.addAttribute("customer", customerDto);
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "/customer/edit";
        }
        return "redirect:/customer";
    }

    @PostMapping("/create")
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        copyPropertiesToEntity(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping("/edit")
    public String editCustomer(CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerService.findById(customerDto.getCustomerId());
        if (customerOptional.isPresent()) {
            Customer customer = new Customer();
            copyPropertiesToEntity(customerDto, customer);
            customerService.save(customer);
        }
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.deleteById(id);
        }
        return "redirect:/customer";
    }

    private void copyPropertiesToDto(Customer customer, CustomerDto customerDto) {
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setAddress(customer.getAddress());
        customerDto.setBirthday(customer.getBirthday());
        customerDto.setCard(customer.getCard());
        customerDto.setGender(customer.getGender());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setCustomerType(customer.getCustomerType());
        customerDto.setName(customer.getName());
    }

    private void copyPropertiesToEntity(CustomerDto customerDto, Customer customer) {
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setAddress(customerDto.getAddress());
        customer.setBirthday(customerDto.getBirthday());
        customer.setCard(customerDto.getCard());
        customer.setGender(customerDto.getGender());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setCustomerType(customerDto.getCustomerType());
        customer.setName(customerDto.getName());
    }
}
