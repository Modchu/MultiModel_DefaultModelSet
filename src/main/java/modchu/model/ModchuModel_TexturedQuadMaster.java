package modchu.model;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ITexturedQuad;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_TexturedQuad;

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
		Object[] apositiontexturevertex = Modchu_Reflect.newInstanceArray("PositionTextureVertex", vertexPositions.length);
		for (int i = 0; i < vertexPositions.length; ++i) {
			apositiontexturevertex[i] = vertexPositions[vertexPositions.length - i - 1];
		}
		vertexPositions = apositiontexturevertex;
	}

	@Override
	public void draw(Object worldRendererOrTessellator, float f) {
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster draw tessellator="+tessellator+" f="+f);
		worldRendererOrTessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		if (vertexPositions != null
				&& vertexPositions.length > 0);
		else {
			Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster vertexPositions="+vertexPositions);
			return;
		}
		Object vec3_1 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[1]);
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster draw vec3_1="+vec3_1);
		Object vec3_0 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[0]));
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster draw vec3_0="+vec3_0);
		Object vec3_2 = Modchu_AS.get(Modchu_AS.vec3Subtract, vec3_1, Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPositions[2]));
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster draw vec3_2="+vec3_2);
		Object vec3_3 = Modchu_AS.get(Modchu_AS.vec3Normalize, Modchu_AS.get(Modchu_AS.vec3CrossProduct, vec3_2, vec3_0));
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster draw vec3_3="+vec3_3);
		Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, worldRendererOrTessellator);

		if (invertNormal) {
			Modchu_AS.set(Modchu_AS.tessellatorSetNormal, worldRendererOrTessellator, -(float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3_3), -(float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3_3), -(float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3_3));
		} else {
			Modchu_AS.set(Modchu_AS.tessellatorSetNormal, worldRendererOrTessellator, (float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3_3), (float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3_3), (float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3_3));
		}

		for (Object vertexPosition : vertexPositions) {
			Object vertexPositionVec3 = Modchu_AS.get(Modchu_AS.positionTextureVertexVector3D, vertexPosition);
			boolean b = Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, worldRendererOrTessellator, (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vertexPositionVec3)) * f), (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vertexPositionVec3)) * f), (double) (((float) Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vertexPositionVec3)) * f), (double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionX, vertexPosition), (double) Modchu_AS.getFloat(Modchu_AS.positionTextureVertexTexturePositionY, vertexPosition));
		}
		Modchu_AS.set(Modchu_AS.tessellatorDraw, worldRendererOrTessellator);
		//Modchu_Debug.mDebug("ModchuModel_TexturedQuadMaster end");
	}

	@Override
	public void setInvertNormal(boolean b) {
		invertNormal = b;
	}

}