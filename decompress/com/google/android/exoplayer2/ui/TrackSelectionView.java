// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.Assertions;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.ArrayList;
import android.util.AttributeSet;
import android.content.Context;
import java.util.Comparator;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Map;
import com.google.android.exoplayer2.Tracks;
import java.util.List;
import android.widget.CheckedTextView;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class TrackSelectionView extends LinearLayout
{
    private final int a;
    private final LayoutInflater b;
    private final CheckedTextView c;
    private final CheckedTextView d;
    private final b e;
    private final List<Tracks.Group> f;
    private final Map<TrackGroup, TrackSelectionOverride> g;
    private boolean h;
    private boolean i;
    private TrackNameProvider j;
    private CheckedTextView[][] p;
    private boolean w;
    private Comparator<c> x;
    private TrackSelectionListener y;
    
    public TrackSelectionView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public TrackSelectionView(final Context context, final AttributeSet set, int resourceId) {
        super(context, set, resourceId);
        this.setOrientation(1);
        this.setSaveFromParentEnabled(false);
        final TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[] { 16843534 });
        resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.a = resourceId;
        obtainStyledAttributes.recycle();
        final LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        final b onClickListener = new b(null);
        this.e = onClickListener;
        this.j = new DefaultTrackNameProvider(this.getResources());
        this.f = new ArrayList<Tracks.Group>();
        this.g = new HashMap<TrackGroup, TrackSelectionOverride>();
        final CheckedTextView c = (CheckedTextView)from.inflate(17367055, (ViewGroup)this, false);
        (this.c = c).setBackgroundResource(resourceId);
        c.setText(R.string.x);
        c.setEnabled(false);
        c.setFocusable(true);
        c.setOnClickListener((View$OnClickListener)onClickListener);
        c.setVisibility(8);
        this.addView((View)c);
        this.addView(from.inflate(R.layout.a, (ViewGroup)this, false));
        final CheckedTextView d = (CheckedTextView)from.inflate(17367055, (ViewGroup)this, false);
        (this.d = d).setBackgroundResource(resourceId);
        d.setText(R.string.w);
        d.setEnabled(false);
        d.setFocusable(true);
        d.setOnClickListener((View$OnClickListener)onClickListener);
        this.addView((View)d);
    }
    
    static void a(final TrackSelectionView trackSelectionView, final View view) {
        trackSelectionView.c(view);
    }
    
    public static Map<TrackGroup, TrackSelectionOverride> b(final Map<TrackGroup, TrackSelectionOverride> map, final List<Tracks.Group> list, final boolean b) {
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); ++i) {
            final TrackSelectionOverride trackSelectionOverride = map.get(((Tracks.Group)list.get(i)).b());
            if (trackSelectionOverride != null && (b || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.a, trackSelectionOverride);
            }
        }
        return hashMap;
    }
    
    private void c(final View view) {
        if (view == this.c) {
            this.e();
        }
        else if (view == this.d) {
            this.d();
        }
        else {
            this.f(view);
        }
        this.i();
        final TrackSelectionListener y = this.y;
        if (y != null) {
            y.a(this.getIsDisabled(), this.getOverrides());
        }
    }
    
    private void d() {
        this.w = false;
        this.g.clear();
    }
    
    private void e() {
        this.w = true;
        this.g.clear();
    }
    
    private void f(final View view) {
        boolean b = false;
        this.w = false;
        final c c = Assertions.e(view.getTag());
        final TrackGroup b2 = c.a.b();
        final int b3 = c.b;
        final TrackSelectionOverride trackSelectionOverride = this.g.get(b2);
        if (trackSelectionOverride == null) {
            if (!this.i && this.g.size() > 0) {
                this.g.clear();
            }
            this.g.put(b2, new TrackSelectionOverride(b2, (List<Integer>)ImmutableList.of((Object)b3)));
        }
        else {
            final ArrayList list = new ArrayList((Collection<?>)trackSelectionOverride.b);
            final boolean checked = ((CheckedTextView)view).isChecked();
            final boolean g = this.g(c.a);
            if (g || this.h()) {
                b = true;
            }
            if (checked && b) {
                list.remove((Object)b3);
                if (list.isEmpty()) {
                    this.g.remove(b2);
                }
                else {
                    this.g.put(b2, new TrackSelectionOverride(b2, (List<Integer>)list));
                }
            }
            else if (!checked) {
                if (g) {
                    list.add((Object)b3);
                    this.g.put(b2, new TrackSelectionOverride(b2, (List<Integer>)list));
                }
                else {
                    this.g.put(b2, new TrackSelectionOverride(b2, (List<Integer>)ImmutableList.of((Object)b3)));
                }
            }
        }
    }
    
    private boolean g(final Tracks.Group group) {
        return this.h && group.f();
    }
    
    private boolean h() {
        final boolean i = this.i;
        boolean b = true;
        if (!i || this.f.size() <= 1) {
            b = false;
        }
        return b;
    }
    
    private void i() {
        this.c.setChecked(this.w);
        this.d.setChecked(!this.w && this.g.size() == 0);
        for (int i = 0; i < this.p.length; ++i) {
            final TrackSelectionOverride trackSelectionOverride = this.g.get(this.f.get(i).b());
            int n = 0;
            while (true) {
                final CheckedTextView[][] p = this.p;
                if (n >= p[i].length) {
                    break;
                }
                if (trackSelectionOverride != null) {
                    this.p[i][n].setChecked(trackSelectionOverride.b.contains((Object)Assertions.e(p[i][n].getTag()).b));
                }
                else {
                    p[i][n].setChecked(false);
                }
                ++n;
            }
        }
    }
    
    private void j() {
        for (int i = this.getChildCount() - 1; i >= 3; --i) {
            this.removeViewAt(i);
        }
        if (this.f.isEmpty()) {
            this.c.setEnabled(false);
            this.d.setEnabled(false);
            return;
        }
        this.c.setEnabled(true);
        this.d.setEnabled(true);
        this.p = new CheckedTextView[this.f.size()][];
        final boolean h = this.h();
        for (int j = 0; j < this.f.size(); ++j) {
            final Tracks.Group group = this.f.get(j);
            final boolean g = this.g(group);
            final CheckedTextView[][] p = this.p;
            final int a = group.a;
            p[j] = new CheckedTextView[a];
            final c[] array = new c[a];
            for (int k = 0; k < group.a; ++k) {
                array[k] = new c(group, k);
            }
            final Comparator<c> x = this.x;
            if (x != null) {
                Arrays.sort(array, x);
            }
            for (int l = 0; l < a; ++l) {
                if (l == 0) {
                    this.addView(this.b.inflate(R.layout.a, (ViewGroup)this, false));
                }
                int n;
                if (!g && !h) {
                    n = 17367055;
                }
                else {
                    n = 17367056;
                }
                final CheckedTextView checkedTextView = (CheckedTextView)this.b.inflate(n, (ViewGroup)this, false);
                checkedTextView.setBackgroundResource(this.a);
                checkedTextView.setText((CharSequence)this.j.a(array[l].a()));
                checkedTextView.setTag((Object)array[l]);
                if (group.i(l)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener((View$OnClickListener)this.e);
                }
                else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.addView((View)(this.p[j][l] = checkedTextView));
            }
        }
        this.i();
    }
    
    public boolean getIsDisabled() {
        return this.w;
    }
    
    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.g;
    }
    
    public void setAllowAdaptiveSelections(final boolean h) {
        if (this.h != h) {
            this.h = h;
            this.j();
        }
    }
    
    public void setAllowMultipleOverrides(final boolean i) {
        if (this.i != i) {
            this.i = i;
            if (!i && this.g.size() > 1) {
                final Map<TrackGroup, TrackSelectionOverride> b = b(this.g, this.f, false);
                this.g.clear();
                this.g.putAll(b);
            }
            this.j();
        }
    }
    
    public void setShowDisableOption(final boolean b) {
        final CheckedTextView c = this.c;
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        c.setVisibility(visibility);
    }
    
    public void setTrackNameProvider(final TrackNameProvider trackNameProvider) {
        this.j = Assertions.e(trackNameProvider);
        this.j();
    }
    
    public interface TrackSelectionListener
    {
        void a(final boolean p0, final Map<TrackGroup, TrackSelectionOverride> p1);
    }
    
    private class b implements View$OnClickListener
    {
        final TrackSelectionView a;
        
        private b(final TrackSelectionView a) {
            this.a = a;
        }
        
        b(final TrackSelectionView trackSelectionView, final TrackSelectionView$a object) {
            this(trackSelectionView);
        }
        
        public void onClick(final View view) {
            TrackSelectionView.a(this.a, view);
        }
    }
    
    private static final class c
    {
        public final Tracks.Group a;
        public final int b;
        
        public c(final Tracks.Group a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        public Format a() {
            return this.a.c(this.b);
        }
    }
}
