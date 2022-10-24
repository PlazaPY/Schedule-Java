package com.entities;


import javax.swing.*;


public class Services {
    private String service, dia, mes, status;
    private int op = 1;
    double price, total;
    Customer customer;
    private Services nextService;


    Services() {

        setService(JOptionPane.showInputDialog("Enter the service name."));
        setDia(JOptionPane.showInputDialog("Enter the day of service."));
        setMes(JOptionPane.showInputDialog("Enter the month of service."));
        setPrice(Double.parseDouble(JOptionPane.showInputDialog("Enter the price of service.")));
        setStatus("Scheduled");
        setCustomer(new Customer());

    }

    public void changeServices() {

        setService(JOptionPane.showInputDialog("Enter the service name."));
        setDia(JOptionPane.showInputDialog("Enter the day of service."));
        setMes(JOptionPane.showInputDialog("Enter the month of service."));
        setPrice(Double.parseDouble(JOptionPane.showInputDialog("Enter the price of service.")));

    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total += total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public com.entities.Services getNextService() {
        return nextService;
    }

    public void setNextService(com.entities.Services nextService) {
        this.nextService = nextService;
    }
}


