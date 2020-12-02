package by.str.connector.dao;

import by.str.connector.model.Employee;

public interface Data {

    public void create(Employee employee);

    public String checkData(Long id);
}
