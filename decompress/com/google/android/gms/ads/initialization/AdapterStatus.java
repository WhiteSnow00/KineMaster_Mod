// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.initialization;

public interface AdapterStatus
{
    String getDescription();
    
    int getLatency();
    
    public enum State
    {
        NOT_READY("NOT_READY", 0), 
        READY("READY", 1);
        
        private static final State[] zza;
        
        private State(final String s, final int n) {
        }
    }
}
