package by.verenich.Intervalproject.entity;

public class Interval {
    private final double start;
    private final double end;
    private final boolean includeStart;
    private final boolean includeEnd;

    public Interval(double start, double end, boolean includeStart, boolean includeEnd) {
        if (start > end || (start == end && (!includeStart || !includeEnd))) {
            throw new IllegalArgumentException("Invalid interval bounds");
        }
        this.start = start;
        this.end = end;
        this.includeStart = includeStart;
        this.includeEnd = includeEnd;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public boolean isIncludeStart() {
        return includeStart;
    }

    public boolean isIncludeEnd() {
        return includeEnd;
    }

    @Override
    public String toString() {
        return (includeStart ? "[" : "(") + start + ", " + end + (includeEnd ? "]" : ")");
    }
}
