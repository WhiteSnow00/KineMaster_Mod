// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.parser;

import p.a;

public class CLParsingException extends Exception
{
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;
    
    public CLParsingException(final String mReason, final a a) {
        this.mReason = mReason;
        this.mElementClass = "unknown";
        this.mLineNumber = 0;
    }
    
    public String reason() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.mReason);
        sb.append(" (");
        sb.append(this.mElementClass);
        sb.append(" at line ");
        sb.append(this.mLineNumber);
        sb.append(")");
        return sb.toString();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CLParsingException (");
        sb.append(this.hashCode());
        sb.append(") : ");
        sb.append(this.reason());
        return sb.toString();
    }
}
