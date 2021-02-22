package com.hudongyang.sunshinehook.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.Mac;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

/**
 * @author dongyang.hu
 * @date 2020/12/10 14:55
 */
public class HmacShaUtils {

    public static byte[] sha256(String source, String secretKey) {
        Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, secretKey.getBytes(StandardCharsets.UTF_8));
        return mac.doFinal(source.getBytes(StandardCharsets.UTF_8));
    }

    public static String sha256String(String source, String secretKey) {
        return Hex.encodeHexString(sha256(source, secretKey));
    }

    public static String sha256Base64(String source, String secretKey) {
        return new String(Base64.encodeBase64(sha256(source, secretKey)));
    }

    public static byte[] sha1(String source, String secretKey) {
        Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_1, secretKey.getBytes(StandardCharsets.UTF_8));
        return mac.doFinal(source.getBytes(StandardCharsets.UTF_8));
    }

    public static String sha1String(String source, String secretKey) {
        return Hex.encodeHexString(sha1(source, secretKey));
    }
}
