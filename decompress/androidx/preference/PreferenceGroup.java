// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Collections;
import android.util.Log;
import android.content.res.TypedArray;
import androidx.core.content.res.i;
import java.util.ArrayList;
import android.os.Looper;
import android.util.AttributeSet;
import android.content.Context;
import java.util.List;
import android.os.Handler;
import androidx.collection.g;

public abstract class PreferenceGroup extends Preference
{
    final g<String, Long> a0;
    private final Handler b0;
    private final List<Preference> c0;
    private boolean d0;
    private int e0;
    private boolean f0;
    private int g0;
    private b h0;
    private final Runnable i0;
    
    public PreferenceGroup(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public PreferenceGroup(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public PreferenceGroup(final Context context, final AttributeSet set, int n, final int n2) {
        super(context, set, n, n2);
        this.a0 = new g<String, Long>();
        this.b0 = new Handler(Looper.getMainLooper());
        this.d0 = true;
        this.e0 = 0;
        this.f0 = false;
        this.g0 = Integer.MAX_VALUE;
        this.h0 = null;
        this.i0 = new Runnable() {
            final PreferenceGroup a;
            
            @Override
            public void run() {
                synchronized (this) {
                    this.a.a0.clear();
                }
            }
        };
        this.c0 = new ArrayList<Preference>();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.A0, n, n2);
        n = s.C0;
        this.d0 = androidx.core.content.res.i.b(obtainStyledAttributes, n, n, true);
        n = s.B0;
        if (obtainStyledAttributes.hasValue(n)) {
            this.g1(androidx.core.content.res.i.d(obtainStyledAttributes, n, n, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }
    
    private boolean f1(final Preference preference) {
        synchronized (this) {
            preference.h0();
            if (preference.w() == this) {
                preference.a(null);
            }
            final boolean remove = this.c0.remove(preference);
            if (remove) {
                final String r = preference.r();
                if (r != null) {
                    this.a0.put(r, preference.p());
                    this.b0.removeCallbacks(this.i0);
                    this.b0.post(this.i0);
                }
                if (this.f0) {
                    preference.d0();
                }
            }
            return remove;
        }
    }
    
    @Override
    public void S(final boolean b) {
        super.S(b);
        for (int b2 = this.b1(), i = 0; i < b2; ++i) {
            this.a1(i).g0(this, b);
        }
    }
    
    @Override
    public void U() {
        super.U();
        this.f0 = true;
        for (int b1 = this.b1(), i = 0; i < b1; ++i) {
            this.a1(i).U();
        }
    }
    
    public void V0(final Preference preference) {
        this.W0(preference);
    }
    
    public boolean W0(final Preference preference) {
        if (this.c0.contains(preference)) {
            return true;
        }
        if (preference.r() != null) {
            PreferenceGroup w;
            for (w = this; w.w() != null; w = w.w()) {}
            final String r = preference.r();
            if (w.X0(r) != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Found duplicated key: \"");
                sb.append(r);
                sb.append("\". This can cause unintended behaviour, please use unique keys for every preference.");
                Log.e("PreferenceGroup", sb.toString());
            }
        }
        if (preference.u() == Integer.MAX_VALUE) {
            if (this.d0) {
                preference.J0(this.e0++);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup)preference).h1(this.d0);
            }
        }
        final int binarySearch = Collections.binarySearch(this.c0, preference);
        int n;
        if ((n = binarySearch) < 0) {
            n = binarySearch * -1 - 1;
        }
        if (!this.d1(preference)) {
            return false;
        }
        synchronized (this) {
            this.c0.add(n, preference);
            monitorexit(this);
            final j c = this.C();
            final String r2 = preference.r();
            long n2;
            if (r2 != null && this.a0.containsKey(r2)) {
                n2 = this.a0.get(r2);
                this.a0.remove(r2);
            }
            else {
                n2 = c.f();
            }
            preference.X(c, n2);
            preference.a(this);
            if (this.f0) {
                preference.U();
            }
            this.T();
            return true;
        }
    }
    
    public <T extends Preference> T X0(final CharSequence charSequence) {
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals((CharSequence)this.r(), charSequence)) {
            return (T)this;
        }
        for (int b1 = this.b1(), i = 0; i < b1; ++i) {
            final Preference a1 = this.a1(i);
            if (TextUtils.equals((CharSequence)a1.r(), charSequence)) {
                return (T)a1;
            }
            if (a1 instanceof PreferenceGroup) {
                final Preference x0 = ((PreferenceGroup)a1).X0(charSequence);
                if (x0 != null) {
                    return (T)x0;
                }
            }
        }
        return null;
    }
    
    public int Y0() {
        return this.g0;
    }
    
    public b Z0() {
        return this.h0;
    }
    
    public Preference a1(final int n) {
        return this.c0.get(n);
    }
    
    public int b1() {
        return this.c0.size();
    }
    
    protected boolean c1() {
        return true;
    }
    
    @Override
    public void d0() {
        super.d0();
        int i = 0;
        this.f0 = false;
        while (i < this.b1()) {
            this.a1(i).d0();
            ++i;
        }
    }
    
    protected boolean d1(final Preference preference) {
        preference.g0(this, this.P0());
        return true;
    }
    
    public boolean e1(final Preference preference) {
        final boolean f1 = this.f1(preference);
        this.T();
        return f1;
    }
    
    protected void g(final Bundle bundle) {
        super.g(bundle);
        for (int b1 = this.b1(), i = 0; i < b1; ++i) {
            this.a1(i).g(bundle);
        }
    }
    
    public void g1(final int g0) {
        if (g0 != Integer.MAX_VALUE && !this.K()) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getSimpleName());
            sb.append(" should have a key defined if it contains an expandable preference");
            Log.e("PreferenceGroup", sb.toString());
        }
        this.g0 = g0;
    }
    
    protected void h(final Bundle bundle) {
        super.h(bundle);
        for (int b1 = this.b1(), i = 0; i < b1; ++i) {
            this.a1(i).h(bundle);
        }
    }
    
    public void h1(final boolean d0) {
        this.d0 = d0;
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            this.g0 = savedState.a;
            super.i0(savedState.getSuperState());
            return;
        }
        super.i0(parcelable);
    }
    
    void i1() {
        synchronized (this) {
            Collections.sort(this.c0);
        }
    }
    
    @Override
    protected Parcelable j0() {
        return (Parcelable)new SavedState(super.j0(), this.g0);
    }
    
    static class SavedState extends BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SavedState(final Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }
        
        SavedState(final Parcelable parcelable, final int a) {
            super(parcelable);
            this.a = a;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.a);
        }
    }
    
    public interface b
    {
        void a();
    }
}
