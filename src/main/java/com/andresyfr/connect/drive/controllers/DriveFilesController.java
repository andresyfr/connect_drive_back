package com.andresyfr.connect.drive.controllers;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.andresyfr.connect.drive.dtos.DriveFiles;
import com.andresyfr.connect.drive.enums.SessionKey;
import com.andresyfr.connect.drive.services.GoogleDriveService2;
import com.andresyfr.connect.drive.services.exceptions.AccessDeniedException;
import jakarta.servlet.http.HttpSession;

@Controller
public class DriveFilesController {

    private final GoogleDriveService2 googleDriveService;

    public DriveFilesController(GoogleDriveService2 googleCalendarService, ClientRegistrationRepository clientRegistrationRepository, RestTemplate restTemplate) {
        this.googleDriveService = googleCalendarService;
    }

    @RequestMapping("/files")
    public String getCalendarEvents(HttpSession session, Model model) {
        String accessToken = session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()) == null
                ? "" : session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()).toString();

        if (accessToken == null || accessToken.isBlank()) {
            throw new AccessDeniedException("Invalid token");
        }
        DriveFiles driveFiles = googleDriveService.getDriveFiles(accessToken);
        System.out.println(driveFiles.toString());
        model.addAttribute("files", driveFiles);
        return "view-files";
    }
}
