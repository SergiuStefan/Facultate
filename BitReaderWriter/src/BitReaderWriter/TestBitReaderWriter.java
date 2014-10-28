package BitReaderWriter;

import java.io.File;
import java.util.Random;

public class TestBitReaderWriter {

	public static void main(String[] args) {

		try {
			String filePath = "D:\\Nature (26).jpg";

			try (BitReader bitReader = new BitReader(filePath);
					BitWriter bitWriter = new BitWriter(
							"D:\\Nature (26) - Output.jpg")) {
				File file = new File(filePath);

				long fileSize = file.length() * 8;

				Random rn = new Random();

				do {
					long numberOfBits = rn.nextInt(31) + 1;

					if (numberOfBits > fileSize)
						numberOfBits = fileSize;

					long value = bitReader.ReadNBit((int) numberOfBits);
					bitWriter.WriteNBit(value, (int) numberOfBits);

					fileSize -= numberOfBits;

				} while (fileSize > 0);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Done");

	}
}
