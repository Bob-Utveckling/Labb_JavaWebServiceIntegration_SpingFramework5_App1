package se.iths.course.webinteg.bob.labb2;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import java.util.logging.Logger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
//@RestController
//@RestController, instead, returns object and object data into HTTP as JSON or XML
//@Controller creates Map of model object and finds a view
//https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html
public class AnmalanController {

    //Logger logger = LoggerFactory.getLogger(LoggingController.class);

    //Storage storage;

    //@Inject
    //public AnmalanController(Storage storage) {
    //    this.storage = storage;
    //}

    @RequestMapping(value="/123")
    public ResponseEntity<?> generealInfo() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/anmalan/writeYourName");
        String htmlContent =
                "123";

        return new ResponseEntity<String>(htmlContent, headers, HttpStatus.CREATED);
    }

    @GetMapping(value={"/", "/start"})
    //@RequestMapping("/start")
    // composed annot shortcut for @RequestMapping(method=Req...Meth...=GET)
    //https://stackoverflow.com/questions/39077787/difference-between-the-annotations-getmapping-and-requestmappingmethod-requ
    public String start (@RequestParam(name="name", required=false, defaultValue="Test") String name, Model model) {
        //logger.trace("Trace message");
        model.addAttribute("name",name);
        System.out.println("Start...");
        return "generalStart"; //view

    }

    @GetMapping("/skrivNamn")
    public String writeName(Model model) {
        return "writeName"; // view
    }

    //helped: https://stackoverflow.com/questions/2494774/how-to-explicitly-obtain-post-data-in-spring-mvc
    //more about validation: https://lmonkiewicz.com/programming/get-noticed-2017/spring-boot-rest-request-validation/
    @RequestMapping(value="/logInCheck", method=POST)
     public String logInCheck(@RequestParam("name") String name, Model model) {
        System.out.println(name);

        //if name in db start writing.
        model.addAttribute("name",name);
        return "AnmalaForslag";
     }


    @RequestMapping(value = "/finishedWriting", method = POST)
    public String handle(@ModelAttribute("Anmalan") Anmalan anmalan, BindingResult result) {
        //utilize ModelAttribute and get Moel anmalan with //binding result//
        // read at: http://viralpatel.net/blogs/spring-3-mvc-handling-forms/
        System.out.println("Färdighet 1 + ...: " + anmalan.getFardighet1());

        Anmalan receievedAnmalan = new Anmalan( anmalan.getName(),
                anmalan.getFardighet1(), anmalan.getFardighet2(),
                anmalan.getFardighet3(), anmalan.getFardighet4(),
                anmalan.getFardighet5(), anmalan.getForslag());

        System.out.println(receievedAnmalan.toString());
        //can also do via implemented Storage and DI
        SqLiteStorage.SqLiteStorage();
        SqLiteStorage.addAnmalan(receievedAnmalan);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        //return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
        return "AnmalanThanks";
    }


    @GetMapping(value="/viewAllaAnmalanForslag")
    public String showAllAnmalan(Model model) {

        List<Anmalan> allaAnmalan = SqLiteStorage.getAll();
        for (Anmalan each : allaAnmalan) {
            System.out.println("-- " + each.toString());
        }

        //useful templating through:
        //https://www.baeldung.com/thymeleaf-iteration
        model.addAttribute("anmalan", allaAnmalan);

        return "showAllAnmalanForslag";
    }


}


