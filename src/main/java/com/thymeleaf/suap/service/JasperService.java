package com.thymeleaf.suap.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class JasperService {

    private static final String JASPER_DIRETORIO = "classpath:jasper/";
    private static final String JASPER_SUFIXO = ".jasper/";

    @Autowired
    private DataSource dataSource;

    @Autowired
    ResourceLoader resourceLoader;

    private Map<String, Object> params = new HashMap<>();

    public JasperService(){
        this.params.put("IMAGEM_DIRETORIO", JASPER_DIRETORIO);
        this.params.put("SUB_REPORT_DIR", JASPER_DIRETORIO);
        this.params.put("REPORT_LOCALE", new Locale("pt","BR"));
    }

    public void addParams(String key, Object value){
        this.params.put(key, value);
    }

    public byte[] exportarPDF(String nomeRelatorio) throws SQLException {
        byte[] bytes = null;
        try {
            Resource resource = resourceLoader
                    .getResource(JASPER_DIRETORIO.concat(nomeRelatorio).concat(JASPER_SUFIXO));
            InputStream stream = resource.getInputStream();

            JasperPrint print = JasperFillManager.fillReport(stream, params, dataSource.getConnection());
            bytes = JasperExportManager.exportReportToPdf(print);
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}

