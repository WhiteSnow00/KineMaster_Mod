// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

class BackStackState implements Parcelable
{
    public static final Parcelable$Creator<BackStackState> CREATOR;
    final List<String> a;
    final List<BackStackRecordState> b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BackStackState>() {
            public BackStackState a(final Parcel parcel) {
                return new BackStackState(parcel);
            }
            
            public BackStackState[] b(final int n) {
                return new BackStackState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    BackStackState(final Parcel parcel) {
        this.a = parcel.createStringArrayList();
        this.b = parcel.createTypedArrayList((Parcelable$Creator)BackStackRecordState.CREATOR);
    }
    
    BackStackState(final List<String> a, final List<BackStackRecordState> b) {
        this.a = a;
        this.b = b;
    }
    
    List<a> a(final FragmentManager fragmentManager, final Map<String, Fragment> map) {
        final HashMap hashMap = new HashMap(this.a.size());
        for (final String s : this.a) {
            final Fragment fragment = map.get(s);
            if (fragment != null) {
                hashMap.put(fragment.mWho, fragment);
            }
            else {
                final FragmentState b = fragmentManager.y0().B(s, null);
                if (b == null) {
                    continue;
                }
                final Fragment a = b.a(fragmentManager.x0(), fragmentManager.A0().f().getClassLoader());
                hashMap.put(a.mWho, a);
            }
        }
        final ArrayList<a> list = new ArrayList<a>();
        final Iterator<BackStackRecordState> iterator2 = this.b.iterator();
        while (iterator2.hasNext()) {
            list.add(iterator2.next().c(fragmentManager, hashMap));
        }
        return list;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeStringList((List)this.a);
        parcel.writeTypedList((List)this.b);
    }
}
