package at.jku.wgmatebackend.controller;

import at.jku.wgmatebackend.model.entity.Flat;
import at.jku.wgmatebackend.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {
    @Autowired
    FlatRepository flatRepository;

    @GetMapping()
    public HashMap<String,Flat> getAllFlats() {
        List<Flat> flats = flatRepository.findAll();
        HashMap<String,Flat> map = new HashMap<>();
        for (Flat flat:flats) {
            map.put(String.valueOf(flat.getFlatId()),flat);
        }
        return map;
    }

    @PostMapping()
    public void createFlat(@RequestBody Flat flat) {
        flatRepository.save(flat);
    }

    @GetMapping("/{id}")
    public HashMap<Object, Object> getFlatById(@PathVariable(value = "id") int id) {
        Flat f = flatRepository.getNames(id);
        HashMap<Object,Object> m = new HashMap<>();
        m.put("flatName",f.getName());
        m.put("flatID",String.valueOf(f.getFlatId()));
        m.put("area",String.valueOf(f.getArea()));
        m.put("owner",f.getOwner());
        m.put("coOwner",f.getCoOwner());
        return m;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlat(@PathVariable(value = "id") int id) {
        Flat flat = flatRepository.findById(id).orElseThrow();

        flatRepository.delete(flat);

        return ResponseEntity.ok().build();
    }

}
