// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.RequestPayload;

public class JsonParseException extends JsonProcessingException
{
    private static final long serialVersionUID = 2L;
    protected transient JsonParser _processor;
    protected RequestPayload _requestPayload;
    
    public JsonParseException(final JsonParser processor, final String s) {
        JsonLocation e;
        if (processor == null) {
            e = null;
        }
        else {
            e = processor.e();
        }
        super(s, e);
        this._processor = processor;
    }
    
    public JsonParseException(final JsonParser processor, final String s, final JsonLocation jsonLocation) {
        super(s, jsonLocation);
        this._processor = processor;
    }
    
    public JsonParseException(final JsonParser processor, final String s, final JsonLocation jsonLocation, final Throwable t) {
        super(s, jsonLocation, t);
        this._processor = processor;
    }
    
    public JsonParseException(final JsonParser processor, final String s, final Throwable t) {
        JsonLocation e;
        if (processor == null) {
            e = null;
        }
        else {
            e = processor.e();
        }
        super(s, e, t);
        this._processor = processor;
    }
    
    @Deprecated
    public JsonParseException(final String s, final JsonLocation jsonLocation) {
        super(s, jsonLocation);
    }
    
    @Deprecated
    public JsonParseException(final String s, final JsonLocation jsonLocation, final Throwable t) {
        super(s, jsonLocation, t);
    }
    
    @Override
    public String getMessage() {
        String s = super.getMessage();
        if (this._requestPayload != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("\nRequest payload : ");
            sb.append(this._requestPayload.toString());
            s = sb.toString();
        }
        return s;
    }
    
    @Override
    public JsonParser getProcessor() {
        return this._processor;
    }
    
    @Override
    public /* bridge */ Object getProcessor() {
        return this.getProcessor();
    }
    
    public RequestPayload getRequestPayload() {
        return this._requestPayload;
    }
    
    public String getRequestPayloadAsString() {
        final RequestPayload requestPayload = this._requestPayload;
        String string;
        if (requestPayload != null) {
            string = requestPayload.toString();
        }
        else {
            string = null;
        }
        return string;
    }
    
    public JsonParseException withParser(final JsonParser processor) {
        this._processor = processor;
        return this;
    }
    
    public JsonParseException withRequestPayload(final RequestPayload requestPayload) {
        this._requestPayload = requestPayload;
        return this;
    }
}
