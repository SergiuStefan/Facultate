import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RWFile {

	public void writeFile(byte buffer) throws IOException {

		File file = new File(
				"D:\\Facultate\\Eclipse\\CodareAudioVideo\\fisier.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
		fos.write(buffer);
		fos.close();

		System.out.println("Done");
	}

	public byte ReadFile() throws IOException {

		File file = new File(
				"D:\\Facultate\\Eclipse\\CodareAudioVideo\\fisier1.txt");
		FileInputStream fis = new FileInputStream(file.getAbsoluteFile());

		int value = fis.read();
		fis.close();

		return (byte) value;
	}
}
