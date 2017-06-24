package og.github.antennae.cfs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        Date currentTime = Calendar.getInstance().getTime();
        model.addAttribute("name", name);
        model.addAttribute("date", currentTime);
        return "home";
    }

}