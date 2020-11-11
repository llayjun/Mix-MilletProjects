package com.llayjun.millet.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * JWT token 生成与验证
 *
 * @author zyl
 * @since 2019/10/15
 */
@Slf4j
public class JwtTokenUtil {

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_STRING = "Authorization";
    /**
     * 过期时间, 默认7天
     */
    private static final long EXPIRE = 7 * 86_400_000L;
    /**
     * JWT secret
     */
    private static final String SECRET = "milletUserJwtSecret";
    /**
     * Token前缀
     */
    private static final String TOKEN_PREFIX = "Bearer";

    /**
     * 生成通用JWT token
     *
     * @param userId 用户id
     * @return JWT String
     */
    public static String buildJWTToken(String userId) {
        String token = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
                .setId(userId)
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        log.debug("用户id: {}, 生成token:{}", userId, token);
        return token;
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     */
    public static boolean validateJWTToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 通用用户JWT验证
     *
     * @param request http请求
     * @return Authentication
     */
    public static String getJwtUserId(HttpServletRequest request) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);
        if (token != null && validateJWTToken(token)) {
            // 解析 Token
            Claims claims = getClaims(token);
            // 返回验证令牌
            String userId = claims.getId();
            return userId != null ? userId: "";
        }
        return "";
    }

    /**
     * 获取Claims
     *
     * @param token token
     * @return Claims
     */
    private static Claims getClaims(String token) {
        return Jwts.parser()
                // 验签
                .setSigningKey(SECRET)
                // 去掉 Bearer
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
    }

}