package main.infrastructure;

import main.human_resources.Employee;
import main.infrastructure.Configuration;
import main.infrastructure.lhc.IBlock;
import main.infrastructure.lhc.experiment.IExperiment;
import main.infrastructure.security.IIDCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    public String driverName = "jdbc:hsqldb:";
    private Connection connection;

    public void setupConnection() {
        System.out.println("--- setupConnection");

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + Configuration.instance.dataBaseFile;
            connection = DriverManager.getConnection(databaseURL, Configuration.instance.username, Configuration.instance.password);
            System.out.println("connection : " + connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);

            if (result == -1) {
                System.out.println("error executing " + sqlStatement);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void createEmployeeTable() {
        String sql = "CREATE TABLE employee (" +
                "id VARCHAR(256) NOT NULL, " +
                "name VARCHAR(256) NOT NULL, " +
                "iris VARCHAR(256) NOT NULL, " +
                "cardId INT NOT NULL, " +
                "fingerprint VARCHAR(256) NOT NULL," +
                "PRIMARY KEY (id) )";
        update(sql);
    }

    public void createIDCardTable() {
        String sql = "CREATE TABLE idcard (" +
                "id INTEGER NOT NULL, " +
                "validFrom DATE NOT NULL, " +
                "validUntil DATE NOT NULL, " +
                "iris VARCHAR(256) NOT NULL, " +
                "isLocked BOOLEAN, " +
                "permission VARCHAR(256) NOT NULL," +
                "invalidPwdCnt INT NOT NULL," +
                "personId INT NULL," +
                "password VARCHAR(256) NOT NULL," +
                "fingerprint VARCHAR(256) NOT NULL," +
                "PRIMARY KEY (id) )";
        update(sql);
    }

    public void createExperimentTable() {
        String sql = "CREATE TABLE experiment (" +
                "id VARCHAR(256) NOT NULL, " +
                "dateTimeStamp VARCHAR(256) NOT NULL, " +
                "isHiggsBosonFound BOOLEAN NOT NULL, " +
                "protonId1 INT NOT NULL, " +
                "protonId2 INT NOT NULL," +
                "PRIMARY KEY (id) )";
        createBlocksTable();
        update(sql);
    }

    private void createBlocksTable() {
        String sql = "CREATE TABLE block (" +
                "id VARCHAR(256) NOT NULL, " +
                "structure VARCHAR(256) NOT NULL, " +
                "experimentId VARCHAR(256) NOT NULL, " +
                "PRIMARY KEY (id) )";
        update(sql);
    }

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee VALUES (" + employee.toDatabaseString() + ")";
        update(sql);
    }

    public void insertIDCard(IIDCard idCard) {
        String sql = "INSERT INTO idcard VALUES (" + idCard + ")";
        update(sql);
    }

    public void insertExperiment(IExperiment experiment) {
        String sql = "INSERT INTO experiment VALUES (" + experiment.toDatabaseString() + ")";
        update(sql);

        for (int i = 0; i < 200000; i++) {
            this.insertBlock(experiment.getBlock(i), experiment.getUuid());
        }
    }

    private void insertBlock(IBlock block, String experimentId) {
        String sql = "INSERT INTO block VALUES (" + block + ", '" + experimentId + "')";
        update(sql);
    }
}
