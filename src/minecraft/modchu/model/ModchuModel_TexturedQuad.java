package modchu.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;

public class ModchuModel_TexturedQuad extends TexturedQuad {

	public boolean invertNormal;

	public ModchuModel_TexturedQuad(PositionTextureVertex[] par1ArrayOfPositionTextureVertex) {
		super(par1ArrayOfPositionTextureVertex);
	}

	public ModchuModel_TexturedQuad(PositionTextureVertex[] par1ArrayOfPositionTextureVertex, int par2, int par3, int par4, int par5, float par6, float par7) {
		super(par1ArrayOfPositionTextureVertex, par2, par3, par4, par5, par6, par7);
	}

	public void draw(Tessellator par1Tessellator, float par2) {
		Vec3 vec3 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[0].vector3D);
		Vec3 vec31 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[2].vector3D);
		Vec3 vec32 = vec31.crossProduct(vec3).normalize();
		par1Tessellator.startDrawingQuads();

		if (invertNormal) {
			par1Tessellator.setNormal(-((float) vec32.xCoord), -((float) vec32.yCoord), -((float) vec32.zCoord));
		} else {
			par1Tessellator.setNormal((float) vec32.xCoord, (float) vec32.yCoord, (float) vec32.zCoord);
		}

		for (int i = 0; i < 4; ++i) {
			PositionTextureVertex positiontexturevertex = this.vertexPositions[i];
			par1Tessellator.addVertexWithUV((double) ((float) positiontexturevertex.vector3D.xCoord * par2), (double) ((float) positiontexturevertex.vector3D.yCoord * par2), (double) ((float) positiontexturevertex.vector3D.zCoord * par2), (double) positiontexturevertex.texturePositionX, (double) positiontexturevertex.texturePositionY);
		}

		par1Tessellator.draw();
	}

}
