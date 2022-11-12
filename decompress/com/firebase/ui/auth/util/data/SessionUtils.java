// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import java.util.Random;

public class SessionUtils
{
    private static final String VALID_CHARS = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static String generateRandomAlphaNumericString(final int n) {
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int i = 0; i < n; ++i) {
            sb.append("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(n)));
        }
        return sb.toString();
    }
}
