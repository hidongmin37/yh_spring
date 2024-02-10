package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);
    
    public void exception(TraceStatus traceStatus, Exception e);


}
