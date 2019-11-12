package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {
        return "hello";
    }

    //cd ~/workspace/assignment-submission
    //./gradlew cloudNativeDeveloperSimpleApp -PserverUrl=https://${APP_URL}
    //./gradlew cloudNativeDeveloperSimpleApp -PserverUrl=http://pal-tracker-shiny-wildebeest.apps.evans.pal.pivotal.io/
}