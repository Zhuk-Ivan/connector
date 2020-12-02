package by.str.connector.controller;

import by.str.connector.dao.DataRepo;
import by.str.connector.model.Employee;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class MyController {

    @Autowired
    private DataRepo dataRepo;

    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity create(@RequestBody Employee employee) {

        dataRepo.create(employee);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "check-data",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody String json) throws ParseException {
        Object obj = new JSONParser().parse(json);
        JSONObject Json = (JSONObject) obj;
        Long id = (Long) Json.get("id");
        return dataRepo.checkData(id);

    }
}
