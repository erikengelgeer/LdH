/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.sql.*;
import java.util.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gebruiker
 */
public class Query {

    private JTable table1 = new JTable();
    
public Query() throws SQLException{
    
 Connection sql = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AuditBlackbox;integratedSecurity=true;");
 
  PreparedStatement query;        // query aanmaken

    
  query = sql.prepareStatement("SELECT afas.EmployeeUsername\n"
                + "FROM dbo.[AfasProfit-Export] afas\n"
                + "LEFT JOIN dbo.PersoonCodes p\n"
                + "ON p.Code = afas.EmployeeUsername\n"
                + "WHERE afas.ContractEndDate < CURRENT_TIMESTAMP\n"
                + "AND p.Einddatum IS NULL;");

        ResultSet result = query.executeQuery();
        ResultSetMetaData metaData = result.getMetaData();

        Vector<String> columns = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columns.add(metaData.getColumnName(column));;
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (result.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(result.getObject(columnIndex));

            }
            data.add(vector);
        }
        this.table1.setModel(new DefaultTableModel(data, columns));
        
        sql.close();

        result.close();
}
public JTable getTable(){
    return this.table1;
}

}

