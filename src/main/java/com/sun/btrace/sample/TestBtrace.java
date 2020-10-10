package com.sun.btrace.sample;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.TLS;
import com.sun.btrace.annotations.TargetMethodOrField;

/**
 * Created by weiyongjun on 2019/11/15
 */
@BTrace
public class TestBtrace {

    @TLS
    static long startTime;

    @OnMethod(clazz = "com.nets.elephant.video.service.VideoService", method = "getVideoByVid")
    public static void lineCall(@TargetMethodOrField String method,
            @ProbeClassName String probeClass, @ProbeMethodName String methodName) {
        println(method + "--" + probeClass + "---" + methodName);

    }
}
