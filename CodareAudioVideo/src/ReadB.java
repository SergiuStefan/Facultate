import java.io.IOException;

public class ReadB {
	int counter = 0;
	byte buffer = 0;
	RWFile read;
	
	public int readBit() throws IOException {
		read = new RWFile();
		if (counter == 0) {
			buffer = read.ReadFile();
			counter = 7;
		}
		if (buffer >= 128)
			return 1;
		else {
			//buffer =(byte) (buffer << 1) ;
			counter--;
			System.out.println(buffer);
		}
		return (byte) ((buffer << counter) % 2);
	}

	public int readNBiti(int n) throws IOException {
		int value = 0;
		for (int i = 0; i < n; i++) {
			readBit();
			value = (byte) (value << i);
		}
		return value;

	}
}
