package com.andresyfr.connect.drive.dtos;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class DriveFiles implements Serializable {
    private static final long serialVersionUID = 4720284805230037893L;
	private String kind;
    private String nextPageToken;
    private String incompleteSearch;
    private List<File> files;
}