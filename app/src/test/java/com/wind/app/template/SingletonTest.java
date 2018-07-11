package com.wind.app.template;

import com.wind.core.util.CountDownLatchWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

/**
 * Created by shanfeng on 2018/7/4.
 */
public class SingletonTest {
    private static final Logger logger = LogManager.getLogger(SingletonTest.class);
    @Test
    public void testGetInstance() throws Exception {
        CountDownLatchWorker worker = new CountDownLatchWorker(10);
        List<FutureTask<Singleton>> lists = new ArrayList<>(10);
        IntStream.range(0, 10).forEach(e ->
                lists.add(worker.safeSubmit(Singleton::getInstance)));

        worker.run();

        IntStream.range(0, 9).forEach(e -> {
          try {
              Assert.assertEquals(lists.get(e).get(), lists.get(e+1).get());
          } catch (Exception ex) {}
        });
        Singleton singleton = Singleton.getInstance();
        logger.info(singleton);
    }
}
