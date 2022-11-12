// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import java.io.IOException;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.Separators;

public interface d
{
    public static final Separators l = Separators.createDefaultInstance();
    public static final SerializedString m = new SerializedString(" ");
    
    void beforeArrayValues(final JsonGenerator p0) throws IOException;
    
    void beforeObjectEntries(final JsonGenerator p0) throws IOException;
    
    void writeArrayValueSeparator(final JsonGenerator p0) throws IOException;
    
    void writeEndArray(final JsonGenerator p0, final int p1) throws IOException;
    
    void writeEndObject(final JsonGenerator p0, final int p1) throws IOException;
    
    void writeObjectEntrySeparator(final JsonGenerator p0) throws IOException;
    
    void writeObjectFieldValueSeparator(final JsonGenerator p0) throws IOException;
    
    void writeRootValueSeparator(final JsonGenerator p0) throws IOException;
    
    void writeStartArray(final JsonGenerator p0) throws IOException;
    
    void writeStartObject(final JsonGenerator p0) throws IOException;
}
