// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseError;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import android.util.Base64;
import java.security.MessageDigest;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import java.util.Locale;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.database.DatabaseException;

public class Utilities
{
    private static final char[] a;
    
    static {
        a = "0123456789abcdef".toCharArray();
    }
    
    public static int a(final int n, final int n2) {
        if (n < n2) {
            return -1;
        }
        if (n == n2) {
            return 0;
        }
        return 1;
    }
    
    public static int b(final long n, final long n2) {
        final long n3 = lcmp(n, n2);
        if (n3 < 0) {
            return -1;
        }
        if (n3 == 0) {
            return 0;
        }
        return 1;
    }
    
    public static String c(final double n) {
        final StringBuilder sb = new StringBuilder(16);
        final long doubleToLongBits = Double.doubleToLongBits(n);
        for (int i = 7; i >= 0; --i) {
            final int n2 = (int)(doubleToLongBits >>> i * 8 & 0xFFL);
            final char[] a = Utilities.a;
            sb.append(a[n2 >> 4 & 0xF]);
            sb.append(a[n2 & 0xF]);
        }
        return sb.toString();
    }
    
    public static boolean d(final Object o, final Object o2) {
        return o == o2 || (o != null && o2 != null && o.equals(o2));
    }
    
    private static String e(String substring) {
        final int index = substring.indexOf("//");
        if (index == -1) {
            throw new DatabaseException("Firebase Database URL is missing URL scheme");
        }
        substring = substring.substring(index + 2);
        final int index2 = substring.indexOf("/");
        if (index2 == -1) {
            return "";
        }
        final int index3 = substring.indexOf("?");
        if (index3 != -1) {
            return substring.substring(index2 + 1, index3);
        }
        return substring.substring(index2 + 1);
    }
    
    public static void f(final boolean b) {
        g(b, "");
    }
    
    public static void g(final boolean b, final String s) {
        if (!b) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Assertion failed: ");
            sb.append(s);
            Log.w("FirebaseDatabase", sb.toString());
        }
    }
    
    public static ParsedUrl h(final String s) throws DatabaseException {
        try {
            final Uri parse = Uri.parse(s);
            final String scheme = parse.getScheme();
            if (scheme == null) {
                throw new IllegalArgumentException("Database URL does not specify a URL scheme");
            }
            final String host = parse.getHost();
            if (host != null) {
                final String queryParameter = parse.getQueryParameter("ns");
                boolean b = false;
                String lowerCase;
                if ((lowerCase = queryParameter) == null) {
                    lowerCase = host.split("\\.", -1)[0].toLowerCase(Locale.US);
                }
                final RepoInfo a = new RepoInfo();
                a.a = host.toLowerCase(Locale.US);
                final int port = parse.getPort();
                if (port != -1) {
                    if (scheme.equals("https") || scheme.equals("wss")) {
                        b = true;
                    }
                    a.b = b;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(a.a);
                    sb.append(":");
                    sb.append(port);
                    a.a = sb.toString();
                }
                else {
                    a.b = true;
                }
                a.d = a.a;
                a.c = lowerCase;
                final String replace = e(s).replace("+", " ");
                Validation.f(replace);
                final ParsedUrl parsedUrl = new ParsedUrl();
                parsedUrl.b = new Path(replace);
                parsedUrl.a = a;
                return parsedUrl;
            }
            throw new IllegalArgumentException("Database URL does not specify a valid host");
        }
        catch (final Exception ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid Firebase Database url specified: ");
            sb2.append(s);
            throw new DatabaseException(sb2.toString(), ex);
        }
    }
    
    public static String i(String encodeToString) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(encodeToString.getBytes("UTF-8"));
            encodeToString = Base64.encodeToString(instance.digest(), 2);
            return encodeToString;
        }
        catch (final UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        }
        catch (final NoSuchAlgorithmException ex2) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", ex2);
        }
    }
    
    public static String j(final String s) {
        String replace;
        if (s.indexOf(92) != -1) {
            replace = s.replace("\\", "\\\\");
        }
        else {
            replace = s;
        }
        String replace2 = replace;
        if (s.indexOf(34) != -1) {
            replace2 = replace.replace("\"", "\\\"");
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(replace2);
        sb.append('\"');
        return sb.toString();
    }
    
    public static Integer k(final String s) {
        if (s.length() > 11 || s.length() == 0) {
            return null;
        }
        int i = 0;
        final char char1 = s.charAt(0);
        boolean b = true;
        if (char1 == '-') {
            if (s.length() == 1) {
                return null;
            }
            i = 1;
        }
        else {
            b = false;
        }
        long n = 0L;
        while (i < s.length()) {
            final char char2 = s.charAt(i);
            if (char2 < '0' || char2 > '9') {
                return null;
            }
            n = n * 10L + (char2 - '0');
            ++i;
        }
        if (b) {
            final long n2 = -n;
            if (n2 < -2147483648L) {
                return null;
            }
            return (int)n2;
        }
        else {
            if (n > 2147483647L) {
                return null;
            }
            return (int)n;
        }
    }
    
    public static Pair<Task<Void>, DatabaseReference.CompletionListener> l(final DatabaseReference.CompletionListener completionListener) {
        if (completionListener == null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            return new Pair<Task<Void>, DatabaseReference.CompletionListener>(taskCompletionSource.a(), new DatabaseReference.CompletionListener(taskCompletionSource) {
                final TaskCompletionSource a;
                
                @Override
                public void a(final DatabaseError databaseError, final DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        this.a.b((Exception)databaseError.g());
                    }
                    else {
                        this.a.c((Object)null);
                    }
                }
            });
        }
        return new Pair<Task<Void>, DatabaseReference.CompletionListener>(null, completionListener);
    }
}
