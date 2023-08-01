package dvb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    public String  translate(String word){
        String [] arrViet = {"Chao","ten","Cay","nam","Mot","Muoi"};
        String [] arrEng = {"hi","name","spicy","man","one","ten"};
        for (int i = 0; i <arrViet.length ; i++) {
            if(word.equals(arrEng[i])){
                return arrViet[i];
            }
        }
        return "Not Found";
    }

    @GetMapping("/search")
    public String search(@RequestParam String word, Model model){
        model.addAttribute("trans", translate(word));
        return "dictionary";
    }
}
