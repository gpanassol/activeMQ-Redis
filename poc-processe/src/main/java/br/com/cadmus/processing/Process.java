package br.com.cadmus.processing;

import br.com.cadmus.processing.sale.ConsumerSale;

public class Process {

    public static void main(String[] args) throws Exception{

        ConsumerSale sale = new ConsumerSale();
        sale.consumerQueueSale();
    }
}
