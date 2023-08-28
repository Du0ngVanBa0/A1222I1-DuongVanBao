package dvb.song_validate.controller;

import dvb.song_validate.entity.Song;
import dvb.song_validate.service.SongService;
import dvb.song_validate.utils.SongValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private SongValidator songValidator;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("action", "create");
        return "/views/create";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(Model model, @PathVariable("id") int id) {
        model.addAttribute("song", songService.findByID(id));
        model.addAttribute("action", "update");
        return "/views/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated Song song, BindingResult bindingResult, @RequestParam("action") String action) {
        songValidator.validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/views/create";
        }
        if (action.equals("create")) {
            songService.create(song);
        } else
            songService.update(song);
        return "redirect:/song/create";
    }
}
