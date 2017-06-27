package org.github.antennae.cfs.web;

import org.github.antennae.cfs.microsoft.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

                //session.setAttribute("authCode", code);
                //session.setAttribute("idToken", idToken);

                IdToken idTokenObj = IdToken.parseEncodedToken(idToken, expectedNonce.toString());

                if (idTokenObj != null) {
                    TokenResponse tokenResponse = AuthHelper.getTokenFromAuthCode(code, idTokenObj.getTenantId());
                    session.setAttribute("tokens", tokenResponse);
                    session.setAttribute("userConnected", true);
                    session.setAttribute("userName", idTokenObj.getName());
                    session.setAttribute("userTenantId", idTokenObj.getTenantId());

                    model.addAttribute("accessToken", tokenResponse.getAccessToken());

                    // Get user info
                    IOutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokenResponse.getAccessToken(), null);
                    OutlookUser user;
                    try {
                        user = outlookService.getCurrentUser().execute().body();
                        session.setAttribute("userEmail", user.getMail());
                    } catch (IOException e) {
                        session.setAttribute("error", e.getMessage());
                    }

                } else {
                    session.setAttribute("error", "ID token failed validation.");
                }

            } else {
                session.setAttribute("error", "Unexpected state returned from authority.");
            }

            boolean isLoggedIn = false;
            if( session.getAttribute("userName") != null ){
                isLoggedIn = true;
            }
            model.addAttribute("isLoggedIn", isLoggedIn);
            model.addAttribute("authCode", code);
            model.addAttribute("idToken", idToken);

            return "auth";
        }
    }

}
