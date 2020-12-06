package thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Linzeyu
 * @create 2020-11-01 18:25
 * @describe
 * @state todo
 */
public class ThreadDemo {


    @Test
    public void $1() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("重写 thread run 方法创建线程");
            }
        };
        thread.start();
    }

    @Test
    public void $2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现 Runnable 接口 重写 run 方法创建线程");
            }
        });
        thread.getState();
        thread.start();
    }

    @Test
    public void $3() throws ExecutionException, InterruptedException {
        // 实现Callable接口，重写call方法
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "实现callable接口 重现 call 方法";
            }
        };
        // 将Callable封装成任务
        FutureTask<String> task = new FutureTask<>(callable);
        // 创建线程
        new Thread(task).start();
        // 获取 Callable返回值
        while (task.isDone()) {
            System.out.println("task = " + task.get());
        }
    }
}