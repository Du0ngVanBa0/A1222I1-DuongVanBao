package dvb.controller;

import dvb.model.Disease;
import dvb.model.MedicalDeclaration;
import dvb.service.DeclarationServiceImpl;
import dvb.service.IDeclarationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/declaration")
public class DeclarationController {
    private IDeclarationService declarationService = new DeclarationServiceImpl();

    public List<Disease> getDisease(){
        List<Disease> diseases = new ArrayList<>();
        diseases.add(new Disease("Sốt", false));
        diseases.add(new Disease("Ho", false));
        diseases.add(new Disease("Khó thở", false));
        diseases.add(new Disease("Đau họng", false));
        diseases.add(new Disease("Tiêu chảy", false));
        return diseases;
    }
    public List<String> getYear(){
        List<String> years = new ArrayList<>();
        years.add("1999");
        years.add("2000");
        years.add("2001");
        years.add("2002");
        years.add("2003");
        years.add("2004");
        years.add("2005");
        return years;
    }
    public List<String> getPlaces(){
        List<String> places = new ArrayList<>();
        places.add("TP Hồ Chí Minh");
        places.add("Đà Nẵng");
        places.add("Hà Nội");
        places.add("Hải Phòng");
        places.add("Quảng Trị");
        places.add("Teyvat");
        places.add("Re:zero");
        return places;
    }
    public List<String> getNationalities(){
        List<String> nationalities = new ArrayList<>();
        nationalities.add("Việt Nam");
        nationalities.add("Singapore");
        nationalities.add("Trung Quốc");
        nationalities.add("Mỹ");
        nationalities.add("Ấn Độ");
        nationalities.add("Hàn Quốc");
        nationalities.add("Malaysia");
        return nationalities;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
        medicalDeclaration.setDiseases(getDisease());
        model.addAttribute("declaration", medicalDeclaration);
        model.addAttribute("years", getYear());
        model.addAttribute("nationalities", getNationalities());
        model.addAttribute("places", getPlaces());
        return "/create";
    }
}
