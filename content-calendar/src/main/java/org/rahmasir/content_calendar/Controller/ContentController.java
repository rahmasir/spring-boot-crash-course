package org.rahmasir.content_calendar.Controller;


import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.rahmasir.content_calendar.model.Content;
import org.rahmasir.content_calendar.model.Status;
import org.rahmasir.content_calendar.model.Type;
import org.rahmasir.content_calendar.repository.ContentCollectionRepository;
import org.rahmasir.content_calendar.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!")));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Content save(@Valid @RequestBody Content content) {
        return repository.save(content);
    }

//    @PutMapping("/{id}")
//    public Content update(@Valid @RequestBody Content content, @PathVariable Integer id) {
//        if(!repository.existById(id))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
//        return repository.update(content, id);
//    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void save(@PathVariable Integer id) {
//        if(!repository.existById(id))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
//        repository.deleteById(id);
//    }
}
