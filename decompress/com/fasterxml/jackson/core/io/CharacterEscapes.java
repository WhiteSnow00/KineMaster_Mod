// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.e;
import java.util.Arrays;
import java.io.Serializable;

public abstract class CharacterEscapes implements Serializable
{
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;
    
    public static int[] standardAsciiEscapesForJSON() {
        final int[] e = a.e();
        return Arrays.copyOf(e, e.length);
    }
    
    public abstract int[] getEscapeCodesForAscii();
    
    public abstract e getEscapeSequence(final int p0);
}
