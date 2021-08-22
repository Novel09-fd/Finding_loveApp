package com.novel.finder.utility;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

public class JwtUtil {

    public static void decoded(String JwtEncoded) throws Exception {
        try {
            String[] split = JwtEncoded.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
        } catch (UnsupportedEncodingException e) {
            //Error
        }
    }

    public static String getBodyDecode(String token) throws UnsupportedEncodingException {
        String[] split = token.split("\\.");
        String body =getJson(split[1]);
        return body;
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException{
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }
}
