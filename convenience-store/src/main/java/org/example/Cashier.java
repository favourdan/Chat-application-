package org.example;

import enums.Department;
import enums.Gender;
import enums.Qualification;
import exception.ProductSoldOutException;
import interfaces.CashierService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Cashier extends Staff implements CashierService, Runnable{

    Customer customer;

    public Cashier(Customer customer) {
        this.customer = customer;
    }

    public Cashier() {
    }

    public Cashier(String firstName, String lastName, String phoneNumber, Gender gender, String address, String id, String position, Department department, Qualification qualification) {
        super(firstName, lastName, phoneNumber, gender, address, id, position, department, qualification);
    }




    @Override
    public String sellProduct(Customer customer)  throws ProductSoldOutException {

        double price = 0;
        for (int i = 0; i < customer.getCartItem().size() ; i++) {
            price += customer.getCartItem().get(i).getPrice();
        }
        if( price> customer.getBalance()){
            return "insufficient fund";
        }else{
            throw new ProductSoldOutException("product sold out");
        }
    }

    @Override
    public String dispenseReceipt(Customer customer) {
        Product product = new Product();
        Customer Customer = new Customer();
        System.out.println("\n\t\t ***** RECEIPT ***** \n");
        System.out.println("Name : " + customer.getFirstName());
        System.out.println("Contact : " + customer.getPhoneNumber());
        System.out.println("\n Products Purchased \n");
        for (int i = 0; i < customer.getCartItem().size(); i++)
        { System.out.println(i + 1 + "." + " " + customer.getCartItem().get(i));
        } System.out.println("\n---------------------------------------");
        System.out.println("Total \t\t\t\t\t\t \t # " + product.getPrice());
        System.out.println();
        System.out.println("---------------------------------------");

        return "Thanks for buying!";
    }


    public String firstInFirstOut(ArrayList<Customer> customerArrayList){
        for(Customer customer: customerArrayList){
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
        return null;
    }
    public void otherMethod(ArrayList<Customer> customerArrayList){
        Collections.sort(customerArrayList, new CustomerComparator().reversed());
        for(Customer customer: customerArrayList){
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
    }


    public PriorityQueue<Customer> addCustomerToPriorityQueue(List<Customer> customers){
        PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(new CustomerComparator());
        for (Customer customer : customers) {
            customerPriorityQueue.add(customer);
        }
        return customerPriorityQueue;
    }

    @Override
    public void run() {
            double price = 0;
            for (int i = 0; i < customer.getCartItem().size() ; i++) {
                price += customer.getCartItem().get(i).getPrice();
            }
            if(price> customer.getBalance()){
                System.out.println("insufficient fund");
            }else{
                System.out.println("product sold out");
//                throw new ProductSoldOutException("product sold out");
            }
    }
}
