// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import android.content.Context;
import kotlin.jvm.internal.o;
import android.os.Parcel;
import kotlin.jvm.internal.i;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import kotlin.Metadata;
import android.os.Parcelable;

@Metadata(bv = {}, d1 = { "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 )2\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b%\u0010(J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f¨\u0006*" }, d2 = { "Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcelable;", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "destination", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/j;", "viewModel", "Landroidx/navigation/NavBackStackEntry;", "c", "", "describeContents", "Landroid/os/Parcel;", "parcel", "i", "Lka/r;", "writeToParcel", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "I", "()I", "destinationId", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "args", "d", "getSavedState", "savedState", "entry", "<init>", "(Landroidx/navigation/NavBackStackEntry;)V", "inParcel", "(Landroid/os/Parcel;)V", "e", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public final class NavBackStackEntryState implements Parcelable
{
    public static final Parcelable$Creator<NavBackStackEntryState> CREATOR;
    public static final b e;
    private final String a;
    private final int b;
    private final Bundle c;
    private final Bundle d;
    
    static {
        e = new b(null);
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<NavBackStackEntryState>() {
            public NavBackStackEntryState a(final Parcel parcel) {
                o.g((Object)parcel, "inParcel");
                return new NavBackStackEntryState(parcel);
            }
            
            public NavBackStackEntryState[] b(final int n) {
                return new NavBackStackEntryState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public NavBackStackEntryState(final Parcel parcel) {
        o.g((Object)parcel, "inParcel");
        final String string = parcel.readString();
        o.d((Object)string);
        this.a = string;
        this.b = parcel.readInt();
        this.c = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        final Bundle bundle = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        o.d((Object)bundle);
        this.d = bundle;
    }
    
    public NavBackStackEntryState(final NavBackStackEntry navBackStackEntry) {
        o.g((Object)navBackStackEntry, "entry");
        this.a = navBackStackEntry.g();
        this.b = navBackStackEntry.f().p();
        this.c = navBackStackEntry.d();
        navBackStackEntry.k(this.d = new Bundle());
    }
    
    public final int a() {
        return this.b;
    }
    
    public final String b() {
        return this.a;
    }
    
    public final NavBackStackEntry c(final Context context, final NavDestination navDestination, final Lifecycle.State state, final j j) {
        o.g((Object)context, "context");
        o.g((Object)navDestination, "destination");
        o.g((Object)state, "hostLifecycleState");
        Bundle c = this.c;
        if (c != null) {
            c.setClassLoader(context.getClassLoader());
        }
        else {
            c = null;
        }
        return NavBackStackEntry.y.a(context, navDestination, c, state, j, this.a, this.d);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        o.g((Object)parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeBundle(this.c);
        parcel.writeBundle(this.d);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b" }, d2 = { "Landroidx/navigation/NavBackStackEntryState$b;", "", "Landroid/os/Parcelable$Creator;", "Landroidx/navigation/NavBackStackEntryState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class b
    {
        private b() {
        }
        
        public b(final i i) {
            this();
        }
    }
}
