package modchu.model;

import modchu.lib.Modchu_ITexturedQuad;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.recompileonly.Modchu_TexturedQuad;

public class ModchuModel_TexturedQuadMaster implements Modchu_ITexturedQuad {
	public Modchu_TexturedQuad base;
	public boolean invertNormal;
	private Object[] vertexPositions;

	public ModchuModel_TexturedQuadMaster(Modchu_TexturedQuad baseTexturedQuad, Object[] arrayOfPositionTextureVertex, Object... o) {
		base = baseTexturedQuad;
		vertexPositions = arrayOfPositionTextureVertex;
	}

	@Override
	public void flipFace() {
		Object[] apositiontexturevertex = new Object[vertexPositions.length];
		for (int i = 0; i < vertexPositions.length; ++i) {
			apositiontexturevertex[i] = vertexPositions[vertexPositions.length - i - 1];
		}
		vertexPositions = apositiontexturevertex;
	}

	@Override
	public void draw(Object tessellator, float f) {
		Object vec3_1 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[1]);
		Object vec3_0 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[0]));
		Object vec3_2 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[2]));
		Object vec3_3 = Modchu_AS.get(Modchu_AS.vec3Normalize, Modchu_AS.get(Modchu_AS.vec3CrossProduct, vec3_2, vec3_0));
		Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);

		if (invertNormal) {
			Modchu_AS.set(Modchu_AS.tessellatorSetNormal, tessellator, -(float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3_3), -(float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3_3), -(float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3_3));
		} else {
			Modchu_AS.set(Modchu_AS.tessellatorSetNormal, tessellator, (float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3_3), (float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3_3), (float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3_3));
		}

		for (int i = 0; i < 4; ++i) {
			Object vertexPosition = vertexPositions[i];
			Object vertexPositionVec3 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPosition);
			Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vertexPositionVec3)) * f), (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vertexPositionVec3)) * f), (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vertexPositionVec3)) * f), (double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionX, vertexPosition), (double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionY, vertexPosition));
		}

		Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
	}

	@Override
	public void setInvertNormal(boolean b) {
		invertNormal = b;
	}

}