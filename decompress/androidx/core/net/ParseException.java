// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.net;

public class ParseException extends RuntimeException
{
    public final String response;
    
    ParseException(final String response) {
        super(response);
        this.response = response;
    }
}
