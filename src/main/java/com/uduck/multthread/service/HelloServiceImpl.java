package com.uduck.multthread.service;

import com.uduck.multthread.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.windows.ThemeReader;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private ExecutorService executorService;

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Override
    public String compute(String param) {
        System.out.println("开始执行任务 ===> " + param);
        /**
         * 第一种方式，直接处理
         */
        //ConvertUtil.convert(param);
        /**
         * 第二种方式，多线程处理
         */
        //Runnable runnable = asyncDeal(param);
        //new Thread(runnable).start();
        /**
         * 第三种方式，线程池处理
         */
        // 取得返回结果后才能继续执行
        /*Future future = executor1(param);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        // executor2(param);
        // executor3(param);
        /**
         * 第四中方式，lambda表达式
         */
        // new Thread(()->ConvertUtil.convert(param)).start();
        /**
         * 第五中方法，Spring封装的线程池
         */
        asyncTaskService.executeAsyncTask(param);
        System.out.println("结束执行任务 ===> " + param);
        return "SUCCESS ===> " + param;
    }

    // 可以返回值的 Callable
    private Future executor1(String param){
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ConvertUtil.convert(param);
                return "线程返回结果啦 ===> " + param ;
            }
        });
        return future;
    }

    // 不会返回值的 Runnable
    private void executor2(String param){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                ConvertUtil.convert(param);
            }
        });
    }

    // 也可以这样
    private void executor3(String param){
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                ConvertUtil.convert(param);
            }
        });
    }

    //创建一个Runnable，重写run方法
    private Runnable asyncDeal(String param){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ConvertUtil.convert(param);
            }
        };

        return runnable;
    }
}
