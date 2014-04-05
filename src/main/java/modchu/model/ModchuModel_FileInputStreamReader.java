package modchu.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModchuModel_FileInputStreamReader {
	private BufferedInputStream input;
	private BufferedReader reader;

	public ModchuModel_FileInputStreamReader(InputStream in) {
		input = new BufferedInputStream(in);
		reader = new BufferedReader(new InputStreamReader(in));
	}

	public short readShort() throws IOException {
		return (short)(input.read() & 0xFF
				| (input.read() & 0xFF) << 8);
	}

	public int readInt16() throws IOException {
		return input.read() & 0xFF
				| (input.read() & 0xFF) << 8
				| (input.read() & 0xFF) << 16;
	}

	public long readIntL() throws IOException {
		return input.read() & 0xFF
				| (input.read() & 0xFF) << 8
				| (input.read() & 0xFF) << 16
				| (input.read() & 0xFF) << 24;
	}

	public int readInt() throws IOException {
		int i = input.read();
		//Modchu_Debug.mDebug("ModchuModel_FileInputStreamReader readInt() i="+i);
		int i1 = input.read() << 8;
		//Modchu_Debug.mDebug("ModchuModel_FileInputStreamReader readInt() i1="+i1);
		int i2 = input.read() << 16;
		//Modchu_Debug.mDebug("ModchuModel_FileInputStreamReader readInt() i2="+i2);
		int i3 = input.read();
		//Modchu_Debug.mDebug("ModchuModel_FileInputStreamReader readInt() i3="+i3);
		i3 = i3 << 24;
		//Modchu_Debug.mDebug("ModchuModel_FileInputStreamReader readInt() 2 i3="+i3);
		return i | i1 | i2 | i3;
	}

	public long readLong() throws IOException {
		return input.read() & 0xFF
				| (input.read() & 0xFF) << 8
				| (input.read() & 0xFF) << 16
				| (input.read() & 0xFF) << 24
				| (input.read() & 0xFF) << 32
				| (input.read() & 0xFF) << 40
				| (input.read() & 0xFF) << 48
				| (input.read() & 0xFF) << 56;
	}

	public boolean readBoolean() throws IOException {
		return input.read() != 0;
	}

	public byte readByte() throws IOException {
		return (byte)input.read();
	}

	public int read() throws IOException {
		return input.read();
	}

	public String readBshort() throws IOException {
		return Integer.toBinaryString(readInt()) + Integer.toBinaryString(readInt());
	}

	public float readFloat() throws IOException {
		return Float.intBitsToFloat(readInt());
	}

	public double readDouble() throws IOException {
		return Double.longBitsToDouble(readLong());
	}

	public byte[] readBytes(byte[] b) throws IOException {
		return readBytes(b, 0, b.length);
	}

	public byte[] readBytes(int i, int i1) throws IOException {
		byte[] b = new byte[i1 - i];
		return readBytes(b, i, i1);
	}

	public byte[] readBytes(byte[] b, int i, int i1) throws IOException {
		input.read(b, i, i1);
		return b;
	}

	public int skipBytes(int n) throws IOException {
		return (int)input.skip(n);
	}

	public String readLine() throws IOException {
		return reader.readLine();
	}

	public void close() throws IOException {
		input.close();
		reader.close();
	}

	public int available() throws IOException {
		return input.available();
	}
}