package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.entity.Employee;
import com.targetindia.entity.Product;
import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class JPAQueryLanguageDemo {

    static EntityManager em = JpaUtil.createEnitytManager();

    static void getAllProducts() {
        // SQL --> SELECT * FROM PRODUCTS
        String ql = "from Product";
        // we are creating an object that is capable of executing a SELECT statement
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.getResultStream() // SQL query is executed here
                .forEach(JPAQueryLanguageDemo::printProductInfo);
    }

    public static void main(String[] args) {
        // getAllProducts();
        // getProductsByPriceRange(50, 500);
        // getProductsHavingUnitsInStockMoreThan(100);
        // getProductsByPageAndSize(6, 10);
        // getProductsByCategoryName("CONDIMENTS");
        // getSuppliersFromCity("London");
        // getCustomersFromCity("London");
        getAllEmployees();
    }

    private static void getAllEmployees() {
        String ql = "from Employee";
        TypedQuery<Employee> qry = em.createQuery(ql, Employee.class);
        qry.getResultStream()
                .forEach(JPAQueryLanguageDemo::printEmployeeDetails);

        System.out.println();

        qry.getResultStream()
                .forEach(e->{
                    System.out.printf("%s %s is from city of %s%n",
                            e.getFirstname(),
                            e.getLastname(),
                            e.getAddress().getCity());
                });
    }

    private static void printEmployeeDetails(Employee e) {
        if(e.getManager()==null){
            System.out.printf("%s %s reports to no one!%n", e.getFirstname(), e.getLastname());
        }
        else{
            System.out.printf("%s %s reports to %s %s%n",
                    e.getFirstname(), e.getLastname(),
                    e.getManager().getFirstname(), e.getManager().getLastname());
        }
    }

    private static void getCustomersFromCity(String city) {
        String ql = "from Customer where address.city = ?1";
        TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
        qry.setParameter(1, city);
        qry.getResultStream()
                .forEach(customer->System.out.printf("%s, %s%n",
                        customer.getCompanyName(),
                        customer.getAddress().getCountry()));
    }

    private static void getSuppliersFromCity(String city) {
        String ql = "from Supplier where address.city = ?1";
        TypedQuery<Supplier> qry = em.createQuery(ql, Supplier.class);
        qry.setParameter(1, city);
        qry.getResultStream()
                .forEach(s->System.out.printf("%s, %s%n",
                        s.getCompanyName(), s.getAddress().getCountry()));
    }

    private static void getProductsByCategoryName(String categoryName) {
        String ql = "from Product p where lower(p.category.categoryName) = lower(:CAT_NAME)";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter("CAT_NAME", categoryName);
        qry.getResultStream() // executes the query now
                .forEach(JPAQueryLanguageDemo::printProductInfo);
    }

    private static void getProductsByPageAndSize(int pageNum, int pageSize) {
        String ql = "from Product order by productId";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);

        int offset = (pageNum - 1) * pageSize;
        qry.setFirstResult(offset);
        qry.setMaxResults(pageSize);

        qry.getResultStream() // executes the query now
                .forEach(JPAQueryLanguageDemo::printProductInfo);
    }

    private static void getProductsHavingUnitsInStockMoreThan(int unitsInStock) {
        String ql = "from Product where unitsInStock > :UNITS_IN_STOCK";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter("UNITS_IN_STOCK", unitsInStock);
        qry.getResultStream() // executes the query now
                .forEach(JPAQueryLanguageDemo::printProductInfo);
    }

    private static void getProductsByPriceRange(double minPrice, double maxPrice) {
        // The JPQL uses class names for table names and property names for column names
        String ql = "from Product where unitPrice between ?1 and ?2 order by unitPrice";
//        String ql = "from Product where unitPrice between :MIN and :MAX order by unitPrice";

        TypedQuery<Product> qry = em.createQuery(ql, Product.class);

        qry.setParameter(1, minPrice);
        qry.setParameter(2, maxPrice);
//        qry.setParameter("MAX", maxPrice);
//        qry.setParameter("MIN", minPrice);

        qry.getResultStream() // executes the query now
                .forEach(JPAQueryLanguageDemo::printProductInfo);
    }

    static void printProductInfo(Product p) {
        System.out.printf("%2d %s (%s) (%d in stock) --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getCategory().getCategoryName(),
                p.getUnitsInStock(),
                p.getUnitPrice());
    }
}
