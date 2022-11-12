// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.Iterator;
import com.google.android.gms.internal.ads.zzfpe;
import com.google.android.gms.internal.ads.zzfof;
import com.google.android.gms.internal.ads.zzfbg;
import java.lang.reflect.InvocationTargetException;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzt;
import android.widget.TextView;
import android.graphics.Rect;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.internal.client.zzaw;
import org.json.JSONObject;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.view.WindowManager$LayoutParams;
import android.graphics.Point;
import android.view.View;
import android.view.MotionEvent;

public final class zzbx
{
    public static Point a(final MotionEvent motionEvent, final View view) {
        final int[] j = j(view);
        return new Point((int)motionEvent.getRawX() - j[0], (int)motionEvent.getRawY() - j[1]);
    }
    
    public static WindowManager$LayoutParams b() {
        final WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(-2, -2, 0, 0, -2);
        windowManager$LayoutParams.flags = (int)zzay.c().zzb(zzbhy.zzgF);
        windowManager$LayoutParams.type = 2;
        windowManager$LayoutParams.gravity = 8388659;
        return windowManager$LayoutParams;
    }
    
    public static JSONObject c(final String s, final Context context, final Point point, final Point point2) {
        JSONObject jsonObject = null;
        final Object o = null;
        JSONObject jsonObject3;
        try {
            final JSONObject jsonObject2 = new JSONObject();
            try {
                jsonObject = new JSONObject();
                Object o2;
                try {
                    jsonObject.put("x", zzaw.b().zzb(context, point2.x));
                    jsonObject.put("y", zzaw.b().zzb(context, point2.y));
                    jsonObject.put("start_x", zzaw.b().zzb(context, point.x));
                    jsonObject.put("start_y", zzaw.b().zzb(context, point.y));
                    o2 = jsonObject;
                }
                catch (final JSONException ex) {
                    zzcfi.zzh("Error occurred while putting signals into JSON object.", (Throwable)ex);
                    o2 = o;
                }
                jsonObject2.put("click_point", o2);
                jsonObject2.put("asset_id", (Object)s);
            }
            catch (final Exception ex2) {
                jsonObject3 = jsonObject2;
            }
        }
        catch (final Exception ex2) {
            jsonObject3 = jsonObject;
        }
        final Exception ex2;
        zzcfi.zzh("Error occurred while grabbing click signals.", (Throwable)ex2);
        return jsonObject3;
    }
    
