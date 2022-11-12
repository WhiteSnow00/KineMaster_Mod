// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.List;
import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable
{
    public static final Parcelable$Creator<FragmentManagerState> CREATOR;
    ArrayList<String> a;
    ArrayList<String> b;
    BackStackRecordState[] c;
    int d;
    String e;
    ArrayList<String> f;
    ArrayList<BackStackState> g;
    ArrayList<FragmentManager.LaunchedFragmentInfo> h;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentManagerState>() {
            public FragmentManagerState a(final Parcel parcel) {
                return new FragmentManagerState(parcel);
            }
            
            public FragmentManagerState[] b(final int n) {
                return new FragmentManagerState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public FragmentManagerState() {
        this.e = null;
        this.f = new ArrayList<String>();
        this.g = new ArrayList<BackStackState>();
    }
    
    public FragmentManagerState(final Parcel parcel) {
        this.e = null;
        this.f = new ArrayList<String>();
        this.g = new ArrayList<BackStackState>();
        this.a = parcel.createStringArrayList();
        this.b = parcel.createStringArrayList();
        this.c = (BackStackRecordState[])parcel.createTypedArray((Parcelable$Creator)BackStackRecordState.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.createStringArrayList();
        this.g = parcel.createTypedArrayList((Parcelable$Creator)BackStackState.CREATOR);
        this.h = parcel.createTypedArrayList((Parcelable$Creator)FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeStringList((List)this.a);
        parcel.writeStringList((List)this.b);
        parcel.writeTypedArray((Parcelable[])this.c, n);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeStringList((List)this.f);
        parcel.writeTypedList((List)this.g);
        parcel.writeTypedList((List)this.h);
    }
}
