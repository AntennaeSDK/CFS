package org.github.antennae.cfs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by nsankaran on 6/26/17.
 */
@Controller
public class MicrosoftAuthorizeController {

    @RequestMapping(value="/authorize", method= RequestMethod.POST)
    public String authorize(
            @RequestParam("code") String code,
            @RequestParam("id_token") String idToken,
            @RequestParam("state") UUID state,
            HttpServletRequest request,
            Model model) {
        {

            // Get the expected state value from the session
            HttpSession session = request.getSession();
            UUID expectedState = (UUID) session.getAttribute("expected_state");
            UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");

            // Make sure that the state query parameter returned matches
            // the expected state
            if (state.equals(expectedState)) {
                session.setAttribute("authCode", code);
                session.setAttribute("idToken", idToken);
            } else {
                session.setAttribute("error", "Unexpected state returned from authority.");
            }

            model.addAttribute("authCode", code);
            model.addAttribute("idToken", idToken);

            return "auth";
        }
    }

}
