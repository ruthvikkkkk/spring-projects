public class MyController {

    static MyCollection<Employee> employeeCollection = new MyCollection<>();

    public static void main(String args[]) {
        ThreadOne one = new ThreadOne();
        ThreadSecond second = new ThreadSecond();
        ThreadThird third = new ThreadThird();
        try {

            one.start();
            one.join();

            second.run();
            second.join();

            third.run();
            third.join();

            Employee test = (Employee) employeeCollection.get(0);
            System.out.println(test.getFirstName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


class ThreadOne extends Thread {
    @Override
    public void run() {
        XMLFileHandler object1 = new XMLFileHandler();
        object1.read();
    }
}

class ThreadSecond extends Thread {
    @Override
    public void run() {
        CSVFileHandler object1 = new CSVFileHandler();
        object1.read();
    }
}

class ThreadThird extends Thread {
    @Override
    public void run() {
        JSONFileHandler object1 = new JSONFileHandler();
        object1.read();
    }
}