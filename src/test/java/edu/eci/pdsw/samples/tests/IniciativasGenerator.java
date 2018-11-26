package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Estado;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.Usuario;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;

import static org.quicktheories.generators.SourceDSL.*;

import java.util.Date;
import java.util.List;

public class IniciativasGenerator {
    
    public static Gen<Iniciativa> iniciativas(Usuario usuario){
        return id().zip(estado(),nombre(),fechaCreacion(),palabrasClave(),
            (id2, estado2,nombre2,now,palabrasClave2) -> new Iniciativa(id2, estado2, nombre2, "descripcion", now, palabrasClave2, usuario, "rrrrr"));
    }
    
    private static Gen<Integer> id(){
        return integers().between(10000000, 1999999999);
    }
    
    public static Gen<Estado> estado() {
        Class d = Estado.class;
        return Generate.enumValues(d);
    }
    
    private static Gen<String> nombre(){
        return strings().basicLatinAlphabet().ofLengthBetween(5, 35);
    }
    
    private static Gen<String> descripcion(){
        return strings().basicLatinAlphabet().ofLengthBetween(5, 35);
    }
    
    private static Gen<Date> fechaCreacion(){
        return dates().withMilliseconds(0);
    }
    
    private static Gen<String> palabrasClave(){
        return strings().basicLatinAlphabet().ofLengthBetween(10, 145);
    }

    private static Gen<Usuario> usuario(){
        return UsuariosGenerator.Usuarios();
    }
    
    private static Gen<String> telefonos(){
        return strings().numericBetween(1000000, 1999999999);
    }
    
    private static Gen<String> correo(){
        return strings().basicLatinAlphabet().ofLengthBetween(10, 145);
    }

    public static Gen<List<Comentario>> comentarios() {
        return lists().of(ComentariosGenerator.comentarios()).ofSizeBetween(0,100);
      }
    
    private static Gen<String> area(){
        return strings().basicLatinAlphabet().ofLengthBetween(10, 145);
    }
}
