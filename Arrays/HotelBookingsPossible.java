public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int n = arrive.size();
        
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < arrive.size(); i++) {
            events.add(new int[] { arrive.get(i), 1 });
            events.add(new int[] { depart.get(i), -1 });
        }
        
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        int roomsInUse = 0;
        int maxRoomsRequired = 0;

        for (int[] event : events) {
            roomsInUse += event[1];
            maxRoomsRequired = Math.max(maxRoomsRequired, roomsInUse);
        }

        return K >= maxRoomsRequired;  
    }
}
