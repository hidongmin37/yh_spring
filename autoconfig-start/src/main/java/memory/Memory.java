package memory;

public class Memory {

    private long used;
    private long maxed;

    public Memory(long used, long maxed) {
        this.used = used;
        this.maxed = maxed;
    }

    public long getUsed() {
        return used;
    }

    public long getMaxed() {
        return maxed;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", maxed=" + maxed +
                '}';
    }
}
