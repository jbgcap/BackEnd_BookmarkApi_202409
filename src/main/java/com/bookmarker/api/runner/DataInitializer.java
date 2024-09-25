package com.bookmarker.api.runner;

import com.bookmarker.api.domain.Bookmark;
import com.bookmarker.api.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<Bookmark> bookmarkList = List.of(new Bookmark("How (not) to ask for Technical Help?", "https://labs.in/how-to-not-to-ask-for-technical-help", Instant.now()),
                new Bookmark("Announcing My SpringBoot Tips Video Series", "https://labs.in/announcing-my-springboot-tips-video-series", Instant.now()),
                new Bookmark("Getting Started with Kubernetes", "https://sivalabs.in/getting-started-with-kubernetes", Instant.now()),
                new Bookmark("Kubernetes Cluster using Ingress", "https://labs.in/kubernetes-ingress", Instant.now()),
                new Bookmark("Kubernetes - Blue/Green Deployments", "https://labs.in/kubernetes-blue-green-deployments", Instant.now()),
                new Bookmark("Integration Testing using TestContainers", "https://labs.in/integration-testing-using-testcontainers", Instant.now()),
                new Bookmark("Deployment Rolling Updates", "https://labs.in/kubernetes-deployment-rolling-updates", Instant.now()),
                new Bookmark("GoLang from a Java developer perspective", "https://labs.in/golang-from-a-java-developer-perspective", Instant.now()),
                new Bookmark("Code Structure Guidelines using ArchUnit", "https://labs.in/architecture-guidelines-using-archunit", Instant.now()),
                new Bookmark("SpringBoot Generator", "https://labs.in/springboot-generator", Instant.now()),
                new Bookmark("Testing REST APIs using Postman", "https://labs.in/testing-rest-apis-with-postman", Instant.now()),
                new Bookmark("Testing SpringBoot Applications", "https://labs.in/spring-boot-testing", Instant.now())
        );
        repository.saveAll(bookmarkList);
    }
}