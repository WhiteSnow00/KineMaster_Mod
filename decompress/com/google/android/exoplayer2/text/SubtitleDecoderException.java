// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderException;

public class SubtitleDecoderException extends DecoderException
{
    public SubtitleDecoderException(final String s) {
        super(s);
    }
    
    public SubtitleDecoderException(final String s, final Throwable t) {
        super(s, t);
    }
    
    public SubtitleDecoderException(final Throwable t) {
        super(t);
    }
}
