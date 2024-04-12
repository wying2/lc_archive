class Logger {
    HashMap<String, Integer> last_print;

    public Logger() {
        this.last_print = new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.last_print.containsKey(message)) {
            this.last_print.put(message, timestamp);
            return true;
        } else {
            int last_print_time = this.last_print.get(message);
            if (last_print_time + 10 > timestamp)
                return false;
            else {
                this.last_print.put(message, timestamp);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */