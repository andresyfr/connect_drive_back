//package com.andresyfr.connect.drive.services;
//
//import com.andresyfr.connect.drive.config.AuthGoogleDrive;
//import org.springframework.stereotype.Service;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.model.File;
//import com.google.api.services.drive.model.FileList;
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//
//@Service
//public class GoogleDriveService {
//	
//	public void listFiles() {
//		try {
//			Drive drive = AuthGoogleDrive.getDriveService();
//	
//	        // Lista los archivos en el directorio raíz
//	        Drive.Files.List request = drive.files().list()
//	                .setFields("nextPageToken, files(id, name)");
//	        FileList files;
//				files = request.execute();
//	
//	        for (File file : files.getFiles()) {
//	            System.out.println(file.getName() + " (" + file.getId() + ")");
//	        }
//		} catch (IOException | GeneralSecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
////    public File createFolder(String folderName) throws IOException {
////        File fileMetadata = new File();
////        fileMetadata.setName(folderName);
////        fileMetadata.setMimeType("application/vnd.google-apps.folder");
////
////        return driveService.files().create(fileMetadata)
////                .setFields("id, name, webViewLink")
////                .execute();
////    }
//}