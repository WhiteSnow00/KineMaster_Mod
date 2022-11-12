// 
// Decompiled by Procyon v0.6.0
// 

package androidx.legacy.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class FragmentTabHost$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<FragmentTabHost$SavedState> CREATOR;
    String a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentTabHost$SavedState>() {
            public FragmentTabHost$SavedState a(final Parcel parcel) {
                return new FragmentTabHost$SavedState(parcel);
            }
            
            public FragmentTabHost$SavedState[] b(final int n) {
                return new FragmentTabHost$SavedState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    FragmentTabHost$SavedState(final Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FragmentTabHost.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" curTab=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeString(this.a);
    }
}
