// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import android.util.Log;
import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl
{
    public int a;
    public int b;
    public int c;
    public int d;
    
    public AudioAttributesImplBase() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1;
    }
    
    AudioAttributesImplBase(final int b, final int c, final int a, final int d) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
    }
    
    static int e(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 10: {
                return 11;
            }
            case 8: {
                return 3;
            }
            case 6: {
                return 2;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 1;
            }
            case 2: {
                return 6;
            }
            case 1:
            case 7: {
                return 13;
            }
            case 0: {
                return 2;
            }
        }
    }
    
    @Override
    public int a() {
        final int d = this.d;
        if (d != -1) {
            return d;
        }
        return AudioAttributesCompat.b(false, this.c, this.a);
    }
    
    public int b() {
        return this.b;
    }
    
    public int c() {
        final int c = this.c;
        final int a = this.a();
        int n;
        if (a == 6) {
            n = (c | 0x4);
        }
        else {
            n = c;
            if (a == 7) {
                n = (c | 0x1);
            }
        }
        return n & 0x111;
    }
    
    public int d() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof AudioAttributesImplBase;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase)o;
        boolean b3 = b2;
        if (this.b == audioAttributesImplBase.b()) {
            b3 = b2;
            if (this.c == audioAttributesImplBase.c()) {
                b3 = b2;
                if (this.a == audioAttributesImplBase.d()) {
                    b3 = b2;
                    if (this.d == audioAttributesImplBase.d) {
                        b3 = true;
                    }
                }
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { this.b, this.c, this.a, this.d });
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.c(this.a));
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
    
    static class a implements AudioAttributesImpl.a
    {
        private int a;
        private int b;
        private int c;
        private int d;
        
        a() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = -1;
        }
        
        private a b(final int n) {
            switch (n) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid stream type ");
                    sb.append(n);
                    sb.append(" for AudioAttributesCompat");
                    Log.e("AudioAttributesCompat", sb.toString());
                    break;
                }
                case 10: {
                    this.b = 1;
                    break;
                }
                case 9: {
                    this.b = 4;
                    break;
                }
                case 8: {
                    this.b = 4;
                    break;
                }
                case 6: {
                    this.b = 1;
                    this.c |= 0x4;
                    break;
                }
                case 5: {
                    this.b = 4;
                    break;
                }
                case 4: {
                    this.b = 4;
                    break;
                }
                case 3: {
                    this.b = 2;
                    break;
                }
                case 2: {
                    this.b = 4;
                    break;
                }
                case 7: {
                    this.c |= 0x1;
                }
                case 1: {
                    this.b = 4;
                    break;
                }
                case 0: {
                    this.b = 1;
                    break;
                }
            }
            this.a = AudioAttributesImplBase.e(n);
            return this;
        }
        
        @Override
        public /* bridge */ AudioAttributesImpl.a a(final int n) {
            return this.c(n);
        }
        
        @Override
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
        }
        
        public a c(final int d) {
            if (d != 10) {
                this.d = d;
                return this.b(d);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }
    }
}
