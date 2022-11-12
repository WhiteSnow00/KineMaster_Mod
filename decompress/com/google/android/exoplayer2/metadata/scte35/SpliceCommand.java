// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;

public abstract class SpliceCommand implements Entry
{
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SCTE-35 splice command: type=");
        sb.append(this.getClass().getSimpleName());
        return sb.toString();
    }
}
