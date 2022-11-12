// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import android.view.ActionMode$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.SearchEvent;
import android.view.KeyboardShortcutGroup;
import java.util.List;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window$Callback;

public class i implements Window$Callback
{
    final Window$Callback a;
    
    public i(final Window$Callback a) {
        if (a != null) {
            this.a = a;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }
    
    public final Window$Callback a() {
        return this.a;
    }
    
    public boolean dispatchGenericMotionEvent(final MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this.a.dispatchKeyEvent(keyEvent);
    }
    
    public boolean dispatchKeyShortcutEvent(final KeyEvent keyEvent) {
        return this.a.dispatchKeyShortcutEvent(keyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }
    
    public boolean dispatchTrackballEvent(final MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }
    
    public void onActionModeFinished(final ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }
    
    public void onActionModeStarted(final ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }
    
    public void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        return this.a.onCreatePanelMenu(n, menu);
    }
    
    public View onCreatePanelView(final int n) {
        return this.a.onCreatePanelView(n);
    }
    
    public void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return this.a.onMenuItemSelected(n, menuItem);
    }
    
    public boolean onMenuOpened(final int n, final Menu menu) {
        return this.a.onMenuOpened(n, menu);
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        this.a.onPanelClosed(n, menu);
    }
    
    public void onPointerCaptureChanged(final boolean b) {
        c.a(this.a, b);
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        return this.a.onPreparePanel(n, view, menu);
    }
    
    public void onProvideKeyboardShortcuts(final List<KeyboardShortcutGroup> list, final Menu menu, final int n) {
        b.a(this.a, list, menu, n);
    }
    
    public boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }
    
    public boolean onSearchRequested(final SearchEvent searchEvent) {
        return i.a.a(this.a, searchEvent);
    }
    
    public void onWindowAttributesChanged(final WindowManager$LayoutParams windowManager$LayoutParams) {
        this.a.onWindowAttributesChanged(windowManager$LayoutParams);
    }
    
    public void onWindowFocusChanged(final boolean b) {
        this.a.onWindowFocusChanged(b);
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback, final int n) {
        return i.a.b(this.a, actionMode$Callback, n);
    }
    
    static class a
    {
        static boolean a(final Window$Callback window$Callback, final SearchEvent searchEvent) {
            return window$Callback.onSearchRequested(searchEvent);
        }
        
        static ActionMode b(final Window$Callback window$Callback, final ActionMode$Callback actionMode$Callback, final int n) {
            return window$Callback.onWindowStartingActionMode(actionMode$Callback, n);
        }
    }
    
    static class b
    {
        static void a(final Window$Callback window$Callback, final List<KeyboardShortcutGroup> list, final Menu menu, final int n) {
            window$Callback.onProvideKeyboardShortcuts((List)list, menu, n);
        }
    }
    
    static class c
    {
        static void a(final Window$Callback window$Callback, final boolean b) {
            window$Callback.onPointerCaptureChanged(b);
        }
    }
}
