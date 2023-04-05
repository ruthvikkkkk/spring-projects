
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONFileHandler implements MyFileHandler {
    Employee employeeObj = new Employee();

    @Override
    public void read() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("/Users/jakkaruthvikkumar/Downloads/Team_project_1/src/employee.json");
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            for(int i=0; i<employeeList.size(); i++) {
                parseEmployee((JSONObject)employeeList.get(i));
            }
            System.out.println("Thread THREE, JSON WriteCounter = " + MyController.employeeCollection.writeCounter);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseEmployee(JSONObject employee) {
        String firstName = (String) employee.get("firstName");
        String lastName = (String) employee.get("lastName");
        String dateOfBirth = (String) employee.get("dateOfBirth");
        String experience = employee.get("experience") + "";
        //System.out.println((String) employee.get("experience") + 2);
        //System.out.println(firstName + "\t" + lastName + "\t" + dateOfBirth + "\t" + employee.get("experience") + "\n");
        try {
            employeeObj.setFirstName(firstName);
            employeeObj.setLastName(lastName);
            employeeObj.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));
            employeeObj.setExperience(Double.parseDouble(experience));

            MyController.employeeCollection.add(employeeObj);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void write() {

    }

    public static void main(String args[]) {
        JSONFileHandler object1 = new JSONFileHandler();
        object1.read();
    }
}
