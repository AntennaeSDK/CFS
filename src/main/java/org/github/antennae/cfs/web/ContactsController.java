package org.github.antennae.cfs.web;

import org.github.antennae.cfs.microsoft.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by nsankaran on 6/30/17.
 */
@Controller
public class ContactsController {
    @RequestMapping("/contacts")
    public String contacts(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();

        boolean isLoggedIn = false;
        if( session.getAttribute("userName") != null ){
            isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }


        TokenResponse tokens = (TokenResponse)session.getAttribute("tokens");
        if (tokens == null) {
            // No tokens in session, user needs to sign in
            redirectAttributes.addFlashAttribute("error", "Please sign in to continue.");
            return "redirect:/";
        }

        String tenantId = (String)session.getAttribute("userTenantId");

        tokens = AuthHelper.ensureTokens(tokens, tenantId);

        String email = (String)session.getAttribute("userEmail");

        IOutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokens.getAccessToken(), email);

        // Sort by given name in ascending order (A-Z)
        String sort = "GivenName ASC";
        // Only return the properties we care about
        String properties = "GivenName,Surname,CompanyName,EmailAddresses";
        // Return at most 10 contacts
        Integer maxResults = 100;

        try {
            PagedResult<Contact> contacts = outlookService.getContacts(
                    sort, properties, maxResults)
                    .execute().body();
            model.addAttribute("contacts", contacts.getValue());
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/";
        }

        return "tiles.contacts";
    }
}