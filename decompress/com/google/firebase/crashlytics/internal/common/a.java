// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.Objects;
import java.io.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class a extends CrashlyticsReportWithSessionId
{
    private final CrashlyticsReport a;
    private final String b;
    private final File c;
    
    a(final CrashlyticsReport a, final String b, final File c) {
        Objects.requireNonNull(a, "Null report");
        this.a = a;
        Objects.requireNonNull(b, "Null sessionId");
        this.b = b;
        Objects.requireNonNull(c, "Null reportFile");
        this.c = c;
    }
    
    @Override
    public CrashlyticsReport b() {
        return this.a;
    }
    
    @Override
    public File c() {
        return this.c;
    }
    
    @Override
    public String d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof CrashlyticsReportWithSessionId) {
            final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId)o;
            if (!this.a.equals(crashlyticsReportWithSessionId.b()) || !this.b.equals(crashlyticsReportWithSessionId.d()) || !this.c.equals(crashlyticsReportWithSessionId.c())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CrashlyticsReportWithSessionId{report=");
        sb.append(this.a);
        sb.append(", sessionId=");
        sb.append(this.b);
        sb.append(", reportFile=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
