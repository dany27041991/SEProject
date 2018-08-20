package com.projectSE.credentialMicroservices.utils;

import io.jsonwebtoken.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    //metodo usato per generare il JWT
    public static String generateJwt(String subject, Date date, String name, String scope) throws java.io.UnsupportedEncodingException {
        String jwt = Jwts.builder()
                .setSubject(subject)
                .setExpiration(date)
                .claim("name", name)
                .claim("scope", scope)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "myPersonalSecretKeyForPPS".getBytes("UTF-8")
                )
                .compact();
        return jwt;
    }

    //recupero dal JWT una mappa con i dati del client
    public static Map<String, Object> jwt2Map(String jwt) throws java.io.UnsupportedEncodingException, ExpiredJwtException {
        Jws<Claims> claim = Jwts.parser()
                .setSigningKey("myPersonalSecretKey12345".getBytes("UTF-8"))
                .parseClaimsJws(jwt);

        String name = claim.getBody().get("name", String.class);
        String scope = (String) claim.getBody().get("scope");

        Date expDate = claim.getBody().getExpiration();
        String subj = claim.getBody().getSubject();

        Map<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("scope", scope);
        userData.put("exp_date", expDate);
        userData.put("subject", subj);

        Date now = new Date();
        if(now.after(expDate)) {
            throw new ExpiredJwtException(null, null, "Session Expired");
        }
        return userData;
    }

    //si analizza la presenza di un JWT all'interno dell'header o dei cookies
    public static String getJwtFromHttpRequest(HttpServletRequest request) {
        String jwt = null;
        if(request.getHeader("jwt") != null) {
            jwt = request.getHeader("jwt");
        } else if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("jwt")){
                    jwt = cookie.getValue();
                }
            }
        }
        return jwt;
    }

}
