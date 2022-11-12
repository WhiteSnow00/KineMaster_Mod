// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTableDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;
import com.google.android.exoplayer2.Format;

public interface MetadataDecoderFactory
{
    public static final MetadataDecoderFactory a = new MetadataDecoderFactory() {
        @Override
        public boolean a(final Format format) {
            final String w = format.w;
            return "application/id3".equals(w) || "application/x-emsg".equals(w) || "application/x-scte35".equals(w) || "application/x-icy".equals(w) || "application/vnd.dvb.ait".equals(w);
        }
        
        @Override
        public MetadataDecoder b(final Format format) {
            final String w = format.w;
            if (w != null) {
                int n = -1;
                switch (w) {
                    case "application/x-scte35": {
                        n = 4;
                        break;
                    }
                    case "application/x-emsg": {
                        n = 3;
                        break;
                    }
                    case "application/id3": {
                        n = 2;
                        break;
                    }
                    case "application/x-icy": {
                        n = 1;
                        break;
                    }
                    case "application/vnd.dvb.ait": {
                        n = 0;
                        break;
                    }
                    default:
                        break;
                }
                switch (n) {
                    case 4: {
                        return new SpliceInfoDecoder();
                    }
                    case 3: {
                        return new EventMessageDecoder();
                    }
                    case 2: {
                        return new Id3Decoder();
                    }
                    case 1: {
                        return new IcyDecoder();
                    }
                    case 0: {
                        return new AppInfoTableDecoder();
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
    
    MetadataDecoder b(final Format p0);
}
