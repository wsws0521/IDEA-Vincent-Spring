package cn.hexing.encryption.rpc.old;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfWebServiceConfig {
    @Bean
    public ServletRegistrationBean<CXFServlet> cxfDispatcherServlet() {
        return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/ws/*");
    }
    @Autowired
    private Bus bus;

    @Bean(name = "hexingStandardEncryption")
    @Autowired
    public Endpoint standardEncryptionEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, );
        endpoint.publish("/tokenService");
        return endpoint;
    }
}
