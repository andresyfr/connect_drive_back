package com.andresyfr.connect.drive.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andresyfr.connect.drive.dtos.DriveFiles;
import com.andresyfr.connect.drive.enums.SessionKey;
import com.andresyfr.connect.drive.services.GoogleDriveService2;
import com.andresyfr.connect.drive.utils.exceptions.AccessDeniedException;

import jakarta.servlet.http.HttpSession;

@RestController
public class DriveFilesControllerRest {

    private final GoogleDriveService2 googleDriveService;

    public DriveFilesControllerRest(GoogleDriveService2 googleDriveService) {
        this.googleDriveService = googleDriveService;
    }

    @GetMapping("/files2")
    public ResponseEntity<?> getDriveFiles(HttpSession session) {
        String accessToken = session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()) == null
                ? "" : session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()).toString();
        if (accessToken == null || accessToken.isBlank()) {
            throw new AccessDeniedException("Invalid token");
        }
        DriveFiles driveFiles = googleDriveService.getDriveFiles(accessToken);
        System.out.println(driveFiles.toString());
        return ResponseEntity.ok(driveFiles);
    }
}
