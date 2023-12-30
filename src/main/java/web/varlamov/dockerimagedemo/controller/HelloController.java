package web.varlamov.dockerimagedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
  @GetMapping
  public String get() {
    return "Hello from docker";
  }
}
