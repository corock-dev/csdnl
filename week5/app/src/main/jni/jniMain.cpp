//
// Created by corock on 2020-04-17.
//
# include "com_example_week5_JNIClass.h"

JNIEXPORT jstring JNICALL java_com_example_week5_cs_android_jnitest_JNIClass_getNumString
    (JNIEnv * a, jobject b, jstring str, jint num)
    {
        jclass cls = a->GetObjectClass(b);
        jmethodID func = a->GetMethodID(cls, "callback", "(Ljava/lang/String;l)Ljava/lang/String;");
        return (jstring)a->CallObjectMethod(b, func, str, num);
    }
