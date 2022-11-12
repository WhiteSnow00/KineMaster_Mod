// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.s0;
import kotlin.jvm.internal.o;
import android.content.Context;
import androidx.lifecycle.t;
import kotlin.Metadata;
import androidx.lifecycle.r;
import android.app.Dialog;

@Metadata(bv = {}, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0003\u0010#\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0015J\b\u0010\u000b\u001a\u00020\u0004H\u0015J\b\u0010\f\u001a\u00020\u0004H\u0015J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u0004H\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001f¨\u0006&" }, d2 = { "Landroidx/activity/f;", "Landroid/app/Dialog;", "Landroidx/lifecycle/r;", "Landroidx/activity/h;", "Lka/r;", "c", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "onStop", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "onBackPressed", "", "layoutResID", "setContentView", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "addContentView", "Landroidx/lifecycle/t;", "a", "Landroidx/lifecycle/t;", "_lifecycleRegistry", "b", "Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher", "()Landroidx/lifecycle/t;", "lifecycleRegistry", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "activity_release" }, k = 1, mv = { 1, 6, 0 })
public class f extends Dialog implements r, h
{
    private t a;
    private final OnBackPressedDispatcher b;
    
    public f(final Context context, final int n) {
        o.g((Object)context, "context");
        super(context, n);
        this.b = new OnBackPressedDispatcher(new e(this));
    }
    
    public static void a(final f f) {
        d(f);
    }
    
    private final t b() {
        t a;
        if ((a = this.a) == null) {
            a = new t(this);
            this.a = a;
        }
        return a;
    }
    
    private final void c() {
        final Window window = this.getWindow();
        o.d((Object)window);
        s0.a(window.getDecorView(), this);
        final Window window2 = this.getWindow();
        o.d((Object)window2);
        final View decorView = window2.getDecorView();
        o.f((Object)decorView, "window!!.decorView");
        j.a(decorView, this);
    }
    
    private static final void d(final f f) {
        o.g((Object)f, "this$0");
        f.onBackPressed();
    }
    
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        o.g((Object)view, "view");
        this.c();
        super.addContentView(view, viewGroup$LayoutParams);
    }
    
    public final Lifecycle getLifecycle() {
        return this.b();
    }
    
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.b;
    }
    
    public void onBackPressed() {
        this.b.d();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.b().h(Lifecycle.Event.ON_CREATE);
    }
    
    protected void onStart() {
        super.onStart();
        this.b().h(Lifecycle.Event.ON_RESUME);
    }
    
    protected void onStop() {
        this.b().h(Lifecycle.Event.ON_DESTROY);
        this.a = null;
        super.onStop();
    }
    
    public void setContentView(final int contentView) {
        this.c();
        super.setContentView(contentView);
    }
    
    public void setContentView(final View contentView) {
        o.g((Object)contentView, "view");
        this.c();
        super.setContentView(contentView);
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        o.g((Object)view, "view");
        this.c();
        super.setContentView(view, viewGroup$LayoutParams);
    }
}