    public static JSONObject d(final Context context, Map iterator, final Map map, View view) {
        final Object o = new JSONObject();
        if (iterator == null || view == null) {
            return (JSONObject)o;
        }
        final int[] j = j(view);
        iterator = ((Map)iterator).entrySet().iterator();
        view = (View)o;
        Map.Entry entry = null;
        View view2 = null;
        int[] i;
        JSONObject jsonObject;
        JSONObject jsonObject2;
        int measuredWidth;
        Rect rect;
        JSONObject k;
        TextView textView;
        String s = null;
        View view3;
        String s2;
        JSONObject jsonObject3;
        Label_0525_Outer:Label_0520_Outer:
        while (true) {
            Block_4: {
                while (iterator.hasNext()) {
                    entry = (Map.Entry)iterator.next();
                    view2 = ((WeakReference<View>)entry.getValue()).get();
                    if (view2 != null) {
                        break Block_4;
                    }
                }
                return (JSONObject)view;
            }
            i = j(view2);
            jsonObject = new JSONObject();
            jsonObject2 = new JSONObject();
            try {
                measuredWidth = view2.getMeasuredWidth();
                try {
                    jsonObject2.put("width", zzaw.b().zzb(context, measuredWidth));
                    jsonObject2.put("height", zzaw.b().zzb(context, view2.getMeasuredHeight()));
                    jsonObject2.put("x", zzaw.b().zzb(context, i[0] - j[0]));
                    jsonObject2.put("y", zzaw.b().zzb(context, i[1] - j[1]));
                    jsonObject2.put("relative_to", (Object)"ad_view");
                    jsonObject.put("frame", (Object)jsonObject2);
                    rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        k = k(context, rect);
                    }
                    else {
                        k = new JSONObject();
                        k.put("width", 0);
                        k.put("height", 0);
                        k.put("x", zzaw.b().zzb(context, i[0] - j[0]));
                        k.put("y", zzaw.b().zzb(context, i[1] - j[1]));
                        k.put("relative_to", (Object)"ad_view");
                    }
                    jsonObject.put("visible_bounds", (Object)k);
                    if (view2 instanceof TextView) {
                        textView = (TextView)view2;
                        jsonObject.put("text_color", textView.getCurrentTextColor());
                        jsonObject.put("font_size", (double)textView.getTextSize());
                        jsonObject.put("text", (Object)textView.getText());
                    }
                    jsonObject.put("is_clickable", map != null && map.containsKey(entry.getKey()) && view2.isClickable());
                    s = (String)entry.getKey();
                    view3 = view;
                    s2 = s;
                    jsonObject3 = jsonObject;
                    ((JSONObject)view3).put(s2, (Object)jsonObject3);
                }
                catch (final JSONException ex) {}
            }
            catch (final JSONException ex2) {}
            while (true) {
                try {
                    view3 = view;
                    s2 = s;
                    jsonObject3 = jsonObject;
                    ((JSONObject)view3).put(s2, (Object)jsonObject3);
                    while (true) {
                        continue Label_0525_Outer;
                        zzcfi.zzj("Unable to get asset views information");
                        continue Label_0520_Outer;
                    }
                }
                catch (final JSONException ex3) {
                    continue;
                }
                break;
            }
            break;
        }
    }
    
    public static JSONObject e(final Context context, final View view) {
        final JSONObject jsonObject = new JSONObject();
        if (view == null) {
            return jsonObject;
        }
        try {
            zzt.q();
            jsonObject.put("can_show_on_lock_screen", zzs.H(view));
            zzt.q();
            jsonObject.put("is_keyguard_locked", zzs.V(context));
        }
        catch (final JSONException ex) {
            zzcfi.zzj("Unable to get lock screen information");
        }
        return jsonObject;
    }
    
    public static JSONObject f(final View view) {
        final JSONObject jsonObject = new JSONObject();
        if (view == null) {
            return jsonObject;
        }
        try {
            final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzgC);
            boolean b = false;
            final boolean b2 = false;
            if (booleanValue) {
                zzt.q();
                ViewParent viewParent;
                for (viewParent = view.getParent(); viewParent != null && !(viewParent instanceof ScrollView); viewParent = viewParent.getParent()) {}
                jsonObject.put("contained_in_scroll_view", viewParent != null || b2);
            }
            else {
                zzt.q();
                ViewParent viewParent2;
                for (viewParent2 = view.getParent(); viewParent2 != null && !(viewParent2 instanceof AdapterView); viewParent2 = viewParent2.getParent()) {}
                int positionForView;
                if (viewParent2 == null) {
                    positionForView = -1;
                }
                else {
                    positionForView = ((AdapterView)viewParent2).getPositionForView(view);
                }
                if (positionForView != -1) {
                    b = true;
                }
                jsonObject.put("contained_in_scroll_view", b);
            }
            return jsonObject;
        }
        catch (final Exception ex) {
            return jsonObject;
        }
    }
    
    public static JSONObject g(Context parent, final View view) {
        final JSONObject jsonObject = new JSONObject();
        if (view == null) {
            return jsonObject;
        }
        try {
            final int[] j = j(view);
            final int[] array = { view.getMeasuredWidth(), view.getMeasuredHeight() };
            for (ViewParent viewParent = view.getParent(); viewParent instanceof ViewGroup; viewParent = viewParent.getParent()) {
                final ViewGroup viewGroup = (ViewGroup)viewParent;
                array[0] = Math.min(viewGroup.getMeasuredWidth(), array[0]);
                array[1] = Math.min(viewGroup.getMeasuredHeight(), array[1]);
            }
            final JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("width", zzaw.b().zzb((Context)parent, view.getMeasuredWidth()));
            jsonObject2.put("height", zzaw.b().zzb((Context)parent, view.getMeasuredHeight()));
            jsonObject2.put("x", zzaw.b().zzb((Context)parent, j[0]));
            jsonObject2.put("y", zzaw.b().zzb((Context)parent, j[1]));
            jsonObject2.put("maximum_visible_width", zzaw.b().zzb((Context)parent, array[0]));
            jsonObject2.put("maximum_visible_height", zzaw.b().zzb((Context)parent, array[1]));
            jsonObject2.put("relative_to", (Object)"window");
            jsonObject.put("frame", (Object)jsonObject2);
            final Rect rect = new Rect();
            JSONObject k;
            if (view.getGlobalVisibleRect(rect)) {
                k = k((Context)parent, rect);
            }
            else {
                final JSONObject jsonObject3 = new JSONObject();
                jsonObject3.put("width", 0);
                jsonObject3.put("height", 0);
                jsonObject3.put("x", zzaw.b().zzb((Context)parent, j[0]));
                jsonObject3.put("y", zzaw.b().zzb((Context)parent, j[1]));
                jsonObject3.put("relative_to", (Object)"window");
                k = jsonObject3;
            }
            jsonObject.put("visible_bounds", (Object)k);
        }
        catch (final Exception ex) {
            zzcfi.zzj("Unable to get native ad view bounding box");
        }
        if (!(boolean)zzay.c().zzb(zzbhy.zzfh)) {
            goto Label_0560;
        }
        parent = (InvocationTargetException)view.getParent();
        if (parent == null) {
            goto Label_0446;
        }
        try {
            parent = (InvocationTargetException)parent.getClass().getMethod("getTemplateTypeName", (Class<?>[])new Class[0]).invoke(parent, new Object[0]);
        }
        catch (final InvocationTargetException parent) {
            goto Label_0439;
        }
        catch (final IllegalAccessException parent) {
            goto Label_0439;
        }
        catch (final SecurityException ex2) {}
        catch (final NoSuchMethodException ex3) {
            goto Label_0446;
        }
        try {
            final int hashCode = ((String)parent).hashCode();
            int n = 0;
            Label_0504: {
                if (hashCode != -2066603854) {
                    if (hashCode == 2019754500) {
                        if (((String)parent).equals("medium_template")) {
                            n = 1;
                            break Label_0504;
                        }
                    }
                }
                else if (((String)parent).equals("small_template")) {
                    n = 0;
                    break Label_0504;
                }
                n = -1;
            }
            if (n == 0) {
                jsonObject.put("native_template_type", 1);
                goto Label_0560;
            }
            if (n != 1) {
                jsonObject.put("native_template_type", 0);
                goto Label_0560;
            }
            jsonObject.put("native_template_type", 2);
            goto Label_0560;
        }
        catch (final JSONException ex4) {}
    }
    
    public static boolean h(final Context context, final zzfbg zzfbg) {
        if (!zzfbg.zzO) {
            return false;
        }
        if (zzay.c().zzb(zzbhy.zzgD)) {
            return (boolean)zzay.c().zzb(zzbhy.zzgG);
        }
        final String s = (String)zzay.c().zzb(zzbhy.zzgE);
        if (!s.isEmpty()) {
            if (context != null) {
                final String packageName = context.getPackageName();
                final Iterator iterator = zzfpe.zzc(zzfof.zzc(';')).zzd((CharSequence)s).iterator();
                while (iterator.hasNext()) {
                    if (((String)iterator.next()).equals(packageName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean i(final int n) {
        return !(boolean)zzay.c().zzb(zzbhy.zzcC) || (boolean)zzay.c().zzb(zzbhy.zzcD) || n <= 15299999;
    }
    
    public static int[] j(final View view) {
        final int[] array = new int[2];
        if (view != null) {
            view.getLocationOnScreen(array);
        }
        return array;
    }
    
    private static JSONObject k(final Context context, final Rect rect) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("width", zzaw.b().zzb(context, rect.right - rect.left));
        jsonObject.put("height", zzaw.b().zzb(context, rect.bottom - rect.top));
        jsonObject.put("x", zzaw.b().zzb(context, rect.left));
        jsonObject.put("y", zzaw.b().zzb(context, rect.top));
        jsonObject.put("relative_to", (Object)"self");
        return jsonObject;
    }
}
