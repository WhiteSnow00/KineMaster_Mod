// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.io.IOException;

public class ParserException extends IOException
{
    public final boolean contentIsMalformed;
    public final int dataType;
    
    protected ParserException(final String s, final Throwable t, final boolean contentIsMalformed, final int dataType) {
        super(s, t);
        this.contentIsMalformed = contentIsMalformed;
        this.dataType = dataType;
    }
    
    public static ParserException createForMalformedContainer(final String s, final Throwable t) {
        return new ParserException(s, t, true, 1);
    }
    
    public static ParserException createForMalformedDataOfUnknownType(final String s, final Throwable t) {
        return new ParserException(s, t, true, 0);
    }
    
    public static ParserException createForMalformedManifest(final String s, final Throwable t) {
        return new ParserException(s, t, true, 4);
    }
    
    public static ParserException createForManifestWithUnsupportedFeature(final String s, final Throwable t) {
        return new ParserException(s, t, false, 4);
    }
    
    public static ParserException createForUnsupportedContainerFeature(final String s) {
        return new ParserException(s, null, false, 1);
    }
}
