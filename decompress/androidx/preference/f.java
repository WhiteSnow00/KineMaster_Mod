// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.view.WindowInsets$Type;
import android.os.Parcelable;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.os.Bundle;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.os.Build$VERSION;
import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.content.DialogInterface$OnClickListener;
import androidx.fragment.app.c;

public abstract class f extends c implements DialogInterface$OnClickListener
{
    private DialogPreference a;
    private CharSequence b;
    private CharSequence c;
    private CharSequence d;
    private CharSequence e;
    private int f;
    private BitmapDrawable g;
    private int h;
    
    private void m4(final Dialog dialog) {
        final Window window = dialog.getWindow();
        if (Build$VERSION.SDK_INT >= 30) {
            androidx.preference.f.a.a(window);
        }
        else {
            this.n4();
        }
    }
    
    public DialogPreference g4() {
        if (this.a == null) {
            this.a = ((DialogPreference.a)this.getTargetFragment()).i2(this.requireArguments().getString("key"));
        }
        return this.a;
    }
    
    protected boolean h4() {
        return false;
    }
    
    protected void i4(final View view) {
        final View viewById = view.findViewById(16908299);
        if (viewById != null) {
            final CharSequence e = this.e;
            int visibility = 8;
            if (!TextUtils.isEmpty(e)) {
                if (viewById instanceof TextView) {
                    ((TextView)viewById).setText(e);
                }
                visibility = 0;
            }
            if (viewById.getVisibility() != visibility) {
                viewById.setVisibility(visibility);
            }
        }
    }
    
    protected View j4(final Context context) {
        final int f = this.f;
        if (f == 0) {
            return null;
        }
        return this.getLayoutInflater().inflate(f, (ViewGroup)null);
    }
    
    public abstract void k4(final boolean p0);
    
    protected void l4(final androidx.appcompat.app.c.a a) {
    }
    
    protected void n4() {
    }
    
    public void onClick(final DialogInterface dialogInterface, final int h) {
        this.h = h;
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Fragment targetFragment = this.getTargetFragment();
        if (targetFragment instanceof DialogPreference.a) {
            final DialogPreference.a a = (DialogPreference.a)targetFragment;
            final String string = this.requireArguments().getString("key");
            if (bundle == null) {
                final DialogPreference a2 = a.i2(string);
                this.a = a2;
                this.b = a2.Y0();
                this.c = this.a.a1();
                this.d = this.a.Z0();
                this.e = this.a.X0();
                this.f = this.a.W0();
                final Drawable v0 = this.a.V0();
                if (v0 != null && !(v0 instanceof BitmapDrawable)) {
                    final Bitmap bitmap = Bitmap.createBitmap(v0.getIntrinsicWidth(), v0.getIntrinsicHeight(), Bitmap$Config.ARGB_8888);
                    final Canvas canvas = new Canvas(bitmap);
                    v0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    v0.draw(canvas);
                    this.g = new BitmapDrawable(this.getResources(), bitmap);
                }
                else {
                    this.g = (BitmapDrawable)v0;
                }
            }
            else {
                this.b = bundle.getCharSequence("PreferenceDialogFragment.title");
                this.c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
                this.d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
                this.e = bundle.getCharSequence("PreferenceDialogFragment.message");
                this.f = bundle.getInt("PreferenceDialogFragment.layout", 0);
                final Bitmap bitmap2 = (Bitmap)bundle.getParcelable("PreferenceDialogFragment.icon");
                if (bitmap2 != null) {
                    this.g = new BitmapDrawable(this.getResources(), bitmap2);
                }
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }
    
    @Override
    public Dialog onCreateDialog(final Bundle bundle) {
        this.h = -2;
        final androidx.appcompat.app.c.a f = new androidx.appcompat.app.c.a(this.requireContext()).setTitle(this.b).c((Drawable)this.g).i(this.c, (DialogInterface$OnClickListener)this).f(this.d, (DialogInterface$OnClickListener)this);
        final View j4 = this.j4(this.requireContext());
        if (j4 != null) {
            this.i4(j4);
            f.setView(j4);
        }
        else {
            f.d(this.e);
        }
        this.l4(f);
        final androidx.appcompat.app.c create = f.create();
        if (this.h4()) {
            this.m4(create);
        }
        return create;
    }
    
    @Override
    public void onDismiss(final DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.k4(this.h == -1);
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f);
        final BitmapDrawable g = this.g;
        if (g != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", (Parcelable)g.getBitmap());
        }
    }
    
    private static class a
    {
        static void a(final Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets$Type.ime());
        }
    }
}
