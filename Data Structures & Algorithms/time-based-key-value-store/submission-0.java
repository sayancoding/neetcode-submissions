class TimeMap {

    private static class DataNode {
        final int timestamp;
        final String value;

        DataNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    private final Map<String, List<DataNode>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<DataNode> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String candidate = "";

        // Binary Search for largest timestamp <= query timestamp
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTimestamp = list.get(mid).timestamp;

            if (midTimestamp <= timestamp) {
                candidate = list.get(mid).value; // Found a valid timestamp, look for closer ones
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return candidate;
    }
}