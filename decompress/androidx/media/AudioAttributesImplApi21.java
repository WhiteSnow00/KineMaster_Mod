// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import android.media.AudioAttributes$Builder;
import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl
{
    public AudioAttributes a;
    public int b;
    
    public AudioAttributesImplApi21() {
        this.b = -1;
    }
    
    AudioAttributesImplApi21(final AudioAttributes a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int a() {
        final int b = this.b;
        if (b != -1) {
            return b;
        }
        return AudioAttributesCompat.b(false, this.b(), this.c());
    }
    
    public int b() {
        return this.a.getFlags();
    }
    
    public int c() {
        return this.a.getUsage();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof AudioAttributesImplApi21 && this.a.equals((Object)((AudioAttributesImplApi21)o).a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AudioAttributesCompat: audioattributes=");
        sb.append(this.a);
        return sb.toString();
    }
    
    static class a implements AudioAttributesImpl.a
    {
        final AudioAttributes$Builder a;
        
        a() {
            this.a = new AudioAttributes$Builder();
        }
        
        @Override
        public /* bridge */ AudioAttributesImpl.a a(final int n) {
            return this.b(n);
        }
        
        public a b(final int legacyStreamType) {
            this.a.setLegacyStreamType(legacyStreamType);
            return this;
        }
    }
}
