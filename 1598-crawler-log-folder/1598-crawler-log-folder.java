class Solution {
    public int minOperations(String[] logs) {
        int layers = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                layers = layers == 0? 0 : layers - 1;
            } else if (!log.equals("./")) {
                layers += 1;
            }
        }
        return layers;
    }
}