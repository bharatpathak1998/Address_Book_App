package com.example.addressbookapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.example.addressbookapp.exception.TokenNotFoundException;
import com.example.addressbookapp.model.AddressBookModel;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    private static final String TOKEN_SECRET = "Secret";

    public String createToken(AddressBookModel addressBookModel) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        return JWT.create().withClaim("Address", addressBookModel.getId()).sign(algorithm);
    }

    public Integer decodeToken(String token) throws TokenNotFoundException {
        Verification verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        JWTVerifier jwtVerifier = verification.build();
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            Claim idClaim = decodedJWT.getClaim("Address");
            return idClaim.asInt();
        } catch (JWTVerificationException e) {
            throw new TokenNotFoundException();
        }
    }
}