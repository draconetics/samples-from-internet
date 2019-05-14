/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpxall.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Angelical
 */
public class Reportes implements Serializable {

    private JasperReport reporte;
    private FileInputStream entrada;
    private JasperPrint print;
    private JasperPrint jasperPrintAux;

    
    // sirve para exportar  pdf
    public boolean jasperReport(String ruta, InputStream dataSourceName, Map<String, Object> params, Connection conn) throws ClassNotFoundException, JRException, FileNotFoundException, IOException {
        this.reporte = JasperCompileManager.compileReport(dataSourceName);
        OutputStreamExporterOutput output;
        try (OutputStream out = new FileOutputStream(ruta+".pdf")) {
            this.print = JasperFillManager.fillReport(this.reporte, params, conn);
            if (this.print.getPages().isEmpty()) {
                return false;
            }   Exporter exporter = new JRPdfExporter();
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            ExporterInput inp = new SimpleExporterInput(this.print);
            configuration.setCreatingBatchModeBookmarks(true);
            //configuration.setIccProfilePath(ruta);
            configuration.set128BitKey(Boolean.TRUE);
            exporter.setConfiguration(configuration);
            JRSaver.saveObject(this.print, ruta + ".jrprint");
            exporter.setExporterInput(inp);
            output = new SimpleOutputStreamExporterOutput(out);
            exporter.setExporterOutput(output);
            exporter.exportReport();
        }
        output.close();
        JasperViewer.viewReport(this.print, false, Locale.getDefault());
        return true;
    }

    
    //Genera el reporte mostrandolo en el editor interno de Ireport
    public boolean jasperReportInterno(InputStream dataSourceName, Map<String, Object> params, Connection conn) throws ClassNotFoundException, JRException {
        this.reporte = JasperCompileManager.compileReport(dataSourceName);

        this.print = JasperFillManager.fillReport(this.reporte, params, conn);
        if (this.print.getPages().isEmpty()) {
            return false;
        }

        JasperViewer.viewReport(this.print, false, Locale.getDefault());
        return true;
    }
    //Muestra el reporte al abrir un archivo jrxml
    public void mostrarReporte(String ruta) throws JRException, FileNotFoundException {
        try {
            URL url = new URL(new File(ruta).toURI().toString());
            JasperPrint jasperPrint2;
            jasperPrint2 = (JasperPrint) JRLoader.loadObject(url);
            JasperViewer jviewer = new JasperViewer(jasperPrint2, false, Locale.getDefault());
            JasperViewer.viewReport(jasperPrint2, false);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
