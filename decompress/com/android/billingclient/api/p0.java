// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

final class p0
{
    static final g a;
    static final g b;
    static final g c;
    static final g d;
    static final g e;
    static final g f;
    static final g g;
    static final g h;
    static final g i;
    static final g j;
    static final g k;
    static final g l;
    static final g m;
    static final g n;
    static final g o;
    static final g p;
    static final g q;
    static final g r;
    static final g s;
    static final g t;
    static final g u;
    static final g v;
    static final g w;
    static final g x;
    static final g y;
    
    static {
        final g.a c2 = com.android.billingclient.api.g.c();
        c2.c(3);
        c2.b("Google Play In-app Billing API version is less than 3");
        a = c2.a();
        final g.a c3 = com.android.billingclient.api.g.c();
        c3.c(3);
        c3.b("Google Play In-app Billing API version is less than 9");
        b = c3.a();
        final g.a c4 = com.android.billingclient.api.g.c();
        c4.c(3);
        c4.b("Billing service unavailable on device.");
        c = c4.a();
        final g.a c5 = com.android.billingclient.api.g.c();
        c5.c(5);
        c5.b("Client is already in the process of connecting to billing service.");
        d = c5.a();
        final g.a c6 = com.android.billingclient.api.g.c();
        c6.c(5);
        c6.b("The list of SKUs can't be empty.");
        e = c6.a();
        final g.a c7 = com.android.billingclient.api.g.c();
        c7.c(5);
        c7.b("SKU type can't be empty.");
        f = c7.a();
        final g.a c8 = com.android.billingclient.api.g.c();
        c8.c(5);
        c8.b("Product type can't be empty.");
        g = c8.a();
        final g.a c9 = com.android.billingclient.api.g.c();
        c9.c(-2);
        c9.b("Client does not support extra params.");
        h = c9.a();
        final g.a c10 = com.android.billingclient.api.g.c();
        c10.c(5);
        c10.b("Invalid purchase token.");
        i = c10.a();
        final g.a c11 = com.android.billingclient.api.g.c();
        c11.c(6);
        c11.b("An internal error occurred.");
        j = c11.a();
        final g.a c12 = com.android.billingclient.api.g.c();
        c12.c(5);
        c12.b("SKU can't be null.");
        k = c12.a();
        final g.a c13 = com.android.billingclient.api.g.c();
        c13.c(0);
        l = c13.a();
        final g.a c14 = com.android.billingclient.api.g.c();
        c14.c(-1);
        c14.b("Service connection is disconnected.");
        m = c14.a();
        final g.a c15 = com.android.billingclient.api.g.c();
        c15.c(-3);
        c15.b("Timeout communicating with service.");
        n = c15.a();
        final g.a c16 = com.android.billingclient.api.g.c();
        c16.c(-2);
        c16.b("Client does not support subscriptions.");
        o = c16.a();
        final g.a c17 = com.android.billingclient.api.g.c();
        c17.c(-2);
        c17.b("Client does not support subscriptions update.");
        p = c17.a();
        final g.a c18 = com.android.billingclient.api.g.c();
        c18.c(-2);
        c18.b("Client does not support get purchase history.");
        q = c18.a();
        final g.a c19 = com.android.billingclient.api.g.c();
        c19.c(-2);
        c19.b("Client does not support price change confirmation.");
        r = c19.a();
        final g.a c20 = com.android.billingclient.api.g.c();
        c20.c(-2);
        c20.b("Play Store version installed does not support cross selling products.");
        s = c20.a();
        final g.a c21 = com.android.billingclient.api.g.c();
        c21.c(-2);
        c21.b("Client does not support multi-item purchases.");
        t = c21.a();
        final g.a c22 = com.android.billingclient.api.g.c();
        c22.c(-2);
        c22.b("Client does not support offer_id_token.");
        u = c22.a();
        final g.a c23 = com.android.billingclient.api.g.c();
        c23.c(-2);
        c23.b("Client does not support ProductDetails.");
        v = c23.a();
        final g.a c24 = com.android.billingclient.api.g.c();
        c24.c(-2);
        c24.b("Client does not support in-app messages.");
        w = c24.a();
        final g.a c25 = com.android.billingclient.api.g.c();
        c25.c(-2);
        c25.b("Client does not support alternative billing.");
        x = c25.a();
        final g.a c26 = com.android.billingclient.api.g.c();
        c26.c(5);
        c26.b("Unknown feature");
        y = c26.a();
    }
}
