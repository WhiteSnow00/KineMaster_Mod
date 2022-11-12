// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException extends IOException
{
    static final long serialVersionUID = 123L;
    protected JsonLocation _location;
    
    protected JsonProcessingException(final String s) {
        super(s);
    }
    
    protected JsonProcessingException(final String s, final JsonLocation jsonLocation) {
        this(s, jsonLocation, null);
    }
    
    protected JsonProcessingException(final String s, final JsonLocation location, final Throwable t) {
        super(s);
        if (t != null) {
            this.initCause(t);
        }
        this._location = location;
    }
    
    protected JsonProcessingException(final String s, final Throwable t) {
        this(s, null, t);
    }
    
    protected JsonProcessingException(final Throwable t) {
        this(null, null, t);
    }
    
    public void clearLocation() {
        this._location = null;
    }
    
    public JsonLocation getLocation() {
        return this._location;
    }
    
    @Override
    public String getMessage() {
        String message;
        if ((message = super.getMessage()) == null) {
            message = "N/A";
        }
        final JsonLocation location = this.getLocation();
        final String messageSuffix = this.getMessageSuffix();
        if (location == null) {
            final String string = message;
            if (messageSuffix == null) {
                return string;
            }
        }
        final StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (messageSuffix != null) {
            sb.append(messageSuffix);
        }
        if (location != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(location.toString());
        }
        return sb.toString();
    }
    
    protected String getMessageSuffix() {
        return null;
    }
    
    public String getOriginalMessage() {
        return super.getMessage();
    }
    
    public Object getProcessor() {
        return null;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append(": ");
        sb.append(this.getMessage());
        return sb.toString();
    }
}
