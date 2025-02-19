package com.andresyfr.connect.drive.dtos;

import lombok.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OauthResponse implements Serializable {
    private static final long serialVersionUID = 5897116500757482987L;
	private String access_token;
    private String expires_in;
    private String scope;
    private String token_type;
    private String id_token;
}