package com.service;


import com.entity.Tutorial;
import com.errors.ItemNotFoundException;
import com.repo.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public List<Tutorial> tutorials() {
        return tutorialRepository.findAll();
    }

    public List<Tutorial> findByTitle(String title) {
        return tutorialRepository.findByTitle(title);
    }

    public Tutorial getTutorialById(Long id) {
        return tutorialRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Tutorial createTutorial(Tutorial newTutorial) {
        return tutorialRepository.save(newTutorial);
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }

    public void deleteAllTutorial() {
        tutorialRepository.deleteAll();
    }

    public Tutorial updateOrCreateTutorial(Long id, Tutorial newTutorial) {
        return tutorialRepository.findById(id)
                .map(tutorial -> {
                    tutorial.setTitle(newTutorial.getTitle());
                    tutorial.setDescription((newTutorial.getDescription()));
                    tutorial.setPublished(newTutorial.isPublished());
                    return tutorialRepository.save(tutorial);
                })
                .orElseGet(() -> {
                    newTutorial.setId(id);
                    return tutorialRepository.save(newTutorial);
                });
    }
}
