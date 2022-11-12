// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.EditText;

public class a extends f
{
    private EditText i;
    private CharSequence j;
    private final Runnable p;
    private long w;
    
    public a() {
        this.p = new Runnable() {
            final a a;
            
            @Override
            public void run() {
                this.a.r4();
            }
        };
        this.w = -1L;
    }
    
    private EditTextPreference o4() {
        return (EditTextPreference)this.g4();
    }
    
    private boolean p4() {
        final long w = this.w;
        return w != -1L && w + 1000L > SystemClock.currentThreadTimeMillis();
    }
    
    public static a q4(final String s) {
        final a a = new a();
        final Bundle arguments = new Bundle(1);
        arguments.putString("key", s);
        a.setArguments(arguments);
        return a;
    }
    
    private void s4(final boolean b) {
        long currentThreadTimeMillis;
        if (b) {
            currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }
        else {
            currentThreadTimeMillis = -1L;
        }
        this.w = currentThreadTimeMillis;
    }
    
    @Override
    protected boolean h4() {
        return true;
    }
    
    @Override
    protected void i4(final View view) {
        super.i4(view);
        final EditText i = (EditText)view.findViewById(16908291);
        this.i = i;
        if (i != null) {
            i.requestFocus();
            this.i.setText(this.j);
            final EditText j = this.i;
            j.setSelection(j.getText().length());
            if (this.o4().b1() != null) {
                this.o4().b1().a(this.i);
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }
    
    @Override
    public void k4(final boolean b) {
        if (b) {
            final String string = this.i.getText().toString();
            final EditTextPreference o4 = this.o4();
            if (o4.c(string)) {
                o4.d1(string);
            }
        }
    }
    
    @Override
    protected void n4() {
        this.s4(true);
        this.r4();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.j = this.o4().c1();
        }
        else {
            this.j = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.j);
    }
    
    void r4() {
        if (this.p4()) {
            final EditText i = this.i;
            if (i != null && i.isFocused()) {
                if (((InputMethodManager)this.i.getContext().getSystemService("input_method")).showSoftInput((View)this.i, 0)) {
                    this.s4(false);
                }
                else {
                    this.i.removeCallbacks(this.p);
                    this.i.postDelayed(this.p, 50L);
                }
            }
            else {
                this.s4(false);
            }
        }
    }
}
