/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ARGOT.dao.api;

import com.example.ARGOT.modelos.Pedido;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface PedidoDaoAPI extends CrudRepository<Pedido, Long>{
    
}
