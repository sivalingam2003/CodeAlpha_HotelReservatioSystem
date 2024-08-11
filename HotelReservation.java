package codealpha;
import java.util.*;
public class HotelReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Map<String, Object>> hotel = new ArrayList<>();
        List<Integer> available = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> reserved = new ArrayList<>();
        System.out.print("Enter number of Customer: ");
        int a=sc.nextInt();
        for(int k=0;k<a;k++) {
        System.out.print("Enter 1 for Room Booking, 2 for Room cancellation: ");
        int key = sc.nextInt();
        sc.nextLine();
        if (key == 1) {
            Map<String, Object> info = new HashMap<>();
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            info.put("Name", name);
            System.out.println("Enter Address: ");
            String address = sc.nextLine();
            info.put("Address", address);
            System.out.println("Enter Aadhar Number: ");
            String aadhar = sc.nextLine();
            info.put("AadharNo", aadhar);
            System.out.println("Enter Contact Number: ");
            String contactNo = sc.nextLine();
            info.put("ContactNo", contactNo);
            System.out.print("Enter Number of Rooms: ");
            int noOfRooms = sc.nextInt();
            info.put("NoOfRooms", noOfRooms);
            Random r = new Random();
            List<Integer> rooms = new ArrayList<>();
            System.out.println("Here the rooms for you: ");
            for (int i = 0; i < noOfRooms; i++) {
                int number = available.get(r.nextInt(available.size()));
                rooms.add(number);
                reserved.add(number);
                available.remove(Integer.valueOf(number));
                System.out.println(number);
            }
            info.put("Rooms", rooms);
            hotel.add(info);
            System.out.println("Thank you for Booking! If you have any queries, please contact.");
        } 
        else{
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Contact Number: ");
            String contactNo = sc.nextLine();
            for (Map<String, Object> x : hotel) {
                if (x.get("Name").equals(name) && x.get("ContactNo").equals(contactNo)) {
                    @SuppressWarnings("unchecked")
                    List<Integer> rooms = (List<Integer>) x.get("Rooms");
                    for (int n : rooms) {
                        available.add(n);
                        reserved.remove(Integer.valueOf(n));
                    }
                    hotel.remove(x);
                    System.out.println("Cancelled successfully. Thank you! Come again.");
                    break;
                }
            }
        }
    }
    sc.close();
    }
}
