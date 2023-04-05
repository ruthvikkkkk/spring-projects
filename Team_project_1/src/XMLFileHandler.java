import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.text.SimpleDateFormat;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import java.io.File;


public class XMLFileHandler implements MyFileHandler {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String experience;
    Employee employee;
    //static MyCollection<Employee> employeeCollection;

    XMLFileHandler(){
        //employeeCollection = new MyCollection<>();
        employee = new Employee();
    }
    public void read() {
        String path = "/Users/jakkaruthvikkumar/Downloads/Team_project_1/src/employee.xml";
        try {
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document Doc = db.parse(file);
            Doc.getDocumentElement().normalize();
            NodeList nodeList = Doc.getElementsByTagName("employee");
            for(int i=0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE ) {
                    Element eElement = (Element) node;
//                    System.out.println(eElement.getElementsByTagName("firstName").item(0).getTextContent() + "\t" +
//                            eElement.getElementsByTagName("lastName").item(0).getTextContent() + "\t" +
//                            eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent() + "\t" +
//                            eElement.getElementsByTagName("experience").item(0).getTextContent());

                        employee.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                        employee.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                        employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent()));
                        employee.setExperience(Double.parseDouble(eElement.getElementsByTagName("experience").item(0).getTextContent()));


                        MyController.employeeCollection.add(employee);

                }
            }
            System.out.println("Thread ONE, XML WriteCounter = " + MyController.employeeCollection.writeCounter);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {

    }

    public static void main(String args[]) {
        XMLFileHandler object1 = new XMLFileHandler();
        object1.read();
    }
}
