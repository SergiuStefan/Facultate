package com.BitReadWrite;

import java.io.File;
import java.io.FileInputStream;

public class BitReader implements AutoCloseable {
	private FileInputStream _inputFile;
	private int _readBuffer;
	private int _ctBitesRead;

	public BitReader(String filepath) throws Exception {
		_ctBitesRead = 8;
		_readBuffer = 0;
		_inputFile = new FileInputStream(new File(filepath));
	}

	public long ReadNBit(int n) throws Exception {
		long result = 0;

		for (int i = 1; i <= n; i++) {
			result <<= 1;
			result = result | ReadBit();
		}

		return result;
	}

	private long ReadBit() throws Exception {
		if (_ctBitesRead == 8) {
			_readBuffer = _inputFile.read();
			_ctBitesRead = 1;
		} else {
			_ctBitesRead++;
		}

		long result = (_readBuffer & 128) == 0 ? 0 : 1;

		_readBuffer = _readBuffer & 127;
		_readBuffer <<= 1;

		return result;
	}

	public void close() throws Exception {
		if (_inputFile != null)
			_inputFile.close();
	}
}
