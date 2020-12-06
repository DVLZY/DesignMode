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
                System.out.println("��д thread run ���������߳�");
            }
        };
        thread.start();
    }

    @Test
    public void $2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ʵ�� Runnable �ӿ� ��д run ���������߳�");
            }
        });
        thread.getState();
        thread.start();
    }

    @Test
    public void $3() throws ExecutionException, InterruptedException {
        // ʵ��Callable�ӿڣ���дcall����
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "ʵ��callable�ӿ� ���� call ����";
            }
        };
        // ��Callable��װ������
        FutureTask<String> task = new FutureTask<>(callable);
        // �����߳�
        new Thread(task).start();
        // ��ȡ Callable����ֵ
        while (task.isDone()) {
            System.out.println("task = " + task.get());
        }
    }
}