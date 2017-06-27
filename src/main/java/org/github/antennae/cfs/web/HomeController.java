package org.github.antennae.cfs.web;


import org.github.antennae.cfs.microsoft.AuthHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value="name", required=false, defaultValue="World") String name,
                       Model model, HttpServletRequest request) {

        Date currentTime = Calendar.getInstance().getTime();

        model.addAttribute("name", name);
        model.addAttribute("date", currentTime);


        UUID state = UUID.randomUUID();
        UUID nonce = UUID.randomUUID();

        // Save the state and nonce in the session so we can
        // verify after the auth process redirects back
        HttpSession session = request.getSession();
        session.setAttribute("expected_state", state);
        session.setAttribute("expected_nonce", nonce);

        String loginUrl = AuthHelper.getLoginUrl(state, nonce);

        Map<String,String> env = System.getenv();

        System.out.println("ENV \n"+ env);

        model.addAttribute("loginUrl", loginUrl);

        return "home";
    }

}