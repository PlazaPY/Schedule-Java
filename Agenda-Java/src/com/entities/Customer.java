package com.entities;
import javax.swing.*;
import java.text.MessageFormat;
import java.util.*;

public class Customer {
    
    private String name;
    private String cpf;
    private String telefone;

    Customer() {
        setName(JOptionPane.showInputDialog(null, "Enter customer name."));
        setCpf(JOptionPane.showInputDialog(null, "Enter customer CPF."));
        setTelefone(JOptionPane.showInputDialog(null, "Enter customer celphone."));
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
