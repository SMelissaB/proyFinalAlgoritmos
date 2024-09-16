/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyfinalalgoritmos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melis
 */
public class GestionArchivos {
    
    private static final String FILENAME_PROYECTOS = "proyectos.json";
    private static final String FILENAME_TAREAS = "tareas.json";
    private static final String FILENAME_PERSONAS = "personas.json";
    private static final String FILENAME_USUARIOS = "usuarios.json";
    private static final Gson gson = new Gson();
    
    public static List<Proyecto> leerProyectos() {
        try (FileReader reader = new FileReader(FILENAME_PROYECTOS)) {
            Type tipoLista = new TypeToken<List<Proyecto>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();  // Si el archivo no existe, devolvemos una lista vacía
        }
    }

    public static void guardarProyecto(List<Proyecto> proyectos) {
        try (FileWriter writer = new FileWriter(FILENAME_PROYECTOS)) {
            gson.toJson(proyectos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        public static List<Persona> leerPersonas() {
        try (FileReader reader = new FileReader(FILENAME_PERSONAS)) {
            Type tipoLista = new TypeToken<List<Persona>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();  // Si el archivo no existe, devolvemos una lista vacía
        }
    }

    public static void guardarPersona(List<Persona> personas) {
        try (FileWriter writer = new FileWriter(FILENAME_PERSONAS)) {
            gson.toJson(personas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        public static List<Tarea> leerTareas() {
        try (FileReader reader = new FileReader(FILENAME_TAREAS)) {
            Type tipoLista = new TypeToken<List<Tarea>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();  // Si el archivo no existe, devolvemos una lista vacía
        }
    }

    public static void guardarTarea(List<Tarea> tareas) {
        try (FileWriter writer = new FileWriter(FILENAME_TAREAS)) {
            gson.toJson(tareas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
