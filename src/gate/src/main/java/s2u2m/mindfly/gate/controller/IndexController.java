package s2u2m.mindfly.gate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping(value = "/")
	public String index() {
		return "hello";
	}
}
