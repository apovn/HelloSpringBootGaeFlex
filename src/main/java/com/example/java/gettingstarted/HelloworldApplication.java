/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.java.gettingstarted;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import java.util.logging.Level;

@SpringBootApplication
@RestController
public class HelloworldApplication {

    private final Logger logger = Logger.getLogger(HelloworldApplication.class.getName());

    @Value("${application.company}")
    private String company;

    @RequestMapping("/")
    private String home() {
        logger.log(Level.INFO, "Started HelloworldApplication.");
        return "Hello World!";
    }

    /**
     * (Optional) App Engine health check endpoint mapping.
     *
     * @see <a href="https://cloud.google.com/appengine/docs/flexible/java/how-instances-are-managed#health_checking"></a>
     * If your app does not handle health checks, a HTTP 404 response is interpreted
     * as a successful reply.
     */
    @RequestMapping("/health")
    public String healthy() {
        // Message body required though ignored
        logger.info("Checking HelloworldApplication health.");
        return "Still surviving. Profile: " + company;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
}
