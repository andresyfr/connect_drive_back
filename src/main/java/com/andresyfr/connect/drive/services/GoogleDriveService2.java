package com.andresyfr.connect.drive.services;

import com.andresyfr.connect.drive.dtos.DriveFiles;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleDriveService2 {

    private final RestTemplate restTemplate;

    public GoogleDriveService2(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DriveFiles getDriveFiles(String accessToken) {
        String requestUri = "https://www.googleapis.com/drive/v3/files";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + accessToken);

        @SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity request = new HttpEntity(headers);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        ResponseEntity<String> response = restTemplate.exchange(requestUri, HttpMethod.GET, request, String.class);

        Gson gson = new Gson();
        DriveFiles driveFiles = gson.fromJson(response.getBody(), DriveFiles.class);

        return driveFiles;
    }
}