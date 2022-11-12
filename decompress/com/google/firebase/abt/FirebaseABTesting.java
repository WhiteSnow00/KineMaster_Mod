// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.abt;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.util.HashSet;
import android.os.Bundle;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayDeque;
import java.util.List;
import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;

public class FirebaseABTesting
{
    private final Provider<AnalyticsConnector> a;
    private final String b;
    private Integer c;
    
    public FirebaseABTesting(final Context context, final Provider<AnalyticsConnector> a, final String b) {
        this.a = a;
        this.b = b;
        this.c = null;
    }
    
    private void a(final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        ((AnalyticsConnector)this.a.get()).a(conditionalUserProperty);
    }
    
    private void b(final List<AbtExperimentInfo> list) {
        final ArrayDeque arrayDeque = new ArrayDeque((Collection<? extends E>)this.d());
        final int g = this.g();
        for (final AbtExperimentInfo abtExperimentInfo : list) {
            while (arrayDeque.size() >= g) {
                this.i(((AnalyticsConnector.ConditionalUserProperty)arrayDeque.pollFirst()).b);
            }
            final AnalyticsConnector.ConditionalUserProperty d = abtExperimentInfo.d(this.b);
            this.a(d);
            arrayDeque.offer(d);
        }
    }
    
    private static List<AbtExperimentInfo> c(final List<Map<String, String>> list) throws AbtException {
        final ArrayList list2 = new ArrayList();
        final Iterator<Map<String, String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(AbtExperimentInfo.a(iterator.next()));
        }
        return list2;
    }
    
    private List<AnalyticsConnector.ConditionalUserProperty> d() {
        return ((AnalyticsConnector)this.a.get()).f(this.b, "");
    }
    
    private ArrayList<AbtExperimentInfo> e(final List<AbtExperimentInfo> list, final Set<String> set) {
        final ArrayList list2 = new ArrayList();
        for (final AbtExperimentInfo abtExperimentInfo : list) {
            if (!set.contains(abtExperimentInfo.b())) {
                list2.add(abtExperimentInfo);
            }
        }
        return list2;
    }
    
    private ArrayList<AnalyticsConnector.ConditionalUserProperty> f(final List<AnalyticsConnector.ConditionalUserProperty> list, final Set<String> set) {
        final ArrayList list2 = new ArrayList();
        for (final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : list) {
            if (!set.contains(conditionalUserProperty.b)) {
                list2.add(conditionalUserProperty);
            }
        }
        return list2;
    }
    
    private int g() {
        if (this.c == null) {
            this.c = ((AnalyticsConnector)this.a.get()).e(this.b);
        }
        return this.c;
    }
    
    private void i(final String s) {
        ((AnalyticsConnector)this.a.get()).clearConditionalUserProperty(s, null, null);
    }
    
    private void j(final Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        final Iterator<AnalyticsConnector.ConditionalUserProperty> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.i(iterator.next().b);
        }
    }
    
    private void l(final List<AbtExperimentInfo> list) throws AbtException {
        if (list.isEmpty()) {
            this.h();
            return;
        }
        final HashSet set = new HashSet();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            set.add(((AbtExperimentInfo)iterator.next()).b());
        }
        final List<AnalyticsConnector.ConditionalUserProperty> d = this.d();
        final HashSet set2 = new HashSet();
        final Iterator<AnalyticsConnector.ConditionalUserProperty> iterator2 = d.iterator();
        while (iterator2.hasNext()) {
            set2.add(iterator2.next().b);
        }
        this.j(this.f(d, set));
        this.b(this.e(list, set2));
    }
    
    private void n() throws AbtException {
        if (this.a.get() != null) {
            return;
        }
        throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
    }
    
    public void h() throws AbtException {
        this.n();
        this.j(this.d());
    }
    
    public void k(final List<Map<String, String>> list) throws AbtException {
        this.n();
        if (list != null) {
            this.l(c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }
    
    public void m(final AbtExperimentInfo abtExperimentInfo) throws AbtException {
        this.n();
        AbtExperimentInfo.f(abtExperimentInfo);
        final ArrayList list = new ArrayList();
        final Map<String, String> e = abtExperimentInfo.e();
        e.remove("triggerEvent");
        list.add(AbtExperimentInfo.a(e));
        this.b(list);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface OriginService {
    }
}
