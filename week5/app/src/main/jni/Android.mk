LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := jniExample
LOCAL_SRC_FILES := jniMain.cpp

include $(BUILD_SHARED_LIBRARY)

LOCAL_EXPORT_C_INCLUDE_DIRS := $(LOCAL_PATH)/com_example_week5_JNIClass.h