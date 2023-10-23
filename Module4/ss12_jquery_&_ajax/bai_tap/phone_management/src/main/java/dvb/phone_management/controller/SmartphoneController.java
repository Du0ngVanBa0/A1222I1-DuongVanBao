package dvb.phone_management.controller;

import dvb.phone_management.entity.Smartphone;
import dvb.phone_management.entity.SmartphoneDto;
import dvb.phone_management.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/smartphones")
@CrossOrigin("*")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> add(@RequestBody @Valid SmartphoneDto smartphoneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Smartphone smartphone = new Smartphone();
        smartphone.setModel(smartphoneDto.getModel());
        smartphone.setPrice(smartphoneDto.getPrice());
        smartphone.setProducer(smartphone.getProducer());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> findAll() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        smartphoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
