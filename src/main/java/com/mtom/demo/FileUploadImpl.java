package com.mtom.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService(endpointInterface = "com.mtom.demo.FileUpload", serviceName = "FileUpload")
public class FileUploadImpl implements FileUpload {

	@Override
	public String uploadFile(DataHandler attachedFile) {

		try (InputStream input = attachedFile.getInputStream();
				OutputStream output = new FileOutputStream(new File(
						"/Users/Inampudi/Spring/testmtom.png"));) {

			byte[] b = new byte[100000];
			int bytesRead = 0;
			while ((bytesRead = input.read(b)) != -1) {
				output.write(b, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Upload Successful";
	}

	@Override
	@XmlMimeType("application/octet-stream")
	public DataHandler downloadFile() {
		DataSource source = new FileDataSource(new File("/Users/Inampudi/Spring/testmtom.png"));
		return new DataHandler(source);
	}

}
