// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UninitializedMessageException extends RuntimeException
{
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;
    
    public UninitializedMessageException(final MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }
    
    public UninitializedMessageException(final List<String> missingFields) {
        super(a(missingFields));
        this.missingFields = missingFields;
    }
    
    private static String a(final List<String> list) {
        final StringBuilder sb = new StringBuilder("Message missing required fields: ");
        final Iterator<String> iterator = list.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(", ");
            }
            sb.append(s);
        }
        return sb.toString();
    }
    
    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(this.getMessage());
    }
    
    public List<String> getMissingFields() {
        return Collections.unmodifiableList((List<? extends String>)this.missingFields);
    }
}
