// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.FileNotFoundException;
import android.provider.ContactsContract$Contacts;
import android.net.Uri;
import android.content.ContentResolver;
import android.content.UriMatcher;
import java.io.InputStream;

public class n extends l<InputStream>
{
    private static final UriMatcher d;
    
    static {
        final UriMatcher d2 = new UriMatcher(-1);
        (d = d2).addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        d2.addURI("com.android.contacts", "contacts/lookup/*", 1);
        d2.addURI("com.android.contacts", "contacts/#/photo", 2);
        d2.addURI("com.android.contacts", "contacts/#", 3);
        d2.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        d2.addURI("com.android.contacts", "phone_lookup/*", 5);
    }
    
    public n(final ContentResolver contentResolver, final Uri uri) {
        super(contentResolver, uri);
    }
    
    private InputStream i(Uri lookupContact, final ContentResolver contentResolver) throws FileNotFoundException {
        final int match = n.d.match(lookupContact);
        if (match != 1) {
            if (match == 3) {
                return this.j(contentResolver, lookupContact);
            }
            if (match != 5) {
                return contentResolver.openInputStream(lookupContact);
            }
        }
        lookupContact = ContactsContract$Contacts.lookupContact(contentResolver, lookupContact);
        if (lookupContact != null) {
            return this.j(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }
    
    private InputStream j(final ContentResolver contentResolver, final Uri uri) {
        return ContactsContract$Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
    
    @Override
    public Class<InputStream> a() {
        return InputStream.class;
    }
    
    @Override
    protected /* bridge */ void c(final Object o) throws IOException {
        this.g((InputStream)o);
    }
    
    @Override
    protected /* bridge */ Object f(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        return this.h(uri, contentResolver);
    }
    
    protected void g(final InputStream inputStream) throws IOException {
        inputStream.close();
    }
    
    protected InputStream h(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        final InputStream i = this.i(uri, contentResolver);
        if (i != null) {
            return i;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("InputStream is null for ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }
}
