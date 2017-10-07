package com.mtom.demo;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface FileUpload {
	
	public @WebResult(name="response")String uploadFile(@WebParam(name = "file")DataHandler attachedFile);
	
	public DataHandler downloadFile();

}
