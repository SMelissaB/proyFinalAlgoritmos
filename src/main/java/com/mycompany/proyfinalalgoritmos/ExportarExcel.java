/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyfinalalgoritmos;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author melis
 */
public class ExportarExcel {
    public static void exportarListaPoryectosAExcel(List<Proyecto> proyectos, String archivoExcel) {
        // Crear un libro de trabajo de Excel
        Workbook workbook = new XSSFWorkbook();

        // Crear una hoja de trabajo
        Sheet sheet = workbook.createSheet("PROYECTOS");

        // Crear una fila para los encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("CODIGO");
        headerRow.createCell(1).setCellValue("NOMBRE");
        headerRow.createCell(2).setCellValue("DESCRIPCION");
        headerRow.createCell(3).setCellValue("FECHA_CREACION");
        headerRow.createCell(4).setCellValue("HORAS_ESTIMADAS");
        headerRow.createCell(5).setCellValue("FECHA_INICIO");
        headerRow.createCell(6).setCellValue("FECHA_FIN");
        headerRow.createCell(7).setCellValue("RESPONSABLE");
        headerRow.createCell(8).setCellValue("ESTADO");
        headerRow.createCell(9).setCellValue("ACTIVO");

        // Crear filas para cada persona en la lista
        int rowNum = 1;
        for (Proyecto p : proyectos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getCodigo());
            row.createCell(1).setCellValue(p.getNombre());
            row.createCell(2).setCellValue(p.getDescripcion());
            row.createCell(3).setCellValue(p.getFechaCreacion());
            row.createCell(4).setCellValue(p.getHorasEstimadas());
            row.createCell(5).setCellValue(p.getFechaInicio());
            row.createCell(6).setCellValue(p.getFechaFin());
            row.createCell(7).setCellValue(p.getResponsableId());
            row.createCell(8).setCellValue(p.getEstado());
            row.createCell(9).setCellValue(p.isActivo());
        }

        // Redimensionar las columnas para ajustarse al contenido
        for (int i = 0; i < 10; i++) {
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
