package com.wsoap;

import org.apache.wss4j.dom.WSConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfigure extends WsConfigurerAdapter {

    @Bean
    public SaajSoapMessageFactory saajSoapMessageFactory(){
        SaajSoapMessageFactory messageFactory= new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return messageFactory;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "consultaRuc")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema consulRuc) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("consultaRucRequest");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://wsoap.com/pwserver/consulta");
        wsdl11Definition.setSchema(consulRuc);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema consultarucSchema() {
        return new SimpleXsdSchema(new ClassPathResource("consulta_ruc_set.xsd"));
    }


    @Bean
    public Wss4jSecurityInterceptor securityInteceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        //securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setValidationActions(WSConstants.USERNAME_TOKEN_LN);
        //securityInterceptor.setSecurementPasswordType(WSConstants.PW_NONE);
        securityInterceptor.setValidationCallbackHandler(callbackHandler());
        return securityInterceptor;
    }
    @Bean
    public PayloadLoggingInterceptor payloadLoggingInterceptor() {
        return new PayloadLoggingInterceptor();
    }

    @Bean
    public SimplePasswordValidationCallbackHandler callbackHandler() {

        SimplePasswordValidationCallbackHandler handler =
                new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("user", "password"));

        return handler;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInteceptor());
        interceptors.add(payloadLoggingInterceptor());
    }
}
