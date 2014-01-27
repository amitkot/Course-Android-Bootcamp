#include "Example.h"

JNIEXPORT jstring JNICALL Java_com_amitkot_android_ndk_example_MainNDKActivity_messageFromNativeCode(
		JNIEnv * env, jobject jObj) {
	return env->NewStringUTF("Hello World!");
}

