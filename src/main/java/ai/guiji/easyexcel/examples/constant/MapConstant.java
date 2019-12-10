package ai.guiji.easyexcel.examples.constant;

import ai.guiji.easyexcel.examples.dto.PlanImportExeclTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import com.google.common.util.concurrent.AtomicLongMap;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class MapConstant {
    public static final AtomicLongMap<String> ATOMIC_LONG_MAP = AtomicLongMap.create(); //线程安全，支持并发

    public static final Map<String, List<PlanImportExeclTemp>> PHONE_LIST_MAP = new ConcurrentHashMap<>();

    public static final Map<String, ConcurrentHashMap<String, String>> PHONE_MAP_MAP = new ConcurrentHashMap<>();

    public static final Map<String, StopWatch> STOP_WATCH_MAP = new ConcurrentHashMap<>();

    public static final Map<String, ExecutorService> EXECUTOR_MAP = new ConcurrentHashMap<>();
}
