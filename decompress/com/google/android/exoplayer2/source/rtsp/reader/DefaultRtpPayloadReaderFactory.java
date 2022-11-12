// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

public final class DefaultRtpPayloadReaderFactory implements Factory
{
    public RtpPayloadReader a(final RtpPayloadFormat rtpPayloadFormat) {
        final String s = Assertions.e(rtpPayloadFormat.c.w);
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1903589369: {
                if (!s.equals("audio/g711-mlaw")) {
                    break;
                }
                n = 13;
                break;
            }
            case 1903231877: {
                if (!s.equals("audio/g711-alaw")) {
                    break;
                }
                n = 12;
                break;
            }
            case 1599127257: {
                if (!s.equals("video/x-vnd.on2.vp9")) {
                    break;
                }
                n = 11;
                break;
            }
            case 1599127256: {
                if (!s.equals("video/x-vnd.on2.vp8")) {
                    break;
                }
                n = 10;
                break;
            }
            case 1504891608: {
                if (!s.equals("audio/opus")) {
                    break;
                }
                n = 9;
                break;
            }
            case 1503095341: {
                if (!s.equals("audio/3gpp")) {
                    break;
                }
                n = 8;
                break;
            }
            case 1331836730: {
                if (!s.equals("video/avc")) {
                    break;
                }
                n = 7;
                break;
            }
            case 1187890754: {
                if (!s.equals("video/mp4v-es")) {
                    break;
                }
                n = 6;
                break;
            }
            case 187094639: {
                if (!s.equals("audio/raw")) {
                    break;
                }
                n = 5;
                break;
            }
            case 187078296: {
                if (!s.equals("audio/ac3")) {
                    break;
                }
                n = 4;
                break;
            }
            case -53558318: {
                if (!s.equals("audio/mp4a-latm")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1606874997: {
                if (!s.equals("audio/amr-wb")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1662541442: {
                if (!s.equals("video/hevc")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1664118616: {
                if (!s.equals("video/3gpp")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 11: {
                return new i(rtpPayloadFormat);
            }
            case 10: {
                return new h(rtpPayloadFormat);
            }
            case 9: {
                return new g(rtpPayloadFormat);
            }
            case 7: {
                return new d(rtpPayloadFormat);
            }
            case 6: {
                return new f(rtpPayloadFormat);
            }
            case 5:
            case 12:
            case 13: {
                return new RtpPcmReader(rtpPayloadFormat);
            }
            case 4: {
                return new RtpAc3Reader(rtpPayloadFormat);
            }
            case 3: {
                return new a(rtpPayloadFormat);
            }
            case 2:
            case 8: {
                return new b(rtpPayloadFormat);
            }
            case 1: {
                return new e(rtpPayloadFormat);
            }
            case 0: {
                return new c(rtpPayloadFormat);
            }
        }
    }
}
