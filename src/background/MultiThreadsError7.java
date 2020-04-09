package background;

/**
 * 描述：用工厂模式修复刚才的初始化问题。
 * <p>
 * Create By ZhangBiao
 * 2020/4/9
 */
public class MultiThreadsError7 {

    int count;
    private EventListener listener;

    private MultiThreadsError7(MultiThreadsError7.MySource source) {
        this.listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.print("我得到的数字是" + count);
            }
        };
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static MultiThreadsError7 getInstance(MySource source) {
        MultiThreadsError7 multiThreadsError7 = new MultiThreadsError7(source);
        source.registerListener(multiThreadsError7.listener);
        return multiThreadsError7;
    }

    public static void main(String[] args) {
        MultiThreadsError7.MySource mySource = new MultiThreadsError7.MySource();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySource.eventCome(new MultiThreadsError7.Event() {
            });
        }).start();
        MultiThreadsError7 instance = MultiThreadsError7.getInstance(mySource);
    }

    static class MySource {
        private MultiThreadsError7.EventListener listener;

        void registerListener(MultiThreadsError7.EventListener eventListener) {
            this.listener = eventListener;
        }

        void eventCome(MultiThreadsError7.Event e) {
            if (listener != null) {
                listener.onEvent(e);
            } else {
                System.out.println("还未初始化完毕");
            }
        }
    }

    interface EventListener {
        void onEvent(MultiThreadsError7.Event e);
    }

    interface Event {
    }

}
