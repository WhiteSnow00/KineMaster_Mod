// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.media.AudioFocusRequest$Builder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import android.media.AudioManager$OnAudioFocusChangeListener;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Handler;
import android.content.Context;
import android.media.AudioFocusRequest;
import com.google.android.exoplayer2.audio.AudioAttributes;
import android.media.AudioManager;

final class AudioFocusManager
{
    private final AudioManager a;
    private final a b;
    private PlayerControl c;
    private AudioAttributes d;
    private int e;
    private int f;
    private float g;
    private AudioFocusRequest h;
    private boolean i;
    
    public AudioFocusManager(final Context context, final Handler handler, final PlayerControl c) {
        this.g = 1.0f;
        this.a = Assertions.e(context.getApplicationContext().getSystemService("audio"));
        this.c = c;
        this.b = new a(handler);
        this.e = 0;
    }
    
    private void a() {
        this.a.abandonAudioFocus((AudioManager$OnAudioFocusChangeListener)this.b);
    }
    
    private void b() {
        if (this.e == 0) {
            return;
        }
        if (Util.a >= 26) {
            this.c();
        }
        else {
            this.a();
        }
        this.n(0);
    }
    
    private void c() {
        final AudioFocusRequest h = this.h;
        if (h != null) {
            this.a.abandonAudioFocusRequest(h);
        }
    }
    
    static void d(final AudioFocusManager audioFocusManager, final int n) {
        audioFocusManager.h(n);
    }
    
    private static int e(final AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.c) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unidentified audio usage: ");
                sb.append(audioAttributes.c);
                Log.i("AudioFocusManager", sb.toString());
                return 0;
            }
            case 16: {
                if (Util.a >= 19) {
                    return 4;
                }
                return 2;
            }
            case 11: {
                if (audioAttributes.a == 1) {
                    return 2;
                }
                return 3;
            }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13: {
                return 3;
            }
            case 3: {
                return 0;
            }
            case 2:
            case 4: {
                return 2;
            }
            case 1:
            case 14: {
                return 1;
            }
            case 0: {
                Log.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            }
        }
    }
    
    private void f(final int n) {
        final PlayerControl c = this.c;
        if (c != null) {
            c.A(n);
        }
    }
    
    private void h(final int n) {
        if (n == -3 || n == -2) {
            if (n != -2 && !this.q()) {
                this.n(3);
            }
            else {
                this.f(0);
                this.n(2);
            }
            return;
        }
        if (n == -1) {
            this.f(-1);
            this.b();
            return;
        }
        if (n != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown focus change type: ");
            sb.append(n);
            Log.i("AudioFocusManager", sb.toString());
            return;
        }
        this.n(1);
        this.f(1);
    }
    
    private int j() {
        if (this.e == 1) {
            return 1;
        }
        int n;
        if (Util.a >= 26) {
            n = this.l();
        }
        else {
            n = this.k();
        }
        if (n == 1) {
            this.n(1);
            return 1;
        }
        this.n(0);
        return -1;
    }
    
    private int k() {
        return this.a.requestAudioFocus((AudioManager$OnAudioFocusChangeListener)this.b, Util.g0(Assertions.e(this.d).c), this.f);
    }
    
    private int l() {
        final AudioFocusRequest h = this.h;
        if (h == null || this.i) {
            AudioFocusRequest$Builder audioFocusRequest$Builder;
            if (h == null) {
                audioFocusRequest$Builder = new AudioFocusRequest$Builder(this.f);
            }
            else {
                audioFocusRequest$Builder = new AudioFocusRequest$Builder(this.h);
            }
            this.h = audioFocusRequest$Builder.setAudioAttributes(Assertions.e(this.d).b().a).setWillPauseWhenDucked(this.q()).setOnAudioFocusChangeListener((AudioManager$OnAudioFocusChangeListener)this.b).build();
            this.i = false;
        }
        return this.a.requestAudioFocus(this.h);
    }
    
    private void n(final int e) {
        if (this.e == e) {
            return;
        }
        float g;
        if ((this.e = e) == 3) {
            g = 0.2f;
        }
        else {
            g = 1.0f;
        }
        if (this.g == g) {
            return;
        }
        this.g = g;
        final PlayerControl c = this.c;
        if (c != null) {
            c.z(g);
        }
    }
    
    private boolean o(final int n) {
        boolean b = true;
        if (n != 1) {
            b = (this.f != 1 && b);
        }
        return b;
    }
    
    private boolean q() {
        final AudioAttributes d = this.d;
        boolean b = true;
        if (d == null || d.a != 1) {
            b = false;
        }
        return b;
    }
    
    public float g() {
        return this.g;
    }
    
    public void i() {
        this.c = null;
        this.b();
    }
    
    public void m(final AudioAttributes d) {
        if (!Util.c(this.d, d)) {
            this.d = d;
            final int e = e(d);
            this.f = e;
            boolean b = true;
            if (e != 1) {
                b = (e == 0 && b);
            }
            Assertions.b(b, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }
    
    public int p(final boolean b, int j) {
        final boolean o = this.o(j);
        j = -1;
        if (o) {
            this.b();
            if (b) {
                j = 1;
            }
            return j;
        }
        if (b) {
            j = this.j();
        }
        return j;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface PlayerCommand {
    }
    
    public interface PlayerControl
    {
        void A(final int p0);
        
        void z(final float p0);
    }
    
    private class a implements AudioManager$OnAudioFocusChangeListener
    {
        private final Handler a;
        final AudioFocusManager b;
        
        public a(final AudioFocusManager b, final Handler a) {
            this.b = b;
            this.a = a;
        }
        
        public static void a(final a a, final int n) {
            a.b(n);
        }
        
        private void b(final int n) {
            AudioFocusManager.d(this.b, n);
        }
        
        public void onAudioFocusChange(final int n) {
            this.a.post((Runnable)new com.google.android.exoplayer2.a(this, n));
        }
    }
}
