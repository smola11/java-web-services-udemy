package com.maciej.mtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWs {

    void upload(@WebParam(name = "file") DataHandler attachment); // serialize incoming file and put contents into DataHandler

    DataHandler download();
}
