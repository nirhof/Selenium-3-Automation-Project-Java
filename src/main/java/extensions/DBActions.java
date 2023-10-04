package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("get customer details from database")
    public static List<String> getCustomers(String query) {
        List<String> Customers = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            Customers.add(rs.getString(1));
            Customers.add(rs.getString(2));
            Customers.add(rs.getString(3));
        } catch (SQLException e) {
            System.out.println("Error occured while printing table data, see details: " + e);
        }
        return Customers;
    }
}

