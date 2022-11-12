// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.view.Window;
import android.view.ViewGroup;
import u0.e;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import androidx.lifecycle.s0;
import android.view.LayoutInflater;
import androidx.activity.f;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.util.Log;
import android.content.DialogInterface;
import androidx.lifecycle.r;
import androidx.lifecycle.a0;
import android.os.Handler;
import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;

public class c extends Fragment implements DialogInterface$OnCancelListener, DialogInterface$OnDismissListener
{
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private a0<r> mObserver;
    private DialogInterface$OnCancelListener mOnCancelListener;
    private DialogInterface$OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;
    
    public c() {
        this.mDismissRunnable = new Runnable() {
            final c a;
            
            @Override
            public void run() {
                c.access$100(this.a).onDismiss((DialogInterface)c.access$000(this.a));
            }
        };
        this.mOnCancelListener = (DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            final c a;
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (c.access$000(this.a) != null) {
                    final c a = this.a;
                    a.onCancel((DialogInterface)c.access$000(a));
                }
            }
        };
        this.mOnDismissListener = (DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener() {
            final c a;
            
            public void onDismiss(final DialogInterface dialogInterface) {
                if (c.access$000(this.a) != null) {
                    final c a = this.a;
                    a.onDismiss((DialogInterface)c.access$000(a));
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new a0<r>() {
            final c a;
            
            public void a(final r r) {
                if (r != null && c.access$200(this.a)) {
                    final View requireView = this.a.requireView();
                    if (requireView.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (c.access$000(this.a) != null) {
                        if (FragmentManager.N0(3)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("DialogFragment ");
                            sb.append(this);
                            sb.append(" setting the content view on ");
                            sb.append(c.access$000(this.a));
                            Log.d("FragmentManager", sb.toString());
                        }
                        c.access$000(this.a).setContentView(requireView);
                    }
                }
            }
            
            @Override
            public /* bridge */ void onChanged(final Object o) {
                this.a((r)o);
            }
        };
        this.mDialogCreated = false;
    }
    
    public c(final int n) {
        super(n);
        this.mDismissRunnable = new Runnable() {
            final c a;
            
            @Override
            public void run() {
                c.access$100(this.a).onDismiss((DialogInterface)c.access$000(this.a));
            }
        };
        this.mOnCancelListener = (DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            final c a;
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (c.access$000(this.a) != null) {
                    final c a = this.a;
                    a.onCancel((DialogInterface)c.access$000(a));
                }
            }
        };
        this.mOnDismissListener = (DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener() {
            final c a;
            
            public void onDismiss(final DialogInterface dialogInterface) {
                if (c.access$000(this.a) != null) {
                    final c a = this.a;
                    a.onDismiss((DialogInterface)c.access$000(a));
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new a0<r>() {
            final c a;
            
            public void a(final r r) {
                if (r != null && c.access$200(this.a)) {
                    final View requireView = this.a.requireView();
                    if (requireView.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (c.access$000(this.a) != null) {
                        if (FragmentManager.N0(3)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("DialogFragment ");
                            sb.append(this);
                            sb.append(" setting the content view on ");
                            sb.append(c.access$000(this.a));
                            Log.d("FragmentManager", sb.toString());
                        }
                        c.access$000(this.a).setContentView(requireView);
                    }
                }
            }
            
            @Override
            public /* bridge */ void onChanged(final Object o) {
                this.a((r)o);
            }
        };
        this.mDialogCreated = false;
    }
    
    static Dialog access$000(final c c) {
        return c.mDialog;
    }
    
    static DialogInterface$OnDismissListener access$100(final c c) {
        return c.mOnDismissListener;
    }
    
    static boolean access$200(final c c) {
        return c.mShowsDialog;
    }
    
    private void dismissInternal(final boolean b, final boolean b2, final boolean b3) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.setOnDismissListener((DialogInterface$OnDismissListener)null);
            this.mDialog.dismiss();
            if (!b2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    this.onDismiss((DialogInterface)this.mDialog);
                }
                else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            if (b3) {
                this.getParentFragmentManager().k1(this.mBackStackId, 1);
            }
            else {
                this.getParentFragmentManager().h1(this.mBackStackId, 1, b);
            }
            this.mBackStackId = -1;
        }
        else {
            final c0 q = this.getParentFragmentManager().q();
            q.w(true);
            q.p(this);
            if (b3) {
                q.k();
            }
            else if (b) {
                q.j();
            }
            else {
                q.i();
            }
        }
    }
    
    private void prepareDialog(final Bundle bundle) {
        if (!this.mShowsDialog) {
            return;
        }
        if (!this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                final Dialog onCreateDialog = this.onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    this.setupDialog(onCreateDialog, this.mStyle);
                    final Context context = this.getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity)context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                }
                else {
                    this.mDialog = null;
                }
            }
            finally {
                this.mCreatingDialog = false;
            }
        }
    }
    
    @Override
    androidx.fragment.app.j createFragmentContainer() {
        return new androidx.fragment.app.j(this, super.createFragmentContainer()) {
            final j a;
            final c b;
            
            @Override
            public View c(final int n) {
                if (this.a.d()) {
                    return this.a.c(n);
                }
                return this.b.onFindViewById(n);
            }
            
            @Override
            public boolean d() {
                return this.a.d() || this.b.onHasView();
            }
        };
    }
    
    public void dismiss() {
        this.dismissInternal(false, false, false);
    }
    
    public void dismissAllowingStateLoss() {
        this.dismissInternal(true, false, false);
    }
    
    public void dismissNow() {
        this.dismissInternal(false, false, true);
    }
    
    public Dialog getDialog() {
        return this.mDialog;
    }
    
    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }
    
    public int getTheme() {
        return this.mTheme;
    }
    
    public boolean isCancelable() {
        return this.mCancelable;
    }
    
    @Deprecated
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
    }
    
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        this.getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = (super.mContainerId == 0);
        if (bundle != null) {
            this.mStyle = bundle.getInt("android:style", 0);
            this.mTheme = bundle.getInt("android:theme", 0);
            this.mCancelable = bundle.getBoolean("android:cancelable", true);
            this.mShowsDialog = bundle.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }
    
    public Dialog onCreateDialog(final Bundle bundle) {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("onCreateDialog called for DialogFragment ");
            sb.append(this);
            Log.d("FragmentManager", sb.toString());
        }
        return new f(this.requireContext(), this.getTheme());
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            this.mViewDestroyed = true;
            mDialog.setOnDismissListener((DialogInterface$OnDismissListener)null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                this.onDismiss((DialogInterface)this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        this.getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (FragmentManager.N0(3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onDismiss called for DialogFragment ");
                sb.append(this);
                Log.d("FragmentManager", sb.toString());
            }
            this.dismissInternal(true, true, false);
        }
    }
    
    View onFindViewById(final int n) {
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            return mDialog.findViewById(n);
        }
        return null;
    }
    
    @Override
    public LayoutInflater onGetLayoutInflater(final Bundle bundle) {
        final LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.mShowsDialog && !this.mCreatingDialog) {
            this.prepareDialog(bundle);
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("get layout inflater for DialogFragment ");
                sb.append(this);
                sb.append(" from dialog context");
                Log.d("FragmentManager", sb.toString());
            }
            final Dialog mDialog = this.mDialog;
            LayoutInflater cloneInContext = onGetLayoutInflater;
            if (mDialog != null) {
                cloneInContext = onGetLayoutInflater.cloneInContext(mDialog.getContext());
            }
            return cloneInContext;
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("getting layout inflater for DialogFragment ");
            sb2.append(this);
            final String string = sb2.toString();
            if (!this.mShowsDialog) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("mShowsDialog = false: ");
                sb3.append(string);
                Log.d("FragmentManager", sb3.toString());
            }
            else {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("mCreatingDialog = true: ");
                sb4.append(string);
                Log.d("FragmentManager", sb4.toString());
            }
        }
        return onGetLayoutInflater;
    }
    
    boolean onHasView() {
        return this.mDialogCreated;
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            final Bundle onSaveInstanceState = mDialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        final int mStyle = this.mStyle;
        if (mStyle != 0) {
            bundle.putInt("android:style", mStyle);
        }
        final int mTheme = this.mTheme;
        if (mTheme != 0) {
            bundle.putInt("android:theme", mTheme);
        }
        final boolean mCancelable = this.mCancelable;
        if (!mCancelable) {
            bundle.putBoolean("android:cancelable", mCancelable);
        }
        final boolean mShowsDialog = this.mShowsDialog;
        if (!mShowsDialog) {
            bundle.putBoolean("android:showsDialog", mShowsDialog);
        }
        final int mBackStackId = this.mBackStackId;
        if (mBackStackId != -1) {
            bundle.putInt("android:backStackId", mBackStackId);
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            this.mViewDestroyed = false;
            mDialog.show();
            final View decorView = this.mDialog.getWindow().getDecorView();
            s0.a(decorView, this);
            t0.a(decorView, this);
            u0.f.a(decorView, this);
        }
    }
    
    @Override
    public void onStop() {
        super.onStop();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.hide();
        }
    }
    
    @Override
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null) {
            bundle = bundle.getBundle("android:savedDialogState");
            if (bundle != null) {
                this.mDialog.onRestoreInstanceState(bundle);
            }
        }
    }
    
    @Override
    void performCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (super.mView == null && this.mDialog != null && bundle != null) {
            final Bundle bundle2 = bundle.getBundle("android:savedDialogState");
            if (bundle2 != null) {
                this.mDialog.onRestoreInstanceState(bundle2);
            }
        }
    }
    
    public final Dialog requireDialog() {
        final Dialog dialog = this.getDialog();
        if (dialog != null) {
            return dialog;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("DialogFragment ");
        sb.append(this);
        sb.append(" does not have a Dialog.");
        throw new IllegalStateException(sb.toString());
    }
    
    public void setCancelable(final boolean b) {
        this.mCancelable = b;
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.setCancelable(b);
        }
    }
    
    public void setShowsDialog(final boolean mShowsDialog) {
        this.mShowsDialog = mShowsDialog;
    }
    
    public void setStyle(final int mStyle, final int mTheme) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Setting style and theme for DialogFragment ");
            sb.append(this);
            sb.append(" to ");
            sb.append(mStyle);
            sb.append(", ");
            sb.append(mTheme);
            Log.d("FragmentManager", sb.toString());
        }
        this.mStyle = mStyle;
        if (mStyle == 2 || mStyle == 3) {
            this.mTheme = 16973913;
        }
        if (mTheme != 0) {
            this.mTheme = mTheme;
        }
    }
    
    public void setupDialog(final Dialog dialog, final int n) {
        if (n != 1 && n != 2) {
            if (n != 3) {
                return;
            }
            final Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }
    
    public int show(final c0 c0, final String s) {
        this.mDismissed = false;
        this.mShownByMe = true;
        c0.e(this, s);
        this.mViewDestroyed = false;
        return this.mBackStackId = c0.i();
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        this.mDismissed = false;
        this.mShownByMe = true;
        final c0 q = fragmentManager.q();
        q.w(true);
        q.e(this, s);
        q.i();
    }
    
    public void showNow(final FragmentManager fragmentManager, final String s) {
        this.mDismissed = false;
        this.mShownByMe = true;
        final c0 q = fragmentManager.q();
        q.w(true);
        q.e(this, s);
        q.k();
    }
}
