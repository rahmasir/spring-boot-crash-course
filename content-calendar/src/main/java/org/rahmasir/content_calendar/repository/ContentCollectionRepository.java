package org.rahmasir.content_calendar.repository;


import jakarta.annotation.PostConstruct;
import org.rahmasir.content_calendar.model.Content;
import org.rahmasir.content_calendar.model.Status;
import org.rahmasir.content_calendar.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void init() {
        var content = new Content(
                1,
                "My first blog",
                "this is my first Blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDate.now(),
                null,
                ""
        );
        contentList.add(content);
    }

    public Content save(Content content) {
        contentList.add(content);
        return content;
    }

    public Content update(Content content, Integer id) {
        for(int i = 0; i < contentList.size(); i++) {
            if(contentList.get(i).id().equals(id)) {
                contentList.set(i, content);
            }
        }
        return content;
    }

    public boolean existById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
