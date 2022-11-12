// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads;

@Deprecated
public final class AdRequest
{
    private AdRequest() {
    }
    
    public enum ErrorCode
    {
        INTERNAL_ERROR("INTERNAL_ERROR", 3, "There was an internal error."), 
        INVALID_REQUEST("INVALID_REQUEST", 0, "Invalid Ad request."), 
        NETWORK_ERROR("NETWORK_ERROR", 2, "A network error occurred."), 
        NO_FILL("NO_FILL", 1, "Ad request successful, but no ad returned due to lack of ad inventory.");
        
        private static final ErrorCode[] zza;
        private final String zzb;
        
        private ErrorCode(final String s, final int n, final String zzb) {
            this.zzb = zzb;
        }
        
        @Override
        public String toString() {
            return this.zzb;
        }
    }
    
    public enum Gender
    {
        FEMALE("FEMALE", 2), 
        MALE("MALE", 1), 
        UNKNOWN("UNKNOWN", 0);
        
        private static final Gender[] zza;
        
        private Gender(final String s, final int n) {
        }
    }
}
