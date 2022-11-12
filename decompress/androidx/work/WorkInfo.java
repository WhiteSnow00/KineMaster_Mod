// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo
{
    private UUID a;
    private State b;
    private b c;
    private Set<String> d;
    private b e;
    private int f;
    
    public WorkInfo(final UUID a, final State b, final b c, final List<String> list, final b e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new HashSet<String>(list);
        this.e = e;
        this.f = f;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && WorkInfo.class == o.getClass()) {
            final WorkInfo workInfo = (WorkInfo)o;
            return this.f == workInfo.f && this.a.equals(workInfo.a) && this.b == workInfo.b && this.c.equals(workInfo.c) && this.d.equals(workInfo.d) && this.e.equals(workInfo.e);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WorkInfo{mId='");
        sb.append(this.a);
        sb.append('\'');
        sb.append(", mState=");
        sb.append(this.b);
        sb.append(", mOutputData=");
        sb.append(this.c);
        sb.append(", mTags=");
        sb.append(this.d);
        sb.append(", mProgress=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }
    
    public enum State
    {
        private static final State[] $VALUES;
        
        BLOCKED, 
        CANCELLED, 
        ENQUEUED, 
        FAILED, 
        RUNNING, 
        SUCCEEDED;
        
        public boolean isFinished() {
            return this == State.SUCCEEDED || this == State.FAILED || this == State.CANCELLED;
        }
    }
}
