// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.Serializable;
import com.fasterxml.jackson.core.d;

public class DefaultPrettyPrinter implements d, Serializable
{
    public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR;
    private static final long serialVersionUID = 1L;
    protected a _arrayIndenter;
    protected transient int _nesting;
    protected String _objectFieldValueSeparatorWithSpaces;
    protected a _objectIndenter;
    protected final e _rootSeparator;
    protected Separators _separators;
    protected boolean _spacesInObjectEntries;
    
    static {
        DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
    }
    
    public DefaultPrettyPrinter() {
        this(DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }
    
    public DefaultPrettyPrinter(final e rootSeparator) {
        this._arrayIndenter = (a)FixedSpaceIndenter.instance;
        this._objectIndenter = (a)DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
        this._spacesInObjectEntries = true;
        this._rootSeparator = rootSeparator;
        this.withSeparators(d.l);
    }
    
    public DefaultPrettyPrinter(final DefaultPrettyPrinter defaultPrettyPrinter) {
        this(defaultPrettyPrinter, defaultPrettyPrinter._rootSeparator);
    }
    
    public DefaultPrettyPrinter(final DefaultPrettyPrinter defaultPrettyPrinter, final e rootSeparator) {
        this._arrayIndenter = (a)FixedSpaceIndenter.instance;
        this._objectIndenter = (a)DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
        this._spacesInObjectEntries = true;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this._nesting = defaultPrettyPrinter._nesting;
        this._separators = defaultPrettyPrinter._separators;
        this._objectFieldValueSeparatorWithSpaces = defaultPrettyPrinter._objectFieldValueSeparatorWithSpaces;
        this._rootSeparator = rootSeparator;
    }
    
    public DefaultPrettyPrinter(final String s) {
        e e;
        if (s == null) {
            e = null;
        }
        else {
            e = new SerializedString(s);
        }
        this(e);
    }
    
    protected DefaultPrettyPrinter _withSpaces(final boolean spacesInObjectEntries) {
        if (this._spacesInObjectEntries == spacesInObjectEntries) {
            return this;
        }
        final DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._spacesInObjectEntries = spacesInObjectEntries;
        return defaultPrettyPrinter;
    }
    
    @Override
    public void beforeArrayValues(final JsonGenerator jsonGenerator) throws IOException {
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }
    
    @Override
    public void beforeObjectEntries(final JsonGenerator jsonGenerator) throws IOException {
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }
    
    public DefaultPrettyPrinter createInstance() {
        return new DefaultPrettyPrinter(this);
    }
    
    public /* bridge */ Object createInstance() {
        return this.createInstance();
    }
    
    public void indentArraysWith(final a a) {
        Object instance = a;
        if (a == null) {
            instance = NopIndenter.instance;
        }
        this._arrayIndenter = (a)instance;
    }
    
    public void indentObjectsWith(final a a) {
        Object instance = a;
        if (a == null) {
            instance = NopIndenter.instance;
        }
        this._objectIndenter = (a)instance;
    }
    
    public DefaultPrettyPrinter withArrayIndenter(final a a) {
        Object instance = a;
        if (a == null) {
            instance = NopIndenter.instance;
        }
        if (this._arrayIndenter == instance) {
            return this;
        }
        final DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._arrayIndenter = (a)instance;
        return defaultPrettyPrinter;
    }
    
    public DefaultPrettyPrinter withObjectIndenter(final a a) {
        Object instance = a;
        if (a == null) {
            instance = NopIndenter.instance;
        }
        if (this._objectIndenter == instance) {
            return this;
        }
        final DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._objectIndenter = (a)instance;
        return defaultPrettyPrinter;
    }
    
    public DefaultPrettyPrinter withRootSeparator(final e e) {
        final e rootSeparator = this._rootSeparator;
        if (rootSeparator != e && (e == null || !e.equals(rootSeparator))) {
            return new DefaultPrettyPrinter(this, e);
        }
        return this;
    }
    
    public DefaultPrettyPrinter withRootSeparator(final String s) {
        e e;
        if (s == null) {
            e = null;
        }
        else {
            e = new SerializedString(s);
        }
        return this.withRootSeparator(e);
    }
    
    public DefaultPrettyPrinter withSeparators(final Separators separators) {
        this._separators = separators;
        final StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(separators.getObjectFieldValueSeparator());
        sb.append(" ");
        this._objectFieldValueSeparatorWithSpaces = sb.toString();
        return this;
    }
    
    public DefaultPrettyPrinter withSpacesInObjectEntries() {
        return this._withSpaces(true);
    }
    
    public DefaultPrettyPrinter withoutSpacesInObjectEntries() {
        return this._withSpaces(false);
    }
    
    @Override
    public void writeArrayValueSeparator(final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.M(this._separators.getArrayValueSeparator());
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }
    
    @Override
    public void writeEndArray(final JsonGenerator jsonGenerator, final int n) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            --this._nesting;
        }
        if (n > 0) {
            this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
        }
        else {
            jsonGenerator.M(' ');
        }
        jsonGenerator.M(']');
    }
    
    @Override
    public void writeEndObject(final JsonGenerator jsonGenerator, final int n) throws IOException {
        if (!this._objectIndenter.isInline()) {
            --this._nesting;
        }
        if (n > 0) {
            this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
        }
        else {
            jsonGenerator.M(' ');
        }
        jsonGenerator.M('}');
    }
    
    @Override
    public void writeObjectEntrySeparator(final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.M(this._separators.getObjectEntrySeparator());
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }
    
    @Override
    public void writeObjectFieldValueSeparator(final JsonGenerator jsonGenerator) throws IOException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.V(this._objectFieldValueSeparatorWithSpaces);
        }
        else {
            jsonGenerator.M(this._separators.getObjectFieldValueSeparator());
        }
    }
    
    @Override
    public void writeRootValueSeparator(final JsonGenerator jsonGenerator) throws IOException {
        final e rootSeparator = this._rootSeparator;
        if (rootSeparator != null) {
            jsonGenerator.O(rootSeparator);
        }
    }
    
    @Override
    public void writeStartArray(final JsonGenerator jsonGenerator) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            ++this._nesting;
        }
        jsonGenerator.M('[');
    }
    
    @Override
    public void writeStartObject(final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.M('{');
        if (!this._objectIndenter.isInline()) {
            ++this._nesting;
        }
    }
    
    public static class FixedSpaceIndenter extends NopIndenter
    {
        public static final FixedSpaceIndenter instance;
        
        static {
            instance = new FixedSpaceIndenter();
        }
        
        @Override
        public boolean isInline() {
            return true;
        }
        
        @Override
        public void writeIndentation(final JsonGenerator jsonGenerator, final int n) throws IOException {
            jsonGenerator.M(' ');
        }
    }
    
    public static class NopIndenter implements a, Serializable
    {
        public static final NopIndenter instance;
        
        static {
            instance = new NopIndenter();
        }
        
        @Override
        public boolean isInline() {
            return true;
        }
        
        @Override
        public void writeIndentation(final JsonGenerator jsonGenerator, final int n) throws IOException {
        }
    }
    
    public interface a
    {
        boolean isInline();
        
        void writeIndentation(final JsonGenerator p0, final int p1) throws IOException;
    }
}
