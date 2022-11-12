// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnKeyListener;
import android.widget.SeekBar$OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.SeekBar;

public class SeekBarPreference extends Preference
{
    int a0;
    int b0;
    private int c0;
    private int d0;
    boolean e0;
    SeekBar f0;
    private TextView g0;
    boolean h0;
    private boolean i0;
    boolean j0;
    private final SeekBar$OnSeekBarChangeListener k0;
    private final View$OnKeyListener l0;
    
    public SeekBarPreference(final Context context, final AttributeSet set) {
        this(context, set, m.j);
    }
    
    public SeekBarPreference(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public SeekBarPreference(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.k0 = (SeekBar$OnSeekBarChangeListener)new SeekBar$OnSeekBarChangeListener() {
            final SeekBarPreference a;
            
            public void onProgressChanged(final SeekBar seekBar, final int n, final boolean b) {
                if (b) {
                    final SeekBarPreference a = this.a;
                    if (a.j0 || !a.e0) {
                        a.Z0(seekBar);
                        return;
                    }
                }
                final SeekBarPreference a2 = this.a;
                a2.a1(n + a2.b0);
            }
            
            public void onStartTrackingTouch(final SeekBar seekBar) {
                this.a.e0 = true;
            }
            
            public void onStopTrackingTouch(final SeekBar seekBar) {
                this.a.e0 = false;
                final int progress = seekBar.getProgress();
                final SeekBarPreference a = this.a;
                if (progress + a.b0 != a.a0) {
                    a.Z0(seekBar);
                }
            }
        };
        this.l0 = (View$OnKeyListener)new View$OnKeyListener() {
            final SeekBarPreference a;
            
            public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                final SeekBarPreference a = this.a;
                if (!a.h0 && (n == 21 || n == 22)) {
                    return false;
                }
                if (n == 23 || n == 66) {
                    return false;
                }
                final SeekBar f0 = a.f0;
                if (f0 == null) {
                    Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                    return false;
                }
                return f0.onKeyDown(n, keyEvent);
            }
        };
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, s.H0, n, n2);
        this.b0 = obtainStyledAttributes.getInt(s.K0, 0);
        this.V0(obtainStyledAttributes.getInt(s.I0, 100));
        this.W0(obtainStyledAttributes.getInt(s.L0, 0));
        this.h0 = obtainStyledAttributes.getBoolean(s.J0, true);
        this.i0 = obtainStyledAttributes.getBoolean(s.M0, false);
        this.j0 = obtainStyledAttributes.getBoolean(s.N0, false);
        obtainStyledAttributes.recycle();
    }
    
    private void Y0(int a0, final boolean b) {
        final int b2 = this.b0;
        int n = a0;
        if (a0 < b2) {
            n = b2;
        }
        final int c0 = this.c0;
        if ((a0 = n) > c0) {
            a0 = c0;
        }
        if (a0 != this.a0) {
            this.a1(this.a0 = a0);
            this.s0(a0);
            if (b) {
                this.R();
            }
        }
    }
    
    public final void V0(final int n) {
        final int b0 = this.b0;
        int c0 = n;
        if (n < b0) {
            c0 = b0;
        }
        if (c0 != this.c0) {
            this.c0 = c0;
            this.R();
        }
    }
    
    public final void W0(final int n) {
        if (n != this.d0) {
            this.d0 = Math.min(this.c0 - this.b0, Math.abs(n));
            this.R();
        }
    }
    
    public void X0(final int n) {
        this.Y0(n, true);
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        l.itemView.setOnKeyListener(this.l0);
        this.f0 = (SeekBar)l.a(o.c);
        final TextView g0 = (TextView)l.a(o.d);
        this.g0 = g0;
        if (this.i0) {
            g0.setVisibility(0);
        }
        else {
            g0.setVisibility(8);
            this.g0 = null;
        }
        final SeekBar f0 = this.f0;
        if (f0 == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        f0.setOnSeekBarChangeListener(this.k0);
        this.f0.setMax(this.c0 - this.b0);
        final int d0 = this.d0;
        if (d0 != 0) {
            this.f0.setKeyProgressIncrement(d0);
        }
        else {
            this.d0 = this.f0.getKeyProgressIncrement();
        }
        this.f0.setProgress(this.a0 - this.b0);
        this.a1(this.a0);
        this.f0.setEnabled(this.N());
    }
    
    void Z0(final SeekBar seekBar) {
        final int n = this.b0 + seekBar.getProgress();
        if (n != this.a0) {
            if (this.c(n)) {
                this.Y0(n, false);
            }
            else {
                seekBar.setProgress(this.a0 - this.b0);
                this.a1(this.a0);
            }
        }
    }
    
    void a1(final int n) {
        final TextView g0 = this.g0;
        if (g0 != null) {
            g0.setText((CharSequence)String.valueOf(n));
        }
    }
    
    @Override
    protected Object e0(final TypedArray typedArray, final int n) {
        return typedArray.getInt(n, 0);
    }
    
    @Override
    protected void i0(final Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            final SavedState savedState = (SavedState)parcelable;
            super.i0(savedState.getSuperState());
            this.a0 = savedState.a;
            this.b0 = savedState.b;
            this.c0 = savedState.c;
            this.R();
            return;
        }
        super.i0(parcelable);
    }
    
    @Override
    protected Parcelable j0() {
        final Parcelable j0 = super.j0();
        if (this.O()) {
            return j0;
        }
        final SavedState savedState = new SavedState(j0);
        savedState.a = this.a0;
        savedState.b = this.b0;
        savedState.c = this.c0;
        return (Parcelable)savedState;
    }
    
    @Override
    protected void k0(final Object o) {
        Object value = o;
        if (o == null) {
            value = 0;
        }
        this.X0(this.y((int)value));
    }
    
    private static class SavedState extends BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int a;
        int b;
        int c;
        
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
            this.b = parcel.readInt();
            this.c = parcel.readInt();
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }
    }
}
