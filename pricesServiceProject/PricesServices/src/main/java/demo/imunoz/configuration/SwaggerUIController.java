package demo.imunoz.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class SwaggerUIController {

    @GetMapping()
    public String redirect() {
	return "redirect:/swagger-ui/index.html";
    }
}
