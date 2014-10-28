import java.io.IOException;

public class WriteB {
	int counter = 0;
	byte buffer;
	RWFile write;

	public void writeBit(int value) throws IOException {
		write = new RWFile();
		buffer = (byte) (buffer << 1);
		buffer |= value % 2;
		

		if (counter == 7) {
			System.out.println(buffer);
			write.writeFile(buffer);
			counter = 0;
			buffer = 0;
		}
		counter++;
	}

	public void writeNBiti(int n, int value) throws IOException {
		for (int i = 0; i < n; i++) {
			writeBit(value >> i);
		}
	}
}
