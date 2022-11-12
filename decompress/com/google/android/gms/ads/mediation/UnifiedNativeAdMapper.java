// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import java.util.Map;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class UnifiedNativeAdMapper
{
    private String a;
    private List b;
    private String c;
    private NativeAd.Image d;
    private String e;
    private String f;
    private Double g;
    private String h;
    private String i;
    private VideoController j;
    private boolean k;
    private View l;
    private View m;
    private Object n;
    private Bundle o;
    private boolean p;
    private boolean q;
    private float r;
    
    public UnifiedNativeAdMapper() {
        this.o = new Bundle();
    }
    
    public final void A(final NativeAd.Image d) {
        this.d = d;
    }
    
    public final void B(final List<NativeAd.Image> b) {
        this.b = b;
    }
    
    public void C(final View m) {
        this.m = m;
    }
    
    public final void D(final boolean q) {
        this.q = q;
    }
    
    public final void E(final boolean p) {
        this.p = p;
    }
    
    public final void F(final String i) {
        this.i = i;
    }
    
    public final void G(final Double g) {
        this.g = g;
    }
    
    public final void H(final String h) {
        this.h = h;
    }
    
    public void I(final View view, final Map<String, View> map, final Map<String, View> map2) {
    }
    
    public void J(final View view) {
    }
    
    public final View K() {
        return this.m;
    }
    
    public final VideoController L() {
        return this.j;
    }
    
    public final Object M() {
        return this.n;
    }
    
    public final void N(final Object n) {
        this.n = n;
    }
    
    public final void O(final VideoController j) {
        this.j = j;
    }
    
    public View a() {
        return this.l;
    }
    
    public final String b() {
        return this.f;
    }
    
    public final String c() {
        return this.c;
    }
    
    public final String d() {
        return this.e;
    }
    
    public float e() {
        return 0.0f;
    }
    
    public float f() {
        return 0.0f;
    }
    
    public final Bundle g() {
        return this.o;
    }
    
    public final String h() {
        return this.a;
    }
    
    public final NativeAd.Image i() {
        return this.d;
    }
    
    public final List<NativeAd.Image> j() {
        return this.b;
    }
    
    public float k() {
        return this.r;
    }
    
    public final boolean l() {
        return this.q;
    }
    
    public final boolean m() {
        return this.p;
    }
    
    public final String n() {
        return this.i;
    }
    
    public final Double o() {
        return this.g;
    }
    
    public final String p() {
        return this.h;
    }
    
    public void q(final View view) {
    }
    
    public boolean r() {
        return this.k;
    }
    
    public void s() {
    }
    
    public void t(final View l) {
        this.l = l;
    }
    
    public final void u(final String f) {
        this.f = f;
    }
    
    public final void v(final String c) {
        this.c = c;
    }
    
    public final void w(final String e) {
        this.e = e;
    }
    
    public final void x(final Bundle o) {
        this.o = o;
    }
    
    public void y(final boolean k) {
        this.k = k;
    }
    
    public final void z(final String a) {
        this.a = a;
    }
}
