/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Iniciativa;
import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 *
 * @author rosal
 */
public interface IniciativaDAO {
    
    public void save(Iniciativa ini) throws PersistenceException;
    public ArrayList<Iniciativa> load() throws PersistenceException;
    
    /**
     * Lista todas las inciativas
     * @return Iniciativas
     * @throws PersistenceException
     */
    public List<Iniciativa>  consultarIniciativas() throws PersistenceException;
    
    /**
     * Actualiza el estado de una iniciativa
     * @param estado
     * @param id
     * @throws PersistenceException
     */
    public void updateEstadoIniciativa(String estado, int id) throws PersistenceException;
    
    public List<Iniciativa> iniciativasUnUsuario (long documento) throws PersistenceException;
    
    public void cambiarInformacionIniciativa(String descripcion,int id);
    
    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
}
