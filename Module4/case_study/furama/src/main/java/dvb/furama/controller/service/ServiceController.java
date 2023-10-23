package dvb.furama.controller.service;

import dvb.furama.entity.service.Service;
import dvb.furama.entity.service.ServiceDto;
import dvb.furama.service.rent_type.RentTypeService;
import dvb.furama.service.service.ServiceService;
import dvb.furama.service.service_type.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService service;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("service", new ServiceDto());
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return "/service/create";
    }

    @PostMapping("/create")
    public String createService(ServiceDto serviceDto) {
        Service serviceEntity = new Service();
        copyPropertiesToEntity(serviceEntity, serviceDto);
        service.save(serviceEntity);
        return "redirect:/service/create";
    }

    private void copyPropertiesToEntity(Service service, ServiceDto serviceDto) {
        service.setName(serviceDto.getName());
        service.setArea(serviceDto.getArea());
        service.setCost(serviceDto.getCost());
        service.setMaxPeople(serviceDto.getMaxPeople());
        service.setRoom(serviceDto.getRoom());
        service.setDescriptionOtherConvenience(serviceDto.getDescriptionOtherConvenience());
        service.setNumberOfFloors(serviceDto.getNumberOfFloors());
        service.setPoolArea(serviceDto.getPoolArea());
        service.setServiceType(serviceDto.getServiceType());
        service.setRentType(serviceDto.getRentType());
    }
}
