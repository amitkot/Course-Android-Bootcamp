#include <stddef.h>
#include <string.h>

#include "MoreExamples.h"

using namespace std;

JNIEXPORT jstring JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_concatenate(
		JNIEnv * env, jobject obj, jstring jFirst, jstring jSecond) {
	// Convert to local types
	const char * first = env->GetStringUTFChars(jFirst, NULL);
	if (NULL == first)
		return NULL;
	const char * second = env->GetStringUTFChars(jSecond, NULL);
	if (NULL == second)
		return NULL;

	// Use local types
	int len = strlen(first) + strlen(second) + 1;
	char res[len];
	strcpy(res, first);
	strcat(res, second);

	// Release local type objects
	env->ReleaseStringUTFChars(jFirst, first);
	env->ReleaseStringUTFChars(jSecond, second);

	// Convert result to JNI type
	jstring result = env->NewStringUTF(res);

	// return result
	return result;
}

JNIEXPORT jint JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_sum(
		JNIEnv * env, jobject obj, jint first, jint second) {
	jint res = first + second;
	return res;
}

JNIEXPORT jint JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_sumArray(
		JNIEnv * env, jobject obj, jintArray array) {
	// Convert to local type array
	jint *cArray = env->GetIntArrayElements(array, NULL);
	if (NULL == cArray)
		return NULL;
	jsize len = env->GetArrayLength(array);

	// Use local type array
	jint sum = 0;
	for (int i = 0; i < len; i++) {
		sum += cArray[i];
	}
	// Release local type array when possible
	env->ReleaseIntArrayElements(array, cArray, NULL);

	// return result
	return sum;
}

JNIEXPORT void JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_processAnimal(
		JNIEnv * env, jobject obj) {
	// get class object
	jclass thisClass = env->GetObjectClass(obj);

	// get the field id
	jfieldID fieldId = env->GetFieldID(thisClass, "mSecretAnimal",
			"Ljava/lang/String;");
	if (NULL == fieldId) return;

	// get the object field
	jobject data = env->GetObjectField(obj, fieldId);
	jstring jStr = reinterpret_cast<jstring>(data);

	// convert string object field to native type
	const char * cStr = env->GetStringUTFChars(jStr, NULL);
	if (NULL == cStr) return;
	int len = strlen(cStr);
	char res[len + 1];
	for (int i = 0; i < len; i++) {
		res[i] = cStr[len - 1 - i];
	}
	res[len] = '\0';
	env->ReleaseStringUTFChars(jStr, cStr);

	// convert result to JNI return type
	jstring result = env->NewStringUTF(res);

	// store result back in data member
	env->SetObjectField(obj, fieldId, result);
}

JNIEXPORT void JNICALL Java_com_amitkot_android_ndk_example_ExamplesActivity_nativeShowAnimalAsToast(
		JNIEnv * env, jobject obj) {
	// get class object
	jclass thisClass = env->GetObjectClass(obj);

	// get the field id
	jfieldID fieldId = env->GetFieldID(thisClass, "mSecretAnimal",
			"Ljava/lang/String;");
	if (NULL == fieldId) return;

	// get the object field
	jobject data = env->GetObjectField(obj, fieldId);
	jstring jStr = reinterpret_cast<jstring>(data);

	// extract method id
	jmethodID methodId = env->GetMethodID(thisClass, "showToast", "(Ljava/lang/String;)V");
	if (NULL == methodId) return;

	// Call classes' member function
	env->CallVoidMethod(obj, methodId, jStr);
}

