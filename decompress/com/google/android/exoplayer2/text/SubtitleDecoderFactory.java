// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.Format;

public interface SubtitleDecoderFactory
{
    public static final SubtitleDecoderFactory a = new SubtitleDecoderFactory() {
        @Override
        public boolean a(final Format format) {
            final String w = format.w;
            return "text/vtt".equals(w) || "text/x-ssa".equals(w) || "application/ttml+xml".equals(w) || "application/x-mp4-vtt".equals(w) || "application/x-subrip".equals(w) || "application/x-quicktime-tx3g".equals(w) || "application/cea-608".equals(w) || "application/x-mp4-cea-608".equals(w) || "application/cea-708".equals(w) || "application/dvbsubs".equals(w) || "application/pgs".equals(w) || "text/x-exoplayer-cues".equals(w);
        }
        
        @Override
        public SubtitleDecoder b(final Format format) {
            final String w = format.w;
            if (w != null) {
                int n = -1;
                switch (w) {
                    case "application/ttml+xml": {
                        n = 11;
                        break;
                    }
                    case "application/x-subrip": {
                        n = 10;
                        break;
                    }
                    case "application/cea-708": {
                        n = 9;
                        break;
                    }
                    case "application/cea-608": {
                        n = 8;
                        break;
                    }
                    case "text/x-exoplayer-cues": {
                        n = 7;
                        break;
                    }
                    case "application/x-mp4-cea-608": {
                        n = 6;
                        break;
                    }
                    case "text/x-ssa": {
                        n = 5;
                        break;
                    }
                    case "application/x-quicktime-tx3g": {
                        n = 4;
                        break;
                    }
                    case "text/vtt": {
                        n = 3;
                        break;
                    }
                    case "application/x-mp4-vtt": {
                        n = 2;
                        break;
                    }
                    case "application/pgs": {
                        n = 1;
                        break;
                    }
                    case "application/dvbsubs": {
                        n = 0;
                        break;
                    }
                    default:
                        break;
                }
                switch (n) {
                    case 11: {
                        return new TtmlDecoder();
                    }
                    case 10: {
                        return new SubripDecoder();
                    }
                    case 9: {
                        return new Cea708Decoder(format.O, format.y);
                    }
                    case 7: {
                        return new ExoplayerCuesDecoder();
                    }
                    case 6:
                    case 8: {
                        return new Cea608Decoder(w, format.O, 16000L);
                    }
                    case 5: {
                        return new SsaDecoder(format.y);
                    }
                    case 4: {
                        return new Tx3gDecoder(format.y);
                    }
                    case 3: {
                        return new WebvttDecoder();
                    }
                    case 2: {
                        return new Mp4WebvttDecoder();
                    }
                    case 1: {
                        return new PgsDecoder();
                    }
                    case 0: {
                        return new DvbDecoder(format.y);
                    }
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Attempted to create decoder for unsupported MIME type: ");
            sb.append(w);
            throw new IllegalArgumentException(sb.toString());
        }
    };
    
    boolean a(final Format p0);
    
    SubtitleDecoder b(final Format p0);
}
