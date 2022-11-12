// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import java.nio.charset.Charset;
import java.io.Serializable;

public class JsonLocation implements Serializable
{
    public static final int MAX_CONTENT_SNIPPET = 500;
    public static final JsonLocation NA;
    private static final long serialVersionUID = 1L;
    protected final int _columnNr;
    protected final int _lineNr;
    final transient Object _sourceRef;
    protected final long _totalBytes;
    protected final long _totalChars;
    
    static {
        NA = new JsonLocation(null, -1L, -1L, -1, -1);
    }
    
    public JsonLocation(final Object o, final long n, final int n2, final int n3) {
        this(o, -1L, n, n2, n3);
    }
    
    public JsonLocation(final Object sourceRef, final long totalBytes, final long totalChars, final int lineNr, final int columnNr) {
        this._sourceRef = sourceRef;
        this._totalBytes = totalBytes;
        this._totalChars = totalChars;
        this._lineNr = lineNr;
        this._columnNr = columnNr;
    }
    
    private int a(final StringBuilder sb, final String s) {
        sb.append('\"');
        sb.append(s);
        sb.append('\"');
        return s.length();
    }
    
    protected StringBuilder _appendSourceDesc(final StringBuilder sb) {
        final Object sourceRef = this._sourceRef;
        if (sourceRef == null) {
            sb.append("UNKNOWN");
            return sb;
        }
        Class<? extends Class> class1;
        if (sourceRef instanceof Class) {
            class1 = (Class<? extends Class>)sourceRef;
        }
        else {
            class1 = ((Class<? extends Class>)sourceRef).getClass();
        }
        final String name = class1.getName();
        String simpleName;
        if (name.startsWith("java.")) {
            simpleName = class1.getSimpleName();
        }
        else if (sourceRef instanceof byte[]) {
            simpleName = "byte[]";
        }
        else {
            simpleName = name;
            if (sourceRef instanceof char[]) {
                simpleName = "char[]";
            }
        }
        sb.append('(');
        sb.append(simpleName);
        sb.append(')');
        final boolean b = sourceRef instanceof CharSequence;
        int n = 0;
        String s = " chars";
        Label_0292: {
            int n2;
            int n3;
            if (b) {
                final CharSequence charSequence = (CharSequence)sourceRef;
                n2 = charSequence.length();
                n3 = this.a(sb, charSequence.subSequence(0, Math.min(n2, 500)).toString());
            }
            else if (sourceRef instanceof char[]) {
                final char[] array = (char[])sourceRef;
                n2 = array.length;
                n3 = this.a(sb, new String(array, 0, Math.min(n2, 500)));
            }
            else {
                if (sourceRef instanceof byte[]) {
                    final byte[] array2 = (byte[])sourceRef;
                    final int min = Math.min(array2.length, 500);
                    this.a(sb, new String(array2, 0, min, Charset.forName("UTF-8")));
                    n = array2.length - min;
                    s = " bytes";
                }
                break Label_0292;
            }
            n = n2 - n3;
        }
        if (n > 0) {
            sb.append("[truncated ");
            sb.append(n);
            sb.append(s);
            sb.append(']');
        }
        return sb;
    }
    
    @Override
    public boolean equals(Object sourceRef) {
        boolean b = true;
        if (sourceRef == this) {
            return true;
        }
        if (sourceRef == null) {
            return false;
        }
        if (!(sourceRef instanceof JsonLocation)) {
            return false;
        }
        final JsonLocation jsonLocation = (JsonLocation)sourceRef;
        sourceRef = this._sourceRef;
        if (sourceRef == null) {
            if (jsonLocation._sourceRef != null) {
                return false;
            }
        }
        else if (!sourceRef.equals(jsonLocation._sourceRef)) {
            return false;
        }
        if (this._lineNr != jsonLocation._lineNr || this._columnNr != jsonLocation._columnNr || this._totalChars != jsonLocation._totalChars || this.getByteOffset() != jsonLocation.getByteOffset()) {
            b = false;
        }
        return b;
    }
    
    public long getByteOffset() {
        return this._totalBytes;
    }
    
    public long getCharOffset() {
        return this._totalChars;
    }
    
    public int getColumnNr() {
        return this._columnNr;
    }
    
    public int getLineNr() {
        return this._lineNr;
    }
    
    public Object getSourceRef() {
        return this._sourceRef;
    }
    
    @Override
    public int hashCode() {
        final Object sourceRef = this._sourceRef;
        int hashCode;
        if (sourceRef == null) {
            hashCode = 1;
        }
        else {
            hashCode = sourceRef.hashCode();
        }
        return ((hashCode ^ this._lineNr) + this._columnNr ^ (int)this._totalChars) + (int)this._totalBytes;
    }
    
    public String sourceDescription() {
        return this._appendSourceDesc(new StringBuilder(100)).toString();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        this._appendSourceDesc(sb);
        sb.append("; line: ");
        sb.append(this._lineNr);
        sb.append(", column: ");
        sb.append(this._columnNr);
        sb.append(']');
        return sb.toString();
    }
}
