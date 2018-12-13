package com.uduck.multthread.service;

import com.uduck.multthread.util.ConvertUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(String param){
        ConvertUtil.convert(param);
    }
}
