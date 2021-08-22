//package com.hwhy.moommoo.utils;
//
//import com.hwhy.moommoo.config.BaseException;
//import com.hwhy.moommoo.config.BaseResponseStatus;
//import com.hwhy.moommoo.config.Secret;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import static com.hwhy.moommoo.config.BaseResponseStatus.EMPTY_JWT;
//import static com.hwhy.moommoo.config.BaseResponseStatus.INVALID_TOKEN;
//
//@Service
//public class JwtService {
//    public static String createJwt(long id){
//        Date now = new Date();
//        return Jwts.builder()
//                .claim("userId", id)
//                .setIssuedAt(now)
//                .signWith(SignatureAlgorithm.HS256, Secret.JWT_SECRET_KEY)
//                .compact();
//    }
//
//
//    /**
//     * Header에서 X-ACCESS-TOKEN 으로 JWT 추출
//     * @return String
//     */
//    public String getJwt() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        return request.getHeader("X-ACCESS-TOKEN");
//    }
//
//    /**
//     * JWT에서 userId 추출
//     * @return int
//     * @throws BaseException
//     */
//
//    public long getUserId() throws BaseException {
//        // 1. JWT 추출
//        String accessToken = getJwt();
//        if (accessToken == null || accessToken.length() == 0) {
//            throw new BaseException(EMPTY_JWT);
//        }
//
//        // 2. JWT parsing
//        Jws<Claims> claims;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(Secret.JWT_SECRET_KEY)
//                    .parseClaimsJws(accessToken);
//        } catch (Exception ignored) {
//            throw new BaseException(INVALID_TOKEN);
//        }
//
//        int user = claims.getBody().get("userId", Integer.class);
//        // 3. userId 추출
//        return Long.valueOf(user);
//    }
//}
