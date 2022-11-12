// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView$OnEditorActionListener;
import android.widget.EditText;

public class ImeHelper
{
    public static void setImeOnDoneListener(final EditText editText, final DonePressedListener donePressedListener) {
        editText.setOnEditorActionListener((TextView$OnEditorActionListener)new TextView$OnEditorActionListener(donePressedListener) {
            final DonePressedListener val$listener;
            
            public boolean onEditorAction(final TextView textView, final int n, final KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (keyEvent.getAction() == 1) {
                        this.val$listener.onDonePressed();
                    }
                    return true;
                }
                if (n == 6) {
                    this.val$listener.onDonePressed();
                    return true;
                }
                return false;
            }
        });
    }
    
    public interface DonePressedListener
    {
        void onDonePressed();
    }
}
