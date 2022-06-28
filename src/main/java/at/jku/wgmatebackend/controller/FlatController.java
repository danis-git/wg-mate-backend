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
    public HashMap<String, Flat> getAllFlats() {
        List<Flat> flats = flatRepository.findAll();
        HashMap<String, Flat> map = new HashMap<>();
        for (Flat flat : flats) {
            map.put(String.valueOf(flat.getFlatId()), flat);
        }
        return map;
    }

    @PostMapping()
    public Flat createFlat(@RequestBody Flat flat) {
        return flatRepository.save(flat);
    }

    @GetMapping("/{id}")
    public HashMap<String, Flat> getFlatById(@PathVariable(value = "id") int id) {
        List<Flat> f = flatRepository.getNames(id);
        List<Flat> coFlats = flatRepository.findAll();
        HashMap<String, Flat> m = new HashMap<>();
        for (Flat flat : f) {
            m.put(String.valueOf(flat.getFlatId()), flat);
        }
        for(Flat flat : coFlats){
            HashMap<Integer, Integer> co = flat.getCoOwnerID();
            if(co.containsValue(id)){
                m.put(String.valueOf(flat.getFlatId()), flat);
            }
        }
        return m;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlat(@PathVariable(value = "id") int id) {
        Flat flat = flatRepository.findById(id).orElseThrow();

        flatRepository.delete(flat);

        return ResponseEntity.ok().build();
    }

}
