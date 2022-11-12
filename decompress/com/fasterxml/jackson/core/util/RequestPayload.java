// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.io.IOException;
import java.io.Serializable;

public class RequestPayload implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected String _charset;
    protected byte[] _payloadAsBytes;
    protected CharSequence _payloadAsText;
    
    public RequestPayload(final CharSequence payloadAsText) {
        if (payloadAsText != null) {
            this._payloadAsText = payloadAsText;
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public RequestPayload(final byte[] payloadAsBytes, final String s) {
        if (payloadAsBytes != null) {
            this._payloadAsBytes = payloadAsBytes;
            String charset = null;
            Label_0029: {
                if (s != null) {
                    charset = s;
                    if (!s.isEmpty()) {
                        break Label_0029;
                    }
                }
                charset = "UTF-8";
            }
            this._charset = charset;
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public Object getRawPayload() {
        final byte[] payloadAsBytes = this._payloadAsBytes;
        if (payloadAsBytes != null) {
            return payloadAsBytes;
        }
        return this._payloadAsText;
    }
    
    @Override
    public String toString() {
        final byte[] payloadAsBytes = this._payloadAsBytes;
        if (payloadAsBytes != null) {
            try {
                return new String(payloadAsBytes, this._charset);
            }
            catch (final IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return this._payloadAsText.toString();
    }
}
