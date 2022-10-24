package com.entities;

import javax.swing.*;

public class Schedule {
    private Services primeiro;
    private Services ultimo;
    private int tamanho;

    public Schedule() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Schedule Service." + "\n2 - Change Service." + "\n3 - Print Schedule." + "\n0 - Exit"));
            switch (op) {
                case 1:
                    scheduleService();
                    break;
                case 2:
                    if (this.primeiro != null) {
                        changeService(JOptionPane.showInputDialog(null, "Insert the CPF customer"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Schedule empty !");
                    }
                    break;
                case 3:
                    printSchedule();
                    break;
                default:
                    break;
            }
        } while (op != 0);
    }

    public Services getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Services primeiro) {
        this.primeiro = primeiro;
    }

    public Services getUltimo() {
        return ultimo;
    }

    public void setUltimo(Services ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    private void scheduleService() {
        Services novoNo = new Services();
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setNextService(novoNo);
            this.ultimo = novoNo;
        }
        this.tamanho++;
    }

    private void changeService(String cpf) {
        Services anterior = null;
        Services atual = this.primeiro;
        int op;
        one:
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Change." +
                    "\n2 - Delete." +
                    "\n3 - Charge Service" +
                    "\n0 - Exit."));
            switch (op) {
                case 1:
                    atual.changeServices();
                    break;
                case 2:
                    for (int i = 0; i < tamanho; i++) {
                        if (atual.getCustomer().getCpf().equalsIgnoreCase(cpf)) {
                            if (this.tamanho == 1) {
                                this.ultimo = this.primeiro = null;

                            } else if (atual == this.primeiro) {
                                this.primeiro = atual.getNextService();
                                atual.setNextService(null);
                            } else if (atual == this.ultimo) {
                                this.ultimo = anterior;
                                anterior.setNextService(null);
                            } else {
                                anterior.setNextService(atual.getNextService());
                                atual = null;

                            }

                            this.tamanho--;
                            break;

                        }
                        anterior = atual;
                        atual = atual.getNextService();
                    }
                    break one;
                case 3:
                    atual.setStatus("Complete");
                    atual.setTotal(atual.getPrice());
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input !");
                    break;
            }
        } while (op != 0);


    }

    private void printSchedule() {
        Services atual = this.primeiro;
        double total = 0;
        String str = "";
        if (atual == null) {
            str = "Schedule empty !";
        } else {
            while (atual != null) {
                str += "*******************" +
                        "\nService: " + atual.getService() +
                        "\nCustomer:" + atual.getCustomer().getName() +
                        "\nCelphone:" + atual.getCustomer().getTelefone() +
                        "\nCPF:" + atual.getCustomer().getCpf() +
                        "\nPrice: " + atual.getPrice() +
                        "\nStatus" + atual.getStatus() +
                        "\n*******************";
                total += atual.getTotal();
                atual = atual.getNextService();
            }

        }

        JOptionPane.showMessageDialog(null, str + "\nTotal of complete services: "+ total);
    }


}
