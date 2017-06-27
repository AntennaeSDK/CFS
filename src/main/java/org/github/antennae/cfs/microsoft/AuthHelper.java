package org.github.antennae.cfs.microsoft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.springframework.web.util.UriComponentsBuilder;

public class AuthHelper {
    private static final String authority = "https://login.microsoftonline.com";
    private static final String authorizeUrl = authority + "/common/oauth2/v2.0/authorize";

    private static String[] scopes = {
            "openid",
            "offline_access",
            "profile",
            "User.Read",
            "Mail.Read"
    };

    private static String appId = null;
    private static String appPassword = null;
    private static String redirectUrl = null;

    private static String getAppId() {
        if (appId == null) {
            try {
                loadConfig();
            } catch (Exception e) {
                return null;
            }
        }
        return appId;
    }
    private static String getAppPassword() {
        if (appPassword == null) {
            try {
                loadConfig();
            } catch (Exception e) {
                return null;
            }
        }
        return appPassword;
    }

    private static String getRedirectUrl() {
        if (redirectUrl == null) {
            try {
                loadConfig();
            } catch (Exception e) {
                return null;
            }
        }
        return redirectUrl;
    }

    private static String getScopes() {
        StringBuilder sb = new StringBuilder();
        for (String scope: scopes) {
            sb.append(scope + " ");
        }
        return sb.toString().trim();
    }

    private static void loadConfig() throws IOException {
        String authConfigFile = "auth.properties";
        InputStream authConfigStream = AuthHelper.class.getClassLoader().getResourceAsStream(authConfigFile);

        if (authConfigStream != null) {
            Properties authProps = new Properties();

            try {

                authProps.load(authConfigStream);

                // ENV variables take precedence
                String appIdEnv = System.getenv("MS.APPID");
                if( appIdEnv == null || appIdEnv.trim().isEmpty()) {
                    appId = authProps.getProperty("MS.APPID");
                }else{
                    appId = appIdEnv;
                }

                String appPasswordEnv = System.getenv("MS.APP_PASSWORD");
                if( appPasswordEnv == null || appPasswordEnv.trim().isEmpty()) {
                    appPassword = authProps.getProperty("MS.APP_PASSWORD");
                }else{
                    appPassword = appPasswordEnv;
                }

                String redirectUrlEnv = System.getenv("MS.REDIRECT_URL");
                if( redirectUrlEnv == null || redirectUrlEnv.trim().isEmpty()){
                    redirectUrl = authProps.getProperty("MS.REDIRECT_URL");
                }else{
                    redirectUrl = redirectUrlEnv;
                }

            } finally {
                authConfigStream.close();
            }
        }
        else {
            throw new FileNotFoundException("Property file '" + authConfigFile + "' not found in the classpath.");
        }
    }

    public static String getLoginUrl(UUID state, UUID nonce) {

        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(authorizeUrl);
        urlBuilder.queryParam("client_id", getAppId());
        urlBuilder.queryParam("redirect_uri", getRedirectUrl());
        urlBuilder.queryParam("response_type", "code id_token");
        urlBuilder.queryParam("scope", getScopes());
        urlBuilder.queryParam("state", state);
        urlBuilder.queryParam("nonce", nonce);
        urlBuilder.queryParam("response_mode", "form_post");

        return urlBuilder.toUriString();
    }
}