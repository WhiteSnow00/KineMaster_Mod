// 
// Decompiled by Procyon v0.6.0
// 

package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;

class SlidingPaneLayout$SavedState extends AbsSavedState
{
    public static final Parcelable$Creator<SlidingPaneLayout$SavedState> CREATOR;
    boolean c;
    int d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SlidingPaneLayout$SavedState>() {
            public SlidingPaneLayout$SavedState a(final Parcel parcel) {
                return new SlidingPaneLayout$SavedState(parcel, null);
            }
            
            public SlidingPaneLayout$SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                return new SlidingPaneLayout$SavedState(parcel, null);
            }
            
            public SlidingPaneLayout$SavedState[] c(final int n) {
                return new SlidingPaneLayout$SavedState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return this.b(parcel, classLoader);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.c(n);
            }
        };
    }
    
    SlidingPaneLayout$SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super(parcel, classLoader);
        this.c = (parcel.readInt() != 0);
        this.d = parcel.readInt();
    }
    
    @Override
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt((int)(this.c ? 1 : 0));
        parcel.writeInt(this.d);
    }
}
