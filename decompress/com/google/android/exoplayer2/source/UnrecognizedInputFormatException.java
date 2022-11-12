// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException
{
    public final Uri uri;
    
    public UnrecognizedInputFormatException(final String s, final Uri uri) {
        super(s, null, false, 1);
        this.uri = uri;
    }
}
