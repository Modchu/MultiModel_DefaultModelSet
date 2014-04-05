package modchu.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class ModchuModel_RenderEngine {
	public static ModchuModel_RenderEngine instance;
	private static final int displayListsNumber = 2;
	private HashMap<String, Integer> textureMap = new HashMap();
	private BufferedImage missingTextureImage = new BufferedImage(64, 64, 2);
	private IntBuffer imageData = Modchu_AS.getIntBuffer(Modchu_AS.glAllocationCreateDirectIntBuffer, 4194304);
	//private int boundTexture;
	public boolean anaglyph = false;

	public ModchuModel_RenderEngine() {
		instance = this;
		Graphics graphics = missingTextureImage.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 64, 64);
	}

	public void bindTexture(Object o) {
		if (o instanceof String) bindTexture((String)o);
		bindTexture(getResourceLocationString(o));
	}

	public void bindTexture(String s) {
		bindTexture(getTexture(s));
	}

	public void bindBufferedImage(String s, BufferedImage image) {
		if (s != null
				&& image != null) ;else return;
		int generateDisplayList = Modchu_AS.getInt(Modchu_AS.glAllocationGenerateDisplayLists, displayListsNumber);
		setupTextureExt(image, generateDisplayList, false, false);
		textureMap.put(s, generateDisplayList);
		bindTexture(generateDisplayList);
	}

	private void bindTexture(int i) {
		//if (i != boundTexture) {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, i);
			//boundTexture = i;
		//}
	}

	public int getTexture(String s) {
		int i = textureMap.containsKey(s) ? textureMap.get(s) : -1;

		if (i > -1) {
			return i;
		} else {
			String s0 = s;
			int generateDisplayList = Modchu_AS.getInt(Modchu_AS.glAllocationGenerateDisplayLists, displayListsNumber);
			try {
				boolean var9 = s0.startsWith("%blur%");
				if (var9) s0 = s0.substring(6);
				boolean var6 = s0.startsWith("%clamp%");
				if (var6) s0 = s0.substring(7);

				InputStream inputStream = getClass().getResourceAsStream(s0);
				if (inputStream == null) {
					setupTextureExt(missingTextureImage, generateDisplayList, var9, var6);
				} else {
					setupTextureExt(readTextureImage(inputStream), generateDisplayList, var9, var6);
				}
				textureMap.put(s, generateDisplayList);
			} catch (Exception e) {
				e.printStackTrace();
				setupTexture(missingTextureImage, generateDisplayList);
				textureMap.put(s, generateDisplayList);
			}
			return generateDisplayList;
		}
	}

	private BufferedImage readTextureImage(InputStream inputStream) throws IOException {
		BufferedImage image = ImageIO.read(inputStream);
		inputStream.close();
		return image;
	}

	public void setupTexture(BufferedImage par1BufferedImage, int par2) {
		setupTextureExt(par1BufferedImage, par2, false, false);
	}

	public void setupTextureExt(BufferedImage par1BufferedImage, int par2, boolean par3, boolean par4) {
		bindTexture(par2);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		if (par3) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		}

		if (par4) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		} else {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
		}

		int var5 = par1BufferedImage.getWidth();
		int var6 = par1BufferedImage.getHeight();
		int[] var7 = new int[var5 * var6];
		par1BufferedImage.getRGB(0, 0, var5, var6, var7, 0, var5);

		if (anaglyph) {
			var7 = colorToAnaglyph(var7);
		}

		imageData.clear();
		imageData.put(var7);
		imageData.position(0).limit(var7.length);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, var5, var6, 0, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, imageData);
	}

	private int[] colorToAnaglyph(int[] par1ArrayOfInteger) {
		int[] var2 = new int[par1ArrayOfInteger.length];

		for (int var3 = 0; var3 < par1ArrayOfInteger.length; ++var3) {
			int var4 = par1ArrayOfInteger[var3] >> 24 & 255;
			int var5 = par1ArrayOfInteger[var3] >> 16 & 255;
			int var6 = par1ArrayOfInteger[var3] >> 8 & 255;
			int var7 = par1ArrayOfInteger[var3] & 255;
			int var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
			int var9 = (var5 * 30 + var6 * 70) / 100;
			int var10 = (var5 * 30 + var7 * 70) / 100;
			var2[var3] = var4 << 24 | var8 << 16 | var9 << 8 | var10;
		}

		return var2;
	}

	private String getResourceLocationString(Object o) {
		String resourceDomain = (String) Modchu_Reflect.getFieldObject(o.getClass(), "func_110624_b", "getResourceDomain", o);
		String resourcePath = (String) Modchu_Reflect.getFieldObject(o.getClass(), "func_110623_a", "getResourcePath", o);
		String s = resourceDomain != null ? "assets/"+resourceDomain+"/"+resourcePath :
			"assets/minecraft/"+resourcePath;
		return s;
	}
}
