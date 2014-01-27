LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Example
LOCAL_SRC_FILES := Example.cpp

include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE    := MoreExamples
LOCAL_SRC_FILES := MoreExamples.cpp

include $(BUILD_SHARED_LIBRARY)

