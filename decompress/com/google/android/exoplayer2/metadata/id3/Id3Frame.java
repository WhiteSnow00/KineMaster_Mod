// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;

public abstract class Id3Frame implements Entry
{
    public final String a;
    
    public Id3Frame(final String a) {
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
}
