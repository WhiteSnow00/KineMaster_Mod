// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.net.Uri;
import java.util.List;
import java.util.Map;

public final class FileTypes
{
    private FileTypes() {
    }
    
    public static int a(String t) {
        if (t == null) {
            return -1;
        }
        t = MimeTypes.t(t);
        t.hashCode();
        int n = 0;
        Label_0704: {
            switch (t) {
                case "video/x-matroska": {
                    n = 25;
                    break Label_0704;
                }
                case "audio/webm": {
                    n = 24;
                    break Label_0704;
                }
                case "audio/mpeg": {
                    n = 23;
                    break Label_0704;
                }
                case "audio/midi": {
                    n = 22;
                    break Label_0704;
                }
                case "audio/flac": {
                    n = 21;
                    break Label_0704;
                }
                case "audio/eac3": {
                    n = 20;
                    break Label_0704;
                }
                case "audio/3gpp": {
                    n = 19;
                    break Label_0704;
                }
                case "video/mp4": {
                    n = 18;
                    break Label_0704;
                }
                case "audio/wav": {
                    n = 17;
                    break Label_0704;
                }
                case "audio/ogg": {
                    n = 16;
                    break Label_0704;
                }
                case "audio/mp4": {
                    n = 15;
                    break Label_0704;
                }
                case "audio/amr": {
                    n = 14;
                    break Label_0704;
                }
                case "audio/ac4": {
                    n = 13;
                    break Label_0704;
                }
                case "audio/ac3": {
                    n = 12;
                    break Label_0704;
                }
                case "video/x-flv": {
                    n = 11;
                    break Label_0704;
                }
                case "application/webm": {
                    n = 10;
                    break Label_0704;
                }
                case "audio/x-matroska": {
                    n = 9;
                    break Label_0704;
                }
                case "text/vtt": {
                    n = 8;
                    break Label_0704;
                }
                case "video/x-msvideo": {
                    n = 7;
                    break Label_0704;
                }
                case "application/mp4": {
                    n = 6;
                    break Label_0704;
                }
                case "image/jpeg": {
                    n = 5;
                    break Label_0704;
                }
                case "audio/amr-wb": {
                    n = 4;
                    break Label_0704;
                }
                case "video/webm": {
                    n = 3;
                    break Label_0704;
                }
                case "video/mp2t": {
                    n = 2;
                    break Label_0704;
                }
                case "video/mp2p": {
                    n = 1;
                    break Label_0704;
                }
                case "audio/eac3-joc": {
                    n = 0;
                    break Label_0704;
                }
                default:
                    break;
            }
            n = -1;
        }
        switch (n) {
            default: {
                return -1;
            }
            case 23: {
                return 7;
            }
            case 22: {
                return 15;
            }
            case 21: {
                return 4;
            }
            case 17: {
                return 12;
            }
            case 16: {
                return 9;
            }
            case 13: {
                return 1;
            }
            case 11: {
                return 5;
            }
            case 8: {
                return 13;
            }
            case 7: {
                return 16;
            }
            case 6:
            case 15:
            case 18: {
                return 8;
            }
            case 5: {
                return 14;
            }
            case 4:
            case 14:
            case 19: {
                return 3;
            }
            case 3:
            case 9:
            case 10:
            case 24:
            case 25: {
                return 6;
            }
            case 2: {
                return 11;
            }
            case 1: {
                return 10;
            }
            case 0:
            case 12:
            case 20: {
                return 0;
            }
        }
    }
    
    public static int b(final Map<String, List<String>> map) {
        final List list = map.get("Content-Type");
        String s;
        if (list != null && !list.isEmpty()) {
            s = (String)list.get(0);
        }
        else {
            s = null;
        }
        return a(s);
    }
    
    public static int c(final Uri uri) {
        final String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        return -1;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Type {
    }
}
