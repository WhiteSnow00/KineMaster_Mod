// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.util.regex.Matcher;
import android.text.TextUtils;
import java.util.regex.Pattern;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class JsonUtils
{
    private static final Pattern a;
    private static final Pattern b;
    
    static {
        a = Pattern.compile("\\\\.");
        b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }
    
    private JsonUtils() {
    }
    
    @KeepForSdk
    public static String a(final String s) {
        String string = s;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final Matcher matcher = JsonUtils.b.matcher(s);
            StringBuffer sb = null;
            while (matcher.find()) {
                StringBuffer sb2;
                if ((sb2 = sb) == null) {
                    sb2 = new StringBuffer();
                }
                final char char1 = matcher.group().charAt(0);
                if (char1 != '\f') {
                    if (char1 != '\r') {
                        if (char1 != '\"') {
                            if (char1 != '/') {
                                if (char1 != '\\') {
                                    switch (char1) {
                                        default: {
                                            sb = sb2;
                                            continue;
                                        }
                                        case 10: {
                                            matcher.appendReplacement(sb2, "\\\\n");
                                            sb = sb2;
                                            continue;
                                        }
                                        case 9: {
                                            matcher.appendReplacement(sb2, "\\\\t");
                                            sb = sb2;
                                            continue;
                                        }
                                        case 8: {
                                            matcher.appendReplacement(sb2, "\\\\b");
                                            sb = sb2;
                                            continue;
                                        }
                                    }
                                }
                                else {
                                    matcher.appendReplacement(sb2, "\\\\\\\\");
                                    sb = sb2;
                                }
                            }
                            else {
                                matcher.appendReplacement(sb2, "\\\\/");
                                sb = sb2;
                            }
                        }
                        else {
                            matcher.appendReplacement(sb2, "\\\\\\\"");
                            sb = sb2;
                        }
                    }
                    else {
                        matcher.appendReplacement(sb2, "\\\\r");
                        sb = sb2;
                    }
                }
                else {
                    matcher.appendReplacement(sb2, "\\\\f");
                    sb = sb2;
                }
            }
            if (sb == null) {
                return s;
            }
            matcher.appendTail(sb);
            string = sb.toString();
        }
        return string;
    }
}
