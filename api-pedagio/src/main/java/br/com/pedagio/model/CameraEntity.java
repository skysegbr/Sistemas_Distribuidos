package br.com.pedagio.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Document
public class CameraEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    private byte[] image;
}