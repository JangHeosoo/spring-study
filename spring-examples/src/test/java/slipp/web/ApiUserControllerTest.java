package slipp.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import slipp.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiUserControllerTest {
    private static final Logger log = LoggerFactory.getLogger(ApiUserControllerTest.class);

    @Autowired
    private TestRestTemplate template;

    @Test
    public void bindingError() throws Exception {
        User user = new User("un", "pa", "javajigi", 1);
        ResponseEntity<String> result = template.postForEntity("/api/users", user, String.class);
        log.debug("body : {}", result.getBody());
    }

    @Test
    public void valid() throws Exception {
        User user = new User("username", "pass", "javajigi@slipp.net", 1);
        ResponseEntity<String> result = template.postForEntity("/api/users", user, String.class);
        log.debug("body : {}", result.getBody());
    }
}
