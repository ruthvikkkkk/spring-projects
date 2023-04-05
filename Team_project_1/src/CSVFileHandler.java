import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class CSVFileHandler implements MyFileHandler {
    Employee employee;
    @Override
    public void read() {
        String path = "/Users/jakkaruthvikkumar/Downloads/Team_project_1/src/employee.csv";
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while((line = bufferedReader.readLine()) != null) {
                employee = new Employee();
                String[] values = line.split(",");

                employee.setFirstName(values[0]);
                employee.setLastName(values[1]);
                employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(values[2]));
                employee.setExperience(Double.parseDouble(values[3]));

                MyController.employeeCollection.add(employee);

            }
            System.out.println("Thread TWO, CSV WriteCounter = " + MyController.employeeCollection.writeCounter);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        //MyController.employeeCollection.

    }

    public static void main(String args[]) {
        CSVFileHandler object1 = new CSVFileHandler();
        object1.read();
    }
}
