package modchu.model;

import modchu.lib.Modchu_ITexturedTriangle;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_TexturedTriangle;

import org.lwjgl.opengl.GL11;

public class ModchuModel_TexturedTriangleMaster implements Modchu_ITexturedTriangle {
	public Modchu_TexturedTriangle base;

	public Object[] vertexPositions;
	public int nVertices;
	public float[][] vn;
	private boolean invertNormal;
	public int red;
	public int green;
	public int blue;
	public int alpha;
	private boolean setColor;

	public ModchuModel_TexturedTriangleMaster(Modchu_TexturedTriangle baseTexturedTriangle, Object... o) {
		if (o != null) ;else return;
		base = baseTexturedTriangle;
		if (o.length > 1) {
			init((Object[])o[0], (float[][])o[1], (float[][])o[2], (float[]) o[3], (Float)o[4], (Float)o[5]);
		} else {
			nVertices = 0;
			invertNormal = false;
			vertexPositions = (Object[]) o[0];
			nVertices = vertexPositions.length;
		}
	}

	public void init(Object[] positionTextureVertex, float[][] var2, float[][] var3, float[] var4, float var5, float var6) {
		if (var4 != null) {
			red = (int) (255.0F * var4[0]);
			green = (int) (255.0F * var4[1]);
			blue = (int) (255.0F * var4[2]);
			alpha = (int) (255.0F * var4[3] * 0.5F);
			setColor = true;
		} else {
			red = 255;
			green = 255;
			blue = 255;
			alpha = 255;
			setColor = false;
		}

		if (var5 == 0.0F && var6 == 0.0F) {
			var6 = 1.0F;
			var5 = 1.0F;
		}

		nVertices = positionTextureVertex.length;

		for (int i = 0; i < nVertices; ++i) {
			positionTextureVertex[i] = Modchu_AS.get(Modchu_AS.positionTextureVertexSetTexturePosition, positionTextureVertex[i], var2[i][0] / var5, var2[i][1] / var6);
		}
		vertexPositions = positionTextureVertex;

		vn = var3;
	}

	@Override
	public void flipFace() {
		Object[] o = new Object[vertexPositions.length];
		for (int var2 = 0; var2 < vertexPositions.length; ++var2) {
			o[var2] = vertexPositions[vertexPositions.length - var2 - 1];
		}
		vertexPositions = o;
	}

	@Override
	public void draw(Object tessellator, float f) {
		tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		Object[] vec3 = Modchu_Reflect.newInstanceArray("Vec3", nVertices);
		int i;

		if (vn == null) {
			Object vec3_1 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[1]);
			Object vec3_0 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[0]));
			Object vec3_2 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[2]));

			for (i = 0; i < nVertices; ++i) {
				vec3[i] = Modchu_AS.get(Modchu_AS.vec3Normalize, Modchu_AS.get(Modchu_AS.vec3CrossProduct, vec3_2, vec3_0));
			}
		} else {
			for (i = 0; i < nVertices; ++i) {
				vec3[i] = Modchu_AS.get(Modchu_AS.vec3CreateVectorHelper, (double) vn[i][0], (double) vn[i][1], (double) vn[i][2]);
			}
		}

		i = GL11.glGetInteger(GL11.GL_CURRENT_COLOR);
		boolean b;

		if ((i & 255) == 102) {
			b = false;
		} else {
			b = true;
		}

		GL11.glShadeModel(GL11.GL_SMOOTH);
		byte by = 6;

		if (nVertices % 4 == 0) {
			by = 7;
		}

		Modchu_AS.set(Modchu_AS.tessellatorStartDrawing, tessellator, by);

		for (int i1 = 0; i1 < nVertices; ++i1) {
			if (invertNormal) {
				Modchu_AS.set(Modchu_AS.tessellatorSetNormal, tessellator, -(float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3[i1]), -(float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3[i1]), -(float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3[i1]));
			} else {
				Modchu_AS.set(Modchu_AS.tessellatorSetNormal, tessellator, (float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3[i1]), (float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3[i1]), (float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3[i1]));
			}

			Object vertexPosition = vertexPositions[i1];
			Object vertexPositionVec3 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPosition);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator,
					(double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vertexPositionVec3)) * f),
					(double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vertexPositionVec3)) * f),
					(double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vertexPositionVec3)) * f),
					(double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionX, vertexPosition),
					(double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionY, vertexPosition));
		}

		Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
	}

}