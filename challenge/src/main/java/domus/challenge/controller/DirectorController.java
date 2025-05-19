package domus.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domus.challenge.model.DirectorResponse;
import domus.challenge.service.DirectorService;

@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/api/directors")
    public DirectorResponse getDirectors(@RequestParam("threshold") Integer threshold) {
        return directorService.getDirectors(threshold);
    }
}