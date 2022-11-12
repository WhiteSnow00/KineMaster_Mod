// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Ascii;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import com.google.android.exoplayer2.Format;

public final class RtpPayloadFormat
{
    public final int a;
    public final int b;
    public final Format c;
    public final ImmutableMap<String, String> d;
    
    public RtpPayloadFormat(final Format c, final int a, final int b, final Map<String, String> map) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = (ImmutableMap<String, String>)ImmutableMap.copyOf((Map)map);
    }
    
    public static String a(final String s) {
        final String g = Ascii.g(s);
        g.hashCode();
        final int hashCode = g.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2137209252: {
                if (!g.equals("H263-2000")) {
                    break;
                }
                n = 15;
                break;
            }
            case 2137188397: {
                if (!g.equals("H263-1998")) {
                    break;
                }
                n = 14;
                break;
            }
            case 1959269366: {
                if (!g.equals("MP4V-ES")) {
                    break;
                }
                n = 13;
                break;
            }
            case 1934494802: {
                if (!g.equals("AMR-WB")) {
                    break;
                }
                n = 12;
                break;
            }
            case 2450139: {
                if (!g.equals("PCMU")) {
                    break;
                }
                n = 11;
                break;
            }
            case 2450119: {
                if (!g.equals("PCMA")) {
                    break;
                }
                n = 10;
                break;
            }
            case 2433087: {
                if (!g.equals("OPUS")) {
                    break;
                }
                n = 9;
                break;
            }
            case 2194729: {
                if (!g.equals("H265")) {
                    break;
                }
                n = 8;
                break;
            }
            case 2194728: {
                if (!g.equals("H264")) {
                    break;
                }
                n = 7;
                break;
            }
            case 85183: {
                if (!g.equals("VP9")) {
                    break;
                }
                n = 6;
                break;
            }
            case 85182: {
                if (!g.equals("VP8")) {
                    break;
                }
                n = 5;
                break;
            }
            case 74609: {
                if (!g.equals("L16")) {
                    break;
                }
                n = 4;
                break;
            }
            case 64934: {
                if (!g.equals("AMR")) {
                    break;
                }
                n = 3;
                break;
            }
            case 64593: {
                if (!g.equals("AC3")) {
                    break;
                }
                n = 2;
                break;
            }
            case 2412: {
                if (!g.equals("L8")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1922091719: {
                if (!g.equals("MPEG4-GENERIC")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException(s);
            }
            case 14:
            case 15: {
                return "video/3gpp";
            }
            case 13: {
                return "video/mp4v-es";
            }
            case 12: {
                return "audio/amr-wb";
            }
            case 11: {
                return "audio/g711-mlaw";
            }
            case 10: {
                return "audio/g711-alaw";
            }
            case 9: {
                return "audio/opus";
            }
            case 8: {
                return "video/hevc";
            }
            case 7: {
                return "video/avc";
            }
            case 6: {
                return "video/x-vnd.on2.vp9";
            }
            case 5: {
                return "video/x-vnd.on2.vp8";
            }
            case 3: {
                return "audio/3gpp";
            }
            case 2: {
                return "audio/ac3";
            }
            case 1:
            case 4: {
                return "audio/raw";
            }
            case 0: {
                return "audio/mp4a-latm";
            }
        }
    }
    
    public static int b(final String s) {
        Assertions.a(s.equals("L8") || s.equals("L16"));
        int n;
        if (s.equals("L8")) {
            n = 3;
        }
        else {
            n = 268435456;
        }
        return n;
    }
    
    public static boolean c(final MediaDescription mediaDescription) {
        final String g = Ascii.g(mediaDescription.j.b);
        g.hashCode();
        final int hashCode = g.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2137209252: {
                if (!g.equals("H263-2000")) {
                    break;
                }
                n = 15;
                break;
            }
            case 2137188397: {
                if (!g.equals("H263-1998")) {
                    break;
                }
                n = 14;
                break;
            }
            case 1959269366: {
                if (!g.equals("MP4V-ES")) {
                    break;
                }
                n = 13;
                break;
            }
            case 1934494802: {
                if (!g.equals("AMR-WB")) {
                    break;
                }
                n = 12;
                break;
            }
            case 2450139: {
                if (!g.equals("PCMU")) {
                    break;
                }
                n = 11;
                break;
            }
            case 2450119: {
                if (!g.equals("PCMA")) {
                    break;
                }
                n = 10;
                break;
            }
            case 2433087: {
                if (!g.equals("OPUS")) {
                    break;
                }
                n = 9;
                break;
            }
            case 2194729: {
                if (!g.equals("H265")) {
                    break;
                }
                n = 8;
                break;
            }
            case 2194728: {
                if (!g.equals("H264")) {
                    break;
                }
                n = 7;
                break;
            }
            case 85183: {
                if (!g.equals("VP9")) {
                    break;
                }
                n = 6;
                break;
            }
            case 85182: {
                if (!g.equals("VP8")) {
                    break;
                }
                n = 5;
                break;
            }
            case 74609: {
                if (!g.equals("L16")) {
                    break;
                }
                n = 4;
                break;
            }
            case 64934: {
                if (!g.equals("AMR")) {
                    break;
                }
                n = 3;
                break;
            }
            case 64593: {
                if (!g.equals("AC3")) {
                    break;
                }
                n = 2;
                break;
            }
            case 2412: {
                if (!g.equals("L8")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1922091719: {
                if (!g.equals("MPEG4-GENERIC")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return false;
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15: {
                return true;
            }
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && RtpPayloadFormat.class == o.getClass()) {
            final RtpPayloadFormat rtpPayloadFormat = (RtpPayloadFormat)o;
            if (this.a != rtpPayloadFormat.a || this.b != rtpPayloadFormat.b || !this.c.equals(rtpPayloadFormat.c) || !this.d.equals((Object)rtpPayloadFormat.d)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((217 + this.a) * 31 + this.b) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
}
