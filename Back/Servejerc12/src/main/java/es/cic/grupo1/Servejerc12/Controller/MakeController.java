package es.cic.grupo1.Servejerc12.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.cic.grupo1.Servejerc12.Model.Make;
import es.cic.grupo1.Servejerc12.Service.MakeService;

@RestController
@RequestMapping("/api/makes")
public class MakeController {

    @Autowired
    private MakeService makeService;

    @GetMapping
    public List<Make> getAllMakes() {
        return makeService.getAllMake();
    }

    @GetMapping("/{id}")
    public Make getMakeById(@PathVariable Long id) {
        return makeService.getMakeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Make createMake(@RequestBody Make make) {
        return makeService.createMake(make);
    }

    @PutMapping("/{id}")
    public Make updateMake(@PathVariable Long id, @RequestBody Make updatedMake) {
        return makeService.updateMake(id, updatedMake);
    }

    @DeleteMapping("/{id}")
    public void deleteMake(@PathVariable Long id) {
        makeService.deleteMake(id);
    }
}