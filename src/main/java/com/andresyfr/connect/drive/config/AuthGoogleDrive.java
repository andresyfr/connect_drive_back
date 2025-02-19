//package com.andresyfr.connect.drive.config;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.GeneralSecurityException;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//
//@SuppressWarnings("deprecation")
//public class AuthGoogleDrive {
//    private static final String CREDENTIALS_FILE = "credenciales.json";
//    private static final String APPLICATION_NAME = "Tu Aplicación";
//
//    public static Drive getDriveService() throws IOException, GeneralSecurityException {
//        // Carga el archivo de credenciales
//        InputStream inputStream = new FileInputStream(CREDENTIALS_FILE);
//		GoogleCredential credential = GoogleCredential.fromStream(inputStream)
//                .createScoped(DriveScopes.all());
//
//        // Crea una instancia de Drive
//        return new Drive.Builder(
//                com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(),
//                GsonFactory.getDefaultInstance(),
//                credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//}