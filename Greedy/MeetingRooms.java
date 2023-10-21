public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        TreeMap<Integer, Integer> roomChanges = new TreeMap<>();
        
        for (List<Integer> interval : A) {
            int start = interval.get(0);
            int end = interval.get(1);
            
            roomChanges.put(start, roomChanges.getOrDefault(start, 0) + 1);
            roomChanges.put(end, roomChanges.getOrDefault(end, 0) - 1);
        }
        
        int maxRooms = 0;
        int currentRooms = 0;
        
        for (int change : roomChanges.values()) {
            currentRooms += change;
            maxRooms = Math.max(maxRooms, currentRooms);
        }
        
        return maxRooms;
    }
}
