// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import z2.f;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.CharArrayReader;
import java.io.StringReader;
import java.io.FileOutputStream;
import java.io.File;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.FileInputStream;
import java.net.URL;
import java.io.OutputStreamWriter;
import z2.i;
import z2.g;
import java.io.Reader;
import java.io.InputStream;
import z2.h;
import java.io.DataInput;
import java.io.IOException;
import z2.k;
import java.io.Writer;
import java.io.OutputStream;
import java.io.DataOutput;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import b3.b;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import b3.a;
import java.io.Serializable;

public class JsonFactory implements Serializable
{
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS;
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS;
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS;
    public static final String FORMAT_NAME_JSON = "JSON";
    private static final e a;
    private static final long serialVersionUID = 1L;
    protected final transient a _byteSymbolCanonicalizer;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected c _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final transient b _rootCharSymbols;
    protected e _rootValueSeparator;
    
    static {
        DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
        DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
        DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
        a = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }
    
    public JsonFactory() {
        this(null);
    }
    
    protected JsonFactory(final JsonFactory jsonFactory, final c c) {
        this._rootCharSymbols = b.m();
        this._byteSymbolCanonicalizer = b3.a.A();
        this._factoryFeatures = JsonFactory.DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = JsonFactory.DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = JsonFactory.DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = JsonFactory.a;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
    }
    
    public JsonFactory(final c c) {
        this._rootCharSymbols = b.m();
        this._byteSymbolCanonicalizer = b3.a.A();
        this._factoryFeatures = JsonFactory.DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = JsonFactory.DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = JsonFactory.DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = JsonFactory.a;
    }
    
    private final boolean a() {
        return this.getFormatName() == "JSON";
    }
    
    private final void b(final String s) {
        if (this.a()) {
            return;
        }
        throw new UnsupportedOperationException(String.format(s, this.getFormatName()));
    }
    
    protected void _checkInvalidCopy(final Class<?> clazz) {
        if (this.getClass() == clazz) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed copy(): ");
        sb.append(this.getClass().getName());
        sb.append(" (version: ");
        sb.append(this.version());
        sb.append(") does not override copy(); it has to");
        throw new IllegalStateException(sb.toString());
    }
    
    protected com.fasterxml.jackson.core.io.c _createContext(final Object o, final boolean b) {
        return new com.fasterxml.jackson.core.io.c(this._getBufferRecycler(), o, b);
    }
    
    protected OutputStream _createDataOutputWrapper(final DataOutput dataOutput) {
        return new com.fasterxml.jackson.core.io.b(dataOutput);
    }
    
    protected JsonGenerator _createGenerator(final Writer writer, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final k k = new k(c, this._generatorFeatures, null, writer);
        final CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            k.t0(characterEscapes);
        }
        final e rootValueSeparator = this._rootValueSeparator;
        if (rootValueSeparator != JsonFactory.a) {
            k.B0(rootValueSeparator);
        }
        return k;
    }
    
    protected JsonParser _createParser(final DataInput dataInput, final com.fasterxml.jackson.core.io.c c) throws IOException {
        this.b("InputData source not (yet?) support for this format (%s)");
        return new h(c, this._parserFeatures, dataInput, null, this._byteSymbolCanonicalizer.G(this._factoryFeatures), z2.a.l(dataInput));
    }
    
    protected JsonParser _createParser(final InputStream inputStream, final com.fasterxml.jackson.core.io.c c) throws IOException {
        return new z2.a(c, inputStream).c(this._parserFeatures, null, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }
    
    protected JsonParser _createParser(final Reader reader, final com.fasterxml.jackson.core.io.c c) throws IOException {
        return new g(c, this._parserFeatures, reader, null, this._rootCharSymbols.q(this._factoryFeatures));
    }
    
    protected JsonParser _createParser(final byte[] array, final int n, final int n2, final com.fasterxml.jackson.core.io.c c) throws IOException {
        return new z2.a(c, array, n, n2).c(this._parserFeatures, null, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }
    
    protected JsonParser _createParser(final char[] array, final int n, final int n2, final com.fasterxml.jackson.core.io.c c, final boolean b) throws IOException {
        return new g(c, this._parserFeatures, null, null, this._rootCharSymbols.q(this._factoryFeatures), array, n, n + n2, b);
    }
    
    protected JsonGenerator _createUTF8Generator(final OutputStream outputStream, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final i i = new i(c, this._generatorFeatures, null, outputStream);
        final CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            i.t0(characterEscapes);
        }
        final e rootValueSeparator = this._rootValueSeparator;
        if (rootValueSeparator != JsonFactory.a) {
            i.B0(rootValueSeparator);
        }
        return i;
    }
    
    protected Writer _createWriter(final OutputStream outputStream, final JsonEncoding jsonEncoding, final com.fasterxml.jackson.core.io.c c) throws IOException {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new com.fasterxml.jackson.core.io.i(c, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }
    
    protected final DataInput _decorate(final DataInput dataInput, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            final DataInput decorate = inputDecorator.decorate(c, dataInput);
            if (decorate != null) {
                return decorate;
            }
        }
        return dataInput;
    }
    
    protected final InputStream _decorate(final InputStream inputStream, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            final InputStream decorate = inputDecorator.decorate(c, inputStream);
            if (decorate != null) {
                return decorate;
            }
        }
        return inputStream;
    }
    
    protected final OutputStream _decorate(final OutputStream outputStream, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final OutputDecorator outputDecorator = this._outputDecorator;
        if (outputDecorator != null) {
            final OutputStream decorate = outputDecorator.decorate(c, outputStream);
            if (decorate != null) {
                return decorate;
            }
        }
        return outputStream;
    }
    
    protected final Reader _decorate(final Reader reader, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            final Reader decorate = inputDecorator.decorate(c, reader);
            if (decorate != null) {
                return decorate;
            }
        }
        return reader;
    }
    
    protected final Writer _decorate(final Writer writer, final com.fasterxml.jackson.core.io.c c) throws IOException {
        final OutputDecorator outputDecorator = this._outputDecorator;
        if (outputDecorator != null) {
            final Writer decorate = outputDecorator.decorate(c, writer);
            if (decorate != null) {
                return decorate;
            }
        }
        return writer;
    }
    
    public com.fasterxml.jackson.core.util.a _getBufferRecycler() {
        if (Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(this._factoryFeatures)) {
            return com.fasterxml.jackson.core.util.b.b();
        }
        return new com.fasterxml.jackson.core.util.a();
    }
    
    protected InputStream _optimizedStreamFromURL(final URL url) throws IOException {
        if ("file".equals(url.getProtocol())) {
            final String host = url.getHost();
            if ((host == null || host.length() == 0) && url.getPath().indexOf(37) < 0) {
                return new FileInputStream(url.getPath());
            }
        }
        return FirebasePerfUrlConnection.openStream(url);
    }
    
    public boolean canHandleBinaryNatively() {
        return false;
    }
    
    public boolean canParseAsync() {
        return this.a();
    }
    
    public boolean canUseCharArrays() {
        return true;
    }
    
    public boolean canUseSchema(final com.fasterxml.jackson.core.a a) {
        final boolean b = false;
        if (a == null) {
            return false;
        }
        final String formatName = this.getFormatName();
        boolean b2 = b;
        if (formatName != null) {
            b2 = b;
            if (formatName.equals(a.a())) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public final JsonFactory configure(final Feature feature, final boolean b) {
        JsonFactory jsonFactory;
        if (b) {
            jsonFactory = this.enable(feature);
        }
        else {
            jsonFactory = this.disable(feature);
        }
        return jsonFactory;
    }
    
    public final JsonFactory configure(final JsonGenerator.Feature feature, final boolean b) {
        JsonFactory jsonFactory;
        if (b) {
            jsonFactory = this.enable(feature);
        }
        else {
            jsonFactory = this.disable(feature);
        }
        return jsonFactory;
    }
    
    public final JsonFactory configure(final JsonParser.Feature feature, final boolean b) {
        JsonFactory jsonFactory;
        if (b) {
            jsonFactory = this.enable(feature);
        }
        else {
            jsonFactory = this.disable(feature);
        }
        return jsonFactory;
    }
    
    public JsonFactory copy() {
        this._checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(this, null);
    }
    
    public JsonGenerator createGenerator(final DataOutput dataOutput) throws IOException {
        return this.createGenerator(this._createDataOutputWrapper(dataOutput), JsonEncoding.UTF8);
    }
    
    public JsonGenerator createGenerator(final DataOutput dataOutput, final JsonEncoding jsonEncoding) throws IOException {
        return this.createGenerator(this._createDataOutputWrapper(dataOutput), jsonEncoding);
    }
    
    public JsonGenerator createGenerator(final File file, final JsonEncoding jsonEncoding) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(fileOutputStream, true);
        createContext.r(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return this._createUTF8Generator(this._decorate(fileOutputStream, createContext), createContext);
        }
        return this._createGenerator(this._decorate(this._createWriter(fileOutputStream, jsonEncoding, createContext), createContext), createContext);
    }
    
    public JsonGenerator createGenerator(final OutputStream outputStream) throws IOException {
        return this.createGenerator(outputStream, JsonEncoding.UTF8);
    }
    
    public JsonGenerator createGenerator(final OutputStream outputStream, final JsonEncoding jsonEncoding) throws IOException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(outputStream, false);
        createContext.r(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return this._createUTF8Generator(this._decorate(outputStream, createContext), createContext);
        }
        return this._createGenerator(this._decorate(this._createWriter(outputStream, jsonEncoding, createContext), createContext), createContext);
    }
    
    public JsonGenerator createGenerator(final Writer writer) throws IOException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(writer, false);
        return this._createGenerator(this._decorate(writer, createContext), createContext);
    }
    
    @Deprecated
    public JsonGenerator createJsonGenerator(final OutputStream outputStream) throws IOException {
        return this.createGenerator(outputStream, JsonEncoding.UTF8);
    }
    
    @Deprecated
    public JsonGenerator createJsonGenerator(final OutputStream outputStream, final JsonEncoding jsonEncoding) throws IOException {
        return this.createGenerator(outputStream, jsonEncoding);
    }
    
    @Deprecated
    public JsonGenerator createJsonGenerator(final Writer writer) throws IOException {
        return this.createGenerator(writer);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final File file) throws IOException, JsonParseException {
        return this.createParser(file);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final InputStream inputStream) throws IOException, JsonParseException {
        return this.createParser(inputStream);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final Reader reader) throws IOException, JsonParseException {
        return this.createParser(reader);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final String s) throws IOException, JsonParseException {
        return this.createParser(s);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final URL url) throws IOException, JsonParseException {
        return this.createParser(url);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final byte[] array) throws IOException, JsonParseException {
        return this.createParser(array);
    }
    
    @Deprecated
    public JsonParser createJsonParser(final byte[] array, final int n, final int n2) throws IOException, JsonParseException {
        return this.createParser(array, n, n2);
    }
    
    public JsonParser createNonBlockingByteArrayParser() throws IOException {
        this.b("Non-blocking source not (yet?) support for this format (%s)");
        return new a3.a(this._createContext(null, false), this._parserFeatures, this._byteSymbolCanonicalizer.G(this._factoryFeatures));
    }
    
    public JsonParser createParser(final DataInput dataInput) throws IOException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(dataInput, false);
        return this._createParser(this._decorate(dataInput, createContext), createContext);
    }
    
    public JsonParser createParser(final File file) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(file, true);
        return this._createParser(this._decorate(new FileInputStream(file), createContext), createContext);
    }
    
    public JsonParser createParser(final InputStream inputStream) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(inputStream, false);
        return this._createParser(this._decorate(inputStream, createContext), createContext);
    }
    
    public JsonParser createParser(final Reader reader) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(reader, false);
        return this._createParser(this._decorate(reader, createContext), createContext);
    }
    
    public JsonParser createParser(final String s) throws IOException, JsonParseException {
        final int length = s.length();
        if (this._inputDecorator == null && length <= 32768 && this.canUseCharArrays()) {
            final com.fasterxml.jackson.core.io.c createContext = this._createContext(s, true);
            final char[] g = createContext.g(length);
            s.getChars(0, length, g, 0);
            return this._createParser(g, 0, length, createContext, true);
        }
        return this.createParser(new StringReader(s));
    }
    
    public JsonParser createParser(final URL url) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(url, true);
        return this._createParser(this._decorate(this._optimizedStreamFromURL(url), createContext), createContext);
    }
    
    public JsonParser createParser(final byte[] array) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(array, true);
        final InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            final InputStream decorate = inputDecorator.decorate(createContext, array, 0, array.length);
            if (decorate != null) {
                return this._createParser(decorate, createContext);
            }
        }
        return this._createParser(array, 0, array.length, createContext);
    }
    
    public JsonParser createParser(final byte[] array, final int n, final int n2) throws IOException, JsonParseException {
        final com.fasterxml.jackson.core.io.c createContext = this._createContext(array, true);
        final InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            final InputStream decorate = inputDecorator.decorate(createContext, array, n, n2);
            if (decorate != null) {
                return this._createParser(decorate, createContext);
            }
        }
        return this._createParser(array, n, n2, createContext);
    }
    
    public JsonParser createParser(final char[] array) throws IOException {
        return this.createParser(array, 0, array.length);
    }
    
    public JsonParser createParser(final char[] array, final int n, final int n2) throws IOException {
        if (this._inputDecorator != null) {
            return this.createParser(new CharArrayReader(array, n, n2));
        }
        return this._createParser(array, n, n2, this._createContext(array, true), false);
    }
    
    public JsonFactory disable(final Feature feature) {
        this._factoryFeatures &= ~feature.getMask();
        return this;
    }
    
    public JsonFactory disable(final JsonGenerator.Feature feature) {
        this._generatorFeatures &= ~feature.getMask();
        return this;
    }
    
    public JsonFactory disable(final JsonParser.Feature feature) {
        this._parserFeatures &= ~feature.getMask();
        return this;
    }
    
    public JsonFactory enable(final Feature feature) {
        this._factoryFeatures |= feature.getMask();
        return this;
    }
    
    public JsonFactory enable(final JsonGenerator.Feature feature) {
        this._generatorFeatures |= feature.getMask();
        return this;
    }
    
    public JsonFactory enable(final JsonParser.Feature feature) {
        this._parserFeatures |= feature.getMask();
        return this;
    }
    
    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }
    
    public c getCodec() {
        return null;
    }
    
    public String getFormatName() {
        if (this.getClass() == JsonFactory.class) {
            return "JSON";
        }
        return null;
    }
    
    public Class<Object> getFormatReadFeatureType() {
        return null;
    }
    
    public Class<Object> getFormatWriteFeatureType() {
        return null;
    }
    
    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }
    
    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }
    
    public String getRootValueSeparator() {
        final e rootValueSeparator = this._rootValueSeparator;
        String value;
        if (rootValueSeparator == null) {
            value = null;
        }
        else {
            value = rootValueSeparator.getValue();
        }
        return value;
    }
    
    public MatchStrength hasFormat(final y2.a a) throws IOException {
        if (this.getClass() == JsonFactory.class) {
            return this.hasJSONFormat(a);
        }
        return null;
    }
    
    protected MatchStrength hasJSONFormat(final y2.a a) throws IOException {
        return z2.a.h(a);
    }
    
    public final boolean isEnabled(final Feature feature) {
        return (feature.getMask() & this._factoryFeatures) != 0x0;
    }
    
    public final boolean isEnabled(final JsonGenerator.Feature feature) {
        return (feature.getMask() & this._generatorFeatures) != 0x0;
    }
    
    public final boolean isEnabled(final JsonParser.Feature feature) {
        return (feature.getMask() & this._parserFeatures) != 0x0;
    }
    
    protected Object readResolve() {
        return new JsonFactory(this, null);
    }
    
    public boolean requiresCustomCodec() {
        return false;
    }
    
    public boolean requiresPropertyOrdering() {
        return false;
    }
    
    public JsonFactory setCharacterEscapes(final CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }
    
    public JsonFactory setCodec(final c c) {
        return this;
    }
    
    public JsonFactory setInputDecorator(final InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }
    
    public JsonFactory setOutputDecorator(final OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }
    
    public JsonFactory setRootValueSeparator(final String s) {
        e rootValueSeparator;
        if (s == null) {
            rootValueSeparator = null;
        }
        else {
            rootValueSeparator = new SerializedString(s);
        }
        this._rootValueSeparator = rootValueSeparator;
        return this;
    }
    
    public Version version() {
        return f.a;
    }
    
    public enum Feature
    {
        private static final Feature[] $VALUES;
        
        CANONICALIZE_FIELD_NAMES(true), 
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true), 
        INTERN_FIELD_NAMES(true), 
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);
        
        private final boolean _defaultState;
        
        private Feature(final boolean defaultState) {
            this._defaultState = defaultState;
        }
        
        public static int collectDefaults() {
            final Feature[] values = values();
            final int length = values.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                final Feature feature = values[i];
                int n2 = n;
                if (feature.enabledByDefault()) {
                    n2 = (n | feature.getMask());
                }
                ++i;
                n = n2;
            }
            return n;
        }
        
        public boolean enabledByDefault() {
            return this._defaultState;
        }
        
        public boolean enabledIn(final int n) {
            return (n & this.getMask()) != 0x0;
        }
        
        public int getMask() {
            return 1 << this.ordinal();
        }
    }
}
