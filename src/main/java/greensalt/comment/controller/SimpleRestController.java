package greensalt.comment.controller;

import greensalt.comment.domain.CommentDto;
import greensalt.comment.domain.Person;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleRestController {
    @GetMapping("/commentTest")
    public String commentTest() {
        return "commentTest";
    }

    @PostMapping("/send")
    public Person test(Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}