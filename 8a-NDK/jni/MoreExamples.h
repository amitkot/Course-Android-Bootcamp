/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_amitkot_android_ndk_example_ExamplesActivity */

#ifndef _Included_com_amitkot_android_ndk_example_ExamplesActivity
#define _Included_com_amitkot_android_ndk_example_ExamplesActivity
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_amitkot_android_ndk_example_ExamplesActivity
 * Method:    concatenate
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_concatenate
  (JNIEnv *, jobject, jstring, jstring);

/*
 * Class:     com_amitkot_android_ndk_example_ExamplesActivity
 * Method:    sum
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_sum
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_amitkot_android_ndk_example_ExamplesActivity
 * Method:    sumArray
 * Signature: ([I)I
 */
JNIEXPORT jint JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_sumArray
  (JNIEnv *, jobject, jintArray);

/*
 * Class:     com_amitkot_android_ndk_example_ExamplesActivity
 * Method:    processAnimal
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_processAnimal
  (JNIEnv *, jobject);

/*
 * Class:     com_amitkot_android_ndk_example_ExamplesActivity
 * Method:    nativeShowAnimalAsToast
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_nativeShowAnimalAsToast
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
