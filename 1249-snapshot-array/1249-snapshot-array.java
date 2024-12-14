class SnapshotArray {

    // List to store snapshots, where each snapshot stores only the changed indices
    ArrayList<HashMap<Integer, Integer>> snapshots;

    // Holds the current state of the array for modifications
    HashMap<Integer, Integer> currentMap;

    // Snapshot ID tracker
    int id;

    public SnapshotArray(int length) {
        // Initialize the list to store snapshots (stores snapshots incrementally)
        snapshots = new ArrayList<>();

        // Initialize the current map which will hold the current state
        currentMap = new HashMap<>();

        // Initialize snapshot id
        id = 0;
    }

    public void set(int index, int val) {
        // Update the current map with the latest value for index
        currentMap.put(index, val);
    }

    public int snap() {
        // Store the current state of the currentMap in snapshots
        // Store a new snapshot with only the changed values since the last snapshot
        snapshots.add(new HashMap<>(currentMap));

        // Clear the currentMap for the next set of changes
        currentMap.clear();

        // Return the snapshot ID (snapshot ID is the index of the list)
        return id++;
    }

    public int get(int index, int snap_id) {
        
        for(int i = snap_id ;i >= 0;i--){

            if(snapshots.get(i).containsKey(index)) return snapshots.get(i).get(index);

        }

        return 0;
    }
}


// class SnapshotArray {
//     TreeMap<Integer, Integer>[] Tm;
//     int snap_id = 0;
//     public SnapshotArray(int length) {
//         Tm = new TreeMap[length];
//         for (int i = 0; i < length; i++) {
//             Tm[i] = new TreeMap<Integer, Integer>();
//             Tm[i].put(0, 0);
//         }
//     }

//     public void set(int index, int val) {
//         Tm[index].put(snap_id, val);
//     }

//     public int snap() {
//         return snap_id++;
//     }

//     public int get(int index, int snap_id) {
//         return Tm[index].floorEntry(snap_id).getValue();
//     }
// }  //O(1)



// class SnapshotArray {

//     private ArrayList<Integer>[] snapshots;
//     private int snapshotCounter = 0;

//     public SnapshotArray(int length) {
//         snapshots = new ArrayList[length];

//         for(int i=0; i<snapshots.length; i++) {
//             snapshots[i] = new ArrayList<>();
//         }
//     }
    
//     public void set(int index, int val) {
//         ArrayList current = snapshots[index];
//         if(snapshotCounter == current.size()) {
//             current.add(snapshotCounter, val);
//             return;
//         }

//         if(current.size() > snapshotCounter) {
//             current.remove(snapshotCounter);
//             current.add(snapshotCounter, val);
//             return;
//         }

//         for(int i=current.size(); i<snapshotCounter; i++) {
//             if(current.size() == 0) {
//                 current.add(i, 0);
//             } else {
//                 current.add(i, current.get(i-1));
//             }
//         }
//         current.add(snapshotCounter, val); 
//     }
    
//     public int snap() {
//         snapshotCounter++;
//         return snapshotCounter-1;
//     }
    
//     public int get(int index, int snap_id) {
//         ArrayList<Integer> current = snapshots[index];
//         if(current.size() == 0) {
//             return 0;
//         }
//         return  current.size()-1 < snap_id ? current.get(current.size()-1) : current.get(snap_id); 
//     }
// }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */