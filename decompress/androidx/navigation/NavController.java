// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.util.AbstractList;
import java.util.HashMap;
import androidx.lifecycle.q0;
import kotlin.jvm.internal.b;
import java.util.Objects;
import java.util.ListIterator;
import android.content.Intent;
import androidx.core.os.d;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.y;
import java.util.Set;
import android.util.Log;
import kotlin.jvm.internal.Ref$BooleanRef;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlin.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.t;
import kotlin.sequences.k;
import kotlin.jvm.internal.o;
import sa.l;
import androidx.lifecycle.q;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CopyOnWriteArrayList;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.r;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.flow.i;
import kotlin.collections.g;
import android.os.Parcelable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import ka.j;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u00c2\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 \u00de\u00012\u00020\u0001:\u0004g\u00e2\u0001mB\u0011\u0012\u0006\u0010k\u001a\u00020f¢\u0006\u0006\b\u00e0\u0001\u0010\u00e1\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002JL\u0010\u0011\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J:\u0010\u0015\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J$\u0010\u0019\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0003J*\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0003J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"H\u0003J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010)\u001a\u0004\u0018\u00010\b*\u00020\b2\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0002J.\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003J.\u0010.\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J2\u00104\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\"2\u0006\u00102\u001a\u00020\u00022\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\b\u00105\u001a\u00020\u0005H\u0002J\u0019\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b6\u00107J\b\u00108\u001a\u00020\u0013H\u0017J\u001a\u00109\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0013H\u0017J\"\u0010:\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J%\u0010=\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050;H\u0000¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\u0013H\u0017J\u000f\u0010@\u001a\u00020\u0005H\u0000¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0000¢\u0006\u0004\bB\u0010CJ\u0012\u0010E\u001a\u00020\u00052\b\b\u0001\u0010D\u001a\u00020\u0016H\u0017J\u001c\u0010F\u001a\u00020\u00052\b\b\u0001\u0010D\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017J\u001a\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020G2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017J\u0012\u0010L\u001a\u00020\u00132\b\u0010K\u001a\u0004\u0018\u00010JH\u0017J\u0014\u0010M\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0007J\u001c\u0010O\u001a\u00020\u00052\b\b\u0001\u0010N\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\"H\u0017J&\u0010P\u001a\u00020\u00052\b\b\u0001\u0010N\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J0\u0010Q\u001a\u00020\u00052\b\b\u0001\u0010N\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010S\u001a\u00020RH\u0017J\b\u0010V\u001a\u00020UH\u0016J\n\u0010W\u001a\u0004\u0018\u00010\"H\u0017J\u0012\u0010Y\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020ZH\u0017J\u0010\u0010_\u001a\u00020\u00052\u0006\u0010^\u001a\u00020]H\u0017J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0013H\u0017J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010c\u001a\u00020bH\u0017J\u0012\u0010e\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010k\u001a\u00020f8\u0007¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010\u0081\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R%\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8WX\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R$\u0010\u008a\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u0090\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u008b\u00018\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R$\u0010\u0094\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R%\u0010\u0097\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u0095\u00010\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0093\u0001R&\u0010\u0099\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010'0\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0093\u0001R)\u0010\u009a\u0001\u001a\u0015\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0091\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b4\u0010\u0093\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010\u009e\u0001R\u001b\u0010¢\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bV\u0010¡\u0001R\u001e\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010¥\u0001R)\u0010\u00ad\u0001\u001a\u00030§\u00018@@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\ba\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010°\u0001\u001a\u00030®\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bM\u0010¯\u0001R\u0017\u0010³\u0001\u001a\u00030±\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b)\u0010²\u0001R\u0018\u0010´\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u0080\u0001R\u001a\u0010·\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010¶\u0001R0\u0010¹\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\t\u0012\u00070¸\u0001R\u00020\u00000\u0091\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010\u0093\u0001R$\u0010»\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010\u0093\u0001R\u0018\u0010½\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u00100R\u001e\u0010\u00c1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010\u00c0\u0001R\u001e\u0010\u00c5\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00c2\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R#\u0010\u00cb\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00c6\u00018\u0006¢\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0017\u0010\u00cd\u0001\u001a\u00020\u00168BX\u0082\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010\u00cc\u0001R(\u0010H\u001a\u00020G2\u0006\u0010H\u001a\u00020G8W@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¿\u0001\u0010\u00ce\u0001\"\u0006\b\u00cf\u0001\u0010\u00d0\u0001R,\u0010\u00d1\u0001\u001a\u00030µ\u00012\b\u0010\u00d1\u0001\u001a\u00030µ\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u00c7\u0001\u0010\u00d2\u0001\"\u0006\b\u00d3\u0001\u0010\u00d4\u0001R \u0010\u00d8\u0001\u001a\u00020p8VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00d7\u0001R\u0019\u0010\u00da\u0001\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010\u00d9\u0001R\u0019\u0010\u00dd\u0001\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001R\u0019\u0010\u00df\u0001\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u00de\u0001\u0010\u00dc\u0001¨\u0006\u00e3\u0001" }, d2 = { "Landroidx/navigation/NavController;", "", "Landroidx/navigation/NavBackStackEntry;", "child", "parent", "Lka/r;", "K", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "", "entries", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "Lkotlin/Function1;", "handler", "Q", "popUpTo", "", "saveState", "X", "", "destinationId", "inclusive", "Y", "Lkotlin/collections/g;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "a0", "p", "m0", "n0", "r", "Landroid/os/Bundle;", "startDestinationArgs", "S", "", "deepLink", "", "v", "u", "node", "args", "O", "id", "e0", "backStackState", "I", "finalArgs", "backStackEntry", "restoredEntries", "n", "q0", "o0", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "T", "U", "V", "Lkotlin/Function0;", "onComplete", "W", "(Landroidx/navigation/NavBackStackEntry;Lsa/a;)V", "R", "p0", "()V", "c0", "()Ljava/util/List;", "graphResId", "g0", "h0", "Landroidx/navigation/NavGraph;", "graph", "i0", "Landroid/content/Intent;", "intent", "H", "t", "resId", "L", "M", "N", "Landroidx/navigation/m;", "directions", "P", "Landroidx/navigation/k;", "q", "f0", "navState", "d0", "Landroidx/lifecycle/r;", "owner", "j0", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "k0", "enabled", "s", "Landroidx/lifecycle/q0;", "viewModelStore", "l0", "x", "Landroid/content/Context;", "a", "Landroid/content/Context;", "y", "()Landroid/content/Context;", "context", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "activity", "Landroidx/navigation/p;", "c", "Landroidx/navigation/p;", "inflater", "d", "Landroidx/navigation/NavGraph;", "_graph", "e", "Landroid/os/Bundle;", "navigatorStateToRestore", "", "Landroid/os/Parcelable;", "f", "[Landroid/os/Parcelable;", "backStackToRestore", "g", "Z", "deepLinkHandled", "h", "Lkotlin/collections/g;", "w", "()Lkotlin/collections/g;", "backQueue", "Lkotlinx/coroutines/flow/i;", "i", "Lkotlinx/coroutines/flow/i;", "_visibleEntries", "Lkotlinx/coroutines/flow/s;", "j", "Lkotlinx/coroutines/flow/s;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/s;", "visibleEntries", "", "k", "Ljava/util/Map;", "childToParentEntries", "Ljava/util/concurrent/atomic/AtomicInteger;", "l", "parentToChildCount", "m", "backStackMap", "backStackStates", "o", "Landroidx/lifecycle/r;", "lifecycleOwner", "Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher", "Landroidx/navigation/j;", "Landroidx/navigation/j;", "viewModel", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$b;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "D", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "hostLifecycleState", "Landroidx/lifecycle/q;", "Landroidx/lifecycle/q;", "lifecycleObserver", "Landroidx/activity/g;", "Landroidx/activity/g;", "onBackPressedCallback", "enableOnBackPressedCallback", "Landroidx/navigation/v;", "Landroidx/navigation/v;", "_navigatorProvider", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "A", "entrySavedState", "B", "dispatchReentrantCount", "", "C", "Ljava/util/List;", "backStackEntriesToDispatch", "Lkotlinx/coroutines/flow/h;", "E", "Lkotlinx/coroutines/flow/h;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/c;", "F", "Lkotlinx/coroutines/flow/c;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/c;", "currentBackStackEntryFlow", "()I", "destinationCountOnBackStack", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "()Landroidx/navigation/v;", "setNavigatorProvider", "(Landroidx/navigation/v;)V", "navInflater$delegate", "Lka/j;", "()Landroidx/navigation/p;", "navInflater", "()Landroidx/navigation/NavDestination;", "currentDestination", "z", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "G", "previousBackStackEntry", "<init>", "(Landroid/content/Context;)V", "NavControllerNavigatorState", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public class NavController
{
    public static final a G;
    private static boolean H;
    private final Map<NavBackStackEntry, Boolean> A;
    private int B;
    private final List<NavBackStackEntry> C;
    private final j D;
    private final h<NavBackStackEntry> E;
    private final c<NavBackStackEntry> F;
    private final Context a;
    private Activity b;
    private p c;
    private NavGraph d;
    private Bundle e;
    private Parcelable[] f;
    private boolean g;
    private final g<NavBackStackEntry> h;
    private final i<List<NavBackStackEntry>> i;
    private final s<List<NavBackStackEntry>> j;
    private final Map<NavBackStackEntry, NavBackStackEntry> k;
    private final Map<NavBackStackEntry, AtomicInteger> l;
    private final Map<Integer, String> m;
    private final Map<String, g<NavBackStackEntryState>> n;
    private r o;
    private OnBackPressedDispatcher p;
    private androidx.navigation.j q;
    private final CopyOnWriteArrayList<b> r;
    private Lifecycle.State s;
    private final q t;
    private final androidx.activity.g u;
    private boolean v;
    private v w;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> x;
    private l<? super NavBackStackEntry, ka.r> y;
    private l<? super NavBackStackEntry, ka.r> z;
    
    static {
        G = new a(null);
        NavController.H = true;
    }
    
    public NavController(final Context a) {
        kotlin.jvm.internal.o.g((Object)a, "context");
        this.a = a;
        while (true) {
            for (final Object next : kotlin.sequences.k.h((Object)a, (l)NavController$activity.NavController$activity$1.INSTANCE)) {
                if (((Context)next) instanceof Activity) {
                    this.b = (Activity)next;
                    this.h = (g<NavBackStackEntry>)new g();
                    final i a2 = kotlinx.coroutines.flow.t.a((Object)kotlin.collections.o.j());
                    this.i = (i<List<NavBackStackEntry>>)a2;
                    this.j = (s<List<NavBackStackEntry>>)kotlinx.coroutines.flow.e.b(a2);
                    this.k = new LinkedHashMap<NavBackStackEntry, NavBackStackEntry>();
                    this.l = new LinkedHashMap<NavBackStackEntry, AtomicInteger>();
                    this.m = new LinkedHashMap<Integer, String>();
                    this.n = new LinkedHashMap<String, g<NavBackStackEntryState>>();
                    this.r = new CopyOnWriteArrayList<b>();
                    this.s = Lifecycle.State.INITIALIZED;
                    this.t = new androidx.navigation.i(this);
                    this.u = new androidx.activity.g(this) {
                        final NavController a;
                        
                        @Override
                        public void handleOnBackPressed() {
                            this.a.T();
                        }
                    };
                    this.v = true;
                    this.w = new v();
                    this.x = new LinkedHashMap<Navigator<? extends NavDestination>, NavControllerNavigatorState>();
                    this.A = new LinkedHashMap<NavBackStackEntry, Boolean>();
                    final v w = this.w;
                    w.b(new n(w));
                    this.w.b(new ActivityNavigator(this.a));
                    this.C = new ArrayList<NavBackStackEntry>();
                    this.D = kotlin.a.b((sa.a)new NavController$navInflater.NavController$navInflater$2(this));
                    final h b = kotlinx.coroutines.flow.n.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object)null);
                    this.E = (h<NavBackStackEntry>)b;
                    this.F = (c<NavBackStackEntry>)kotlinx.coroutines.flow.e.a(b);
                    return;
                }
            }
            Object next = null;
            continue;
        }
    }
    
    private final int B() {
        final g<NavBackStackEntry> w = this.w();
        final boolean b = w instanceof Collection;
        int n = 0;
        int n2 = 0;
        if (!b || !((Collection)w).isEmpty()) {
            final Iterator<NavBackStackEntry> iterator = ((Iterable<NavBackStackEntry>)w).iterator();
            while (true) {
                n = n2;
                if (!iterator.hasNext()) {
                    break;
                }
                if (!(iterator.next().f() instanceof NavGraph ^ true)) {
                    continue;
                }
                final int n3 = n2 + 1;
                if ((n2 = n3) >= 0) {
                    continue;
                }
                kotlin.collections.o.s();
                n2 = n3;
            }
        }
        return n;
    }
    
    private final List<NavBackStackEntry> I(final g<NavBackStackEntryState> g) {
        final ArrayList list = new ArrayList();
        final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)this.w().m();
        NavDestination navDestination;
        if (navBackStackEntry == null || (navDestination = navBackStackEntry.f()) == null) {
            navDestination = this.C();
        }
        if (g != null) {
            for (final NavBackStackEntryState navBackStackEntryState : g) {
                final NavDestination u = this.u(navDestination, navBackStackEntryState.a());
                if (u == null) {
                    final String b = NavDestination.j.b(this.a, navBackStackEntryState.a());
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Restore State failed: destination ");
                    sb.append(b);
                    sb.append(" cannot be found from the current destination ");
                    sb.append(navDestination);
                    throw new IllegalStateException(sb.toString().toString());
                }
                list.add(navBackStackEntryState.c(this.a, u, this.D(), this.q));
                navDestination = u;
            }
        }
        return list;
    }
    
    private static final void J(final NavController navController, final r r, final Lifecycle.Event event) {
        o.g((Object)navController, "this$0");
        o.g((Object)r, "<anonymous parameter 0>");
        o.g((Object)event, "event");
        final Lifecycle.State targetState = event.getTargetState();
        o.f((Object)targetState, "event.targetState");
        navController.s = targetState;
        if (navController.d != null) {
            final Iterator<NavBackStackEntry> iterator = ((AbstractList<NavBackStackEntry>)navController.w()).iterator();
            while (iterator.hasNext()) {
                iterator.next().j(event);
            }
        }
    }
    
    private final void K(final NavBackStackEntry navBackStackEntry, final NavBackStackEntry navBackStackEntry2) {
        this.k.put(navBackStackEntry, navBackStackEntry2);
        if (this.l.get(navBackStackEntry2) == null) {
            this.l.put(navBackStackEntry2, new AtomicInteger(0));
        }
        final AtomicInteger value = this.l.get(navBackStackEntry2);
        kotlin.jvm.internal.o.d((Object)value);
        value.incrementAndGet();
    }
    
    private final void O(final NavDestination navDestination, final Bundle bundle, final androidx.navigation.q q, final Navigator.a a) {
        final Iterator<Object> iterator = this.x.values().iterator();
        int n;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            n = 1;
            if (!hasNext) {
                break;
            }
            iterator.next().i(true);
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final boolean b = q != null && q.e() != -1 && this.Y(q.e(), q.f(), q.h());
        final Bundle f = navDestination.f(bundle);
        int n2 = 0;
        Label_0380: {
            if (q != null && q.i() && this.m.containsKey(navDestination.p())) {
                ref$BooleanRef.element = this.e0(navDestination.p(), f, q, a);
            }
            else {
                final NavBackStackEntry z = this.z();
                final Navigator d = this.w.d(navDestination.q());
                if (q != null && q.g()) {
                    boolean b2 = false;
                    Label_0250: {
                        if (z != null) {
                            final NavDestination f2 = z.f();
                            if (f2 != null && navDestination.p() == f2.p()) {
                                b2 = true;
                                break Label_0250;
                            }
                        }
                        b2 = false;
                    }
                    if (b2) {
                        this.o0((NavBackStackEntry)this.w().removeLast());
                        final NavBackStackEntry navBackStackEntry = new NavBackStackEntry(z, f);
                        this.w().addLast((Object)navBackStackEntry);
                        final NavGraph s = navBackStackEntry.f().s();
                        if (s != null) {
                            this.K(navBackStackEntry, this.x(s.p()));
                        }
                        d.g(navBackStackEntry);
                        n2 = n;
                        break Label_0380;
                    }
                }
                this.Q(d, kotlin.collections.o.e((Object)NavBackStackEntry.a.b(NavBackStackEntry.y, this.a, navDestination, f, this.D(), this.q, null, null, 96, null)), q, a, (l<? super NavBackStackEntry, ka.r>)new NavController$navigate.NavController$navigate$4(ref$BooleanRef, this, navDestination, f));
            }
            n2 = 0;
        }
        this.q0();
        final Iterator<Object> iterator2 = this.x.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().i(false);
        }
        if (!b && !ref$BooleanRef.element && n2 == 0) {
            this.p0();
        }
        else {
            this.r();
        }
    }
    
    private final void Q(final Navigator<? extends NavDestination> navigator, final List<NavBackStackEntry> list, final androidx.navigation.q q, final Navigator.a a, final l<? super NavBackStackEntry, ka.r> y) {
        this.y = y;
        navigator.e(list, q, a);
        this.y = null;
    }
    
    private final void S(final Bundle bundle) {
        final Bundle e = this.e;
        if (e != null) {
            final ArrayList stringArrayList = e.getStringArrayList("android-support-nav:controller:navigatorState:names");
            if (stringArrayList != null) {
                for (final String s : stringArrayList) {
                    final v w = this.w;
                    kotlin.jvm.internal.o.f((Object)s, "name");
                    final Navigator d = w.d(s);
                    final Bundle bundle2 = e.getBundle(s);
                    if (bundle2 != null) {
                        d.h(bundle2);
                    }
                }
            }
        }
        final Parcelable[] f = this.f;
        final boolean b = false;
        if (f != null) {
            for (int length = f.length, i = 0; i < length; ++i) {
                final NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState)f[i];
                final NavDestination t = this.t(navBackStackEntryState.a());
                if (t == null) {
                    final String b2 = NavDestination.j.b(this.a, navBackStackEntryState.a());
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Restoring the Navigation back stack failed: destination ");
                    sb.append(b2);
                    sb.append(" cannot be found from the current destination ");
                    sb.append(this.A());
                    throw new IllegalStateException(sb.toString());
                }
                final NavBackStackEntry c = navBackStackEntryState.c(this.a, t, this.D(), this.q);
                final Navigator d2 = this.w.d(t.q());
                final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> x = this.x;
                NavControllerNavigatorState value;
                if ((value = x.get(d2)) == null) {
                    value = new NavControllerNavigatorState(d2);
                    x.put(d2, value);
                }
                final NavControllerNavigatorState navControllerNavigatorState = value;
                this.w().add((Object)c);
                navControllerNavigatorState.k(c);
                final NavGraph s2 = c.f().s();
                if (s2 != null) {
                    this.K(c, this.x(s2.p()));
                }
            }
            this.q0();
            this.f = null;
        }
        final Collection<Navigator<? extends NavDestination>> values = this.w.e().values();
        final ArrayList list = new ArrayList();
        for (final Navigator next : values) {
            if (!next.c()) {
                list.add(next);
            }
        }
        for (final Navigator navigator : list) {
            final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> x2 = this.x;
            NavControllerNavigatorState value2;
            if ((value2 = x2.get(navigator)) == null) {
                value2 = new NavControllerNavigatorState(navigator);
                x2.put(navigator, value2);
            }
            navigator.f(value2);
        }
        if (this.d != null && this.w().isEmpty()) {
            int n = b ? 1 : 0;
            if (!this.g) {
                final Activity b3 = this.b;
                n = (b ? 1 : 0);
                if (b3 != null) {
                    kotlin.jvm.internal.o.d((Object)b3);
                    n = (b ? 1 : 0);
                    if (this.H(b3.getIntent())) {
                        n = 1;
                    }
                }
            }
            if (n == 0) {
                final NavGraph d3 = this.d;
                kotlin.jvm.internal.o.d((Object)d3);
                this.O(d3, bundle, null, null);
            }
        }
        else {
            this.r();
        }
    }
    
    private final void X(final Navigator<? extends NavDestination> navigator, final NavBackStackEntry navBackStackEntry, final boolean b, final l<? super NavBackStackEntry, ka.r> z) {
        this.z = z;
        navigator.j(navBackStackEntry, b);
        this.z = null;
    }
    
    private final boolean Y(int p3, final boolean b, final boolean b2) {
        if (this.w().isEmpty()) {
            return false;
        }
        final ArrayList list = new ArrayList();
        final Iterator iterator = kotlin.collections.o.z0((Iterable)this.w()).iterator();
        while (true) {
            while (iterator.hasNext()) {
                final NavDestination f = ((NavBackStackEntry)iterator.next()).f();
                final Navigator d = this.w.d(f.q());
                if (b || f.p() != p3) {
                    list.add(d);
                }
                if (f.p() == p3) {
                    if (f == null) {
                        final String b3 = NavDestination.j.b(this.a, p3);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Ignoring popBackStack to destination ");
                        sb.append(b3);
                        sb.append(" as it was not found on the current back stack");
                        Log.i("NavController", sb.toString());
                        return false;
                    }
                    final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    final g g = new g();
                    for (final Navigator navigator : list) {
                        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                        this.X(navigator, (NavBackStackEntry)this.w().last(), b2, (l<? super NavBackStackEntry, ka.r>)new NavController$popBackStackInternal.NavController$popBackStackInternal$2(ref$BooleanRef2, ref$BooleanRef, this, b2, g));
                        if (!ref$BooleanRef2.element) {
                            break;
                        }
                    }
                    if (b2) {
                        if (!b) {
                            for (final NavDestination navDestination : kotlin.sequences.k.B(kotlin.sequences.k.h((Object)f, (l)NavController$popBackStackInternal.NavController$popBackStackInternal$3.INSTANCE), (l)new NavController$popBackStackInternal.NavController$popBackStackInternal$4(this))) {
                                final Map<Integer, String> m = this.m;
                                p3 = navDestination.p();
                                final NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState)g.g();
                                String b4;
                                if (navBackStackEntryState != null) {
                                    b4 = navBackStackEntryState.b();
                                }
                                else {
                                    b4 = null;
                                }
                                m.put(p3, b4);
                            }
                        }
                        if (((Collection)g).isEmpty() ^ true) {
                            final NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState)g.first();
                            final Iterator iterator4 = kotlin.sequences.k.B(kotlin.sequences.k.h((Object)this.t(navBackStackEntryState2.a()), (l)NavController$popBackStackInternal.NavController$popBackStackInternal$6.INSTANCE), (l)new NavController$popBackStackInternal.NavController$popBackStackInternal$7(this)).iterator();
                            while (iterator4.hasNext()) {
                                this.m.put(((NavDestination)iterator4.next()).p(), navBackStackEntryState2.b());
                            }
                            this.n.put(navBackStackEntryState2.b(), (g<NavBackStackEntryState>)g);
                        }
                    }
                    this.q0();
                    return ref$BooleanRef.element;
                }
            }
            final NavDestination f = null;
            continue;
        }
    }
    
    static boolean Z(final NavController navController, final int n, final boolean b, boolean b2, final int n2, final Object o) {
        if (o == null) {
            if ((n2 & 0x4) != 0x0) {
                b2 = false;
            }
            return navController.Y(n, b, b2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }
    
    public static void a(final NavController navController, final r r, final Lifecycle.Event event) {
        J(navController, r, event);
    }
    
    private final void a0(final NavBackStackEntry navBackStackEntry, final boolean b, final g<NavBackStackEntryState> g) {
        final NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry)this.w().last();
        if (kotlin.jvm.internal.o.b((Object)navBackStackEntry2, (Object)navBackStackEntry)) {
            this.w().removeLast();
            final NavControllerNavigatorState navControllerNavigatorState = this.x.get(this.F().d(navBackStackEntry2.f().q()));
            final int n = 1;
            boolean b2 = false;
            Label_0110: {
                if (navControllerNavigatorState != null) {
                    final s<Set<NavBackStackEntry>> c = navControllerNavigatorState.c();
                    if (c != null) {
                        final Set set = (Set)c.getValue();
                        if (set != null && set.contains(navBackStackEntry2)) {
                            b2 = true;
                            break Label_0110;
                        }
                    }
                }
                b2 = false;
            }
            int n2 = n;
            if (!b2) {
                if (this.l.containsKey(navBackStackEntry2)) {
                    n2 = n;
                }
                else {
                    n2 = 0;
                }
            }
            final Lifecycle.State b3 = navBackStackEntry2.getLifecycle().b();
            final Lifecycle.State created = Lifecycle.State.CREATED;
            if (b3.isAtLeast(created)) {
                if (b) {
                    navBackStackEntry2.m(created);
                    g.addFirst((Object)new NavBackStackEntryState(navBackStackEntry2));
                }
                if (n2 == 0) {
                    navBackStackEntry2.m(Lifecycle.State.DESTROYED);
                    this.o0(navBackStackEntry2);
                }
                else {
                    navBackStackEntry2.m(created);
                }
            }
            if (!b && n2 == 0) {
                final androidx.navigation.j q = this.q;
                if (q != null) {
                    q.j(navBackStackEntry2.g());
                }
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Attempted to pop ");
        sb.append(navBackStackEntry.f());
        sb.append(", which is not the top of the back stack (");
        sb.append(navBackStackEntry2.f());
        sb.append(')');
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public static final void b(final NavController navController, final NavDestination navDestination, final Bundle bundle, final NavBackStackEntry navBackStackEntry, final List list) {
        navController.n(navDestination, bundle, navBackStackEntry, list);
    }
    
    static void b0(final NavController navController, final NavBackStackEntry navBackStackEntry, boolean b, g g, final int n, final Object o) {
        if (o == null) {
            if ((n & 0x2) != 0x0) {
                b = false;
            }
            if ((n & 0x4) != 0x0) {
                g = new g();
            }
            navController.a0(navBackStackEntry, b, (g<NavBackStackEntryState>)g);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }
    
    public static final l c(final NavController navController) {
        return navController.y;
    }
    
    public static final Map d(final NavController navController) {
        return navController.m;
    }
    
    public static final boolean e() {
        return NavController.H;
    }
    
    private final boolean e0(final int n, final Bundle bundle, final androidx.navigation.q q, final Navigator.a a) {
        if (!this.m.containsKey(n)) {
            return false;
        }
        final String s = this.m.get(n);
        kotlin.collections.o.D((Iterable)this.m.values(), (l)new NavController$restoreStateInternal.NavController$restoreStateInternal$1(s));
        final List<NavBackStackEntry> i = this.I((g<NavBackStackEntryState>)kotlin.jvm.internal.y.d((Object)this.n).remove(s));
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (final NavBackStackEntry next : i) {
            if (!(next.f() instanceof NavGraph)) {
                list2.add(next);
            }
        }
        for (final NavBackStackEntry navBackStackEntry : list2) {
            final List list3 = (List)kotlin.collections.o.p0((List)list);
            String q2 = null;
            Label_0240: {
                if (list3 != null) {
                    final NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry)kotlin.collections.o.n0(list3);
                    if (navBackStackEntry2 != null) {
                        final NavDestination f = navBackStackEntry2.f();
                        if (f != null) {
                            q2 = f.q();
                            break Label_0240;
                        }
                    }
                }
                q2 = null;
            }
            if (kotlin.jvm.internal.o.b((Object)q2, (Object)navBackStackEntry.f().q())) {
                list3.add(navBackStackEntry);
            }
            else {
                list.add(kotlin.collections.o.p((Object[])new NavBackStackEntry[] { navBackStackEntry }));
            }
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (final List list4 : list) {
            this.Q(this.w.d(((NavBackStackEntry)kotlin.collections.o.b0((List)list4)).f().q()), list4, q, a, (l<? super NavBackStackEntry, ka.r>)new NavController$restoreStateInternal.NavController$restoreStateInternal$4(ref$BooleanRef, (List)i, new Ref$IntRef(), this, bundle));
        }
        return ref$BooleanRef.element;
    }
    
    public static final Map f(final NavController navController) {
        return navController.A;
    }
    
    public static final p g(final NavController navController) {
        return navController.c;
    }
    
    public static final Map h(final NavController navController) {
        return navController.x;
    }
    
    public static final l i(final NavController navController) {
        return navController.z;
    }
    
    public static final androidx.navigation.j j(final NavController navController) {
        return navController.q;
    }
    
    public static final v k(final NavController navController) {
        return navController.w;
    }
    
    public static final i l(final NavController navController) {
        return navController.i;
    }
    
    public static final void m(final NavController navController, final NavBackStackEntry navBackStackEntry, final boolean b, final g g) {
        navController.a0(navBackStackEntry, b, (g<NavBackStackEntryState>)g);
    }
    
    private final boolean m0() {
        final boolean g = this.g;
        final int n = 0;
        if (!g) {
            return false;
        }
        final Activity b = this.b;
        kotlin.jvm.internal.o.d((Object)b);
        final Intent intent = b.getIntent();
        final Bundle extras = intent.getExtras();
        kotlin.jvm.internal.o.d((Object)extras);
        final int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        kotlin.jvm.internal.o.d((Object)intArray);
        final List j0 = kotlin.collections.h.j0(intArray);
        final ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        int n2 = ((Number)kotlin.collections.o.F(j0)).intValue();
        if (parcelableArrayList != null) {
            final Bundle bundle = (Bundle)kotlin.collections.o.F((List)parcelableArrayList);
        }
        if (j0.isEmpty()) {
            return false;
        }
        final NavDestination u = this.u(this.C(), n2);
        if (u instanceof NavGraph) {
            n2 = NavGraph.A.a((NavGraph)u).p();
        }
        final NavDestination a = this.A();
        if (a == null || n2 != a.p()) {
            return false;
        }
        final androidx.navigation.k q = this.q();
        final Bundle a2 = androidx.core.os.d.a(ka.l.a((Object)"android-support-nav:controller:deepLinkIntent", (Object)intent));
        final Bundle bundle2 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle2 != null) {
            a2.putAll(bundle2);
        }
        q.e(a2);
        final Iterator iterator = j0.iterator();
        int n3 = n;
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            if (n3 < 0) {
                kotlin.collections.o.t();
            }
            final int intValue = ((Number)next).intValue();
            Bundle bundle3;
            if (parcelableArrayList != null) {
                bundle3 = parcelableArrayList.get(n3);
            }
            else {
                bundle3 = null;
            }
            q.a(intValue, bundle3);
            ++n3;
        }
        q.b().p();
        final Activity b2 = this.b;
        if (b2 != null) {
            b2.finish();
        }
        return true;
    }
    
    private final void n(final NavDestination navDestination, final Bundle bundle, NavBackStackEntry navBackStackEntry, final List<NavBackStackEntry> list) {
        final NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        final NavDestination f = navBackStackEntry.f();
        if (!(f instanceof androidx.navigation.c)) {
            while (!this.w().isEmpty() && ((NavBackStackEntry)this.w().last()).f() instanceof androidx.navigation.c && Z(this, ((NavBackStackEntry)this.w().last()).f().p(), true, false, 4, null)) {}
        }
        g g = new g();
        final boolean b = navDestination instanceof NavGraph;
        final NavBackStackEntry navBackStackEntry3 = null;
        NavBackStackEntry navBackStackEntry4;
        List<NavBackStackEntry> list4;
        Bundle bundle2;
        NavDestination f2;
        if (b) {
            NavDestination navDestination2 = f;
            List<NavBackStackEntry> list2 = list;
            final g g2 = g;
            while (true) {
                kotlin.jvm.internal.o.d((Object)navDestination2);
                final NavGraph s = navDestination2.s();
                Label_0319: {
                    if (s != null) {
                        final ListIterator<NavBackStackEntry> listIterator = list2.listIterator(list.size());
                        while (true) {
                            while (listIterator.hasPrevious()) {
                                final NavBackStackEntry previous = listIterator.previous();
                                if (kotlin.jvm.internal.o.b((Object)previous.f(), (Object)s)) {
                                    NavBackStackEntry b2 = previous;
                                    if (b2 == null) {
                                        b2 = NavBackStackEntry.a.b(NavBackStackEntry.y, this.a, s, bundle, this.D(), this.q, null, null, 96, null);
                                    }
                                    g2.addFirst((Object)b2);
                                    if ((((Collection)this.w()).isEmpty() ^ true) && ((NavBackStackEntry)this.w().last()).f() == s) {
                                        b0(this, (NavBackStackEntry)this.w().last(), false, null, 6, null);
                                    }
                                    break Label_0319;
                                }
                            }
                            final NavBackStackEntry previous = null;
                            continue;
                        }
                    }
                }
                final List<NavBackStackEntry> list3 = list2;
                navBackStackEntry4 = navBackStackEntry2;
                g = g2;
                list4 = list3;
                bundle2 = bundle;
                f2 = f;
                if (s == null) {
                    break;
                }
                if (s == navDestination) {
                    navBackStackEntry4 = navBackStackEntry2;
                    g = g2;
                    list4 = list3;
                    bundle2 = bundle;
                    f2 = f;
                    break;
                }
                final NavGraph navGraph = s;
                final List<NavBackStackEntry> list5 = list3;
                navDestination2 = navGraph;
                list2 = list5;
            }
        }
        else {
            f2 = f;
            bundle2 = bundle;
            list4 = list;
            navBackStackEntry4 = navBackStackEntry2;
        }
        NavDestination f3;
        if (g.isEmpty()) {
            f3 = f2;
        }
        else {
            f3 = ((NavBackStackEntry)g.first()).f();
        }
    Label_0430:
        while (f3 != null && this.t(f3.p()) == null) {
            final NavGraph s2 = f3.s();
            if ((f3 = s2) != null) {
                final ListIterator<NavBackStackEntry> listIterator2 = list4.listIterator(list.size());
                while (true) {
                    while (listIterator2.hasPrevious()) {
                        final NavBackStackEntry previous2 = listIterator2.previous();
                        if (kotlin.jvm.internal.o.b((Object)previous2.f(), (Object)s2)) {
                            NavBackStackEntry b3;
                            if ((b3 = previous2) == null) {
                                b3 = NavBackStackEntry.a.b(NavBackStackEntry.y, this.a, s2, s2.f(bundle2), this.D(), this.q, null, null, 96, null);
                            }
                            g.addFirst((Object)b3);
                            f3 = s2;
                            continue Label_0430;
                        }
                    }
                    final NavBackStackEntry previous2 = null;
                    continue;
                }
            }
        }
        if (!g.isEmpty()) {
            f2 = ((NavBackStackEntry)g.last()).f();
        }
        while (!this.w().isEmpty() && ((NavBackStackEntry)this.w().last()).f() instanceof NavGraph && ((NavGraph)((NavBackStackEntry)this.w().last()).f()).G(f2.p(), false) == null) {
            b0(this, (NavBackStackEntry)this.w().last(), false, null, 6, null);
        }
        navBackStackEntry = (NavBackStackEntry)this.w().g();
        NavBackStackEntry navBackStackEntry5;
        if ((navBackStackEntry5 = navBackStackEntry) == null) {
            navBackStackEntry5 = (NavBackStackEntry)g.g();
        }
        NavDestination f4;
        if (navBackStackEntry5 != null) {
            f4 = navBackStackEntry5.f();
        }
        else {
            f4 = null;
        }
        if (!kotlin.jvm.internal.o.b((Object)f4, (Object)this.d)) {
            final ListIterator<NavBackStackEntry> listIterator3 = list4.listIterator(list.size());
            NavDestination f5;
            NavGraph d;
            NavBackStackEntry previous3;
            do {
                previous3 = navBackStackEntry3;
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                previous3 = listIterator3.previous();
                f5 = previous3.f();
                d = this.d;
                kotlin.jvm.internal.o.d((Object)d);
            } while (!kotlin.jvm.internal.o.b((Object)f5, (Object)d));
            navBackStackEntry = previous3;
            NavBackStackEntry b4;
            if ((b4 = navBackStackEntry) == null) {
                final NavBackStackEntry.a y = NavBackStackEntry.y;
                final Context a = this.a;
                final NavGraph d2 = this.d;
                kotlin.jvm.internal.o.d((Object)d2);
                final NavGraph d3 = this.d;
                kotlin.jvm.internal.o.d((Object)d3);
                b4 = NavBackStackEntry.a.b(y, a, d2, d3.f(bundle2), this.D(), this.q, null, null, 96, null);
            }
            g.addFirst((Object)b4);
        }
        final Iterator iterator = ((Iterable)g).iterator();
        while (iterator.hasNext()) {
            navBackStackEntry = (NavBackStackEntry)iterator.next();
            final NavControllerNavigatorState value = this.x.get(this.w.d(navBackStackEntry.f().q()));
            if (value == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("NavigatorBackStack for ");
                sb.append(navDestination.q());
                sb.append(" should already be created");
                throw new IllegalStateException(sb.toString().toString());
            }
            value.k(navBackStackEntry);
        }
        this.w().addAll((Collection)g);
        this.w().add((Object)navBackStackEntry4);
        for (final NavBackStackEntry navBackStackEntry6 : kotlin.collections.o.x0((Collection)g, (Object)navBackStackEntry4)) {
            final NavGraph s3 = navBackStackEntry6.f().s();
            if (s3 != null) {
                this.K(navBackStackEntry6, this.x(s3.p()));
            }
        }
    }
    
    private final boolean n0() {
        final NavDestination a = this.A();
        kotlin.jvm.internal.o.d((Object)a);
        int n = a.p();
        for (NavGraph navGraph = a.s(); navGraph != null; navGraph = navGraph.s()) {
            if (navGraph.N() != n) {
                final Bundle bundle = new Bundle();
                final Activity b = this.b;
                if (b != null) {
                    kotlin.jvm.internal.o.d((Object)b);
                    if (b.getIntent() != null) {
                        final Activity b2 = this.b;
                        kotlin.jvm.internal.o.d((Object)b2);
                        if (b2.getIntent().getData() != null) {
                            final Activity b3 = this.b;
                            kotlin.jvm.internal.o.d((Object)b3);
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", (Parcelable)b3.getIntent());
                            final NavGraph d = this.d;
                            kotlin.jvm.internal.o.d((Object)d);
                            final Activity b4 = this.b;
                            kotlin.jvm.internal.o.d((Object)b4);
                            final Intent intent = b4.getIntent();
                            kotlin.jvm.internal.o.f((Object)intent, "activity!!.intent");
                            final NavDestination.a v = d.v(new androidx.navigation.l(intent));
                            if (v != null) {
                                bundle.putAll(v.c().f(v.d()));
                            }
                        }
                    }
                }
                androidx.navigation.k.g(new androidx.navigation.k(this), navGraph.p(), null, 2, null).e(bundle).b().p();
                final Activity b5 = this.b;
                if (b5 != null) {
                    b5.finish();
                }
                return true;
            }
            n = navGraph.p();
        }
        return false;
    }
    
    static void o(final NavController navController, final NavDestination navDestination, final Bundle bundle, final NavBackStackEntry navBackStackEntry, List j, final int n, final Object o) {
        if (o == null) {
            if ((n & 0x8) != 0x0) {
                j = kotlin.collections.o.j();
            }
            navController.n(navDestination, bundle, navBackStackEntry, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }
    
    private final boolean p(final int n) {
        final Iterator<Object> iterator = this.x.values().iterator();
        boolean b;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            b = true;
            if (!hasNext) {
                break;
            }
            iterator.next().i(true);
        }
        final boolean e0 = this.e0(n, null, null, null);
        final Iterator<Object> iterator2 = this.x.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().i(false);
        }
        if (!e0 || !this.Y(n, true, false)) {
            b = false;
        }
        return b;
    }
    
    private final void q0() {
        final androidx.activity.g u = this.u;
        final boolean v = this.v;
        boolean enabled = true;
        if (!v || this.B() <= 1) {
            enabled = false;
        }
        u.setEnabled(enabled);
    }
    
    private final boolean r() {
        while (!this.w().isEmpty() && ((NavBackStackEntry)this.w().last()).f() instanceof NavGraph) {
            b0(this, (NavBackStackEntry)this.w().last(), false, null, 6, null);
        }
        final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)this.w().m();
        if (navBackStackEntry != null) {
            this.C.add(navBackStackEntry);
        }
        final int b = this.B;
        boolean b2 = true;
        this.B = b + 1;
        this.p0();
        if (--this.B == 0) {
            final List p0 = kotlin.collections.o.P0((Collection)this.C);
            this.C.clear();
            for (final NavBackStackEntry navBackStackEntry2 : p0) {
                final Iterator<b> iterator2 = this.r.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().a(this, navBackStackEntry2.f(), navBackStackEntry2.d());
                }
                this.E.a((Object)navBackStackEntry2);
            }
            ((h)this.i).a((Object)this.c0());
        }
        if (navBackStackEntry == null) {
            b2 = false;
        }
        return b2;
    }
    
    private final NavDestination u(final NavDestination navDestination, final int n) {
        if (navDestination.p() == n) {
            return navDestination;
        }
        NavGraph s;
        if (navDestination instanceof NavGraph) {
            s = (NavGraph)navDestination;
        }
        else {
            s = navDestination.s();
            kotlin.jvm.internal.o.d((Object)s);
        }
        return s.D(n);
    }
    
    private final String v(final int[] array) {
        NavGraph d = this.d;
        final int length = array.length;
        int n = 0;
        while (true) {
            NavDestination navDestination = null;
            if (n >= length) {
                return null;
            }
            final int n2 = array[n];
            if (n == 0) {
                final NavGraph d2 = this.d;
                kotlin.jvm.internal.o.d((Object)d2);
                if (d2.p() == n2) {
                    navDestination = this.d;
                }
            }
            else {
                kotlin.jvm.internal.o.d((Object)d);
                navDestination = d.D(n2);
            }
            if (navDestination == null) {
                return NavDestination.j.b(this.a, n2);
            }
            NavGraph navGraph = d;
            if (n != array.length - 1) {
                navGraph = d;
                if (navDestination instanceof NavGraph) {
                    NavGraph navGraph2 = (NavGraph)navDestination;
                    while (true) {
                        kotlin.jvm.internal.o.d((Object)navGraph2);
                        if (!(navGraph2.D(navGraph2.N()) instanceof NavGraph)) {
                            break;
                        }
                        navGraph2 = (NavGraph)navGraph2.D(navGraph2.N());
                    }
                    navGraph = navGraph2;
                }
            }
            ++n;
            d = navGraph;
        }
    }
    
    public NavDestination A() {
        final NavBackStackEntry z = this.z();
        NavDestination f;
        if (z != null) {
            f = z.f();
        }
        else {
            f = null;
        }
        return f;
    }
    
    public NavGraph C() {
        final NavGraph d = this.d;
        if (d != null) {
            Objects.requireNonNull(d, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            return d;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }
    
    public final Lifecycle.State D() {
        Enum<Lifecycle.State> enum1;
        if (this.o == null) {
            enum1 = Lifecycle.State.CREATED;
        }
        else {
            enum1 = this.s;
        }
        return (Lifecycle.State)enum1;
    }
    
    public p E() {
        return (p)this.D.getValue();
    }
    
    public v F() {
        return this.w;
    }
    
    public NavBackStackEntry G() {
        final Iterator iterator = kotlin.collections.o.z0((Iterable)this.w()).iterator();
        if (iterator.hasNext()) {
            iterator.next();
        }
        for (final Object next : kotlin.sequences.k.c((Iterator)iterator)) {
            if (((NavBackStackEntry)next).f() instanceof NavGraph ^ true) {
                return (NavBackStackEntry)next;
            }
        }
        Object next = null;
        return (NavBackStackEntry)next;
    }
    
    public boolean H(final Intent intent) {
        final int n = 0;
        if (intent == null) {
            return false;
        }
        final Bundle extras = intent.getExtras();
        int[] array;
        if (extras != null) {
            array = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        }
        else {
            array = null;
        }
        ArrayList parcelableArrayList;
        if (extras != null) {
            parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        }
        else {
            parcelableArrayList = null;
        }
        final Bundle bundle = new Bundle();
        Bundle bundle2;
        if (extras != null) {
            bundle2 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        }
        else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (array == null || array.length == 0) {
            final NavGraph d = this.d;
            kotlin.jvm.internal.o.d((Object)d);
            final NavDestination.a v = d.v(new androidx.navigation.l(intent));
            if (v != null) {
                final NavDestination c = v.c();
                array = NavDestination.k(c, null, 1, null);
                final Bundle f = c.f(v.d());
                if (f != null) {
                    bundle.putAll(f);
                }
                parcelableArrayList = null;
            }
        }
        if (array == null || array.length == 0) {
            return false;
        }
        final String v2 = this.v(array);
        if (v2 != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not find destination ");
            sb.append(v2);
            sb.append(" in the navigation graph, ignoring the deep link from ");
            sb.append(intent);
            Log.i("NavController", sb.toString());
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", (Parcelable)intent);
        final int length = array.length;
        final Bundle[] array2 = new Bundle[length];
        for (int i = 0; i < length; ++i) {
            final Bundle bundle3 = new Bundle();
            bundle3.putAll(bundle);
            if (parcelableArrayList != null) {
                final Bundle bundle4 = parcelableArrayList.get(i);
                if (bundle4 != null) {
                    bundle3.putAll(bundle4);
                }
            }
            array2[i] = bundle3;
        }
        final int flags = intent.getFlags();
        final int n2 = 0x10000000 & flags;
        if (n2 != 0 && (flags & 0x8000) == 0x0) {
            intent.addFlags(32768);
            final androidx.core.app.v b = androidx.core.app.v.g(this.a).b(intent);
            kotlin.jvm.internal.o.f((Object)b, "create(context)\n        \u2026ntWithParentStack(intent)");
            b.p();
            final Activity b2 = this.b;
            if (b2 != null) {
                b2.finish();
                b2.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (n2 != 0) {
            int j = n;
            if (!this.w().isEmpty()) {
                final NavGraph d2 = this.d;
                kotlin.jvm.internal.o.d((Object)d2);
                Z(this, d2.p(), true, false, 4, null);
                j = n;
            }
            while (j < array.length) {
                final int n3 = array[j];
                final Bundle bundle5 = array2[j];
                final NavDestination t = this.t(n3);
                if (t == null) {
                    final String b3 = NavDestination.j.b(this.a, n3);
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Deep Linking failed: destination ");
                    sb2.append(b3);
                    sb2.append(" cannot be found from the current destination ");
                    sb2.append(this.A());
                    throw new IllegalStateException(sb2.toString());
                }
                this.O(t, bundle5, androidx.navigation.s.a((l<? super androidx.navigation.r, ka.r>)new NavController$handleDeepLink.NavController$handleDeepLink$2(t, this)), null);
                ++j;
            }
            return true;
        }
        NavGraph d3 = this.d;
        for (int length2 = array.length, k = 0; k < length2; ++k) {
            final int n4 = array[k];
            final Bundle bundle6 = array2[k];
            NavDestination navDestination;
            if (k == 0) {
                navDestination = this.d;
            }
            else {
                kotlin.jvm.internal.o.d((Object)d3);
                navDestination = d3.D(n4);
            }
            if (navDestination == null) {
                final String b4 = NavDestination.j.b(this.a, n4);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Deep Linking failed: destination ");
                sb3.append(b4);
                sb3.append(" cannot be found in graph ");
                sb3.append(d3);
                throw new IllegalStateException(sb3.toString());
            }
            if (k != array.length - 1) {
                if (navDestination instanceof NavGraph) {
                    d3 = (NavGraph)navDestination;
                    while (true) {
                        kotlin.jvm.internal.o.d((Object)d3);
                        if (!(d3.D(d3.N()) instanceof NavGraph)) {
                            break;
                        }
                        d3 = (NavGraph)d3.D(d3.N());
                    }
                }
            }
            else {
                final androidx.navigation.q.a a = new androidx.navigation.q.a();
                final NavGraph d4 = this.d;
                kotlin.jvm.internal.o.d((Object)d4);
                this.O(navDestination, bundle6, androidx.navigation.q.a.i(a, d4.p(), true, false, 4, null).b(0).c(0).a(), null);
            }
        }
        return this.g = true;
    }
    
    public void L(final int n, final Bundle bundle) {
        this.M(n, bundle, null);
    }
    
    public void M(final int n, final Bundle bundle, final androidx.navigation.q q) {
        this.N(n, bundle, q, null);
    }
    
    public void N(final int n, final Bundle bundle, final androidx.navigation.q q, final Navigator.a a) {
        NavDestination navDestination;
        if (this.w().isEmpty()) {
            navDestination = this.d;
        }
        else {
            navDestination = ((NavBackStackEntry)this.w().last()).f();
        }
        if (navDestination == null) {
            throw new IllegalStateException("no current navigation node");
        }
        final androidx.navigation.d m = navDestination.m(n);
        final Bundle bundle2 = null;
        Bundle bundle3;
        int n2;
        androidx.navigation.q q2;
        if (m != null) {
            androidx.navigation.q c;
            if ((c = q) == null) {
                c = m.c();
            }
            final int b = m.b();
            final Bundle a2 = m.a();
            bundle3 = bundle2;
            n2 = b;
            q2 = c;
            if (a2 != null) {
                bundle3 = new Bundle();
                bundle3.putAll(a2);
                n2 = b;
                q2 = c;
            }
        }
        else {
            n2 = n;
            q2 = q;
            bundle3 = bundle2;
        }
        Bundle bundle4 = bundle3;
        if (bundle != null) {
            if ((bundle4 = bundle3) == null) {
                bundle4 = new Bundle();
            }
            bundle4.putAll(bundle);
        }
        if (n2 == 0 && q2 != null && q2.e() != -1) {
            this.U(q2.e(), q2.f());
            return;
        }
        final int n3 = 1;
        if (n2 == 0) {
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
        }
        final NavDestination t = this.t(n2);
        if (t != null) {
            this.O(t, bundle4, q2, a);
            return;
        }
        final NavDestination.Companion j = NavDestination.j;
        final String b2 = j.b(this.a, n2);
        int n4;
        if (m == null) {
            n4 = n3;
        }
        else {
            n4 = 0;
        }
        if (n4 == 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Navigation destination ");
            sb.append(b2);
            sb.append(" referenced from action ");
            sb.append(j.b(this.a, n));
            sb.append(" cannot be found from the current destination ");
            sb.append(navDestination);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Navigation action/destination ");
        sb2.append(b2);
        sb2.append(" cannot be found from the current destination ");
        sb2.append(navDestination);
        throw new IllegalArgumentException(sb2.toString());
    }
    
    public void P(final m m) {
        kotlin.jvm.internal.o.g((Object)m, "directions");
        this.M(m.getActionId(), m.getArguments(), null);
    }
    
    public boolean R() {
        if (this.B() != 1) {
            return this.T();
        }
        final Activity b = this.b;
        int[] intArray = null;
        Bundle extras = null;
        Label_0038: {
            if (b != null) {
                final Intent intent = b.getIntent();
                if (intent != null) {
                    extras = intent.getExtras();
                    break Label_0038;
                }
            }
            extras = null;
        }
        if (extras != null) {
            intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        }
        if (intArray != null) {
            return this.m0();
        }
        return this.n0();
    }
    
    public boolean T() {
        boolean u;
        if (this.w().isEmpty()) {
            u = false;
        }
        else {
            final NavDestination a = this.A();
            kotlin.jvm.internal.o.d((Object)a);
            u = this.U(a.p(), true);
        }
        return u;
    }
    
    public boolean U(final int n, final boolean b) {
        return this.V(n, b, false);
    }
    
    public boolean V(final int n, final boolean b, final boolean b2) {
        return this.Y(n, b, b2) && this.r();
    }
    
    public final void W(final NavBackStackEntry navBackStackEntry, final sa.a<ka.r> a) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "popUpTo");
        kotlin.jvm.internal.o.g((Object)a, "onComplete");
        int index = this.w().indexOf((Object)navBackStackEntry);
        if (index < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring pop of ");
            sb.append(navBackStackEntry);
            sb.append(" as it was not found on the current back stack");
            Log.i("NavController", sb.toString());
            return;
        }
        if (++index != ((kotlin.collections.d)this.w()).size()) {
            this.Y(((NavBackStackEntry)this.w().get(index)).f().p(), true, false);
        }
        b0(this, navBackStackEntry, false, null, 6, null);
        a.invoke();
        this.q0();
        this.r();
    }
    
    public final List<NavBackStackEntry> c0() {
        final ArrayList list = new ArrayList();
        final Iterator<Object> iterator = this.x.values().iterator();
        while (iterator.hasNext()) {
            final Iterable iterable = (Iterable)iterator.next().c().getValue();
            final ArrayList list2 = new ArrayList();
            for (final Object next : iterable) {
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)next;
                if (!list.contains(navBackStackEntry) && !navBackStackEntry.h().isAtLeast(Lifecycle.State.STARTED)) {
                    list2.add(next);
                }
            }
            kotlin.collections.o.z((Collection)list, (Iterable)list2);
        }
        final g<NavBackStackEntry> w = this.w();
        final ArrayList list3 = new ArrayList();
        for (final NavBackStackEntry next2 : w) {
            final NavBackStackEntry navBackStackEntry2 = next2;
            if (!list.contains(navBackStackEntry2) && navBackStackEntry2.h().isAtLeast(Lifecycle.State.STARTED)) {
                list3.add(next2);
            }
        }
        kotlin.collections.o.z((Collection)list, (Iterable)list3);
        final ArrayList list4 = new ArrayList();
        for (final Object next3 : list) {
            if (((NavBackStackEntry)next3).f() instanceof NavGraph ^ true) {
                list4.add(next3);
            }
        }
        return list4;
    }
    
    public void d0(final Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.a.getClassLoader());
        this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.n.clear();
        final int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
        final ArrayList stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            for (int length = intArray.length, i = 0, n = 0; i < length; ++i, ++n) {
                this.m.put(intArray[i], (String)stringArrayList.get(n));
            }
        }
        final ArrayList stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (final String s : stringArrayList2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("android-support-nav:controller:backStackStates:");
                sb.append(s);
                final Parcelable[] parcelableArray = bundle.getParcelableArray(sb.toString());
                if (parcelableArray != null) {
                    final Map<String, g<NavBackStackEntryState>> n2 = this.n;
                    kotlin.jvm.internal.o.f((Object)s, "id");
                    final g g = new g(parcelableArray.length);
                    final Iterator a = kotlin.jvm.internal.b.a((Object[])parcelableArray);
                    while (a.hasNext()) {
                        final Parcelable parcelable = a.next();
                        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        g.add((Object)parcelable);
                    }
                    n2.put(s, (g<NavBackStackEntryState>)g);
                }
            }
        }
        this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }
    
    public Bundle f0() {
        final ArrayList list = new ArrayList();
        final Bundle bundle = new Bundle();
        for (final Map.Entry<String, V> entry : this.w.e().entrySet()) {
            final String s = entry.getKey();
            final Bundle i = ((Navigator)entry.getValue()).i();
            if (i != null) {
                list.add(s);
                bundle.putBundle(s, i);
            }
        }
        Bundle bundle2;
        if (list.isEmpty() ^ true) {
            bundle2 = new Bundle();
            bundle.putStringArrayList("android-support-nav:controller:navigatorState:names", list);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle);
        }
        else {
            bundle2 = null;
        }
        Bundle bundle3 = bundle2;
        if (((Collection)this.w()).isEmpty() ^ true) {
            if ((bundle3 = bundle2) == null) {
                bundle3 = new Bundle();
            }
            final Parcelable[] array = new Parcelable[((kotlin.collections.d)this.w()).size()];
            final Iterator<NavBackStackEntry> iterator2 = ((AbstractList<NavBackStackEntry>)this.w()).iterator();
            int n = 0;
            while (iterator2.hasNext()) {
                array[n] = (Parcelable)new NavBackStackEntryState(iterator2.next());
                ++n;
            }
            bundle3.putParcelableArray("android-support-nav:controller:backStack", array);
        }
        Bundle bundle4 = bundle3;
        if (this.m.isEmpty() ^ true) {
            if ((bundle4 = bundle3) == null) {
                bundle4 = new Bundle();
            }
            final int[] array2 = new int[this.m.size()];
            final ArrayList list2 = new ArrayList();
            final Iterator<Map.Entry<Integer, String>> iterator3 = this.m.entrySet().iterator();
            int n2 = 0;
            while (iterator3.hasNext()) {
                final Map.Entry<Number, V> entry2 = (Map.Entry<Number, V>)iterator3.next();
                final int intValue = entry2.getKey().intValue();
                final String s2 = (String)entry2.getValue();
                array2[n2] = intValue;
                list2.add(s2);
                ++n2;
            }
            bundle4.putIntArray("android-support-nav:controller:backStackDestIds", array2);
            bundle4.putStringArrayList("android-support-nav:controller:backStackIds", list2);
        }
        Bundle bundle5 = bundle4;
        if (this.n.isEmpty() ^ true) {
            if ((bundle5 = bundle4) == null) {
                bundle5 = new Bundle();
            }
            final ArrayList list3 = new ArrayList();
            for (final Map.Entry<String, V> entry3 : this.n.entrySet()) {
                final String s3 = entry3.getKey();
                final g g = (g)entry3.getValue();
                list3.add(s3);
                final Parcelable[] array3 = new Parcelable[((kotlin.collections.d)g).size()];
                final Iterator iterator5 = ((Iterable)g).iterator();
                int n3 = 0;
                while (iterator5.hasNext()) {
                    final Object next = iterator5.next();
                    if (n3 < 0) {
                        kotlin.collections.o.t();
                    }
                    array3[n3] = (Parcelable)next;
                    ++n3;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("android-support-nav:controller:backStackStates:");
                sb.append(s3);
                bundle5.putParcelableArray(sb.toString(), array3);
            }
            bundle5.putStringArrayList("android-support-nav:controller:backStackStates", list3);
        }
        Bundle bundle6 = bundle5;
        if (this.g) {
            if ((bundle6 = bundle5) == null) {
                bundle6 = new Bundle();
            }
            bundle6.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle6;
    }
    
    public void g0(final int n) {
        this.i0(this.E().b(n), null);
    }
    
    public void h0(final int n, final Bundle bundle) {
        this.i0(this.E().b(n), bundle);
    }
    
    public void i0(final NavGraph d, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)d, "graph");
        if (!kotlin.jvm.internal.o.b((Object)this.d, (Object)d)) {
            final NavGraph d2 = this.d;
            if (d2 != null) {
                for (final Integer n : new ArrayList(this.m.keySet())) {
                    kotlin.jvm.internal.o.f((Object)n, "id");
                    this.p(n);
                }
                Z(this, d2.p(), true, false, 4, null);
            }
            this.d = d;
            this.S(bundle);
        }
        else {
            for (int q = d.J().q(), i = 0; i < q; ++i) {
                final NavDestination navDestination = d.J().r(i);
                final NavGraph d3 = this.d;
                kotlin.jvm.internal.o.d((Object)d3);
                d3.J().p(i, navDestination);
                final g<NavBackStackEntry> w = this.w();
                final ArrayList list = new ArrayList();
                for (final NavBackStackEntry next : w) {
                    final NavBackStackEntry navBackStackEntry = next;
                    if (navDestination != null && navBackStackEntry.f().p() == navDestination.p()) {
                        list.add(next);
                    }
                }
                for (final NavBackStackEntry navBackStackEntry2 : list) {
                    kotlin.jvm.internal.o.f((Object)navDestination, "newDestination");
                    navBackStackEntry2.l(navDestination);
                }
            }
        }
    }
    
    public void j0(final r o) {
        o.g((Object)o, "owner");
        if (o.b((Object)o, (Object)this.o)) {
            return;
        }
        final r o2 = this.o;
        if (o2 != null) {
            final Lifecycle lifecycle = o2.getLifecycle();
            if (lifecycle != null) {
                lifecycle.c(this.t);
            }
        }
        this.o = o;
        o.getLifecycle().a(this.t);
    }
    
    public void k0(final OnBackPressedDispatcher p) {
        kotlin.jvm.internal.o.g((Object)p, "dispatcher");
        if (kotlin.jvm.internal.o.b((Object)p, (Object)this.p)) {
            return;
        }
        final r o = this.o;
        if (o != null) {
            this.u.remove();
            (this.p = p).b(o, this.u);
            final Lifecycle lifecycle = o.getLifecycle();
            lifecycle.c(this.t);
            lifecycle.a(this.t);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
    }
    
    public void l0(final q0 q0) {
        kotlin.jvm.internal.o.g((Object)q0, "viewModelStore");
        final androidx.navigation.j q2 = this.q;
        final androidx.navigation.j.b b = androidx.navigation.j.b;
        if (kotlin.jvm.internal.o.b((Object)q2, (Object)b.a(q0))) {
            return;
        }
        if (this.w().isEmpty()) {
            this.q = b.a(q0);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
    }
    
    public final NavBackStackEntry o0(final NavBackStackEntry navBackStackEntry) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "child");
        final NavBackStackEntry navBackStackEntry2 = this.k.remove(navBackStackEntry);
        Integer value = null;
        if (navBackStackEntry2 == null) {
            return null;
        }
        final AtomicInteger atomicInteger = this.l.get(navBackStackEntry2);
        if (atomicInteger != null) {
            value = atomicInteger.decrementAndGet();
        }
        if (value != null) {
            if (value == 0) {
                final NavControllerNavigatorState navControllerNavigatorState = this.x.get(this.w.d(navBackStackEntry2.f().q()));
                if (navControllerNavigatorState != null) {
                    navControllerNavigatorState.e(navBackStackEntry2);
                }
                this.l.remove(navBackStackEntry2);
            }
        }
        return navBackStackEntry2;
    }
    
    public final void p0() {
        final List p0 = kotlin.collections.o.P0((Collection)this.w());
        if (p0.isEmpty()) {
            return;
        }
        NavDestination navDestination = ((NavBackStackEntry)kotlin.collections.o.n0(p0)).f();
        NavDestination navDestination2 = null;
        Label_0096: {
            if (navDestination instanceof androidx.navigation.c) {
                final Iterator iterator = kotlin.collections.o.z0((Iterable)p0).iterator();
                while (iterator.hasNext()) {
                    navDestination2 = ((NavBackStackEntry)iterator.next()).f();
                    if (!(navDestination2 instanceof NavGraph) && !(navDestination2 instanceof androidx.navigation.c)) {
                        break Label_0096;
                    }
                }
            }
            navDestination2 = null;
        }
        final HashMap<NavBackStackEntry, Lifecycle.State> hashMap = new HashMap<NavBackStackEntry, Lifecycle.State>();
        for (final NavBackStackEntry navBackStackEntry : kotlin.collections.o.z0((Iterable)p0)) {
            final Lifecycle.State h = navBackStackEntry.h();
            final NavDestination f = navBackStackEntry.f();
            if (navDestination != null && f.p() == navDestination.p()) {
                final Lifecycle.State resumed = Lifecycle.State.RESUMED;
                Label_0350: {
                    if (h != resumed) {
                        final NavControllerNavigatorState navControllerNavigatorState = this.x.get(this.F().d(navBackStackEntry.f().q()));
                        Boolean value = null;
                        Label_0270: {
                            if (navControllerNavigatorState != null) {
                                final s<Set<NavBackStackEntry>> c = navControllerNavigatorState.c();
                                if (c != null) {
                                    final Set set = (Set)c.getValue();
                                    if (set != null) {
                                        value = set.contains(navBackStackEntry);
                                        break Label_0270;
                                    }
                                }
                            }
                            value = null;
                        }
                        if (!kotlin.jvm.internal.o.b((Object)value, (Object)Boolean.TRUE)) {
                            final AtomicInteger atomicInteger = this.l.get(navBackStackEntry);
                            int n = 0;
                            if (atomicInteger != null) {
                                n = n;
                                if (atomicInteger.get() == 0) {
                                    n = 1;
                                }
                            }
                            if (n == 0) {
                                hashMap.put(navBackStackEntry, resumed);
                                break Label_0350;
                            }
                        }
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    }
                }
                navDestination = navDestination.s();
            }
            else if (navDestination2 != null && f.p() == navDestination2.p()) {
                if (h == Lifecycle.State.RESUMED) {
                    navBackStackEntry.m(Lifecycle.State.STARTED);
                }
                else {
                    final Lifecycle.State started = Lifecycle.State.STARTED;
                    if (h != started) {
                        hashMap.put(navBackStackEntry, started);
                    }
                }
                navDestination2 = navDestination2.s();
            }
            else {
                navBackStackEntry.m(Lifecycle.State.CREATED);
            }
        }
        for (final NavBackStackEntry navBackStackEntry2 : p0) {
            final Lifecycle.State state = hashMap.get(navBackStackEntry2);
            if (state != null) {
                navBackStackEntry2.m(state);
            }
            else {
                navBackStackEntry2.n();
            }
        }
    }
    
    public androidx.navigation.k q() {
        return new androidx.navigation.k(this);
    }
    
    public void s(final boolean v) {
        this.v = v;
        this.q0();
    }
    
    public final NavDestination t(final int n) {
        final NavGraph d = this.d;
        if (d == null) {
            return null;
        }
        kotlin.jvm.internal.o.d((Object)d);
        if (d.p() == n) {
            return this.d;
        }
        final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)this.w().m();
        NavDestination navDestination;
        if (navBackStackEntry == null || (navDestination = navBackStackEntry.f()) == null) {
            navDestination = this.d;
            kotlin.jvm.internal.o.d((Object)navDestination);
        }
        return this.u(navDestination, n);
    }
    
    public g<NavBackStackEntry> w() {
        return this.h;
    }
    
    public NavBackStackEntry x(final int n) {
        final g<NavBackStackEntry> w = this.w();
        final ListIterator<NavBackStackEntry> listIterator = ((List<NavBackStackEntry>)w).listIterator(((List)w).size());
        while (true) {
            while (listIterator.hasPrevious()) {
                final NavBackStackEntry previous = listIterator.previous();
                if (previous.f().p() == n) {
                    final NavBackStackEntry navBackStackEntry = previous;
                    if (navBackStackEntry != null) {
                        return navBackStackEntry;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("No destination with ID ");
                    sb.append(n);
                    sb.append(" is on the NavController's back stack. The current destination is ");
                    sb.append(this.A());
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
            final NavBackStackEntry previous = null;
            continue;
        }
    }
    
    public final Context y() {
        return this.a;
    }
    
    public NavBackStackEntry z() {
        return (NavBackStackEntry)this.w().m();
    }
    
    @Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u001f\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00128\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019" }, d2 = { "Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/w;", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "Lka/r;", "h", "k", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "a", "popUpTo", "", "saveState", "g", "entry", "e", "Landroidx/navigation/Navigator;", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigator", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    private final class NavControllerNavigatorState extends w
    {
        private final Navigator<? extends NavDestination> g;
        final NavController h;
        
        public NavControllerNavigatorState(final NavController h, final Navigator<? extends NavDestination> g) {
            kotlin.jvm.internal.o.g((Object)g, "navigator");
            this.h = h;
            this.g = g;
        }
        
        public static final void j(final NavControllerNavigatorState navControllerNavigatorState, final NavBackStackEntry navBackStackEntry, final boolean b) {
            navControllerNavigatorState.g(navBackStackEntry, b);
        }
        
        @Override
        public NavBackStackEntry a(final NavDestination navDestination, final Bundle bundle) {
            kotlin.jvm.internal.o.g((Object)navDestination, "destination");
            return NavBackStackEntry.a.b(NavBackStackEntry.y, this.h.y(), navDestination, bundle, this.h.D(), NavController.j(this.h), null, null, 96, null);
        }
        
        @Override
        public void e(final NavBackStackEntry navBackStackEntry) {
            kotlin.jvm.internal.o.g((Object)navBackStackEntry, "entry");
            final boolean b = kotlin.jvm.internal.o.b(NavController.f(this.h).get(navBackStackEntry), (Object)Boolean.TRUE);
            super.e(navBackStackEntry);
            NavController.f(this.h).remove(navBackStackEntry);
            if (!this.h.w().contains((Object)navBackStackEntry)) {
                this.h.o0(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.m(Lifecycle.State.DESTROYED);
                }
                final g<NavBackStackEntry> w = this.h.w();
                final boolean b2 = w instanceof Collection;
                final int n = 1;
                int n2 = 0;
                Label_0176: {
                    if (b2 && ((Collection)w).isEmpty()) {
                        n2 = n;
                    }
                    else {
                        final Iterator<NavBackStackEntry> iterator = ((Iterable<NavBackStackEntry>)w).iterator();
                        do {
                            n2 = n;
                            if (iterator.hasNext()) {
                                continue;
                            }
                            break Label_0176;
                        } while (!kotlin.jvm.internal.o.b((Object)iterator.next().g(), (Object)navBackStackEntry.g()));
                        n2 = 0;
                    }
                }
                if (n2 != 0 && !b) {
                    final androidx.navigation.j j = NavController.j(this.h);
                    if (j != null) {
                        j.j(navBackStackEntry.g());
                    }
                }
                this.h.p0();
                ((h)NavController.l(this.h)).a((Object)this.h.c0());
            }
            else if (!this.d()) {
                this.h.p0();
                ((h)NavController.l(this.h)).a((Object)this.h.c0());
            }
        }
        
        @Override
        public void g(final NavBackStackEntry navBackStackEntry, final boolean b) {
            kotlin.jvm.internal.o.g((Object)navBackStackEntry, "popUpTo");
            final Navigator d = NavController.k(this.h).d(navBackStackEntry.f().q());
            if (kotlin.jvm.internal.o.b((Object)d, (Object)this.g)) {
                final l i = NavController.i(this.h);
                if (i != null) {
                    i.invoke((Object)navBackStackEntry);
                    super.g(navBackStackEntry, b);
                }
                else {
                    this.h.W(navBackStackEntry, (sa.a<ka.r>)new NavController$NavControllerNavigatorState$pop.NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, b));
                }
            }
            else {
                final Object value = NavController.h(this.h).get(d);
                kotlin.jvm.internal.o.d(value);
                ((NavControllerNavigatorState)value).g(navBackStackEntry, b);
            }
        }
        
        @Override
        public void h(final NavBackStackEntry navBackStackEntry) {
            kotlin.jvm.internal.o.g((Object)navBackStackEntry, "backStackEntry");
            final Navigator d = NavController.k(this.h).d(navBackStackEntry.f().q());
            if (kotlin.jvm.internal.o.b((Object)d, (Object)this.g)) {
                final l c = NavController.c(this.h);
                if (c != null) {
                    c.invoke((Object)navBackStackEntry);
                    this.k(navBackStackEntry);
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring add of destination ");
                    sb.append(navBackStackEntry.f());
                    sb.append(" outside of the call to navigate(). ");
                    Log.i("NavController", sb.toString());
                }
            }
            else {
                final Object value = NavController.h(this.h).get(d);
                if (value == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("NavigatorBackStack for ");
                    sb2.append(navBackStackEntry.f().q());
                    sb2.append(" should already be created");
                    throw new IllegalStateException(sb2.toString().toString());
                }
                ((NavControllerNavigatorState)value).h(navBackStackEntry);
            }
        }
        
        public final void k(final NavBackStackEntry navBackStackEntry) {
            kotlin.jvm.internal.o.g((Object)navBackStackEntry, "backStackEntry");
            super.h(navBackStackEntry);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\n\u0010\u0004\u0012\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017" }, d2 = { "Landroidx/navigation/NavController$a;", "", "", "KEY_BACK_STACK", "Ljava/lang/String;", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "()V", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "", "deepLinkSaveState", "Z", "<init>", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final kotlin.jvm.internal.i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n" }, d2 = { "Landroidx/navigation/NavController$b;", "", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "Lka/r;", "a", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    public interface b
    {
        void a(final NavController p0, final NavDestination p1, final Bundle p2);
    }
}
