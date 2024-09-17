/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyfinalalgoritmos;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrossBetween;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
/**
 *
 * @author melis
 */
public class ExportarExcel {
    public static void exportarListaPoryectosAExcel(List<Proyecto> proyectos, String archivoExcel) throws FileNotFoundException, IOException {
        // Crear un libro de trabajo de Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet01 = workbook.createSheet("Proyectos");
        /*Workbook workbook = new XSSFWorkbook();

        // Crear una hoja de trabajo
        Sheet sheet = workbook.createSheet("Proyectos");
        */
        // Crear una fila para los encabezados
        Row headerRow = sheet01.createRow(0);
        headerRow.createCell(0).setCellValue("CODIGO");
        headerRow.createCell(1).setCellValue("NOMBRE");
        headerRow.createCell(2).setCellValue("DESCRIPCION");
        headerRow.createCell(3).setCellValue("FECHA_CREACION");
        headerRow.createCell(4).setCellValue("HORAS_ESTIMADAS");
        headerRow.createCell(5).setCellValue("FECHA_INICIO");
        headerRow.createCell(6).setCellValue("FECHA_FIN");
        headerRow.createCell(7).setCellValue("% DE AVANCE");
        headerRow.createCell(8).setCellValue("RESPONSABLE");
        headerRow.createCell(9).setCellValue("ESTADO");
        headerRow.createCell(10).setCellValue("ACTIVO");

        // Crear filas para cada persona en la lista
        int rowNum = 1;
        for (Proyecto p : proyectos) {
            Row row = sheet01.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getCodigo());
            row.createCell(1).setCellValue(p.getNombre());
            row.createCell(2).setCellValue(p.getDescripcion());
            row.createCell(3).setCellValue(p.getFechaCreacion());
            row.createCell(4).setCellValue(p.getHorasEstimadas());
            row.createCell(5).setCellValue(p.getFechaInicio());
            row.createCell(6).setCellValue(p.getFechaFin());
            row.createCell(7).setCellValue(p.getPorcAvance()+" %");
            row.createCell(8).setCellValue(p.getResponsableId());
            row.createCell(9).setCellValue(p.getEstado());
            row.createCell(10).setCellValue(p.isActivo());
        }

        // Redimensionar las columnas para ajustarse al contenido
        for (int i = 0; i < 10; i++) {
            sheet01.autoSizeColumn(i);
        }
 

        
        //XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet02 = workbook.createSheet("Graficos");

        // Crear encabezados
        Row header = sheet02.createRow(0);
        header.createCell(0).setCellValue("Proyecto");
        header.createCell(1).setCellValue("Porc. Avance");

        // Agregar datos
        //String[] proyectos = {"Proyecto A", "Proyecto B", "Proyecto C"};
        //int[] avances = {75, 50, 90};  // Los porcentajes de avance de cada proyecto

        int i=1;
        for (Proyecto p : proyectos) {
            Row row = sheet02.createRow(i++);
            row.createCell(0).setCellValue(p.getNombre());
            row.createCell(1).setCellValue(p.getPorcAvance());
        }

        // Crear gráfico de barras
        XSSFDrawing drawing = sheet02.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 20);

        XSSFChart chart = drawing.createChart(anchor);
        chart.setTitleText("Porcentaje de Avance por Proyecto");
        chart.setTitleOverlay(false);

        // Crear el eje de categorías (proyectos)
        XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        bottomAxis.setTitle("Proyectos");

        // Crear el eje de valores (porcentaje)
        XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
        leftAxis.setTitle("Porcentaje de Avance");
        leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
        leftAxis.setMaximum(100);  // Máximo de 100%

        // Datos para el gráfico
        XDDFDataSource<String> proyectosData = XDDFDataSourcesFactory.fromStringCellRange(sheet02, new CellRangeAddress(1, proyectos.size(), 0, 0));
        XDDFNumericalDataSource<Double> avanceData = XDDFDataSourcesFactory.fromNumericCellRange(sheet02, new CellRangeAddress(1, proyectos.size(), 1, 1));

        // Crear las barras
        XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
        XDDFChartData.Series series = data.addSeries(proyectosData, avanceData);
        series.setTitle("Avance (%)", null);
        chart.plot(data);

        // Escribir el archivo Excel
        try (FileOutputStream fileOut = new FileOutputStream(archivoExcel)) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el libro de trabajo
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        public static void exportarListaPersonasAExcel(List<Persona> personas, String archivoExcel) {
        // Crear un libro de trabajo de Excel
        Workbook workbook = new XSSFWorkbook();

        // Crear una hoja de trabajo
        Sheet sheet = workbook.createSheet("Personas");

        // Crear una fila para los encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("CODIGO");
        headerRow.createCell(1).setCellValue("NOMBRE");
        headerRow.createCell(2).setCellValue("ESPECIALIDAD"); 
        // Crear filas para cada persona en la lista
        int rowNum = 1;
        for (Persona persona : personas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(persona.getCodigo());
            row.createCell(1).setCellValue(persona.getNombre());
            row.createCell(2).setCellValue(persona.getEspecialidad());
        }

        // Redimensionar las columnas para ajustarse al contenido
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Escribir el archivo Excel
        try (FileOutputStream fileOut = new FileOutputStream(archivoExcel)) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el libro de trabajo
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
