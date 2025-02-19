package com.andresyfr.connect.drive.dtos;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class File implements Serializable {
    private static final long serialVersionUID = 8219321824630393625L;
	private String kind;
    private String id;
    private String name;
    private String mimeType;

}