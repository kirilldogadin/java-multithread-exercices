в классе ExecutorsMain
НЕ будет выброшено исключение в коде
executorService.submit(() -> {
            System.out.println(1 / 0);
        });

НЕ будет перехвачено исключение 
в коде UncaughtExceptionHandler interface не работает для 

Предпочитайте **CompletableFuture** там где это возможно.
**CompletableFuture** будет рассмотрен в след главе