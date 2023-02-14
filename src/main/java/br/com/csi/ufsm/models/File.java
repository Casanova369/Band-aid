package br.com.csi.ufsm.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {
    
    // Todo: this POJO doesnt work. go look for some file uploading examples
    private File filename = new File().getFilename();
    private Path dirname = Path.of(String.valueOf(filename));
}
