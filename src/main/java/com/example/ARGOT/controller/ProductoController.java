/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ARGOT.controller;

import com.example.ARGOT.modelos.Pedido;
import com.example.ARGOT.modelos.Producto;
import com.example.ARGOT.service.api.PedidoServiceAPI;
import com.example.ARGOT.service.api.ProductoServiceAPI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Usuario
 */
@Controller
public class ProductoController {

    @Autowired
    private ProductoServiceAPI productoServiceAPI;

    @Autowired(required = false)
    private PedidoServiceAPI pedidoServiceAPI;

    ArrayList<Producto> prod = new ArrayList();
    String dato = "";
    int total = 0;
    int cantventa = 0;
    int dato2 = -1;
    int cantTotal=0;
    int resta=0;
    
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    // para el metodo facturar, se reutilizara el metodo save se recibira un objeto producto y se guardara en una lista 
    //posteriormente a eso la lista sera enviada a la pagina de factura para hacer el loop de los productos y demas
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("CantProd", productoServiceAPI.getAll().size());
        return "index";
    }

    @RequestMapping("/facturar")
    public String facturar(Model model) {
        model.addAttribute("factura", prod);
        for (int i = 0; i < prod.size(); i++) {
            if (prod.get(i).getPrecio() != null && prod.get(i).getVendidos() != null) {
                cantventa = Integer.parseInt(prod.get(i).getVendidos());
                total += Integer.parseInt(prod.get(i).getPrecio()) * cantventa;
            }
        }
        dato = String.valueOf(total);
        model.addAttribute("total", dato);
        model.addAttribute("fecha", getFechaActual());
        return "facturar.html";
    }

    @RequestMapping("/inventario")
    public String inventario(Model model, Producto produc) {
        model.addAttribute("list", productoServiceAPI.getAll());
        Long id = Long.parseLong("0");
        if (produc.getCantidad() != null) {
            dato2 = Integer.parseInt(produc.getCantidad());
        }
        if (dato2 > 0) {
            prod.add(produc);
            productoServiceAPI.delete(produc.getId());
            Producto prod = new Producto();
            prod.setId(produc.getId());
            prod.setNombre(produc.getNombre());
            resta= Integer.parseInt(produc.getVendidos());
            cantTotal=Integer.parseInt(produc.getCantidad())-resta;
            prod.setCantidad(String.valueOf(cantTotal));
            prod.setPrecio(produc.getPrecio());
            productoServiceAPI.save(prod);
            if (id != null && id != 0) {
                model.addAttribute("producto", productoServiceAPI.get(id));
            } else {
                model.addAttribute("producto", new Producto());
            }
        } else {
            model.addAttribute("Mensaje", dato2);
        }
     dato2 = -1;
        return "inventario.html";
    }

    @RequestMapping("/pedido")
    public String pedidos(Model model) {
        model.addAttribute("listpedido", pedidoServiceAPI.getAll());
        Long id = Long.parseLong("0");
        if (id != null && id != 0) {
            model.addAttribute("pedido", pedidoServiceAPI.get(id));
        } else {
            model.addAttribute("pedido", new Pedido());
        }
        return "pedido";
    }

    @PostMapping("/pedido")
    public String savePedido(Pedido pedido, Model model) {
        model.addAttribute("listpedido", pedidoServiceAPI.getAll());
        pedidoServiceAPI.save(pedido);
        return "redirect:/pedido";
    }

    @GetMapping("/deletePedido/{id}")
    public String deletePedido(@PathVariable long id, Model model) {
        pedidoServiceAPI.delete(id);
        return "redirect:/pedido";
    }

    @GetMapping("/administrar-productos")
    public String administrar_productos(Model model) {
        model.addAttribute("list", productoServiceAPI.getAll());
        model.addAttribute("CantProd", productoServiceAPI.getAll().size());
        Long id = Long.parseLong("0");
        if (id != null && id != 0) {
            model.addAttribute("producto", productoServiceAPI.get(id));
        } else {
            model.addAttribute("producto", new Producto());
        }
        return "administrar-productos";
    }

    /**
     * @GetMapping("/save/{id}") public String showSave(@PathVariable("id") Long
     * id, Model model) { if (id != null) { model.addAttribute("producto",
     * productoServiceAPI.get(id)); } else { model.addAttribute("producto", new
     * Producto()); } return "save"; }
     */
    @PostMapping("/administrar-productos")
    public String save(Producto producto, Model model) {
        model.addAttribute("list", productoServiceAPI.getAll());
        productoServiceAPI.save(producto);
        return "redirect:/administrar-productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
        productoServiceAPI.delete(id);
        return "redirect:/administrar-productos";
    }

    @PostMapping("/update")
    public String update(Producto producto) {
        productoServiceAPI.delete(producto.getId());
        productoServiceAPI.save(producto);
        return "redirect:/administrar-productos";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Producto findOne(long id) {
        return productoServiceAPI.get(id);
    }
}
