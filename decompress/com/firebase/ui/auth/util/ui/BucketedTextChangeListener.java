// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import android.text.Editable;
import android.text.TextUtils;
import java.util.Collections;
import android.widget.EditText;
import android.text.TextWatcher;

public final class BucketedTextChangeListener implements TextWatcher
{
    private final ContentChangeCallback mCallback;
    private final EditText mEditText;
    private final int mExpectedContentLength;
    private final String mPlaceHolder;
    private final String[] mPostFixes;
    
    public BucketedTextChangeListener(final EditText mEditText, final int mExpectedContentLength, final String mPlaceHolder, final ContentChangeCallback mCallback) {
        this.mEditText = mEditText;
        this.mExpectedContentLength = mExpectedContentLength;
        this.mPostFixes = generatePostfixArray(mPlaceHolder, mExpectedContentLength);
        this.mCallback = mCallback;
        this.mPlaceHolder = mPlaceHolder;
    }
    
    private static String[] generatePostfixArray(final CharSequence charSequence, final int n) {
        final String[] array = new String[n + 1];
        for (int i = 0; i <= n; ++i) {
            array[i] = TextUtils.join((CharSequence)"", (Iterable)Collections.nCopies(i, charSequence));
        }
        return array;
    }
    
    public void afterTextChanged(final Editable editable) {
    }
    
    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
    
    public void onTextChanged(final CharSequence charSequence, int min, final int n, final int n2) {
        final String replaceAll = charSequence.toString().replaceAll(" ", "").replaceAll(this.mPlaceHolder, "");
        min = Math.min(replaceAll.length(), this.mExpectedContentLength);
        final String substring = replaceAll.substring(0, min);
        this.mEditText.removeTextChangedListener((TextWatcher)this);
        final EditText mEditText = this.mEditText;
        final StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(this.mPostFixes[this.mExpectedContentLength - min]);
        mEditText.setText((CharSequence)sb.toString());
        this.mEditText.setSelection(min);
        this.mEditText.addTextChangedListener((TextWatcher)this);
        if (min == this.mExpectedContentLength) {
            final ContentChangeCallback mCallback = this.mCallback;
            if (mCallback != null) {
                mCallback.whenComplete();
                return;
            }
        }
        final ContentChangeCallback mCallback2 = this.mCallback;
        if (mCallback2 != null) {
            mCallback2.whileIncomplete();
        }
    }
    
    public interface ContentChangeCallback
    {
        void whenComplete();
        
        void whileIncomplete();
    }
}
