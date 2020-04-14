package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;
import org.springframework.util.StopWatch;

public class LogUtil extends StaticBaseBean {
    public interface SimpleFunction {
        public void run();
    }

    public static StopWatch runWithStopWatch(String commonPrefix, String startMessage, String endMessage, SimpleFunction function) {
        StopWatch s = new StopWatch();
        s.start();
        var functionId = function.toString();
        loggerStatic.info("[STOPWATCH][START] {} {}", TypeUtil.checkNull(commonPrefix), TypeUtil.checkNull(startMessage, "start-" + functionId));
        function.run();
        s.stop();
        loggerStatic.info("[STOPWATCH][END]{} duration : {} / {}", TypeUtil.checkNull(commonPrefix), s.getTotalTimeMillis() + " (ms)", TypeUtil.checkNull(endMessage, "end-" + functionId));
        return s;
    }

    public static StopWatch runWithStopWatch(String commonPrefix, SimpleFunction function) {
        return runWithStopWatch(commonPrefix, null, null, function);
    }

    public static StopWatch runWithStopWatch(SimpleFunction function) {
        return runWithStopWatch(null, null, null, function);
    }
}
