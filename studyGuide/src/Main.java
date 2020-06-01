import trie.Trie;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
      final String[] dictionary =  {"cat", "cats", "cot"};

      Trie trie = new Trie();
      add(trie, dictionary, 0);

      System.out.println(trie.search("cot"));
      System.out.println(trie.startsWith("c"));
      Set<String> set = new HashSet<>();
      set.add("B");
      set.add("D");
      set.add("A");
      set.add("Z");
      set.stream().sorted();
      for (String i : set) {
          System.out.println(i);
      }
    }

    private static void add(Trie t, String[] dic, int start) {
      if (start >= dic.length) {
        return;
      }
      t.put(dic[start]);
      add(t, dic, start + 1);
    }
/*      ExecutorService executor = Executors.newWorkStealingPool();

      List<Callable<String>> callables = Arrays.asList(
          callable("task1", 1),
          callable("task2", 2),
          callable("task3", 3));

      try {
        String result = executor.invokeAny(callables);
        System.out.print(result);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

  static Callable<String> callable(String result, int duration) {
    return () -> {
      TimeUnit.SECONDS.sleep(duration);
      return result;
    };
  }*/

/*
      ExecutorService executor = Executors.newFixedThreadPool(1);

      Future<Integer> future = executor.submit(() -> {
        try {
          TimeUnit.SECONDS.sleep(2);
          return 123;
        } catch (InterruptedException ex) {
          throw new IllegalStateException("task cancelled", ex);
        }
      });

      try {
        future.get(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (TimeoutException e) {
        e.printStackTrace();
      }
*/

 /*     tree.BSTree<Integer> bTree = new tree.BSTree<>(50);
      bTree.addEdge(25);
      bTree.addEdge(75);
      bTree.inOrder(bTree.root);
      System.out.println();
      bTree.preOrder(bTree.root);
      System.out.println();
      bTree.postOrder(bTree.root);
      System.out.println();
      System.out.println(bTree.find(11));*/
/*      Callable<Integer> task = () -> {
        try {
          TimeUnit.SECONDS.sleep(1);
          return 123;
        } catch (InterruptedException ex) {
          throw new IllegalStateException("task interrupted", ex);
        }
      };

      ExecutorService executor = Executors.newSingleThreadExecutor();
      Future<Integer> future = executor.submit(task);
      System.out.println("future done? " + future.isDone());
      try {
        Integer result = future.get();
        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);
      } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
      } finally {
        if (!executor.isTerminated()) {
          System.err.println("ending task");
        }
        executor.shutdownNow();
        System.out.println("Done!");
      }*/
/*      Runnable task = () -> {
        try {
          String threadName = Thread.currentThread().getName();
          System.out.println("Foo: " + threadName);
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      };

      task.run();
      Thread thread = new Thread(task);
      thread.start();
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("Done!");

      ExecutorService executor = Executors.newSingleThreadExecutor();
      executor.submit(() -> {
        String name = Thread.currentThread().getName();
        System.out.println("Oi " + name);
        try {
          System.out.println("Attempt to shutdown executor");
          executor.shutdown();
          executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
          System.err.println("Task interrupted");
        } finally {
          if (!executor.isTerminated()) {
            System.err.println("cancel non-finished tasks");
          }
          executor.shutdownNow();
          System.out.println("shutdown finished");
        }
      });*/
}
