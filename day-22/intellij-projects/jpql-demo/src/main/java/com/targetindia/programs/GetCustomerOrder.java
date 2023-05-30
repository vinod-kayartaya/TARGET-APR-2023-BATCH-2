package com.targetindia.programs;

import com.targetindia.entity.Order;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetCustomerOrder {
    public static void main(String[] args) {

        int orderId = KeyboardUtil.getInt("Enter order id to fetch: ");

        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            Order ord = em.find(Order.class, orderId);
            System.out.println("Customer details: ");
            System.out.printf("Company name: %s%n", ord.getCustomer().getCompanyName());
            System.out.printf("Customer city: %s%n", ord.getCustomer().getAddress().getCity());

            System.out.println();

            System.out.println("Employee details: ");
            System.out.printf("Name: %s %s%n", ord.getEmployee().getFirstname(), ord.getEmployee().getLastname());
            System.out.printf("Phone: %s%n", ord.getEmployee().getHomePhone());

            System.out.println();
            System.out.printf("Order date: %s%n", ord.getOrderDate());
            System.out.printf("Required date: %s%n", ord.getRequiredDate());
            System.out.printf("Shpped date: %s%n", ord.getShippedDate());

            System.out.println();

            System.out.println("Shipping address details: ");
            System.out.printf("Shipped to: %s%n", ord.getShippedTo());
            System.out.printf("Address: %s%n", ord.getAddress().getStreetAddress());
            System.out.printf("City: %s%n", ord.getAddress().getCity());
            System.out.printf("Country: %s%n", ord.getAddress().getCountry());


            System.out.println();

            System.out.println("Products in this order are: ");
            System.out.printf("%-40s %10s %15s %15s%15s%n",
                    "Product name",
                    "Unit price",
                    "Quantity",
                    "Discount",
                    "Amount");
            System.out.println("---------------------------------------------------------------------------------------------------");
            ord.getLineItems()
                    .stream()
                    .forEach(li -> {
                        System.out.printf("%-40s %10.2f %15d %14.0f%%%15.2f%n",
                                li.getProduct().getProductName(),
                                li.getUnitPrice(),
                                li.getQuantity(),
                                li.getDiscount() * 100,
                                li.getUnitPrice() * li.getQuantity() * (1 - li.getDiscount()));
                    });
            System.out.println("---------------------------------------------------------------------------------------------------");
            // TODO: Display the total amount for the order here
        }
    }
}
