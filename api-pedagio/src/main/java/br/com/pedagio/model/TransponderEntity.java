package br.com.pedagio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Document
public class TransponderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String tag;
    private String dateTime;
}
