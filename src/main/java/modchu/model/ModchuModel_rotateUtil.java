package modchu.model;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class ModchuModel_rotateUtil {

	//pool
	public static Matrix4f mat = new Matrix4f();
	public static Vector3f vec = new Vector3f();
	public static Quaternion qt = new Quaternion();

	/**
	 *
	 * @param offsetX 移動させたいオフセット
	 * @param offsetY
	 * @param offsetZ
	 * @param rotPosX 回転中心のオフセット
	 * @param rotPosY
	 * @param rotPosZ
	 * @param pitch rotationAngleX 回転量 これはそのままrotationAngle使います
	 * @param yaw   rotationAngleY
	 * @param roll  rotationAngleZ
	 * @param result 実際のrotationPoint これをrotationPointとして使います
	 * @return 
	 */
	public static void setRotation(float offsetX, float offsetY, float offsetZ, float rotPosX, float rotPosY, float rotPosZ, float pitch, float yaw, float roll, Vector3f result) {
		mat.setIdentity();
		vec.set(-rotPosX, -rotPosY, -rotPosZ);
		mat.translate(vec);
		RotationYawPitchRoll(yaw, pitch, roll, mat);
		vec.set(offsetX, offsetY, offsetZ);
		mat.translate(vec);
		result.x = mat.m30 / mat.m33;
		result.y = mat.m31 / mat.m33;
		result.y = mat.m32 / mat.m33;
	}

	public static void RotationYawPitchRoll(float yaw, float pitch, float roll, Matrix4f result) {
		Quaternion quaternion = qt;
		RotationYawPitchRoll(yaw, pitch, roll, quaternion);
		RotationQuaternion(quaternion, result);
	}

	public static void RotationQuaternion(Quaternion rotation, Matrix4f result) {
		double x = rotation.x;
		float xx = (float) (x * x);
		double y = rotation.y;
		float yy = (float) (y * y);
		double z = rotation.z;
		float zz = (float) (z * z);
		float xy = rotation.y * rotation.x;
		float zw = rotation.w * rotation.z;
		float zx = rotation.z * rotation.x;
		float yw = rotation.w * rotation.y;
		float yz = rotation.z * rotation.y;
		float xw = rotation.w * rotation.x;
		result.m00 = (float) (1.0 - ((zz + yy) * 2.0));
		result.m01 = (float) ((zw + xy) * 2.0);
		result.m02 = (float) ((zx - yw) * 2.0);
		result.m03 = 0f;
		result.m10 = (float) ((xy - zw) * 2.0);
		result.m11 = (float) (1.0 - ((zz + xx) * 2.0));
		result.m12 = (float) ((xw + yz) * 2.0);
		result.m13 = 0f;
		result.m20 = (float) ((yw + zx) * 2.0);
		result.m21 = (float) ((yz - xw) * 2.0);
		result.m22 = (float) (1.0 - ((yy + xx) * 2.0));
		result.m23 = 0f;
		result.m30 = 0f;
		result.m31 = 0f;
		result.m32 = 0f;
		result.m33 = 1f;
	}

	public static void RotationYawPitchRoll(float yaw, float pitch, float roll, Quaternion result) {
		float halfRoll = roll * 0.5f;
		float sinRoll = (float) Math.sin((double) halfRoll);
		float cosRoll = (float) Math.cos((double) halfRoll);
		float halfPitch = pitch * 0.5f;
		float sinPitch = (float) Math.sin((double) halfPitch);
		float cosPitch = (float) Math.cos((double) halfPitch);
		float halfYaw = yaw * 0.5f;
		float sinYaw = (float) Math.sin((double) halfYaw);
		float cosYaw = (float) Math.cos((double) halfYaw);
		double num4 = cosYaw * sinPitch;
		double num3 = sinYaw * cosPitch;
		result.x = (float) ((sinRoll * num3) + (cosRoll * num4));
		result.y = (float) ((cosRoll * num3) - (sinRoll * num4));
		double num2 = cosYaw * cosPitch;
		double num = sinYaw * sinPitch;
		result.z = (float) ((sinRoll * num2) - (cosRoll * num));
		result.w = (float) ((sinRoll * num) + (cosRoll * num2));
	}
}