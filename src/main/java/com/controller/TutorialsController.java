package com.controller;


import com.entity.Tutorial;
import com.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tutorials")
@RequiredArgsConstructor
public class TutorialsController {

    private final TutorialService tutorialService;

    @GetMapping("")
    List<Tutorial> tutorials(@RequestParam(required = false) String title) {
        if(StringUtils.hasText(title))
            return tutorialService.findByTitle(title);
        return tutorialService.tutorials();
    }

    @GetMapping("/{id}")
    Tutorial getTutorialById(@PathVariable Long id) {
        return tutorialService.getTutorialById(id);
    }

    @PostMapping("")
    Tutorial createTutorial(@RequestBody Tutorial newTutorial) {
        return tutorialService.createTutorial(newTutorial);
    }

    @PutMapping("/{id}")
    Tutorial updateOrCreateTutorial(@PathVariable Long id, @RequestBody Tutorial newTutorial) {
        return tutorialService.updateOrCreateTutorial(id, newTutorial);
    }

    @DeleteMapping("/{id}")
    void deleteTutorial(@PathVariable Long id) {
        tutorialService.deleteTutorial(id);
    }

    @DeleteMapping("")
    void deleteTutorial() {
        tutorialService.deleteAllTutorial();
    }
}
