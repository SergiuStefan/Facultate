package BitReaderWriter;

import java.io.File;
import java.io.FileOutputStream;

public class BitWriter implements AutoCloseable {

	private FileOutputStream _outputFile;
	private int _writeBuffer;
	private int _ctBitesWrite;

	public BitWriter(String outputFilePath) throws Exception {
		_ctBitesWrite = 1;
		_writeBuffer = 0;
		_outputFile = new FileOutputStream(new File(outputFilePath));
	}

	public void WriteNBit(long value, int numberOfBits) throws Exception {
		if (numberOfBits > 32) {
			throw new Exception(
					"Numarul de biti care trebuie scris depaseste 32");
		}

		for (int k = numberOfBits - 1; k >= 0; k--) {
			WriteBit(value >> k);
		}
	}

	private void WriteBit(long value) throws Exception {
		_writeBuffer <<= 1;
		_writeBuffer |= (byte) (value % 2);

		if (_ctBitesWrite == 8) {
			_outputFile.write(_writeBuffer);
			_ctBitesWrite = 1;
			_writeBuffer = 0;
		} else {
			_ctBitesWrite++;
		}
	}

	@Override
	public void close() throws Exception {
		if (_outputFile != null)
			_outputFile.close();
	}

}
