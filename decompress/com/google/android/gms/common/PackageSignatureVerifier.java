// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class PackageSignatureVerifier
{
}
