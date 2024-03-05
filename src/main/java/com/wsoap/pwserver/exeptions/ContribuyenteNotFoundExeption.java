package com.wsoap.pwserver.exeptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode =  "{http://wsoap.com/pwserver/consulta}001_CONTRIBUYENTE_NOT_FOUND")
public class ContribuyenteNotFoundExeption extends RuntimeException {
    private static final long serialVersionUID= 3518170101751491969L;

    public ContribuyenteNotFoundExeption(String message){
        super(message);
    }
}
